package gico.com.sistemagico.cliente.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cliente implements Serializable{

    @SerializedName("clientAddress")
    @Expose
    private String clientAddress;
    @SerializedName("clientCell")
    @Expose
    private String clientCell;
    @SerializedName("clientCi")
    @Expose
    private String clientCi;
    @SerializedName("clientCredit")
    @Expose
    private Double clientCredit;
    @SerializedName("clientId")
    @Expose
    private Integer clientId;
    @SerializedName("clientMail")
    @Expose
    private String clientMail;
    @SerializedName("clientName")
    @Expose
    private String clientName;
    @SerializedName("clientPhone")
    @Expose
    private String clientPhone;

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientCell() {
        return clientCell;
    }

    public void setClientCell(String clientCell) {
        this.clientCell = clientCell;
    }

    public String getClientCi() {
        return clientCi;
    }

    public void setClientCi(String clientCi) {
        this.clientCi = clientCi;
    }

    public Double getClientCredit() {
        return clientCredit;
    }

    public void setClientCredit(Double clientCredit) {
        this.clientCredit = clientCredit;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientMail() {
        return clientMail;
    }

    public void setClientMail(String clientMail) {
        this.clientMail = clientMail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

}