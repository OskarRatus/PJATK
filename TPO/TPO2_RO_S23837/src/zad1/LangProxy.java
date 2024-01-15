package zad1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class LangProxy {

    private static ServerSocket server;
    public static Socket clientSocket;
    public static ObjectInputStream ois;
    public static String message;
    public static String[] msg;
    public static int serverPort;
    public static Socket langServerSocket;
    public static ObjectOutputStream oos;

    private static final int port = 9876;

    public static void main(String args[]) throws Exception {
        server = new ServerSocket(port);

        while(true){
            System.out.println("Waiting for the client request");
            clientSocket = server.accept();

            // nowy watek dla klientow

            ois = new ObjectInputStream(clientSocket.getInputStream());
            message = (String) ois.readObject();
            msg = message.replaceAll("\\}|\\{", "").split(", ");
            System.out.println("Received: " + msg[0] + ", " + msg[1] + ", " + msg[2]);

            // select proper server address
            if (!Arrays.asList("jezioro", "góry", "morze").contains(msg[0]))
                throw new Exception("Brak słowa w bazie");
            
            
            if(msg[1].equals("EN")) {
                Thread thread = new Thread(() -> {
                    serverPort = 9871;
                    try {
                        new LangServerEN().start(serverPort);
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
                thread.start();
            } else if (msg[1].equals("DE")) {
                Thread thread = new Thread(() -> {
                    serverPort = 9872;
                    try {
                        new LangServerDE().start(serverPort);
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
                thread.start();
            }




            // send to langServer
            langServerSocket = new Socket(InetAddress.getLocalHost().getHostName(), serverPort);
            oos = new ObjectOutputStream(langServerSocket.getOutputStream());
            oos.writeObject("{"+msg[0]+", "+clientSocket.getInetAddress()+", "+msg[2]+"}");


            ois.close();
            oos.close();
            clientSocket.close();
            langServerSocket.close();

            if(message.equalsIgnoreCase("exit")) break;
        }

        System.out.println("Shutting down Socket server!!");
        server.close();
    }

}