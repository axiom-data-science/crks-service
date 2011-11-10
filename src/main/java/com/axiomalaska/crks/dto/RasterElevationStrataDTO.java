package com.axiomalaska.crks.dto;


public class RasterElevationStrataDTO extends AbstractDTO {
    private Integer id;
    private Integer idRasterLayer;
    private double elevationMeters;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdRasterLayer() {
        return this.idRasterLayer;
    }
    
    public void setIdRasterLayer(Integer idRasterLayer) {
        this.idRasterLayer = idRasterLayer;
    }

    public double getElevationMeters() {
        return this.elevationMeters;
    }
    
    public void setElevationMeters(double elevationMeters) {
        this.elevationMeters = elevationMeters;
    }
}