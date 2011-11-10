package com.axiomalaska.crks.dto;


public class LayerTypeDTO extends AbstractDTO {
    private Integer id;
    private String type;
    private String label;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
}