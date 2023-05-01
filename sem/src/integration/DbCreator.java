package integration;

public class DbCreator 
{
    public DbCreator ()
    {
        AccountingSystem accounting = new AccountingSystem();
        ExternalInventory externalInventory = new ExternalInventory();
        SaleLog saleLog = new SaleLog();
    }
}
