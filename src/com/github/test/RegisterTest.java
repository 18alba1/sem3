package com.github.test;

import org.junit.After;
import org.junit.Test;

import com.github.dtos.ItemDTO;
import com.github.dtos.ReceiptDTO;
import com.github.integration.*;
import com.github.model.Register;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class RegisterTest
{
    private Register register;

    public RegisterTest()
    {

        register = new Register(new AccountingSystem(), new SaleLog());
    }

    @After
    public void reset() 
    {
        register = null;
    }

    @Test
    public void testUpdateTotal()
    {
        ItemDTO item1 = new ItemDTO(1, "Tomat",50 , "Röd", 1, 25);
        ItemDTO item2 = new ItemDTO(1, "Potatis",100 , "Röd", 1, 25);      
        register.updateTotal(item2);
        register.updateTotal(item1);
        double TotalPrice = item1.getPrice() + item2.getPrice();

        assertEquals(TotalPrice, register.getTotalPrice(), "false");
    }

    @Test
    public void testPayment()
    {
        ItemDTO item1 = new ItemDTO(1, "Tomat",50 , "Röd", 1, 25);
        ItemDTO item2 = new ItemDTO(1, "Potatis",100 , "Röd", 1, 25);      
        register.updateTotal(item2);
        register.updateTotal(item1);
        double change = 200 - register.getTotalPrice();

        assertEquals(change, register.payment(200), "false");
    }

    @Test
    public void testCreateReceipt_change() 
    {
        ExternalInventory externalInventory = new ExternalInventory();
        ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();

        ItemDTO item1 = externalInventory.getItem(1);
        ItemDTO item2 = externalInventory.getItem(2);
        ItemDTO item3 = externalInventory.getItem(2);
        ItemDTO item4 = externalInventory.getItem(3);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        register.updateTotal(item1);
        register.updateTotal(item2);
        register.updateTotal(item3);
        register.updateTotal(item4);

        double pay = 500;
        double change = pay - register.getTotalPrice();
        register.payment(pay);

        ReceiptDTO receipt = register.createReceipt(items);

        assertEquals(change, receipt.getChange(), "Not the correct change back.");
    }

    @Test
    public void testEndTransaction_totalPrice() 
    {
        ExternalInventory externalInventory = new ExternalInventory();
        ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();

        ItemDTO item1 = externalInventory.getItem(1);
        ItemDTO item2 = externalInventory.getItem(2);
        ItemDTO item3 = externalInventory.getItem(2);
        ItemDTO item4 = externalInventory.getItem(3);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        register.updateTotal(item1);
        register.updateTotal(item2);
        register.updateTotal(item3);
        register.updateTotal(item4);

        double totalPrice = item1.getPrice() + item2.getPrice() + item3.getPrice() + item4.getPrice();
        
        register.payment(500);
        ReceiptDTO receipt = register.createReceipt(items);

        assertEquals(totalPrice, receipt.getTotalPrice(), "Wrong total price.");
    }

    @Test
    public void testEndTransaction_totalVAT() 
    {
        ExternalInventory externalInventory = new ExternalInventory();
        ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();

        ItemDTO item1 = externalInventory.getItem(1);
        ItemDTO item2 = externalInventory.getItem(2);
        ItemDTO item3 = externalInventory.getItem(2);
        ItemDTO item4 = externalInventory.getItem(3);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        register.updateTotal(item1);
        register.updateTotal(item2);
        register.updateTotal(item3);
        register.updateTotal(item4);

        double totalVAT = (item1.getPrice() * (item1.getVAT() / 100)) + (item2.getPrice() * (item2.getVAT() / 100)) + 
                            (item3.getPrice() * (item3.getVAT() / 100)) + (item4.getPrice() * (item4.getVAT() / 100));

        register.payment(500);
        ReceiptDTO receipt = register.createReceipt(items);

        assertEquals(totalVAT, receipt.getTotalVAT(), "wrong total VAT.");
    }

    @Test
    public void testEndTransaction_numberOfItems() 
    {
        ExternalInventory externalInventory = new ExternalInventory();
        ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();

        ItemDTO item1 = externalInventory.getItem(1);
        ItemDTO item2 = externalInventory.getItem(2);
        ItemDTO item3 = externalInventory.getItem(3);

        items.add(item1);
        items.add(item2);
        items.add(item3);

        register.updateTotal(item1);
        register.updateTotal(item2);
        register.updateTotal(item3);

        register.payment(500);
        ReceiptDTO receipt = register.createReceipt(items);

        assertEquals(3, receipt.getItems().size(), "Wrong number of items in receipt.");
    }

    @Test
    public void testEndTransactionCorrectItemsAdded() 
    {
        ExternalInventory externalInventory = new ExternalInventory();
        ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();

        ItemDTO item1 = externalInventory.getItem(1);
        ItemDTO item2 = externalInventory.getItem(2);
        ItemDTO item3 = externalInventory.getItem(2);
        ItemDTO item4 = externalInventory.getItem(3);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        register.updateTotal(item1);
        register.updateTotal(item2);
        register.updateTotal(item3);
        register.updateTotal(item4);

        register.payment(500);
        ReceiptDTO receipt = register.createReceipt(items);

        assertTrue(receipt.getItems().get(0).getItemNumber() == item1.getItemNumber() 
                    && receipt.getItems().get(1).getItemNumber() == item2.getItemNumber() 
                    && receipt.getItems().get(2).getItemNumber() == item3.getItemNumber(), "Not the correct items added to the receipt.");
    }
}
