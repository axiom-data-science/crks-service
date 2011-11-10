package com.axiomalaska.crks.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.ModuleDTO;

public class Module extends AbstractVO {
     private Integer id;
     private DataProvider dataProvider;
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
     private Set<ModuleStickyLayerGroup> moduleStickyLayerGroups = new HashSet<ModuleStickyLayerGroup>(0);
     private Set<PortalModule> portalModules = new HashSet<PortalModule>(0);
     private Set<LayerGroup> layerGroups = new HashSet<LayerGroup>(0);

     public boolean hasMetadata() {
         return true;
     }   
     
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public DataProvider getDataProvider() {
        return this.dataProvider;
    }
    
    public void setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
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
    public Set<ModuleStickyLayerGroup> getModuleStickyLayerGroups() {
        return this.moduleStickyLayerGroups;
    }
    
    public void setModuleStickyLayerGroups(Set<ModuleStickyLayerGroup> moduleStickyLayerGroups) {
        this.moduleStickyLayerGroups = moduleStickyLayerGroups;
    }
    public Set<PortalModule> getPortalModules() {
        return this.portalModules;
    }
    
    public void setPortalModules(Set<PortalModule> portalModules) {
        this.portalModules = portalModules;
    }
    public Set<LayerGroup> getLayerGroups() {
        return this.layerGroups;
    }
    
    public void setLayerGroups(Set<LayerGroup> layerGroups) {
        this.layerGroups = layerGroups;
    }




	/**
	 * Creates a new Module DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return Module DTO with values set
	 */

    public ModuleDTO createDTO(){
        return createDTO( new ModuleDTO() );
    }

	@Override
    protected ModuleDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    ModuleDTO dto = (ModuleDTO) abstractDto;
		dto.setId( getId() );
		if( getDataProvider() != null ){
			dto.setIdDataProvider( getDataProvider().getId() );
		}
		dto.setLabel( getLabel() );
		dto.setDescription( getDescription() );
		dto.setMetadataUrl( getMetadataUrl() );
		dto.setV1ParentOfSelectables( isV1ParentOfSelectables() );
		dto.setMutuallyExclusive( isMutuallyExclusive() );
		dto.setStartTimeUtc( getStartTimeUtc() );
		dto.setEndTimeUtc( getEndTimeUtc() );
		dto.setMinLng( getMinLng() );
		dto.setMinLat( getMinLat() );
		dto.setMaxLng( getMaxLng() );
		dto.setMaxLat( getMaxLat() );
		dto.setIconCode( getIconCode() );
        dto.setHasMetadata( hasMetadata() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The ModuleDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		ModuleDTO dto = (ModuleDTO) abstractDto;		
		setId( dto.getId() );
			
		if( dto.getIdDataProvider() != null ){ 
			setDataProvider(
				(DataProvider) session
				.createCriteria(DataProvider.class)
				.add( Restrictions.idEq( dto.getIdDataProvider() ) )
				.uniqueResult()			
			);
		} else {
			setDataProvider( null );		
		}
		setLabel( dto.getLabel() );
		setDescription( dto.getDescription() );
		setMetadataUrl( dto.getMetadataUrl() );
		setV1ParentOfSelectables( dto.isV1ParentOfSelectables() );
		setMutuallyExclusive( dto.isMutuallyExclusive() );
		setStartTimeUtc( dto.getStartTimeUtc() );
		setEndTimeUtc( dto.getEndTimeUtc() );
		setMinLng( dto.getMinLng() );
		setMinLat( dto.getMinLat() );
		setMaxLng( dto.getMaxLng() );
		setMaxLat( dto.getMaxLat() );
		setIconCode( dto.getIconCode() );
	}	
}