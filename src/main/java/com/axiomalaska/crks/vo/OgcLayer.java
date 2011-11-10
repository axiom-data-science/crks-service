package com.axiomalaska.crks.vo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.OgcLayerDTO;

public class OgcLayer extends Layer {
     private String ogcName;
     private String wmsUrl;
     private String wmsCacheUrl;
     private int cacheExpirationSeconds;
     private int nativeEpsg;
     private String defaultStyle;
     private boolean supportsGetLegendGraphic;
     private String googleMapsTileUrl;
     private Set<SupportedEpsg> supportedEpsgs = new HashSet<SupportedEpsg>(0);
   
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
    public Set<SupportedEpsg> getSupportedEpsgs() {
        return this.supportedEpsgs;
    }
    
    public void setSupportedEpsgs(Set<SupportedEpsg> supportedEpsgs) {
        this.supportedEpsgs = supportedEpsgs;
    }




	/**
	 * Creates a new OgcLayer DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return OgcLayer DTO with values set
	 */

    public OgcLayerDTO createDTO(){
        return createDTO( new OgcLayerDTO() );
    }

	@Override
    protected OgcLayerDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    OgcLayerDTO dto = (OgcLayerDTO) abstractDto;
		dto.setOgcName( getOgcName() );
		dto.setWmsUrl( getWmsUrl() );
		dto.setWmsCacheUrl( getWmsCacheUrl() );
		dto.setCacheExpirationSeconds( getCacheExpirationSeconds() );
		dto.setNativeEpsg( getNativeEpsg() );
		dto.setDefaultStyle( getDefaultStyle() );
		dto.setSupportsGetLegendGraphic( isSupportsGetLegendGraphic() );
		dto.setGoogleMapsTileUrl( getGoogleMapsTileUrl() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The OgcLayerDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		OgcLayerDTO dto = (OgcLayerDTO) abstractDto;		
		setOgcName( dto.getOgcName() );
		setWmsUrl( dto.getWmsUrl() );
		setWmsCacheUrl( dto.getWmsCacheUrl() );
		setCacheExpirationSeconds( dto.getCacheExpirationSeconds() );
		setNativeEpsg( dto.getNativeEpsg() );
		setDefaultStyle( dto.getDefaultStyle() );
		setSupportsGetLegendGraphic( dto.isSupportsGetLegendGraphic() );
		setGoogleMapsTileUrl( dto.getGoogleMapsTileUrl() );
	}	
}