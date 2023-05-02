package model;

import java.util.ArrayList;
import DTOs.ItemDTO;
import integration.*;

public class Goods 
{
    private ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();

    public Goods ()
    {
        
    }

    public ArrayList<ItemDTO> getItems ()
    {
        return items; 
    }

    private boolean duplicateItem(ItemDTO item) 
    {
        boolean found = false;

        for (int i = 0; i < items.size(); i++)
        {
            ItemDTO currentItem = items.get(i);
            
            if (currentItem.getDescription() == item.getDescription())
            {
                found = true;
                int newQuantity = currentItem.getQuantity() + 1;
                currentItem.setQuantity(newQuantity);
                break;
            }
        }

        return found;

    }

    public ItemDTO addProduct (int barcode)
    {
        ItemDTO item = ExternalInventory.getItem(barcode);

        boolean found = duplicateItem (item);
        if (found == false)
         items.add(item);

        return item;
    }

}
