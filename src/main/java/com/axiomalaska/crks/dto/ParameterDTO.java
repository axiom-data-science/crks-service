package com.axiomalaska.crks.dto;


public class ParameterDTO extends AbstractDTO {

    private Integer id;
    private Integer idParameterType;
    private String label;
    private String unit;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdParameterType() {
        return this.idParameterType;
    }
    
    public void setIdParameterType(Integer idParameterType) {
        this.idParameterType = idParameterType;
    }

    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }

    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
}