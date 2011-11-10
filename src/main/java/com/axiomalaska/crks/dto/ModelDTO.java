package com.axiomalaska.crks.dto;

import java.util.Date;

public class ModelDTO extends AbstractDTO {
    private Integer id;
    private Integer idDataProvider;
    private String label;
    private String description;
    private String ncwmsName;
    private String lefteyePath;
    private Date lastUpdateTimeUtc;
    private String spatialResolution;
    private Double temporalResolutionHours;
    private Double modelRunFrequencyHours;
    private Double forecastThresholdHours;
    private String region;
    private String metadataUrl;
    private Boolean enabled;
    private Double minLng;
    private Double minLat;
    private Double maxLng;
    private Double maxLat;

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

    public String getNcwmsName() {
        return this.ncwmsName;
    }
    
    public void setNcwmsName(String ncwmsName) {
        this.ncwmsName = ncwmsName;
    }

    public String getLefteyePath() {
        return this.lefteyePath;
    }
    
    public void setLefteyePath(String lefteyePath) {
        this.lefteyePath = lefteyePath;
    }

    public Date getLastUpdateTimeUtc() {
        return this.lastUpdateTimeUtc;
    }
    
    public void setLastUpdateTimeUtc(Date lastUpdateTimeUtc) {
        this.lastUpdateTimeUtc = lastUpdateTimeUtc;
    }

    public String getSpatialResolution() {
        return this.spatialResolution;
    }
    
    public void setSpatialResolution(String spatialResolution) {
        this.spatialResolution = spatialResolution;
    }

    public Double getTemporalResolutionHours() {
        return this.temporalResolutionHours;
    }
    
    public void setTemporalResolutionHours(Double temporalResolutionHours) {
        this.temporalResolutionHours = temporalResolutionHours;
    }

    public Double getModelRunFrequencyHours() {
        return this.modelRunFrequencyHours;
    }
    
    public void setModelRunFrequencyHours(Double modelRunFrequencyHours) {
        this.modelRunFrequencyHours = modelRunFrequencyHours;
    }

    public Double getForecastThresholdHours() {
        return this.forecastThresholdHours;
    }
    
    public void setForecastThresholdHours(Double forecastThresholdHours) {
        this.forecastThresholdHours = forecastThresholdHours;
    }

    public String getRegion() {
        return this.region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }

    public String getMetadataUrl() {
        return this.metadataUrl;
    }
    
    public void setMetadataUrl(String metadataUrl) {
        this.metadataUrl = metadataUrl;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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
}