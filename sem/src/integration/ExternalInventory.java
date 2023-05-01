package integration;

public class ExternalInventory 
{
    public ExternalInventory ()
    {

    }

    public static ItemDTO getDescription (int barcode)      // fixa retunr DTO
    {

        ItemDTO item = new ItemDTO(barcode, null, barcode, null, barcode, barcode);

        updateInventory(item);

        return item;
    }

    public static void updateInventory (ItemDTO itemDescription)    // fixa parameter DTO
    {

    }
}
