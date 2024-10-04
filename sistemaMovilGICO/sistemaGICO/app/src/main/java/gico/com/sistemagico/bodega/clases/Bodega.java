package gico.com.sistemagico.bodega.clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Bodega implements Serializable{

    @SerializedName("cellarId")
    @Expose
    private Integer cellarId;
    @SerializedName("cellarName")
    @Expose
    private String cellarName;
    @SerializedName("cellarManager")
    @Expose
    private String cellarManager;
    @SerializedName("cellarMType")
    @Expose
    private Integer cellarMType;

    public Integer getCellarId() {
        return cellarId;
    }

    public void setCellarId(Integer cellarId) {
        this.cellarId = cellarId;
    }

    public String getCellarName() {
        return cellarName;
    }

    public void setCellarName(String cellarName) {
        this.cellarName = cellarName;
    }

    public String getCellarManager() {
        return cellarManager;
    }

    public void setCellarManager(String cellarManager) {
        this.cellarManager = cellarManager;
    }

    public Integer getCellarMType() {
        return cellarMType;
    }

    public void setCellarMType(Integer cellarMType) {
        this.cellarMType = cellarMType;
    }
}
