package com.zavrsnirad.model;

import com.google.gson.annotations.SerializedName;

public class CarBrand {

    @SerializedName("id")
    private int ID;
    @SerializedName("brandName")
    private String brandName;

    public CarBrand( int id, String brandName){
        this.ID = id;
        this.brandName = brandName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
