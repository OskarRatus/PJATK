package w8.mvc;

import java.awt.*;
import javax.swing.*;

public class View {

    private JFrame frame;
    private JLabel label;
    private JButton buttonSolve;
    private JButton buttonClear;
    private JTextField textFieldA;
    private JTextField textFieldB;
    private JTextField textFieldC;

    private JPanel jp;

    View() {
        frame = new JFrame();
        label= new JLabel("Result");
            label.setPreferredSize(new Dimension(100,30));
        textFieldA = new JTextField("Enter a here");
            textFieldA.setToolTipText("Enter a");
            textFieldA.setPreferredSize(new Dimension(100,33));
        textFieldB = new JTextField("Enter x here");
            textFieldB.setToolTipText("Enter b");
            textFieldB.setPreferredSize(new Dimension(100,33));
        textFieldC = new JTextField("Enter x here");
            textFieldC.setToolTipText("Enter c");
            textFieldC.setPreferredSize(new Dimension(100,33));
        buttonSolve = new JButton("Solve");
            buttonSolve.setMnemonic('s');
        buttonClear = new JButton("Clear");
            buttonClear.setMnemonic('c');

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.PAGE_START);
        frame.add(textFieldA, BorderLayout.LINE_START);
        frame.add(textFieldB, BorderLayout.CENTER);
        frame.add(textFieldC, BorderLayout.LINE_END);
            jp = new JPanel(new BorderLayout());
                jp.add(buttonSolve, BorderLayout.PAGE_START);
                jp.add(buttonClear, BorderLayout.PAGE_END);
        frame.add(jp, BorderLayout.PAGE_END);

        frame.pack();
        frame.setVisible(true);
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getButton() {
        return buttonSolve;
    }

    public JButton getButton2() {
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

    public JLabel setRED(){
        label.setOpaque(true);
        label.setBackground(Color.RED);
        return null;
    }

    public JLabel setGREEN(){
        label.setOpaque(true);
        label.setBackground(Color.GREEN);
        return null;
    }
}
