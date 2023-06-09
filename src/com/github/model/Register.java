package com.github.model;

import java.util.ArrayList;

import com.github.dtos.*;
import com.github.integration.*;

/*
 * The register of the program
 */
public class Register 
{
    private double totalPrice;
    private double totalVAT; 
    private double change;
    private AccountingSystem accountingSystem;
    private SaleLog saleLog;

    /*
     * The register
     */
    public Register(AccountingSystem accountingSystem, SaleLog saleLog)
    {
        this.accountingSystem = accountingSystem;
        this.saleLog = saleLog;
    }

    /*
     * Updates the total price of the sale with the price of the given item.
     * @param item The item to add to the sale total.
     */
    public void updateTotal(ItemDTO item)
    {
        totalPrice += item.getPrice();
        totalVAT += item.getPrice() * (item.getVAT() / 100);
    }

    /*
     * Calculates the change owed to the customer after they pay the given amount.
     * @param paidAmount The amount paid by the customer.
     * @return The change owed to the customer.
     */
    public double payment(double paidAmount) 
    {
        change = paidAmount - totalPrice;
    
        return change;
    }

    /*
     * Creates a new receipt for the given list of items.
     * @param items The list of items to include in the receipt.
     * @return The newly created receipt.
     */
    public ReceiptDTO createReceipt(ArrayList<ItemDTO> items)
    {
        ReceiptDTO receipt = new ReceiptDTO(totalPrice, totalVAT, change, items);

        accountingSystem.updateAccountingInfo(receipt);
        saleLog.addSale(receipt);

        return receipt;
    }
    
    /*
     * Returns the total price of the sale.
     * @return The total price of the sale.
     */
    public double getTotalPrice()
    {
        return this.totalPrice;
    }

    /*
     * Gets the total VAT of the sale.
     * @return The total VAT of the sale.
     */
    public double getTotalVAT()
    {
        return this.totalVAT;
    }

    /*
     * Gets the change owed to the customer.
     * @return The change owed to the customer.
     */
    public double getChange()
    {
        return this.change;
    }
}
