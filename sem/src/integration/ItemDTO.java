package integration;

public class ItemDTO 
{
    private int itemNumber;
    private String name;
    private double price;
    private String description;
    private double vat;

    public ItemDTO (int itemNumber, String name, double price, String description, double vat)
    {
        this.itemNumber = itemNumber;
        this.name = name;
        this.price = price;
        this.description = description;
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

    public double getVAT ()
    {
        return vat;
    }

    public void setVAT (int newVAT)
    {
        vat = newVAT;
    }
}
