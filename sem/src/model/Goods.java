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

    private void isDuplicateItem(Goods item, int quantity) {
        boolean found = false;
        for (int i = 0; i < items.size(); i++) {
            Goods currentItem = items.get(i);
            if (currentItem.getDescription() == item.getDescription) {
                found = true;
                int newQuantity = ItemDTO.getQuantity(i) + quantity;
                ItemDTO.setQuantity(i, newQuantity);
                break;
            }
        }
    }

    public double pay(double paidAmount) {
        double change = paidAmount - Register.getTotalPrice();
    
        return change;
    }

    public String addProduct (int barcode)
    {
        ItemDTO item = ExternalInventory.getDescription(barcode);

        items.add(item);

        return item.getDescription();
    }

}
