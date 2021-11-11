package w8.mvc;


import java.awt.*;

public class Controller {

    private View view;
    private Model model;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void initController() {

        view.getButton().addActionListener(e ->
                {
                    int newA, newB, newC;
                    try {
                        newA = Integer.valueOf(view.getTextFieldA().getText());
                        newB = Integer.valueOf(view.getTextFieldB().getText());
                        newC = Integer.valueOf(view.getTextFieldC().getText());
                        if (newA == 0){
                            view.getLabel().setText("To nie jest rownanie kwardrawow");
                            view.setRED();
                        }else {
                            model.setABC(newA, newB, newC);
                            model.calculate();
                            view.getLabel().setText("X1= " + model.getX1() + ", X2= " + model.getX2());
                            view.setGREEN();
                        }

                    } catch (NumberFormatException nfe) {
                        view.setRED();
                        view.getLabel().setText("Podaj poprawne liczby");
                    }
                }
        );

        view.getButton2().addActionListener(e ->
        {
            model.setABC(0, 0, 0);
            view.getLabel().setText("");
            view.getTextFieldA().setText("Podaj A");
            view.getTextFieldB().setText("Podaj B");
            view.getTextFieldC().setText("Podaj C");
            view.getLabel().setBackground(Color.LIGHT_GRAY);
        });

    }
}