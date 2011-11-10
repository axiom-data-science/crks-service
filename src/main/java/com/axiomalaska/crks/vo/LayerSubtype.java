package com.axiomalaska.crks.vo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.LayerSubtypeDTO;

public class LayerSubtype extends AbstractVO {
     private Integer id;
     private LayerType layerType;
     private String label;
     private Integer ZIndex;
     private Set<Layer> layers = new HashSet<Layer>(0);
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
    public Integer getZIndex() {
        return this.ZIndex;
    }
    
    public void setZIndex(Integer ZIndex) {
        this.ZIndex = ZIndex;
    }
    public Set<Layer> getLayers() {
        return this.layers;
    }
    
    public void setLayers(Set<Layer> layers) {
        this.layers = layers;
    }




	/**
	 * Creates a new LayerSubtype DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return LayerSubtype DTO with values set
	 */

    public LayerSubtypeDTO createDTO(){
        return createDTO( new LayerSubtypeDTO() );
    }

	@Override
    protected LayerSubtypeDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    LayerSubtypeDTO dto = (LayerSubtypeDTO) abstractDto;
		dto.setId( getId() );
		if( getLayerType() != null ){
			dto.setIdLayerType( getLayerType().getId() );
		}
		dto.setLabel( getLabel() );
		dto.setZIndex( getZIndex() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The LayerSubtypeDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		LayerSubtypeDTO dto = (LayerSubtypeDTO) abstractDto;		
		setId( dto.getId() );
			
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
		setZIndex( dto.getZIndex() );
	}	
}