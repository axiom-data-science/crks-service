package com.axiomalaska.crks.dto;

import java.util.Date;

public class ModuleDTO extends AbstractDTO {
    private Integer id;
    private Integer idDataProvider;
    private String label;
    private String description;
    private String metadataUrl;
    private boolean v1ParentOfSelectables;
    private boolean mutuallyExclusive;
    private Date startTimeUtc;
    private Date endTimeUtc;
    private Double minLng;
    private Double minLat;
    private Double maxLng;
    private Double maxLat;
    private String iconCode;

    private boolean hasMetadata = false;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDataProvider() {
        return this.idDataProvider;
    }
    
    public void setIdDataProvider(Integer idDataProvider) {
        this.idDataProvider = idDataProvider;
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

    public boolean isV1ParentOfSelectables() {
        return this.v1ParentOfSelectables;
    }
    
    public void setV1ParentOfSelectables(boolean v1ParentOfSelectables) {
        this.v1ParentOfSelectables = v1ParentOfSelectables;
    }

    public boolean isMutuallyExclusive() {
        return this.mutuallyExclusive;
    }
    
    public void setMutuallyExclusive(boolean mutuallyExclusive) {
        this.mutuallyExclusive = mutuallyExclusive;
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

    public String getIconCode() {
        return this.iconCode;
    }
    
    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }

    public boolean getHasMetadata() {
        return hasMetadata;
    }

    public void setHasMetadata(boolean hasMetadata) {
        this.hasMetadata = hasMetadata;
    }
}