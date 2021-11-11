package w8.zad17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class View {
    private JFrame jf;
    private  JMenuItem jmiOpen, jmiSave, jmiSaveAs, jmiExit, jmiPraca, jmiDom, jmiSzkola;
    private JRadioButton fgGreen, fgOrange, fgRed, fgBlack, fgWhite, fgYellow, fgBlue;
    private JRadioButton bgGreen, bgOrange, bgRed, bgBlack, bgWhite, bgYellow, bgBlue;
    private JMenuItem f8, f10, f12, f14, f16, f18, f20, f22, f24;
    private JTextArea jTextArea;
    private JLabel fgCol, bgCol, fntSize;


    View() {
        //set frame
        jf = new JFrame("Prosty edytor");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //content
        jf.setJMenuBar(createJMenuBar());
        jf.setContentPane(createJTextArea());


        //display
        jf.setSize(450, 250);
        jf.setVisible(true);
    }


    public Container createJTextArea(){
        JPanel jPanel = new JPanel(new BorderLayout());
        jTextArea = new JTextArea(50,300);

        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jPanel.add(jScrollPane, BorderLayout.CENTER);

        JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel.add(jp2, BorderLayout.PAGE_END);
            fgCol = new JLabel("fg");
                fgCol.setIcon(new ColorIcon(jTextArea.getForeground()));
            jp2.add(fgCol);
            bgCol = new JLabel("bg");
                bgCol.setIcon(new ColorIcon(jTextArea.getBackground()));
            jp2.add(bgCol);
            fntSize = new JLabel(String.valueOf(jTextArea.getFont().getSize()));
            jp2.add(fntSize);

        return  jPanel;
    }

    public JMenuBar createJMenuBar(){
        JMenuBar jMenuBar;
        JMenu jMenu, subMenu;
        ButtonGroup buttonGroup;


        //create menu bar
        jMenuBar = new JMenuBar();


        //create FILE menu
        jMenu = new JMenu("File");
        jMenuBar.add(jMenu);

        //create menu items
            jmiOpen = createJMI("Open", KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_DOWN_MASK));
            jMenu.add(jmiOpen);
            jmiSave = createJMI("Save", KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
            jMenu.add(jmiSave);
            jmiSaveAs = createJMI("Save As",KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
            jMenu.add(jmiSaveAs);
        jMenu.addSeparator();
            jmiExit = createJMI("Exit", KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
            jMenu.add(jmiExit);


        //create EDIT menu
        jMenu = new JMenu("Edit");
        jMenuBar.add(jMenu);

        //create menu items
        //ADRESY
            subMenu = new JMenu("Adresy");
            jMenu.add(subMenu);
                jmiPraca = createJMI("Praca",KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
                subMenu.add(jmiPraca);
                jmiDom = createJMI("Dom", KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
                subMenu.add(jmiDom);
                jmiSzkola = createJMI("Szkola", KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
                subMenu.add(jmiSzkola);

        //create OPTIONS menu
        jMenu = new JMenu("Opcje");
        jMenuBar.add(jMenu);
        //create subMenu items
            subMenu = new JMenu("Foreground");
            jMenu.add(subMenu);
            //FOREGROUND
            buttonGroup = new ButtonGroup();
                fgGreen = createJRB("Green", Color.GREEN, buttonGroup);
                subMenu.add(fgGreen);
                fgOrange = createJRB("Orange", Color.ORANGE, buttonGroup);
                subMenu.add(fgOrange);
                fgRed = createJRB("Red", Color.RED, buttonGroup);
                subMenu.add(fgRed);
                fgBlack = createJRB("Black", Color.BLACK, buttonGroup);
                subMenu.add(fgBlack);
                fgWhite = createJRB("White", Color.WHITE, buttonGroup);
                subMenu.add(fgWhite);
                fgYellow = createJRB("Yellow", Color.YELLOW, buttonGroup);
                subMenu.add(fgYellow);
                fgBlue = createJRB("Blue", Color.BLUE, buttonGroup);
                subMenu.add(fgBlue);



            subMenu = new JMenu("Background");
            jMenu.add(subMenu);
            //BACKGROUND
            buttonGroup = new ButtonGroup();
                bgGreen = createJRB("Green", Color.GREEN, buttonGroup);
                subMenu.add(bgGreen);
                bgOrange = createJRB("Orange", Color.ORANGE, buttonGroup);
                subMenu.add(bgOrange);
                bgRed = createJRB("Red", Color.RED, buttonGroup);
                subMenu.add(bgRed);
                bgBlack = createJRB("Black", Color.BLACK, buttonGroup);
                subMenu.add(bgBlack);
                bgWhite = createJRB("White", Color.WHITE, buttonGroup);
                bgWhite.setSelected(true);
                subMenu.add(bgWhite);
                bgYellow = createJRB("Yellow", Color.YELLOW, buttonGroup);
                subMenu.add(bgYellow);
                bgBlue = createJRB("Blue", Color.BLUE, buttonGroup);
                subMenu.add(bgBlue);

            subMenu = new JMenu("Font");
            jMenu.add(subMenu);
                f8 = createJMI("8 pts", new Font("Times News Roman", Font.PLAIN, 8));
                subMenu.add(f8);
                f10 = createJMI("10 pts", new Font("Times News Roman", Font.PLAIN, 10));
                subMenu.add(f10);
                f12 = createJMI("12 pts", new Font("Times News Roman", Font.PLAIN, 12));
                subMenu.add(f12);
                f14 = createJMI("14 pts", new Font("Times News Roman", Font.PLAIN, 14));
                subMenu.add(f14);
                f16 = createJMI("16 pts", new Font("Times News Roman", Font.PLAIN, 16));
                subMenu.add(f16);
                f18 = createJMI("18 pts", new Font("Times News Roman", Font.PLAIN, 18));
                subMenu.add(f16);
                f20 = createJMI("20 pts", new Font("Times News Roman", Font.PLAIN, 20));
                subMenu.add(f20);
                f22 = createJMI("22 pts", new Font("Times News Roman", Font.PLAIN, 22));
                subMenu.add(f22);
                f24 = createJMI("24 pts", new Font("Times News Roman", Font.PLAIN, 24));
                subMenu.add(f24);
        return jMenuBar;
    }

    public JRadioButton createJRB(String text, Color color, ButtonGroup buttonGroup){
        JRadioButton jRadioButton = new JRadioButton();
        JLabel jLabel = new JLabel("      ● " + text);
        jRadioButton.setForeground(color);
        jLabel.setForeground(color);
        jRadioButton.add(jLabel);
        jRadioButton.setName(text);
        buttonGroup.add(jRadioButton);

        return jRadioButton;
    }

    public JMenuItem createJMI(String text, KeyStroke keyStroke){
        JMenuItem jMenuItem = new JMenuItem(text);
        jMenuItem.setAccelerator(keyStroke);

        return jMenuItem;
    }

    public JMenuItem createJMI(String text, Font font ){
        JMenuItem jMenuItem = new JMenuItem(text);
        jMenuItem.setFont(font);
        return  jMenuItem;
    }


// GETTER
    public JFrame getJf() {
        return jf;
    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public JMenuItem getJmiOpen() {
        return jmiOpen;
    }
    public JMenuItem getJmiSave() {
        return jmiSave;
    }
    public JMenuItem getJmiSaveAs() {
        return jmiSaveAs;
    }
    public JMenuItem getJmiExit() {
        return jmiExit;
    }

    public JMenuItem getJmiPraca() {
        return jmiPraca;
    }
    public JMenuItem getJmiDom() {
        return jmiDom;
    }
    public JMenuItem getJmiSzkola() {
        return jmiSzkola;
    }

    public JRadioButton getFgGreen() {
        return fgGreen;
    }
    public JRadioButton getFgOrange() {
        return fgOrange;
    }
    public JRadioButton getFgRed() {
        return fgRed;
    }
    public JRadioButton getFgBlack() {
        return fgBlack;
    }
    public JRadioButton getFgWhite() {
        return fgWhite;
    }
    public JRadioButton getFgYellow() {
        return fgYellow;
    }
    public JRadioButton getFgBlue() {
        return fgBlue;
    }

    public JRadioButton getBgGreen() {
        return bgGreen;
    }
    public JRadioButton getBgOrange() {
        return bgOrange;
    }
    public JRadioButton getBgRed() {
        return bgRed;
    }
    public JRadioButton getBgBlack() {
        return bgBlack;
    }
    public JRadioButton getBgWhite() {
        return bgWhite;
    }
    public JRadioButton getBgYellow() {
        return bgYellow;
    }
    public JRadioButton getBgBlue() {
        return bgBlue;
    }

    public JMenuItem getF8() {
        return f8;
    }
    public JMenuItem getF10() {
        return f10;
    }
    public JMenuItem getF12() {
        return f12;
    }
    public JMenuItem getF14() {
        return f14;
    }
    public JMenuItem getF16() {
        return f16;
    }
    public JMenuItem getF18() {
        return f18;
    }
    public JMenuItem getF20() {
        return f20;
    }
    public JMenuItem getF22() {
        return f22;
    }
    public JMenuItem getF24() {
        return f24;
    }

    public JLabel getFgCol() {
        return fgCol;
    }
    public JLabel getBgCol() {
        return bgCol;
    }
    public JLabel getFntSize() {
        return fntSize;
    }
}
