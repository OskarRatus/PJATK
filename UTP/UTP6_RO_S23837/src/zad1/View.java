package zad1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class View implements ActionListener {
    JButton button;
    JComboBox<String> languageDropdown;
    JTable table;
    List<Trip> tripList;
    String[][] arrData;
    DefaultTableModel model;
    Database db;


    View(Database db, String[] columns){
        this.db = db;
        this.tripList = db.retriveFromDB();
        arrData = db.makeToLocalArray(tripList, "pl");



         model = new DefaultTableModel(arrData, columns);
         table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);

        JScrollPane pane = new JScrollPane(table);

        button = new JButton("Select");
        button.addActionListener(this);

        languageDropdown = new JComboBox<>(new String[]{"pl", "en", "de"});

        JPanel panel = new JPanel();
            panel.add(pane);
            panel.add(button);
            panel.add(languageDropdown);



        JFrame f = new JFrame();
            f.add(panel);
            f.setSize(500, 500);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        List<String> col = new ArrayList<>();

        if (source == button){
            String selectedLocale = (String) languageDropdown.getSelectedItem();
            ResourceBundle rb = ResourceBundle.getBundle("zad1.ColNames", new Locale(selectedLocale));
            for (String s : new String[]{"Country", "DateFrom", "DateTo", "Place", "Price", "Currency"}) {
                col.add(rb.getString(s));
            }

            arrData = db.makeToLocalArray(tripList, selectedLocale);
            model = new DefaultTableModel(arrData, col.toArray());
            this.table.setModel(model);



        }

    }
}
