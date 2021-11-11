package w9.zad18;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;


public class View {
    private JFrame jFrame;

    View(){
        JList myList = new JList(new AbstractListModel() {
            LocalDate now = LocalDate.now();

            @Override
            public int getSize() {
                return now.lengthOfMonth();
            }

            @Override
            public Object getElementAt(int index) {
                return index+1 + " - " + LocalDate.of(
                        now.getYear()
                        ,now.getMonthValue()
                        ,index+1)
                        .getDayOfWeek()
                        .getDisplayName(TextStyle.FULL, new Locale("PL"));
            }
        });
        myList.setSelectedIndex(LocalDate.now().getDayOfMonth()-1);

        jFrame = new JFrame(LocalDate.now().getMonthValue() + "." + LocalDate.now().getYear());
        JPanel jPanel= new JPanel();
        JScrollPane jScrollPane = new JScrollPane(myList);
        jPanel.add(jScrollPane);

        jFrame.add(jPanel);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);



    }

}
