package com.axiomalaska.crks.dto;


public class OgcLayerDTO extends LayerDTO {
    private String ogcName;
    private String wmsUrl;
    private String wmsCacheUrl;
    private int cacheExpirationSeconds;
    private int nativeEpsg;
    private String defaultStyle;
    private boolean supportsGetLegendGraphic;
    private String googleMapsTileUrl;

    public String getOgcName() {
        return this.ogcName;
    }
    
    public void setOgcName(String ogcName) {
        this.ogcName = ogcName;
    }

    public String getWmsUrl() {
        return this.wmsUrl;
    }
    
    public void setWmsUrl(String wmsUrl) {
        this.wmsUrl = wmsUrl;
    }

    public String getWmsCacheUrl() {
        return this.wmsCacheUrl;
    }
    
    public void setWmsCacheUrl(String wmsCacheUrl) {
        this.wmsCacheUrl = wmsCacheUrl;
    }

    public int getCacheExpirationSeconds() {
        return this.cacheExpirationSeconds;
    }
    
    public void setCacheExpirationSeconds(int cacheExpirationSeconds) {
        this.cacheExpirationSeconds = cacheExpirationSeconds;
    }

    public int getNativeEpsg() {
        return this.nativeEpsg;
    }
    
    public void setNativeEpsg(int nativeEpsg) {
        this.nativeEpsg = nativeEpsg;
    }

    public String getDefaultStyle() {
        return this.defaultStyle;
    }
    
    public void setDefaultStyle(String defaultStyle) {
        this.defaultStyle = defaultStyle;
    }

    public boolean isSupportsGetLegendGraphic() {
        return this.supportsGetLegendGraphic;
    }
    
    public void setSupportsGetLegendGraphic(boolean supportsGetLegendGraphic) {
        this.supportsGetLegendGraphic = supportsGetLegendGraphic;
    }

    public String getGoogleMapsTileUrl() {
        return this.googleMapsTileUrl;
    }
    
    public void setGoogleMapsTileUrl(String googleMapsTileUrl) {
        this.googleMapsTileUrl = googleMapsTileUrl;
    }
}