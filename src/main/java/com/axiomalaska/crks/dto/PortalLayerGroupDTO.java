package com.axiomalaska.crks.dto;


public class PortalLayerGroupDTO extends AbstractDTO {

    private Integer id;
    private Integer idLayerGroup;
    private Integer idPortal;
    private int sortOrder;

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

    public Integer getIdPortal() {
        return this.idPortal;
    }
    
    public void setIdPortal(Integer idPortal) {
        this.idPortal = idPortal;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }
    
    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }
}