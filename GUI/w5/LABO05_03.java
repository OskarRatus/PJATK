package w5;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class LABO05_03 {
    public static void main(String[] args) {
        new Selector();
    }
}


class Layout{
    protected char txt;
    protected LayoutManager layout;

    public Layout(char txt, LayoutManager layout){
        this.txt = txt;
        this.layout = layout;
    }

    public char getTxt() {
        return txt;
    }

    public LayoutManager getLayout() {
        return layout;
    }
}


class Selector{
    JFrame obj;
    char letter;

    protected Layout[] tab= {
            new Layout('a', new BorderLayout()),
            new Layout('b', new FlowLayout()),
            new Layout('c', new FlowLayout(FlowLayout.LEFT)),
            new Layout('d', new FlowLayout(FlowLayout.RIGHT)),
            new Layout('e', new GridLayout(1,0)),
            new Layout('f', new GridLayout(0,1)),
            new Layout('g', new GridLayout(3,2))
    };

    public Selector(){
        obj = new JFrame();
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setLocationRelativeTo(null);

        Object[] opt = Arrays.stream(tab).map(x -> x.getTxt()).toArray();

        letter = (char) JOptionPane.showInputDialog(obj
                , "Select layout"
                , "Selector"
                ,  JOptionPane.QUESTION_MESSAGE
                , null
                , opt
                , opt[0]
        );

        for (Layout l : tab) {
            if (l.getTxt()==letter)
                obj.setLayout(l.getLayout());
        }

        String[] str = {"Przycisk 1", "P 2", "Większy przycisk numer 3", "Przycisk 4", "P5"};
        for (String s: str) {
            JButton button = new JButton(s);
            obj.add(button);
        }

        obj.pack();
        obj.setVisible(true);

    }



}