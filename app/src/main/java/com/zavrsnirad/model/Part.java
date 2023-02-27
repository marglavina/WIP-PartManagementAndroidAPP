package com.zavrsnirad.model;

import java.sql.Date;

public class Part {

    int part_ID;

    private String partNumber;

    private Date manufDate;

    private String part_name;

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public int getPart_ID() {
        return part_ID;
    }

    public void setPart_ID(int part_ID) {
        this.part_ID = part_ID;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public Date getManufDate() {
        return manufDate;
    }

    public void setManufDate(Date manufDate) {
        this.manufDate = manufDate;
    }
}
