package w8.zad16;

public class Main {
    public static void main(String[] args)
    {
        Model model = new Model();
        View view = new View();

        Controler controller = new Controler(view, model);

//        controller.initView();
//        controller.initController();
    }
}
