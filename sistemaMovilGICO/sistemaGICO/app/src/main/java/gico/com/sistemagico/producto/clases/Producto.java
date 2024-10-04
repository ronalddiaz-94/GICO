package gico.com.sistemagico.producto.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Producto implements Serializable{

    @SerializedName("productAveragePrice")
    @Expose
    private Double productAveragePrice;
    @SerializedName("productCount")
    @Expose
    private Double productCount;
    @SerializedName("productDateExpiration")
    @Expose
    private String productDateExpiration;
    @SerializedName("productDescription")
    @Expose
    private String productDescription;
    @SerializedName("productId")
    @Expose
    private Integer productId;
    @SerializedName("productIva")
    @Expose
    private Double productIva;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productPrice")
    @Expose
    private Double productPrice;
    @SerializedName("productTotalValue")
    @Expose
    private Double productTotalValue;
    @SerializedName("productUtility")
    @Expose
    private Double productUtility;

    public Double getProductAveragePrice() {
        return productAveragePrice;
    }

    public void setProductAveragePrice(Double productAveragePrice) {
        this.productAveragePrice = productAveragePrice;
    }

    public Double getProductCount() {
        return productCount;
    }

    public void setProductCount(Double productCount) {
        this.productCount = productCount;
    }

    public String getProductDateExpiration() {
        return productDateExpiration;
    }

    public void setProductDateExpiration(String productDateExpiration) {
        this.productDateExpiration = productDateExpiration;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getProductIva() {
        return productIva;
    }

    public void setProductIva(Double productIva) {
        this.productIva = productIva;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductTotalValue() {
        return productTotalValue;
    }

    public void setProductTotalValue(Double productTotalValue) {
        this.productTotalValue = productTotalValue;
    }

    public Double getProductUtility() {
        return productUtility;
    }

    public void setProductUtility(Double productUtility) {
        this.productUtility = productUtility;
    }

}
