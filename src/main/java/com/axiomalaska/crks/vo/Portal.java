package com.axiomalaska.crks.vo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.PortalDTO;

public class Portal extends AbstractVO {
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
     private Set<PortalModule> portalModules = new HashSet<PortalModule>(0);
     private Set<PortalLayerGroup> portalLayerGroups = new HashSet<PortalLayerGroup>(0);

   
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
    public Set<PortalModule> getPortalModules() {
        return this.portalModules;
    }
    
    public void setPortalModules(Set<PortalModule> portalModules) {
        this.portalModules = portalModules;
    }
    public Set<PortalLayerGroup> getPortalLayerGroups() {
        return this.portalLayerGroups;
    }
    
    public void setPortalLayerGroups(Set<PortalLayerGroup> portalLayerGroups) {
        this.portalLayerGroups = portalLayerGroups;
    }




	/**
	 * Creates a new Portal DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return Portal DTO with values set
	 */

    public PortalDTO createDTO(){
        return createDTO( new PortalDTO() );
    }

	@Override
    protected PortalDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    PortalDTO dto = (PortalDTO) abstractDto;
		dto.setId( getId() );
		dto.setLabel( getLabel() );
		dto.setDescription( getDescription() );
		dto.setBackgroundColor( getBackgroundColor() );
		dto.setBackgroundColor2( getBackgroundColor2() );
		dto.setMinLng( getMinLng() );
		dto.setMinLat( getMinLat() );
		dto.setMaxLng( getMaxLng() );
		dto.setMaxLat( getMaxLat() );
		dto.setSplashScreenHtml( getSplashScreenHtml() );
		dto.setV1StartOverlays( getV1StartOverlays() );
		dto.setV1Javascript( getV1Javascript() );
		dto.setV1LogoImage( getV1LogoImage() );
		dto.setV1BannerImage( getV1BannerImage() );
		dto.setBaseLayerCode( getBaseLayerCode() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The PortalDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		PortalDTO dto = (PortalDTO) abstractDto;		
		setId( dto.getId() );
		setLabel( dto.getLabel() );
		setDescription( dto.getDescription() );
		setBackgroundColor( dto.getBackgroundColor() );
		setBackgroundColor2( dto.getBackgroundColor2() );
		setMinLng( dto.getMinLng() );
		setMinLat( dto.getMinLat() );
		setMaxLng( dto.getMaxLng() );
		setMaxLat( dto.getMaxLat() );
		setSplashScreenHtml( dto.getSplashScreenHtml() );
		setV1StartOverlays( dto.getV1StartOverlays() );
		setV1Javascript( dto.getV1Javascript() );
		setV1LogoImage( dto.getV1LogoImage() );
		setV1BannerImage( dto.getV1BannerImage() );
		setBaseLayerCode( dto.getBaseLayerCode() );
	}	
}