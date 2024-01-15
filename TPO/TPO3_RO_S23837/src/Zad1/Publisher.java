package Zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.List;

public class Publisher extends JFrame implements ActionListener {

    private static final int PORT = 1234;
    private static final String HOST = "localhost";

    private SocketChannel socketChannel;

    private JTextArea ta = new JTextArea(20, 20);
    private JTextField tfMsg = new JTextField(20);
    private JTextField tfTopic = new JTextField(20);
    private JLabel infoLabMsg = new JLabel("Message");
    private JLabel infoLabTopic = new JLabel("Topic");
    private JButton publish = new JButton("Publikuj");
    private JButton updateTopics = new JButton("Aktualizuj");
    private Container cp = getContentPane();

    Publisher() {
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            connect();
            runGUI();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void runGUI() {
        // Konfiguracja GUI
        JPanel p = new JPanel();
        p.add(infoLabTopic);
        p.add(tfTopic);
        p.add(updateTopics);
        p.add(tfMsg);
        p.add(infoLabMsg);
        p.add(publish);
        cp.add(p, "South");

        tfMsg.addActionListener(this);
        publish.addActionListener(this);
        updateTopics.addActionListener(this);

        // Przy zamykaniu aplikacji
        // zamykamy kanał i gniazdo
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                sendToServer("Bye");

                dispose();
                try {
                    socketChannel.close();
                    socketChannel.socket().close();
                } catch(Exception exc) {}
                System.exit(0);
            }
        });

        pack();
        show();
    }


    private void connect() throws IOException {
        if (!socketChannel.isOpen()) SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(HOST, PORT));
        System.out.println("Connected to " + HOST + ":" + PORT);
        while (!socketChannel.finishConnect()) {
            try {
                Thread.sleep(200);
            } catch(Exception exc) { return; }
            System.out.print(".");
        }
        System.out.println("\\nPołączony z: " + socketChannel.getRemoteAddress());

    }

    private void publish(String topic, String message) {
        System.out.println("Publishing: " + topic + " : " + message);
        sendToServer("Publish:" + topic + ":" + message);
    }

    private void updateTopics(List<String> newTopics){
        System.out.println("Updating topics: " + newTopics);
        sendToServer("newTopics:" + newTopics);
    }

    private void sendToServer(String s) {
        try {
            socketChannel.write(Charset.forName("ISO-8859-2").encode(s + "\n"));
            Thread.sleep(200);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == publish) {
            publish(tfTopic.getText(), tfMsg.getText());
            tfMsg.setText("");
        }
        if (e.getSource() == updateTopics) {
            updateTopics(List.of(tfTopic.getText()));
        }
 


    }

    public static void main(String[] args) {
        new Publisher();
    }


}
