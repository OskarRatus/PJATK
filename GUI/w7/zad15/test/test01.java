package w7.zad15.test;

import javax.swing.*;
import java.awt.*;


public class test01 {
    public static void main(String[] args) {
        createGUItest();
    }
    private static void createGUItest(){
        JFrame jf = new JFrame("Simple Swing App");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        JButton button;

        //Przyciski kolorowe
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        JPanel jp1_1 = new JPanel();
            jp1_1.setLayout(new FlowLayout(FlowLayout.LEFT));
            button = new JButton("FR");
            button.setBackground(Color.RED);
            jp1_1.add(button);

            button = new JButton("FG");
            button.setBackground(Color.GREEN);
            jp1_1.add(button);

            button = new JButton("FB");
            button.setBackground(Color.BLUE);
            jp1_1.add(button);
        jf.add(jp1_1, c);

        //Przyciski alfabetyczne
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        JPanel jp1_3 = new JPanel();
            jp1_3.setLayout(new FlowLayout(FlowLayout.RIGHT));

            button = new JButton("A");
            jp1_3.add(button);

            button = new JButton("B");
            jp1_3.add(button);

            button = new JButton("C");
            jp1_3.add(button);
        jf.add(jp1_3, c);


        // Pole tekstowe
        c.ipady = 40;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        JPanel jp2 = new JPanel();
        jp2.setLayout(new BorderLayout());
            JTextArea jta = new JTextArea("Obszar tekstowy typy JTextArea");
                jta.setColumns(200);
                jta.setRows(500);
            JScrollPane jsp = new JScrollPane(jta);
                jsp.setPreferredSize(new Dimension( 600, 200));
        jp2.add(jsp, BorderLayout.CENTER);
        jf.add(jp2, c);


        // Klawiatura
        c.gridx = 0;
        c.gridy = 2;
        JPanel jp3 = new JPanel(new GridLayout(1,2));
            JPanel jp3L = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JPanel jp3Lnum = new JPanel(new GridLayout(3, 3));
                    for (int i = 0; i < 9; i++) {
                        button = new JButton("" + (i+1));
                        jp3Lnum.add(button);
                    }
                jp3L.add(jp3Lnum);

        // Pola tekstowe
            JPanel jp3R = new JPanel(new BorderLayout());
                JPanel jp3Rlet = new JPanel(new BorderLayout());
                    JTextField jta1 = new JTextField("Pole tekstowe 1 typu \"JText\" \t");
                    jp3Rlet.add(jta1, BorderLayout.PAGE_START);
                    JTextField jta2 = new JTextField("Pole tekstowe 2 typu \"JText\" \t");
                    jp3Rlet.add(jta2, BorderLayout.CENTER);
                    JTextField jta3 = new JTextField("Pole tekstowe 3 typu \"JText\" \t");
                    jp3Rlet.add(jta3, BorderLayout.PAGE_END);
                jp3R.add(jp3Rlet);
        jp3.add(jp3L);
        jp3.add(jp3R);
        jf.add(jp3, c);

        jf.pack();
        jf.setVisible(true);
    }
}
