package Zad1;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;
import java.util.Arrays;


public class Server {

    private static final String HOSTNAME = "localhost";
    private static final int PORT = 1234;

    private static Map<SocketChannel, Set<String>> subscriptions;
//    private Set<String> availableTopics = new HashSet<>();
    private Set<String> availableTopics = new HashSet<>(Arrays.asList("sport", "politics", "economy"));

    private static String publicationTopic;
    private static String publicationMessage;

    public static void main(String[] args) throws IOException, InterruptedException {
        new Server();
    }

    Server () throws IOException {

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(HOSTNAME, PORT));
        serverChannel.configureBlocking(false);

        // Utworzenie selektora
        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        subscriptions = new HashMap<>();

        System.out.println("Serwer czeka na " + HOSTNAME + ":" + PORT);


        while (true) {

            selector.select();
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();

            while(iter.hasNext()) {

                // pobranie klucza
                SelectionKey key = iter.next();
                iter.remove();

                // Wykonanie operacji opisywanej przez klucz
                if (key.isAcceptable()) { // połaczenie klienta gotowe do akceptacji
                    SocketChannel cc = serverChannel.accept();
                    cc.configureBlocking(false);
                    cc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);

                    subscriptions.put(cc, new HashSet<>());

                    System.out.println("Serwer: połączenie z " + cc.getRemoteAddress());
                    continue;
                }

                if (key.isReadable()) {  // któryś z kanałów gotowy do czytania

                    // Uzyskanie kanału na którym czekają dane do odczytania
                    SocketChannel cc = (SocketChannel) key.channel();

                    serviceRequest(cc);

                    // obsługa zleceń klienta
                    // ...
                    continue;
                }
                if (key.isWritable()) {  // któryś z kanałów gotowy do pisania
                    // Uzyskanie kanału na ktérym czekają dane do zapisu
                    SocketChannel cc = (SocketChannel) key.channel();

                    servicePublish(cc);

                }

            }
        }

    }




    // Strona kodowa do kodowania/dekodowania buforów
    private static Charset charset  = Charset.forName("ISO-8859-2");
    private static final int BSIZE = 1024;

    private ByteBuffer bbuf = ByteBuffer.allocate(BSIZE);
    private StringBuffer reqString = new StringBuffer();

    private boolean isValidTopic(String topic,  Set<String> subscribedTopics) {
        // oddzielic walidacje na sub i unsubscribe

        if (!availableTopics.contains(topic)) {
            System.out.println("Nie ma takiego tematu: "+ topic);
            return false;
        }
        if (availableTopics.contains(topic) && subscribedTopics.contains(topic)) {
            System.out.println("Jest juz na liście subskrypcji: " + topic);
            return false;
        }
        return true;
    }

    private void servicePublish(SocketChannel cc) {
        if (!cc.isOpen()) return; // jeŻeli kanał zamknięty

        if (publicationTopic == null) return;
        if (subscriptions.get(cc).contains(publicationTopic)) {
            System.out.println("Serwer: wysyłam wiadomość do klienta: " + publicationTopic + " # " + publicationMessage);
            try {
                cc.write(charset.encode(CharBuffer.wrap(publicationTopic + ": " + publicationMessage)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        publicationTopic = null;
        publicationMessage = null;

    }

    private void serviceRequest(SocketChannel sc) {
        if (!sc.isOpen()) return; // jeżeli kanał zamknięty

        System.out.print("Serwer: czytam komunikat od klienta: ");
        // Odczytanie zlecenia
        try {
            String cmd = readRequest(sc);
            System.out.println(cmd);

            if (cmd.startsWith("subscribe")) {
                String[] topic = cmd.split("subscribe ");

                if (!availableTopics.contains(topic[1])) {
                    sc.write(charset.encode(CharBuffer.wrap("Nie ma takiego tematu: " + topic[1])));
                }else {
                    subscriptions.get(sc).add(topic[1]);
                    sc.write(charset.encode(CharBuffer.wrap("dodano do listy subskrypcji: " + topic[1])));
                }
            }
            else if (cmd.startsWith("unsubscribe")) {
                String[] topic = cmd.split("unsubscribe ");

                if (!subscriptions.get(sc).contains(topic[1])) {
                    sc.write(charset.encode(CharBuffer.wrap("Nie ma takiego tematu: " + topic[1])));
                } else {
                    subscriptions.get(sc).remove(topic[1]);
                    sc.write(charset.encode(CharBuffer.wrap("usunięto z listy subskrypcji: " + topic[1])));
                }
            }
            else if (cmd.startsWith("list")) {
                String list = "";
                for (String s : subscriptions.get(sc)) {
                    list += s + ", ";
                }
                sc.write(charset.encode(CharBuffer.wrap(list)));
            }
            else if (cmd.startsWith("showAll")) {
                sc.write(charset.encode(CharBuffer.wrap(Arrays.toString(availableTopics.toArray()))));
            }
            else if (cmd.startsWith("Publish")) {
                String[] topic = cmd.split(":");
                publicationTopic = topic[1];
                publicationMessage = topic[2];

            }
            else if (cmd.startsWith("newTopics")) {
                String[] topic = cmd.split("newTopics:");
                availableTopics = new HashSet<>(Arrays.asList(topic[1].replace("[", "").replace("]", "").split(", ")));
                System.out.println("Nowe tematy to: " + availableTopics);

            }
            else if (cmd.equals("Bye")) {           // koniec komunikacji
                sc.write(charset.encode(CharBuffer.wrap("Bye")));
                System.out.println("Serwer: mówię \"Bye\" do klienta ...\n\n");

                sc.close();                      // - zamknięcie kanału
                sc.socket().close();             // i gniazda

            } else
                // echo do Klienta
                sc.write(charset.encode(CharBuffer.wrap(reqString)));


        } catch (Exception exc) { // przerwane polączenie?
            exc.printStackTrace();
            try { sc.close();
                sc.socket().close();
            } catch (Exception e) {}
        }

    }

    private String readRequest(SocketChannel sc) throws IOException {
        reqString.setLength(0);
        bbuf.clear();

        readLoop:                    // Czytanie jest nieblokujące
        while (true) {               // kontynujemy je dopóki
            int n = sc.read(bbuf);   // nie natrafimy na koniec wiersza
            if (n > 0) {
                bbuf.flip();
                CharBuffer cbuf = charset.decode(bbuf);
                while(cbuf.hasRemaining()) {
                    char c = cbuf.get();
                    //System.out.println(c);
                    if (c == '\r' || c == '\n') break readLoop;
                    else {
                        //System.out.println(c);
                        reqString.append(c);
                    }
                }
            }
        }

        return reqString.toString();
    }

}
