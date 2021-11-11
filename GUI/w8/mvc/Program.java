package w8.mvc;

public class Program {

    public static void main(String[] args)
    {
        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(model, view);

        controller.initController();
    }
}