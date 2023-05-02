package DTOs;

import java.util.ArrayList;

public class ReceiptDTO {
    
    private double totalPrice;
    private double totalVAT;
    private double change;
    private ArrayList<ItemDTO> items;


     /*
     * Constructs ReceiptDTO with the given parameters
     * 
     * @param totalPrice, the total price
     * @param change, the change
     * @param items, a list of items
     * @param totalVAT, the total VAT-rate
     */
    public ReceiptDTO(double totalPrice, double totalVAT, double change, ArrayList<ItemDTO> items)
    {
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.change = change;
        this.items = items;
    }

     /*
     * Gets total price
     * 
     * @return The total price 
     */
    public double getTotalPrice ()
    {
        return totalPrice;
    }

     /*
     * Gets total VAT
     * 
     * @return The total VAT 
     */
    public double getTotalVAT ()
    {
        return totalVAT;
    }

    /*
     * Gets  change
     * 
     * @return The change 
     */
    public double change ()
    {
        return change;
    }

     /*
     * Gets  items on the list
     * 
     * @return The items on the list 
     */
    public ArrayList<ItemDTO> getItems ()
    {
        return items;
    }
}
