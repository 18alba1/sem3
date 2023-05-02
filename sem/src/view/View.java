package view;
import DTOs.ItemDTO;
import DTOs.ReceiptDTO;
import controller.*;

/*
 * The view which uses the controller to make method calls
 */
public class View 
{
    /*
     * Creates a new instance of this class that uses the Controller. This is needed to make calls in other layers
     * 
     * @param Represents the controller
     */
    public View(Controller contr)
    {
        
       contr.startSale();

       ItemDTO item = contr.scanProduct(0);

       contr.pay(0);

       ReceiptDTO receipt = contr.endTransaction();
 
    }
}