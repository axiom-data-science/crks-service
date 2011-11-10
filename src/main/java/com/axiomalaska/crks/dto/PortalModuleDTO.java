package com.axiomalaska.crks.dto;

public class PortalModuleDTO extends AbstractDTO {
    private Integer id;
    private Integer idModule;
    private Integer idPortal;
    private int sortOrder;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdModule() {
        return this.idModule;
    }
    
    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
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