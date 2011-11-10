package com.axiomalaska.crks.dto;


public class RasterLayerDTO extends OgcLayerDTO {
    private Integer idModelVariable;
    private String wcsUrl;

    public Integer getIdModelVariable() {
        return this.idModelVariable;
    }
    
    public void setIdModelVariable(Integer idModelVariable) {
        this.idModelVariable = idModelVariable;
    }

    public String getWcsUrl() {
        return this.wcsUrl;
    }
    
    public void setWcsUrl(String wcsUrl) {
        this.wcsUrl = wcsUrl;
    }
}