package com.github.test;

import org.junit.After;
import org.junit.Test;

import com.github.dtos.*;
import com.github.integration.*;

import static org.junit.jupiter.api.Assertions.*;

public class ExternalInventoryTest
{
    public ExternalInventoryTest() 
    {
    }
    
    @After
    public void reset() 
    {
    }

    @Test
    public void testGetItem()
    {
        ExternalInventory externalInventory = new ExternalInventory();

        int barcode = 1;
        ItemDTO item = externalInventory.getItem(barcode);

        assertEquals(barcode, item.getItemNumber(), "Fetched wrong item");
        assertEquals("Tomat", item.getName(), "Fetched wrong item");
        assertEquals(10, item.getPrice(), "Fetched wrong item");
        assertEquals("Röd", item.getDescription(), "Fetched wrong item");
        assertEquals(25, item.getVAT(), "Fetched wrong item");
    }

    @Test
    public void testGetItem_zero()
    {
        ExternalInventory externalInventory = new ExternalInventory();

        int barcode = 0;
        ItemDTO item = externalInventory.getItem(barcode);

        assertEquals(barcode, item.getItemNumber(), "Fetched wrong item");
        assertEquals("NOTFound", item.getName(), "Fetched wrong item");
        assertEquals(0, item.getPrice(), "Fetched wrong item");
        assertEquals("", item.getDescription(), "Fetched wrong item");
        assertEquals(0, item.getVAT(), "Fetched wrong item");
    }
    
}
