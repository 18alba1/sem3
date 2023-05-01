package controller;
import integration.*;
import model.*;

public class Controller 
{

    private Sale sale;

    public Controller ()
    {
        
    }
    
    public void startSale ()
    {
        sale = new Sale();
        Goods goods = new Goods(0);
    }

    public String scanProduct (int barcode)
    {

        //ExternalInventory.getDescription()

        return "";                          // fixa sen
    }
    
    public void pay (double paidAmount)
    {
        //DiscountRegister.validateID()

        Change change = new Change(0);

        sale.updateTotal();
    }

    public void validateID (IDDTO customerIdentification)    
    {

    }

    public void endTransaction ()
    {
        
    }
}
