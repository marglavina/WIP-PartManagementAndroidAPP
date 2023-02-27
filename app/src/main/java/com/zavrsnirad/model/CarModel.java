package com.zavrsnirad.model;

public class CarModel {


    private int model_ID;

    private String modelName;

    private CarBrand carBrand;

    public int getModel_ID() {
        return model_ID;
    }

    public void setModel_ID(int model_ID) {
        this.model_ID = model_ID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

}
