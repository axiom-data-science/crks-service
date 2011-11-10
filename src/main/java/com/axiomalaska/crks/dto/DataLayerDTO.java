package com.axiomalaska.crks.dto;

public class DataLayerDTO extends LayerDTO {
    private String dataRequestUrl;
    private boolean sensor;

    public String getDataRequestUrl() {
        return this.dataRequestUrl;
    }
    
    public void setDataRequestUrl(String dataRequestUrl) {
        this.dataRequestUrl = dataRequestUrl;
    }

    public boolean isSensor() {
        return this.sensor;
    }
    
    public void setSensor(boolean sensor) {
        this.sensor = sensor;
    }
}