package com.github.model;

import java.util.ArrayList;

import com.github.dtos.ItemDTO;
import com.github.integration.ExternalInventory;

/*
 * the goods/items
 */
public class Goods 
{
    private ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();
    private ExternalInventory externalInventory;

    /*
     * goods
     */
    public Goods(ExternalInventory externalInventory)
    {
        this.externalInventory = externalInventory;
    }

    /*
     * gets items of the list
     * 
     * @return an ArrayList containg items
     */
    public ArrayList<ItemDTO> getItems()
    {
        return items; 
    }

    /*
     * Checks if the given ItemDTO already exists in the list of items.
     * If it exists, the quantity of the existing item is increased by 1.
     * @param item The ItemDTO to check for duplicates.
     * @return true if the ItemDTO already exists in the list, false otherwise.
     */
    private boolean checkIfDuplicatedItem(ItemDTO item) 
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

    /*
     * Adds a new product with the given barcode to the list if it  exsist.
     * @param barcode The barcode of the product to be added.
     * @return The ItemDTO object representing the added product.
     */
    public ItemDTO addProduct(int barcode)
    {
        ItemDTO item = externalInventory.getItem(barcode);
        if (item.getItemNumber() != 0)
        {
        boolean found = checkIfDuplicatedItem(item);
        if (found == false)
            items.add(item);
        }
        return item;
    }
}
