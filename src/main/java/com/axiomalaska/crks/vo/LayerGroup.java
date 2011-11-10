package com.axiomalaska.crks.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.LayerGroupDTO;

public class LayerGroup extends AbstractVO {
     private Integer id;
     private Module module;
     private LayerType layerType;
     private String label;
     private String description;
     private String metadataUrl;
     private Date startTimeUtc;
     private Date endTimeUtc;
     private Double minLng;
     private Double minLat;
     private Double maxLng;
     private Double maxLat;
     private Set<PortalLayerGroup> portalLayerGroups = new HashSet<PortalLayerGroup>(0);
     private Set<ModuleStickyLayerGroup> moduleStickyLayerGroups = new HashSet<ModuleStickyLayerGroup>(0);
     private Set<Layer> layers = new HashSet<Layer>(0);
     
     public boolean hasMetadata() {
         return true;
     }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Module getModule() {
        return this.module;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }
    public LayerType getLayerType() {
        return this.layerType;
    }
    
    public void setLayerType(LayerType layerType) {
        this.layerType = layerType;
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
    public Set<PortalLayerGroup> getPortalLayerGroups() {
        return this.portalLayerGroups;
    }
    
    public void setPortalLayerGroups(Set<PortalLayerGroup> portalLayerGroups) {
        this.portalLayerGroups = portalLayerGroups;
    }
    public Set<ModuleStickyLayerGroup> getModuleStickyLayerGroups() {
        return this.moduleStickyLayerGroups;
    }
    
    public void setModuleStickyLayerGroups(Set<ModuleStickyLayerGroup> moduleStickyLayerGroups) {
        this.moduleStickyLayerGroups = moduleStickyLayerGroups;
    }
    public Set<Layer> getLayers() {
        return this.layers;
    }
    
    public void setLayers(Set<Layer> layers) {
        this.layers = layers;
    }




	/**
	 * Creates a new LayerGroup DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return LayerGroup DTO with values set
	 */

    public LayerGroupDTO createDTO(){
        return createDTO( new LayerGroupDTO() );
    }

	@Override
    protected LayerGroupDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    LayerGroupDTO dto = (LayerGroupDTO) abstractDto;
		dto.setId( getId() );
		if( getModule() != null ){
			dto.setIdModule( getModule().getId() );
		}
		if( getLayerType() != null ){
			dto.setIdLayerType( getLayerType().getId() );
		}
		dto.setLabel( getLabel() );
		dto.setDescription( getDescription() );
		dto.setMetadataUrl( getMetadataUrl() );
		dto.setStartTimeUtc( getStartTimeUtc() );
		dto.setEndTimeUtc( getEndTimeUtc() );
		dto.setMinLng( getMinLng() );
		dto.setMinLat( getMinLat() );
		dto.setMaxLng( getMaxLng() );
		dto.setMaxLat( getMaxLat() );
        dto.setHasMetadata( hasMetadata() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The LayerGroupDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		LayerGroupDTO dto = (LayerGroupDTO) abstractDto;		
		setId( dto.getId() );
			
		if( dto.getIdModule() != null ){ 
			setModule(
				(Module) session
				.createCriteria(Module.class)
				.add( Restrictions.idEq( dto.getIdModule() ) )
				.uniqueResult()			
			);
		} else {
			setModule( null );		
		}
			
		if( dto.getIdLayerType() != null ){ 
			setLayerType(
				(LayerType) session
				.createCriteria(LayerType.class)
				.add( Restrictions.idEq( dto.getIdLayerType() ) )
				.uniqueResult()			
			);
		} else {
			setLayerType( null );		
		}
		setLabel( dto.getLabel() );
		setDescription( dto.getDescription() );
		setMetadataUrl( dto.getMetadataUrl() );
		setStartTimeUtc( dto.getStartTimeUtc() );
		setEndTimeUtc( dto.getEndTimeUtc() );
		setMinLng( dto.getMinLng() );
		setMinLat( dto.getMinLat() );
		setMaxLng( dto.getMaxLng() );
		setMaxLat( dto.getMaxLat() );
	}	
}


