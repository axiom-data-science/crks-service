package com.axiomalaska.crks.dto;

import java.util.Date;

public class LayerDTO extends AbstractDTO {
    private Integer id;
    private Integer idLayerSubtype;
    private Integer idLayerGroup;
    private Integer idParameterType;
    private Integer idParameter;
    private Integer idDataProvider;
    private String label;
    private String description;
    private boolean complexSymbology;
    private String legendImageUrl;
    private String dataUrl;
    private String metadataUrl;
    private Double minLng;
    private Double minLat;
    private Double maxLng;
    private Double maxLat;
    private String v1CatalogControlSourceUrl;
    private String v1CatalogControlJsObject;
    private Integer itisTsn;
    private Date startTimeUtc;
    private Date endTimeUtc;
    private Integer preferredEpsg;
    private int ZIndex;

    private boolean hasMetadata = false;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdLayerSubtype() {
        return this.idLayerSubtype;
    }
    
    public void setIdLayerSubtype(Integer idLayerSubtype) {
        this.idLayerSubtype = idLayerSubtype;
    }

    public Integer getIdLayerGroup() {
        return this.idLayerGroup;
    }
    
    public void setIdLayerGroup(Integer idLayerGroup) {
        this.idLayerGroup = idLayerGroup;
    }

    public Integer getIdParameterType() {
        return this.idParameterType;
    }
    
    public void setIdParameterType(Integer idParameterType) {
        this.idParameterType = idParameterType;
    }

    public Integer getIdParameter() {
        return this.idParameter;
    }
    
    public void setIdParameter(Integer idParameter) {
        this.idParameter = idParameter;
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

    public boolean isComplexSymbology() {
        return this.complexSymbology;
    }
    
    public void setComplexSymbology(boolean complexSymbology) {
        this.complexSymbology = complexSymbology;
    }

    public String getLegendImageUrl() {
        return this.legendImageUrl;
    }
    
    public void setLegendImageUrl(String legendImageUrl) {
        this.legendImageUrl = legendImageUrl;
    }

    public String getDataUrl() {
        return this.dataUrl;
    }
    
    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getMetadataUrl() {
        return this.metadataUrl;
    }
    
    public void setMetadataUrl(String metadataUrl) {
        this.metadataUrl = metadataUrl;
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

    public String getV1CatalogControlSourceUrl() {
        return this.v1CatalogControlSourceUrl;
    }
    
    public void setV1CatalogControlSourceUrl(String v1CatalogControlSourceUrl) {
        this.v1CatalogControlSourceUrl = v1CatalogControlSourceUrl;
    }

    public String getV1CatalogControlJsObject() {
        return this.v1CatalogControlJsObject;
    }
    
    public void setV1CatalogControlJsObject(String v1CatalogControlJsObject) {
        this.v1CatalogControlJsObject = v1CatalogControlJsObject;
    }

    public Integer getItisTsn() {
        return this.itisTsn;
    }
    
    public void setItisTsn(Integer itisTsn) {
        this.itisTsn = itisTsn;
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

    public Integer getPreferredEpsg() {
        return this.preferredEpsg;
    }
    
    public void setPreferredEpsg(Integer preferredEpsg) {
        this.preferredEpsg = preferredEpsg;
    }

    public int getZIndex() {
        return this.ZIndex;
    }
    
    public void setZIndex(int ZIndex) {
        this.ZIndex = ZIndex;
    }

    public boolean getHasMetadata() {
        return hasMetadata;
    }

    public void setHasMetadata(boolean hasMetadata) {
        this.hasMetadata = hasMetadata;
    }
}