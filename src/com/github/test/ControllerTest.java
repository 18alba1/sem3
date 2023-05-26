package com.github.test;

import org.junit.After;
import org.junit.Test;

import com.github.controller.Controller;
import com.github.dtos.*;
import com.github.integration.*;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest
{
    private Controller contr;
    
    public ControllerTest() 
    {
        contr = new Controller(new AccountingSystem(), new ExternalInventoryTest(), new SaleLog());
        contr.startSale();
    }

    @After
    public void reset() 
    {
        contr = null;
    }

    @Test
    public void testScanProduct_AddProduct()
    {
        contr.scanProduct(1);
        ReceiptDTO receipt = contr.endTransaction();

        assertEquals(1, receipt.getItems().size(), "Scanned product didnt get added.");
    }

    @Test
    public void testScanProduct_Quantity()
    {
        contr.scanProduct(1);
        contr.scanProduct(1);

        ReceiptDTO receipt = contr.endTransaction();

        assertEquals(2, receipt.getItems().get(0).getQuantity(), "Didnt increase the item quantity correctly.");
    }

    @Test
    public void testScanProduct_ItemNotFound()
    {
        contr.scanProduct(50);
        ReceiptDTO receipt = contr.endTransaction();

        assertEquals(0, receipt.getItems().size(), "Item that does not exist got added to the receipt.");
    }

    @Test
    public void pay_Change() 
    {
        contr.scanProduct(1);       //10kr
        contr.scanProduct(1);       //10kr
        contr.scanProduct(3);       //15kr
        contr.pay(40);
        double change = 40 - 35;
        ReceiptDTO receipt = contr.endTransaction();

        assertEquals(change, receipt.getChange(), "Not the correct change back.");
    }

    @Test
    public void testEndTransaction_change() 
    {
        contr.startSale();

        contr.scanProduct(1);
        contr.scanProduct(2);
        contr.scanProduct(2);
        contr.scanProduct(3);

        double change = contr.pay(500);
        ReceiptDTO receipt = contr.endTransaction();

        assertEquals(change, receipt.getChange(), "Not the correct change back.");
    }

    @Test
    public void testEndTransaction_totalPrice() 
    {
        contr.startSale();

        ItemDTO item1 = contr.scanProduct(1);
        ItemDTO item2 = contr.scanProduct(2);
        ItemDTO item3 = contr.scanProduct(2);
        ItemDTO item4 = contr.scanProduct(3);
        double totalPrice = item1.getPrice() + item2.getPrice() + item3.getPrice() + item4.getPrice();
        
        contr.pay(500);
        ReceiptDTO receipt = contr.endTransaction();

        assertEquals(totalPrice, receipt.getTotalPrice(), "Wrong total price.");
    }

    @Test
    public void testEndTransaction_totalVAT() 
    {
        contr.startSale();

        ItemDTO item1 = contr.scanProduct(1);
        ItemDTO item2 = contr.scanProduct(2);
        ItemDTO item3 = contr.scanProduct(2);
        ItemDTO item4 = contr.scanProduct(3);

        double totalVAT = (item1.getPrice() * (item1.getVAT() / 100)) + (item2.getPrice() * (item2.getVAT() / 100)) + 
                            (item3.getPrice() * (item3.getVAT() / 100)) + (item4.getPrice() * (item4.getVAT() / 100));

        contr.pay(500);
        ReceiptDTO receipt = contr.endTransaction();

        assertEquals(totalVAT, receipt.getTotalVAT(), "wrong total VAT.");
    }

    @Test
    public void testEndTransaction_numberOfItems() 
    {
        contr.startSale();

        contr.scanProduct(1);
        contr.scanProduct(2);
        contr.scanProduct(2);
        contr.scanProduct(3);

        contr.pay(500);
        ReceiptDTO receipt = contr.endTransaction();

        assertEquals(3, receipt.getItems().size(), "Wrong number of items in receipt.");
    }

    @Test
    public void testEndTransactionCorrectItemsAdded() 
    {
        contr.startSale();

        ItemDTO item1 = contr.scanProduct(1);
        ItemDTO item2 = contr.scanProduct(2);
        ItemDTO item3 = contr.scanProduct(3);

        contr.pay(500);

        ReceiptDTO receipt = contr.endTransaction();

        assertTrue(receipt.getItems().get(0).getItemNumber() == item1.getItemNumber() 
                    && receipt.getItems().get(1).getItemNumber() == item2.getItemNumber() 
                    && receipt.getItems().get(2).getItemNumber() == item3.getItemNumber(), "Not the correct items added to the receipt.");
    }

}