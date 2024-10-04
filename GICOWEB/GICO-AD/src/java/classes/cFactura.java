/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Jorge
 */
public class cFactura {
    private cProduct oProduct;
    private cClient oClient;
        
    /*--------General de Factura----------*/
    
    private Integer FacturaMType;
    private Integer clientId;
    private Integer facturaId;
    private Double facturaSubTotal;
    private Double facturaIva;
    private Double facturaTotal;
    private Integer facturaState;
    private String facturaDate;

    public Integer getFacturaMType() {
        return FacturaMType;
    }

    public void setFacturaMType(Integer FacturaMType) {
        this.FacturaMType = FacturaMType;
    }

    
    public cProduct getoProduct() {
        return oProduct;
    }

    public void setoProduct(cProduct oProduct) {
        this.oProduct = oProduct;
    }

    public cClient getoClient() {
        return oClient;
    }

    public void setoClient(cClient oClient) {
        this.oClient = oClient;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }


    public Double getFacturaSubTotal() {
        return facturaSubTotal;
    }

    public void setFacturaSubTotal(Double facturaSubTotal) {
        this.facturaSubTotal = facturaSubTotal;
    }

    public Double getFacturaIva() {
        return facturaIva;
    }

    public void setFacturaIva(Double facturaIva) {
        this.facturaIva = facturaIva;
    }

    public Double getFacturaTotal() {
        return facturaTotal;
    }

    public void setFacturaTotal(Double facturaTotal) {
        this.facturaTotal = facturaTotal;
    }

    public Integer getFacturaState() {
        return facturaState;
    }

    public void setFacturaState(Integer facturaState) {
        this.facturaState = facturaState;
    }

    public String getFacturaDate() {
        return facturaDate;
    }

    public void setFacturaDate(String facturaDate) {
        this.facturaDate = facturaDate;
    }
  
}