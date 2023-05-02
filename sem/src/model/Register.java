package model;

import DTOs.ItemDTO;
import DTOs.ReceiptDTO;
import java.util.ArrayList;

public class Register 
{
    private double totalPrice;
    private double totalVAT; 
    private double change;

    public Register ()
    {

    }

    public void updateTotal (ItemDTO item)
    {
        totalPrice = item.getPrice();
        
        //Display.updateTotal()
    }

    public double payment(double paidAmount) 
    {
        change = paidAmount - totalPrice;
    
        return change;
    }

    public ReceiptDTO createReceipt (ArrayList<ItemDTO> items)
    {
        ReceiptDTO receipt = new ReceiptDTO(0,0,0,null);
        return receipt;

    }
    
    public double getTotalPrice ()
    {
        return this.totalPrice;
    }

    public double getTotalVAT ()
    {
        return this.totalVAT;
    }

    public double getChange ()
    {
        return this.change;
    }
}
