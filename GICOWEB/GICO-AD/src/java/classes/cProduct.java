package classes;

import java.math.BigDecimal;

public class cProduct {
    private Integer productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Double productIva;   
    private String productDateExpiration;   
    private Double productCount; 
    private Integer productMType;
    private Double productTotalValue;
    private Double productUtility;
    private Double productAveragePrice;
    private String productDetail;
    private Double productValue;
    private Double productcountprocess;
    private cProvider oProvider;
    private cCellar oCellar;

    public cProvider getoProvider() {
        return oProvider;
    }

    public void setoProvider(cProvider oProvider) {
        this.oProvider = oProvider;
    }

    public cCellar getoCellar() {
        return oCellar;
    }

    public void setoCellar(cCellar oCellar) {
        this.oCellar = oCellar;
    }

    public Integer getProductMType() {
        return productMType;
    }

    public void setProductMType(Integer productMType) {
        this.productMType = productMType;
    }
    
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductIva() {
        return productIva;
    }

    public void setProductIva(Double productIva) {
        this.productIva = productIva;
    }

    public String getProductDateExpiration() {
        return productDateExpiration;
    }

    public void setProductDateExpiration(String productDateExpiration) {
        this.productDateExpiration = productDateExpiration;
    }

    public Double getProductCount() {
        return productCount;
    }

    public void setProductCount(Double productCount) {
        this.productCount = productCount;
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

    public Double getProductAveragePrice() {
        return productAveragePrice;
    }

    public void setProductAveragePrice(Double productAveragePrice) {
        this.productAveragePrice = productAveragePrice;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public Double getProductValue() {
        return productValue;
    }

    public void setProductValue(Double productValue) {
        this.productValue = productValue;
    }

    public Double getProductcountprocess() {
        return productcountprocess;
    }

    public void setProductcountprocess(Double productcountprocess) {
        this.productcountprocess = productcountprocess;
    }
    
    
}
    