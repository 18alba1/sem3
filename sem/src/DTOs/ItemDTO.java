package DTOs;

public class ItemDTO 
{
    private int itemNumber;
    private String name;
    private double price;
    private String description;
    private int quantity;
    private double vat;

    public ItemDTO (int itemNumber, String name, double price, String description, int quantity, double vat)
    {
        this.itemNumber = itemNumber;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.vat = vat;
    }

    public double getPrice ()
    {
        return price;
    }

    public void setPrice (double newPrice)
    {
        price = newPrice;
    }

    public int getItemNumber ()
    {
        return itemNumber;
    }

    public void setItemNumber (int newItemNumber)
    {
        itemNumber = newItemNumber;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String newName)
    {
        name = newName;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String newDescription)
    {
        description = newDescription;
    }

    public int getQuantity ()
    {
        return quantity;
    }

    public void setQuantity (int quantity)
    {
        this.quantity = quantity;
    }

    public double getVAT ()
    {
        return vat;
    }

    public void setVAT (int newVAT)
    {
        vat = newVAT;
    }
}
