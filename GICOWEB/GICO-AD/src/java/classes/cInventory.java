/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.math.BigDecimal;

/**
 *
 * @author Ronald
 */
public class cInventory {
    private cProduct oProduct;
    private cCellar oCellar;
    private Integer productCountCellar;
    
    /*--------General de inventario----------*/
    
    private Double ProductsPrice;
    private Double ProductsCount;
    private Double ProductsUtility;
    private Double totalPrice;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getProductsUtility() {
        return ProductsUtility;
    }

    public void setProductsUtility(Double ProductsUtility) {
        this.ProductsUtility = ProductsUtility;
    }

    public Double getProductsPrice() {
        return ProductsPrice;
    }

    public void setProductsPrice(Double ProductsPrice) {
        this.ProductsPrice = ProductsPrice;
    }

    public Double getProductsCount() {
        return ProductsCount;
    }

    public void setProductsCount(Double ProductsCount) {
        this.ProductsCount = ProductsCount;
    }
    
    
    

    public Integer getProductCountCellar() {
        return productCountCellar;
    }

    public void setProductCountCellar(Integer productCountCellar) {
        this.productCountCellar = productCountCellar;
    }
    
    public cProduct getoProduct() {
        return oProduct;
    }

    public void setoProduct(cProduct oProduct) {
        this.oProduct = oProduct;
    }

    public cCellar getoCellar() {
        return oCellar;
    }

    public void setoCellar(cCellar oCellar) {
        this.oCellar = oCellar;
    }
    
    
}
