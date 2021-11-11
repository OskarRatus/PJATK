package w7.zad15;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingApp2 implements ActionListener {

    public static void main(String[] args)
    {
        new SwingApp2();
    }

    public SwingApp2()
    {
        SwingUtilities.invokeLater(
                () -> createGUI()
        );
    }

    protected void createGUI()
    {
        // utworzenie okna
        JFrame jf = new JFrame();

        // określenie tytułu okna
        jf.setTitle("Simple Swing Event Handler");

        // obsługa zamknięcia okna JFrame
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // okno wyśrodkowane na ekranie
        jf.setLocationRelativeTo(null);

        // komponent z obsługą zdarzeń (za pomocą obiektu klasy słuchacza utworzonej gdzie indziej)
        JButton jb1 = new JButton("1");
        jb1.addActionListener(new InnerHandler());

        // dodatkowy panel do grupowania komponentów
        JPanel jp = new JPanel();

        // ustawianie zarządcy rozkładu dla panelu
        jp.setLayout(new GridLayout(2, 3, 2, 2));

        // dodawanie komponentów (z obsługą zdarzeń za pomocą klas anonimowych) do panelu
        for (int i = 0; i < 5; i++) {

            JButton jb = new JButton("" + (i+2));

            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jb = (JButton)(e.getSource());
                    System.out.println(jb.getText());

                }
            });

            jp.add(jb);
        }

        // komponent z obsługą zdarzeń za pomocą samej klasy SwingApp2 będącej klasą słuchacza
        JButton jb7 = new JButton("7");
        jb7.addActionListener(this);
        jp.add(jb7);


        // ustawianie zarządcy rozkladu dla okna
        jf.setLayout(new FlowLayout(FlowLayout.CENTER));

        // dodawanie komponentów do okna
        jf.add(jb1);
        jf.add(jp);

        // ustawianie możliwości zmiany rozmiarów okna
        jf.setResizable(true);

        // upakowanie okna
        jf.pack();

        // wyświetlenie okna
        jf.setVisible(true);
    }

    private class InnerHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton jb = (JButton)(e.getSource());
            System.out.println(jb.getText());

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton)(e.getSource());
        System.out.println(jb.getText());
    }

}

