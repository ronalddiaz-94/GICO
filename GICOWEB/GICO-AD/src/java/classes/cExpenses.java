/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Ronald
 */
public class cExpenses {
    
    private Integer expensesId;
    private String expensesDescription;
    private Double expensesCost;
    private Integer businessId;
    private Integer expensesMType;

    public Integer getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(Integer expensesId) {
        this.expensesId = expensesId;
    }

    public String getExpensesDescription() {
        return expensesDescription;
    }

    public void setExpensesDescription(String expensesDescription) {
        this.expensesDescription = expensesDescription;
    }

    public Double getExpensesCost() {
        return expensesCost;
    }

    public void setExpensesCost(Double expensesCost) {
        this.expensesCost = expensesCost;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getExpensesMType() {
        return expensesMType;
    }

    public void setExpensesMType(Integer expensesMType) {
        this.expensesMType = expensesMType;
    }
    
    
    
    
}
