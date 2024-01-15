package Zad1;


import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;


public class Client extends JFrame implements ActionListener {
    private JButton button1 = new JButton("List");
    private JButton button2 = new JButton("showAll");
    private JButton button3 = new JButton("sub");
    private JButton button4 = new JButton("unsub");
    private JTextField textField1 = new JTextField(20);
    private JTextArea textArea1 = new JTextArea(20, 20);
    private Container cp = getContentPane();

    SocketChannel channel = null;
    String server = "localhost"; // adres hosta serwera
    int port = 1234; // numer portu

    private Client() throws IOException{

        String serverOut = null;
        try {
            // Utworzenie kanału
            channel = SocketChannel.open();

            // Ustalenie trybu nieblokującego
            channel.configureBlocking(false);

            // połączenie kanału
            channel.connect(new InetSocketAddress(server, port));

            System.out.print("Klient: łączę się z serwerem ...");

//            runGui();

            while (!channel.finishConnect()) {
                // ew. pokazywanie czasu łączenia (np. pasek postępu)
                // lub wykonywanie jakichś innych (krótkotrwałych) działań
            }

        } catch(UnknownHostException exc) {
            System.err.println("Uknown host " + server);
            // ...
        } catch(Exception exc) {
            exc.printStackTrace();
            // ...
        }

        System.out.println("\nKlient: jestem połączony z serwerem ...");

        Charset charset  = Charset.forName("ISO-8859-2");
        Scanner scanner = new Scanner(System.in);

        // Alokowanie bufora bajtowego
        int rozmiar_bufora = 1024;
        ByteBuffer inBuf = ByteBuffer.allocateDirect(rozmiar_bufora);
        CharBuffer cbuf = null;


        System.out.println("Klient: wysyłam - Hi");
        // "Powitanie" do serwera
        channel.write(charset.encode("Hi\n"));

        // pętla czytania
        while (true) {
            inBuf.clear();	// opróżnienie bufora wejściowego
            int readBytes = channel.read(inBuf); // czytanie nieblokujące

            if (readBytes == 0) {                              // jeszcze nie ma danych
                // jakieś (krótkotrwałe) działania np. info o upływającym czasie

                continue;

            }
            else if (readBytes == -1) { // kanał zamknięty po stronie serwera
                break;
            }
            else {		// dane dostępne w buforze
                inBuf.flip();	// przestawienie bufora

                // pobranie danych z bufora
                cbuf = charset.decode(inBuf);

                String odSerwera = cbuf.toString();

                System.out.println("Klient: serwer właśnie odpisał ... " + odSerwera);
                cbuf.clear();

                if (odSerwera.equals("Bye")) break;
            }

            // Teraz klient pisze do serwera poprzez Scanner
            String input = scanner.nextLine();
            cbuf = CharBuffer.wrap(input + "\n");
            ByteBuffer outBuf = charset.encode(cbuf);
            channel.write(outBuf);

            if (!input.equals(""))
                System.out.println("Klient: piszę " + input);

        }

        scanner.close();

    }

    private static String odSerwera(SocketChannel socketChannel){



        return null;
    }



    private void runGui(){
        JPanel jPanel = new JPanel();

        jPanel.add(button1);
        jPanel.add(button2);
        jPanel.add(button3);
        jPanel.add(button4);
        jPanel.add(textField1);
        jPanel.add(textArea1);

        cp.add(jPanel, "South");


        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

                dispose();
                try {
                    channel.close();
                    channel.socket().close();
                } catch(Exception exc) {}
                System.exit(0);
            }
        });

        pack();
        show();
    }

    public static void main(String[] args){
        try {
            new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) { //list
            try {
                channel.write(Charset.forName("ISO-8859-2").encode("list\n"));
                textArea1.setText("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == button2) { //showAll
            try {
                channel.write(Charset.forName("ISO-8859-2").encode("showAll\n"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == button3) { //sub
            try {
                channel.write(Charset.forName("ISO-8859-2").encode("sub " + textField1.getText() + "\n"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == button4) { //unsub
            try {
                channel.write(Charset.forName("ISO-8859-2").encode("unsub " + textField1.getText() + "\n"));
            } catch (IOException e1) {

            }
        }

    }
}
