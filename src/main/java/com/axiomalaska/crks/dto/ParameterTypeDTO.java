package com.axiomalaska.crks.dto;


public class ParameterTypeDTO extends AbstractDTO {

    private Integer id;
    private String label;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
}