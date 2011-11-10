package com.axiomalaska.crks.vo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.LayerTypeDTO;

public class LayerType extends AbstractVO {
     private Integer id;
     private String type;
     private String label;
     private Set<LayerSubtype> layerSubtypes = new HashSet<LayerSubtype>(0);
     private Set<LayerGroup> layerGroups = new HashSet<LayerGroup>(0);
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    public Set<LayerSubtype> getLayerSubtypes() {
        return this.layerSubtypes;
    }
    
    public void setLayerSubtypes(Set<LayerSubtype> layerSubtypes) {
        this.layerSubtypes = layerSubtypes;
    }
    public Set<LayerGroup> getLayerGroups() {
        return this.layerGroups;
    }
    
    public void setLayerGroups(Set<LayerGroup> layerGroups) {
        this.layerGroups = layerGroups;
    }




	/**
	 * Creates a new LayerType DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return LayerType DTO with values set
	 */

    public LayerTypeDTO createDTO(){
        return createDTO( new LayerTypeDTO() );
    }

	@Override
    protected LayerTypeDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    LayerTypeDTO dto = (LayerTypeDTO) abstractDto;
		dto.setId( getId() );
		dto.setType( getType() );
		dto.setLabel( getLabel() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The LayerTypeDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		LayerTypeDTO dto = (LayerTypeDTO) abstractDto;		
		setId( dto.getId() );
		setType( dto.getType() );
		setLabel( dto.getLabel() );
	}	
}