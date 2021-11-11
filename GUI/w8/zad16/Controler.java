package w8.zad16;

public class Controler {

    private View view;
    private Model model;

    Controler(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void initControler(){

        view.getButtonClear().addActionListener(e ->
        {
            System.out.println("jb1");
//            model.setA(Integer.parseInt(view.getJtf1().toString()));
//            model.setB(Integer.parseInt(view.getJtf2().toString()));
//            model.setC(Integer.parseInt(view.getJtf3().toString()));
//
//            view.getJl().setText("x1=" + model.getX1() + ", x2=" + model.getX2());
        });
    }
}
