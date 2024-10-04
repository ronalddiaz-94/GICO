package gico.com.sistemagico.cliente.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class actividadesCliente {

    @SerializedName("activityclientid")
    @Expose
    private Integer activityclientid;
    @SerializedName("activityclientdescription")
    @Expose
    private String activityclientdescription;
    @SerializedName("activityclientcost")
    @Expose
    private Double activityclientcost;
    @SerializedName("activityclientdate")
    @Expose
    private String activityclientdate;
    @SerializedName("clientid")
    @Expose
    private Integer clientid;

    public Integer getActivityclientid() {
        return activityclientid;
    }

    public void setActivityclientid(Integer activityclientid) {
        this.activityclientid = activityclientid;
    }

    public String getActivityclientdescription() {
        return activityclientdescription;
    }

    public void setActivityclientdescription(String activityclientdescription) {
        this.activityclientdescription = activityclientdescription;
    }

    public Double getActivityclientcost() {
        return activityclientcost;
    }

    public void setActivityclientcost(Double activityclientcost) {
        this.activityclientcost = activityclientcost;
    }

    public String getActivityclientdate() {
        return activityclientdate;
    }

    public void setActivityclientdate(String activityclientdate) {
        this.activityclientdate = activityclientdate;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }
}
