package model;

import java.util.ArrayList;
import integration.*;

public class Receipt 
{
    private double totalPrice;
    private double totalVat;

    private double change;
    private ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();

    public Receipt (int saleInformation)
    {

    }

    public void addProduct (String itemDescription)         // fixa parameter DTO sen
    {

    }
}
