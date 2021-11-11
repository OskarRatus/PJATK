package w7.zad15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LAB07_01 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> createGUI()
        );
    }

    private static void createGUI() {
        JFrame frame = new JFrame("BoxLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());
        JPanel jp = new JPanel();



        jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));
        JButton button = new JButton("7");
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        JButton button2 = new JButton("7");
        button2.setAlignmentX(Component.RIGHT_ALIGNMENT);

        jp.add(button);
        jp.add(Box.createHorizontalGlue());
        jp.add(button2);

        frame.add(jp);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
