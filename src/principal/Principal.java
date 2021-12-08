package principal;
import controller.Controller;
import model.Model;
import view.View;

public class Principal {
    public static void main(String [] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Controller(new Model(), new View());
            }
        });


    }
}
