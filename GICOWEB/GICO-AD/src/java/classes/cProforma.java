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
public class cProforma {
    private cProduct oProduct;
    private cClient oClient;
        
    /*--------General de proforma----------*/
    
    private Integer proformaMType;
    private Integer proformaId;
    private Integer clientId;
    private Double proformaTotal;
    private Integer proformaTime;
    private Integer proformaState;
    private String proformaDate;

    public Integer getProformaMType() {
        return proformaMType;
    }

    public void setProformaMType(Integer proformaMType) {
        this.proformaMType = proformaMType;
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

    public Integer getProformaId() {
        return proformaId;
    }

    public void setProformaId(Integer proformaId) {
        this.proformaId = proformaId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Double getProformaTotal() {
        return proformaTotal;
    }

    public void setProformaTotal(Double proformaTotal) {
        this.proformaTotal = proformaTotal;
    }

    public Integer getProformaTime() {
        return proformaTime;
    }

    public void setProformaTime(Integer proformaTime) {
        this.proformaTime = proformaTime;
    }

    public Integer getProformaState() {
        return proformaState;
    }

    public void setProformaState(Integer proformaState) {
        this.proformaState = proformaState;
    }

    public String getProformaDate() {
        return proformaDate;
    }

    public void setProformaDate(String proformaDate) {
        this.proformaDate = proformaDate;
    }

  
    
}