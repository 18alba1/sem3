package model;

import DTOs.ItemDTO;
import DTOs.ReceiptDTO;
import java.util.ArrayList;

/*
 * The register of the program
 */
public class Register 
{
    private double totalPrice;
    private double totalVAT; 
    private double change;

    /*
     * The register
     */
    public Register ()
    {

    }

    /*
     * Updates the total price of the sale with the price of the given item.
     * @param item The item to add to the sale total.
     */
    public void updateTotal (ItemDTO item)
    {
        totalPrice = item.getPrice();
        
        //Display.updateTotal()
    }

    /*
     * Calculates the change owed to the customer after they pay the given amount.
     * @param paidAmount The amount paid by the customer.
     * @return The change owed to the customer.
     */
    public double payment(double paidAmount) 
    {
        change = paidAmount - totalPrice;
    
        return change;
    }

    /*
     * Creates a new receipt for the given list of items.
     * @param items The list of items to include in the receipt.
     * @return The newly created receipt.
     */
    public ReceiptDTO createReceipt (ArrayList<ItemDTO> items)
    {
        ReceiptDTO receipt = new ReceiptDTO(totalPrice, totalVAT, change, items);
        return receipt;
    }
    
    /*
     * Returns the total price of the sale.
     * @return The total price of the sale.
     */
    public double getTotalPrice ()
    {
        return this.totalPrice;
    }

    /*
     * Gets the total VAT of the sale.
     * @return The total VAT of the sale.
     */
    public double getTotalVAT ()
    {
        return this.totalVAT;
    }

    /*
     * Gets the change owed to the customer.
     * @return The change owed to the customer.
     */
    public double getChange ()
    {
        return this.change;
    }
}
