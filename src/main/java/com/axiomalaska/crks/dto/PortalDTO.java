package com.axiomalaska.crks.dto;


public class PortalDTO extends AbstractDTO {
    private Integer id;
    private String label;
    private String description;
    private String backgroundColor;
    private String backgroundColor2;
    private Double minLng;
    private Double minLat;
    private Double maxLng;
    private Double maxLat;
    private String splashScreenHtml;
    private String v1StartOverlays;
    private String v1Javascript;
    private String v1LogoImage;
    private String v1BannerImage;
    private String baseLayerCode;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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

    public String getBackgroundColor() {
        return this.backgroundColor;
    }
    
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundColor2() {
        return this.backgroundColor2;
    }
    
    public void setBackgroundColor2(String backgroundColor2) {
        this.backgroundColor2 = backgroundColor2;
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

    public String getSplashScreenHtml() {
        return this.splashScreenHtml;
    }
    
    public void setSplashScreenHtml(String splashScreenHtml) {
        this.splashScreenHtml = splashScreenHtml;
    }

    public String getV1StartOverlays() {
        return this.v1StartOverlays;
    }
    
    public void setV1StartOverlays(String v1StartOverlays) {
        this.v1StartOverlays = v1StartOverlays;
    }

    public String getV1Javascript() {
        return this.v1Javascript;
    }
    
    public void setV1Javascript(String v1Javascript) {
        this.v1Javascript = v1Javascript;
    }

    public String getV1LogoImage() {
        return this.v1LogoImage;
    }
    
    public void setV1LogoImage(String v1LogoImage) {
        this.v1LogoImage = v1LogoImage;
    }

    public String getV1BannerImage() {
        return this.v1BannerImage;
    }
    
    public void setV1BannerImage(String v1BannerImage) {
        this.v1BannerImage = v1BannerImage;
    }

    public String getBaseLayerCode() {
        return this.baseLayerCode;
    }
    
    public void setBaseLayerCode(String baseLayerCode) {
        this.baseLayerCode = baseLayerCode;
    }
}