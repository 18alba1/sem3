package model;

import java.util.ArrayList;
import integration.*;

public class Goods 
{
    private Receipt receipt;
    private ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();

    public Goods ()
    {
        receipt = new Receipt();
    }

    public String addProduct (int barcode)
    {
        ItemDTO item = ExternalInventory.getDescription(barcode);

        items.add(item);

        return item.getDescription();
    }

}
