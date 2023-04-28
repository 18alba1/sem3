package integration;

public class DbCreator 
{
    public DbCreator ()
    {
        AccountingSystem accounting = new AccountingSystem();
        DiscountRegister discountRegister = new DiscountRegister();
        ExternalInventory externalInventory = new ExternalInventory();
        SaleLog saleLog = new SaleLog();
    }
}
