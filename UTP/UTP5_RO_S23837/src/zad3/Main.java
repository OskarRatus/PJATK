package zad3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    Main() {
        JTextArea ta = new JTextArea(20,40);
        add(new JScrollPane(ta));
        JPanel p = new JPanel();

        DefaultListModel<String> l1 = new DefaultListModel<>();
        l1.addElement("Item1");
        l1.addElement("Item2");
        l1.addElement("Item3");
        l1.addElement("Item4");
        JList<String> list = new JList<>(l1);
        list.setBounds(100,100, 75,75);
        p.add(list);

        JButton b = new JButton("Start");
        b.addActionListener(this);
        p.add(b);
        b = new JButton("Stop current");
        b.setActionCommand("Stop");
        b.addActionListener(this);
        p.add(b);
        b = new JButton("Curent result");
        b.setActionCommand("Result");
        b.addActionListener(this);
        p.add(b);
        b = new JButton("Shutdown");
        b.addActionListener(this);
        p.add(b);
        b = new JButton("ShutdownNow");
        b.addActionListener(this);
        p.add(b);
        add(p, "South");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Main();
    }
}

