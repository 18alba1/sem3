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
import model.Goods;
import model.Register;

public class RegisterTest {
    private Register register;

    public RegisterTest() {
        register = new Register();
        DbCreator creator = new DbCreator();
    }

    @After
    public void reset() 
    {
        register = null;
    }

    @Test
    public void testUpdateTotal()
    {
        
    }

}
