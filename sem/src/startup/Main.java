package startup;

import controller.Controller;
import integration.DbCreator;
import view.View;

public class Main 
{

    public static void main (String[] args)
    {
        Controller controller = new Controller();

        View view = new View(controller);
        DbCreator creator = new DbCreator();
    }
}
