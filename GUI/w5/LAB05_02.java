package w5;

import javax.swing.*;
import java.awt.*;

public class LAB05_02 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> createGUI()
        );
    }

    protected static void createGUI()
    {
        JFrame jf = new JFrame();

        jf.setTitle("Edytor tekstu");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setLocation(100,100);

        JTextArea textarea = new JTextArea();
        jf.add(textarea);
        textarea.setBackground(Color.GREEN);
        textarea.setForeground(Color.BLUE);
        textarea.setFont(new Font("Times New Roman", Font.BOLD+Font.ITALIC, 20));

        jf.setLayout(new FlowLayout(FlowLayout.LEFT));

        jf.setResizable(true);

        jf.pack();
        jf.setVisible(true);
    }
}
