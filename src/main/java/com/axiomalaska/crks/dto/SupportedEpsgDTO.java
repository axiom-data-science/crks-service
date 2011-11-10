package com.axiomalaska.crks.dto;


public class SupportedEpsgDTO extends AbstractDTO {
    private Integer id;
    private Integer idOgcLayer;
    private int epsg;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOgcLayer() {
        return this.idOgcLayer;
    }
    
    public void setIdOgcLayer(Integer idOgcLayer) {
        this.idOgcLayer = idOgcLayer;
    }

    public int getEpsg() {
        return this.epsg;
    }
    
    public void setEpsg(int epsg) {
        this.epsg = epsg;
    }
}