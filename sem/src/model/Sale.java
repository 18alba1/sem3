package model;

import integration.*;

public class Sale 
{
    private Register register;

    public Sale (Register register)
    {
        this.register = register;

        SaleLog.addSale(null);
    }

    public void updateTotal ()
    {
        register.updateTotal(0);

        AccountingSystem.updateAccountingInfo();

        SaleLog.addSale(null);
    }
}
