package integration;

/*
 * A class that creates other classes
 */
public class DbCreator 
{
    /*
     * Creates external inventory etc
     */
    public DbCreator ()
    {
        AccountingSystem accounting = new AccountingSystem();
        ExternalInventory externalInventory = new ExternalInventory();
        SaleLog saleLog = new SaleLog();
    }
}
