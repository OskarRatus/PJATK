package w8.zad16;

import javax.swing.*;
import java.awt.*;

public class View {

    private JFrame frame;
    private JLabel label;
    private JButton buttonSolve, buttonClear;
    private JTextField textFieldA, textFieldB, textFieldC;

    View() {
        frame = new JFrame();
        label= new JLabel("Result");
        textFieldA = new JTextField("Enter a here");
        textFieldB = new JTextField("Enter b here");
        textFieldC = new JTextField("Enter c here");
        buttonSolve = new JButton("Solve");
        buttonClear = new JButton("Clear");

        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(textFieldA);
        frame.add(textFieldB);
        frame.add(textFieldC);
        frame.add(buttonSolve);
        frame.add(buttonClear);

        frame.pack();
        frame.setVisible(true);
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getButtonSolve() {
        return buttonSolve;
    }

    public JButton getButtonClear() {
        return buttonClear;
    }

    public JTextField getTextFieldA() {
        return textFieldA;
    }

    public JTextField getTextFieldB() {
        return textFieldB;
    }

    public JTextField getTextFieldC() {
        return textFieldC;
    }
}
