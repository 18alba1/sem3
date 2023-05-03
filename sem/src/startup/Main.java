package startup;

import controller.Controller;
import integration.*;
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

        new View(controller);

        new AccountingSystem();
        new ExternalInventory();
        new SaleLog();
    }
}
