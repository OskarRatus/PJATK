package zad1;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class LangServer extends Thread {

    private static ServerSocket server;
    private static Socket proxySocket;
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;
    private static String message;
    private static String[] msg;

    public void start(int proxyPort) throws IOException, ClassNotFoundException {
        System.out.println("Waiting for the proxyServer request");
        server = new ServerSocket(proxyPort);


        while(true){
            // receive msg
            proxySocket = server.accept();
            ois = new ObjectInputStream(proxySocket.getInputStream());
            message = (String) ois.readObject();
            msg = message.replaceAll("\\}|\\{", "").split(", ");
            System.out.println("Received: " + message);

            // setup connection with client
            InetAddress host = InetAddress.getByName(msg[1].replaceAll("/",""));
            int clientPort = Integer.parseInt(msg[2]);
            oos = new ObjectOutputStream(
                    new Socket(host, clientPort).getOutputStream());

            String returnMsg = getTranslation(msg[0]);
            oos.writeObject(returnMsg);

            ois.close();
            oos.close();
            proxySocket.close();
            server.close();

        }
    }

    abstract public String getTranslation(String s);


}
