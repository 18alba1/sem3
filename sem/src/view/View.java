package view;
import controller.*;

public class View 
{
    public View(Controller contr)
    {
        contr.startSale();

        contr.scanProduct(0);

        contr.pay(0);

        contr.endTransaction();
    }
}

//display ?