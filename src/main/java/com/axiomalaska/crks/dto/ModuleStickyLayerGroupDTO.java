package com.axiomalaska.crks.dto;


public class ModuleStickyLayerGroupDTO extends AbstractDTO {
    private Integer id;
    private Integer idLayerGroup;
    private Integer idModule;
    private boolean top;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdLayerGroup() {
        return this.idLayerGroup;
    }
    
    public void setIdLayerGroup(Integer idLayerGroup) {
        this.idLayerGroup = idLayerGroup;
    }

    public Integer getIdModule() {
        return this.idModule;
    }
    
    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public boolean isTop() {
        return this.top;
    }
    
    public void setTop(boolean top) {
        this.top = top;
    }
}