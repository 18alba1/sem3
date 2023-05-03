package test;

import org.junit.After;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import DTOs.ItemDTO;
import integration.DbCreator;
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

}
