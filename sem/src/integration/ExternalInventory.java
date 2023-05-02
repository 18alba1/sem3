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
     * 
     */
    public static ItemDTO getItem (int barcode)      
    {
        ItemDTO item = new ItemDTO(barcode, null, barcode, null, barcode, barcode);

        return item;
    }

    public static void updateInventory (ArrayList<ItemDTO> items)    
    {
        // Behöver ej koda
    }
}
