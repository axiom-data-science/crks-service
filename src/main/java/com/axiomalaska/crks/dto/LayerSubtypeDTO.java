package com.axiomalaska.crks.dto;


public class LayerSubtypeDTO extends AbstractDTO {
    private Integer id;
    private Integer idLayerType;
    private String label;
    private Integer ZIndex;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdLayerType() {
        return this.idLayerType;
    }
    
    public void setIdLayerType(Integer idLayerType) {
        this.idLayerType = idLayerType;
    }

    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getZIndex() {
        return this.ZIndex;
    }
    
    public void setZIndex(Integer ZIndex) {
        this.ZIndex = ZIndex;
    }
}