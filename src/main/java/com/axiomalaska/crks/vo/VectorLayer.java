package com.axiomalaska.crks.vo;

import org.hibernate.Session;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.VectorLayerDTO;
import com.axiomalaska.crks.visitor.LayerVisitor;

public class VectorLayer extends OgcLayer {
     private Integer minDepth;
     private Integer maxDepth;
     private String timeProperty;
     private String sld;

   
    public Integer getMinDepth() {
        return this.minDepth;
    }
    
    public void setMinDepth(Integer minDepth) {
        this.minDepth = minDepth;
    }
    public Integer getMaxDepth() {
        return this.maxDepth;
    }
    
    public void setMaxDepth(Integer maxDepth) {
        this.maxDepth = maxDepth;
    }
    public String getTimeProperty() {
        return this.timeProperty;
    }
    
    public void setTimeProperty(String timeProperty) {
        this.timeProperty = timeProperty;
    }
    public String getSld() {
        return this.sld;
    }
    
    public void setSld(String sld) {
        this.sld = sld;
    }




	/**
	 * Creates a new VectorLayer DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return VectorLayer DTO with values set
	 */

    public VectorLayerDTO createDTO(){
        return createDTO( new VectorLayerDTO() );
    }

	@Override
    protected VectorLayerDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    VectorLayerDTO dto = (VectorLayerDTO) abstractDto;
		dto.setMinDepth( getMinDepth() );
		dto.setMaxDepth( getMaxDepth() );
		dto.setTimeProperty( getTimeProperty() );
		dto.setSld( getSld() );
		dto.setHasSld( getSld() != null );		
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The VectorLayerDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		VectorLayerDTO dto = (VectorLayerDTO) abstractDto;		
		setMinDepth( dto.getMinDepth() );
		setMaxDepth( dto.getMaxDepth() );
		setTimeProperty( dto.getTimeProperty() );
		setSld( dto.getSld() );
	}

    public void accept(LayerVisitor visitor) {
        visitor.visit(this);
    }
}