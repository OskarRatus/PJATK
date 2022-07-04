//package zad3;
//
//import javax.swing.*;
//
//public class ListExample {
//
//    int k = 0;
//    int n = 15;
//    JTextArea ta = new JTextArea(40,20);
//
//    ListExample() {
//        add(new JScrollPane(ta));
//        JPanel p = new JPanel();
//        JButton b = new JButton("Start");
//        b.addActionListener(this);
//        p.add(b);
//        b = new JButton("Stop current");
//        b.setActionCommand("Stop");
//        b.addActionListener(this);
//        p.add(b);
//        b = new JButton("Curent result");
//        b.setActionCommand("Result");
//        b.addActionListener(this);
//        p.add(b);
//        b = new JButton("Shutdown");
//        b.addActionListener(this);
//        p.add(b);
//        b = new JButton("ShutdownNow");
//        b.addActionListener(this);
//        p.add(b);
//        add(p, "South");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        pack();
//        setVisible(true);
//    }
//}
