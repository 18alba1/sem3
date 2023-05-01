package controller;
import integration.*;
import model.*;

public class Controller 
{
    private Goods goods;
    private Register register;

    public Controller ()
    {
        this.register = new Register();
    }
    
    public void startSale ()
    {
        goods = new Goods();
    }

    public String scanProduct (int barcode)
    {
        String description = goods.addProduct(barcode);

        return description;
    }
    
    public void pay (double paidAmount)
    {
        //Change change = new Change(0);
    }

    public void endTransaction ()
    {
        
    }
}
