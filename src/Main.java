import controller.MainController;
import dao.RechnerDAO;
import view.MainView;

public class Main {
    public static void main(String[] args){
        new MainController(new RechnerDAO(), new MainView(700, 500));
    }
}
