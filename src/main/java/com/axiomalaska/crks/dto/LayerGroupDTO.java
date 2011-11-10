package com.axiomalaska.crks.dto;

import java.util.Date;

public class LayerGroupDTO extends AbstractDTO {
    private Integer id;
    private Integer idModule;
    private Integer idLayerType;
    private String label;
    private String description;
    private String metadataUrl;
    private Date startTimeUtc;
    private Date endTimeUtc;
    private Double minLng;
    private Double minLat;
    private Double maxLng;
    private Double maxLat;

    private boolean hasMetadata = false;
    
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

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetadataUrl() {
        return this.metadataUrl;
    }
    
    public void setMetadataUrl(String metadataUrl) {
        this.metadataUrl = metadataUrl;
    }

    public Date getStartTimeUtc() {
        return this.startTimeUtc;
    }
    
    public void setStartTimeUtc(Date startTimeUtc) {
        this.startTimeUtc = startTimeUtc;
    }

    public Date getEndTimeUtc() {
        return this.endTimeUtc;
    }
    
    public void setEndTimeUtc(Date endTimeUtc) {
        this.endTimeUtc = endTimeUtc;
    }

    public Double getMinLng() {
        return this.minLng;
    }
    
    public void setMinLng(Double minLng) {
        this.minLng = minLng;
    }

    public Double getMinLat() {
        return this.minLat;
    }
    
    public void setMinLat(Double minLat) {
        this.minLat = minLat;
    }

    public Double getMaxLng() {
        return this.maxLng;
    }
    
    public void setMaxLng(Double maxLng) {
        this.maxLng = maxLng;
    }

    public Double getMaxLat() {
        return this.maxLat;
    }
    
    public void setMaxLat(Double maxLat) {
        this.maxLat = maxLat;
    }
    
    public boolean getHasMetadata() {
        return hasMetadata;
    }

    public void setHasMetadata(boolean hasMetadata) {
        this.hasMetadata = hasMetadata;
    }    
}