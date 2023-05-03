package test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import DTOs.ItemDTO;
import DTOs.ReceiptDTO;

import org.junit.jupiter.api.AfterEach;

import controller.Controller;
import integration.DbCreator;
import model.Register;

public class controllerTest {
    private Controller contr;
    

    @BeforeEach
    public void controller_SetUp() 
    {
        contr = new Controller();
        contr.startSale();
        DbCreator creator = new DbCreator();
    }

    @AfterEach
    public void reset() 
    {
        contr = null;
    }

    @Test
    public void testScanProduct_AddProduct()
    {
        contr.scanProduct(1);
        contr.pay(30);
        ReceiptDTO receipt = contr.endTransaction();
        ArrayList<ItemDTO> item = receipt.getItems();
        assertEquals(1, item.size(), "false");
    }
}
