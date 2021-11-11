package w8.zad17;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.cert.Extension;

public class Controler {
    private Model model;
    private  View view;
    private File file;

    public Controler(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void initControl(){
        //File
        view.getJmiOpen().addActionListener(e ->{
            view.getjTextArea().setText("");
            JFileChooser jFileChooser = new JFileChooser(".");
            int r = jFileChooser.showOpenDialog(view.getJf());
            file = jFileChooser.getSelectedFile();
            try {
                if (!(file == null)) {
                    BufferedReader in = new BufferedReader(new FileReader(file));
                    String line = in.readLine();
                    while (line != null) {
                        view.getjTextArea().setText(view.getjTextArea().getText() + "\n" + line);
                        line = in.readLine();
                    }
                    view.getJf().setTitle("Prosty edytor - " + file.getAbsolutePath());

                    // SYS INFO
                    System.out.println("READ: " + file.getAbsolutePath());
                }

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });
        view.getJmiSave().addActionListener(e ->{
            if (!(file == null)){
                try {
                    String fileName = file.getCanonicalPath();
                    file = new File(fileName);
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(view.getjTextArea().getText());
                    bufferedWriter.close();

                    view.getJf().setTitle("Prosty edytor - " + file.getAbsolutePath());

                    // SYS INFO
                    System.out.println("SAVED: " + fileName);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else {
                view.getJmiSaveAs().doClick();
            }

        });
        view.getJmiSaveAs().addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser(".");
            int r = jFileChooser.showSaveDialog(view.getJf());

            if (r == JFileChooser.APPROVE_OPTION){
                file = jFileChooser.getSelectedFile();
                try {
                    String fileName = file.getCanonicalPath();
                    file = new File(fileName);
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(view.getjTextArea().getText());
                    bufferedWriter.close();

                    view.getJf().setTitle("Prosty edytor - " + file.getAbsolutePath());

                    // SYS INFO
                    System.out.println("SAVED AS: " + fileName);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        view.getJmiExit().addActionListener(e -> {
            System.out.println("SYS EXIT 0");
            System.exit(0);
        });


        //Edit
        view.getJmiPraca().addActionListener(e -> {view.getjTextArea().insert("[ Adres praca ]", view.getjTextArea().getCaretPosition());
        });
        view.getJmiDom().addActionListener(e -> {view.getjTextArea().insert("[ Adres domowy ]", view.getjTextArea().getCaretPosition());
        });
        view.getJmiSzkola().addActionListener(e -> {view.getjTextArea().insert("[ Adres szkolny ]", view.getjTextArea().getCaretPosition());
        });


        // Fg RadioButtons
        view.getFgGreen().addActionListener(e ->{
            view.getjTextArea().setForeground(view.getFgGreen().getForeground());
            view.getFgCol().setIcon(new ColorIcon(view.getFgGreen().getForeground()));
        });
        view.getFgOrange().addActionListener(e ->{
            view.getjTextArea().setForeground(view.getFgOrange().getForeground());
            view.getFgCol().setIcon(new ColorIcon(view.getFgOrange().getForeground()));
        });
        view.getFgRed().addActionListener(e ->{
            view.getjTextArea().setForeground(view.getFgRed().getForeground());
            view.getFgCol().setIcon(new ColorIcon(view.getFgRed().getForeground()));
        });
        view.getFgBlack().addActionListener(e ->{
            view.getjTextArea().setForeground(view.getFgBlack().getForeground());
            view.getFgCol().setIcon(new ColorIcon(view.getFgBlack().getForeground()));
        });
        view.getFgWhite().addActionListener(e ->{
            view.getjTextArea().setForeground(view.getFgWhite().getForeground());
            view.getFgCol().setIcon(new ColorIcon(view.getFgWhite().getForeground()));
        });
        view.getFgYellow().addActionListener(e ->{
            view.getjTextArea().setForeground(view.getFgYellow().getForeground());
            view.getFgCol().setIcon(new ColorIcon(view.getFgYellow().getForeground()));
        });
        view.getFgBlue().addActionListener(e ->{
            view.getjTextArea().setForeground(view.getFgBlue().getForeground());
            view.getFgCol().setIcon(new ColorIcon(view.getFgBlue().getForeground()));
        });

        // Bg RadioButtons
        view.getBgGreen().addActionListener(e -> {
            view.getjTextArea().setBackground(view.getBgGreen().getForeground());
            view.getBgCol().setIcon(new ColorIcon(view.getBgGreen().getForeground()));
        });
        view.getBgOrange().addActionListener(e -> {
            view.getjTextArea().setBackground(view.getBgOrange().getForeground());
            view.getBgCol().setIcon(new ColorIcon(view.getBgOrange().getForeground()));
        });
        view.getBgRed().addActionListener(e -> {
            view.getjTextArea().setBackground(view.getBgRed().getForeground());
            view.getBgCol().setIcon(new ColorIcon(view.getBgRed().getForeground()));
        });
        view.getBgBlack().addActionListener(e -> {
            view.getjTextArea().setBackground(view.getBgBlack().getForeground());
            view.getBgCol().setIcon(new ColorIcon(view.getBgBlack().getForeground()));
        });
        view.getBgWhite().addActionListener(e -> {
            view.getjTextArea().setBackground(view.getBgWhite().getForeground());
            view.getBgCol().setIcon(new ColorIcon(view.getBgWhite().getForeground()));
        });
        view.getBgYellow().addActionListener(e -> {
            view.getjTextArea().setBackground(view.getBgYellow().getForeground());
            view.getBgCol().setIcon(new ColorIcon(view.getBgYellow().getForeground()));
        });
        view.getBgBlue().addActionListener(e -> {
            view.getjTextArea().setBackground(view.getBgBlue().getForeground());
            view.getBgCol().setIcon(new ColorIcon(view.getBgBlue().getForeground()));
        });

        // font size
        view.getF8().addActionListener(e -> {
            view.getjTextArea().setFont(view.getF8().getFont());
            view.getFntSize().setText(String.valueOf(view.getF8().getFont().getSize()));
        });
        view.getF10().addActionListener(e -> {
            view.getjTextArea().setFont(view.getF10().getFont());
            view.getFntSize().setText(String.valueOf(view.getF10().getFont().getSize()));
        });
        view.getF12().addActionListener(e -> {
            view.getjTextArea().setFont(view.getF12().getFont());
            view.getFntSize().setText(String.valueOf(view.getF12().getFont().getSize()));
        });
        view.getF14().addActionListener(e -> {
            view.getjTextArea().setFont(view.getF14().getFont());
            view.getFntSize().setText(String.valueOf(view.getF14().getFont().getSize()));
        });
        view.getF16().addActionListener(e -> {
            view.getjTextArea().setFont(view.getF16().getFont());
            view.getFntSize().setText(String.valueOf(view.getF16().getFont().getSize()));
        });
        view.getF18().addActionListener(e -> {
            view.getjTextArea().setFont(view.getF18().getFont());
            view.getFntSize().setText(String.valueOf(view.getF18().getFont().getSize()));
        });
        view.getF20().addActionListener(e -> {
            view.getjTextArea().setFont(view.getF20().getFont());
            view.getFntSize().setText(String.valueOf(view.getF20().getFont().getSize()));
        });
        view.getF22().addActionListener(e -> {
            view.getjTextArea().setFont(view.getF22().getFont());
            view.getFntSize().setText(String.valueOf(view.getF22().getFont().getSize()));
        });
        view.getF24().addActionListener(e -> {
            view.getjTextArea().setFont(view.getF24().getFont());
            view.getFntSize().setText(String.valueOf(view.getF24().getFont().getSize()));
        });


    }


}
