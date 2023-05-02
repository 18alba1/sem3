package startup;

import controller.Controller;
import integration.DbCreator;
import view.View;

/*
 * The main class that starts the program
 */
public class Main 
{

    /*
     * Used in the startup and creates controller etc
     * 
     * @param args (??????)
     */
    public static void main (String[] args)
    {
        Controller controller = new Controller();

        View view = new View(controller);
        DbCreator creator = new DbCreator();
    }
}
