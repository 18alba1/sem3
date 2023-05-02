package integration;

import java.util.ArrayList;
import DTOs.*;

/*
 * The external inventory of the program
 */
public class ExternalInventory 
{
    /*
     * The external inventory
     */
    public ExternalInventory ()
    {

    }

    /*
     * Returns an ItemDTO object with the specified barcode 
     * 
     * @param barcode, the unique barcode identifier of the item
     * @return an ItemDTO object with the specified barcode and other values for all other parameters
     */
    public static ItemDTO getItem (int barcode)      
    {
        ItemDTO item = new ItemDTO(barcode, null, barcode, null, barcode, barcode);

        return item;
    }

    /*
     * Updates inventory
     * 
     * @param items, an Array list of all items
     */
    public static void updateInventory (ArrayList<ItemDTO> items)    
    {
        // Behöver ej koda
    }
}
