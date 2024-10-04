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
public class cBadInventory {
    private Integer returnedProductId;
    private Integer productId;
    private String productName;
    private Integer productCount;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }



    public Integer getReturnedProductId() {
        return returnedProductId;
    }

    public void setReturnedProductId(Integer returnedProductId) {
        this.returnedProductId = returnedProductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
    
    
    
}
