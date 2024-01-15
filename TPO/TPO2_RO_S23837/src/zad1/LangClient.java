package zad1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class LangClient {
    private static ServerSocket langSocket;
    private static Socket proxySocket;
    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;
    private static final int proxyPort = 9876;


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
        proxySocket = new Socket(InetAddress.getLocalHost(), proxyPort);
        langSocket = new ServerSocket(0);
        int langPortNo = langSocket.getLocalPort();

        //send request to proxy server
        oos = new ObjectOutputStream(proxySocket.getOutputStream());
        oos.writeObject("{morze, EN, "+langPortNo+"}");

        Thread.sleep(6000);

        //retrieve translated info
        Socket socketReceived = langSocket.accept();
        ois = new ObjectInputStream(socketReceived.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Message: " + message);

        ois.close();
        oos.close();

        socketReceived.close();
        langSocket.close();
        proxySocket.close();

    }

}

