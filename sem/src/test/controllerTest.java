package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import DTOs.ItemDTO;
import DTOs.ReceiptDTO;

import controller.Controller;
import integration.DbCreator;
import model.Register;

public class controllerTest {
    private Controller contr;
    

    
    public controllerTest() 
    {
        contr = new Controller();
        contr.startSale();
        DbCreator creator = new DbCreator();
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

        assertEquals(1, receipt.getItems().size(), "false");
    }

    @Test
    public void testScanProduct_Quantity()
    {
        contr.scanProduct(1);
        contr.scanProduct(1);

        ReceiptDTO receipt = contr.endTransaction();

        assertEquals(2, receipt.getItems().get(0).getQuantity(), "false");
    }

    @Test
    public void testScanProduct_ItemNotFound()
    {
        contr.scanProduct(50);
        ReceiptDTO receipt = contr.endTransaction();

        assertEquals(0, receipt.getItems().size(), "false");
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

        assertEquals(change, receipt.getChange(), "false");
    }
}
