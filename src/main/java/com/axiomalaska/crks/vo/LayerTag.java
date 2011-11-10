package com.axiomalaska.crks.vo;

import org.hibernate.Session;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.LayerTagDTO;

public class LayerTag extends AbstractVO {
     private Integer id;
     private int layerId;
     private int tagId;
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getLayerId() {
        return this.layerId;
    }
    
    public void setLayerId(int layerId) {
        this.layerId = layerId;
    }
    public int getTagId() {
        return this.tagId;
    }
    
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }


	/**
	 * Creates a new LayerTag DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return LayerTag DTO with values set
	 */

    public LayerTagDTO createDTO(){
        return createDTO( new LayerTagDTO() );
    }

	@Override
    protected LayerTagDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    LayerTagDTO dto = (LayerTagDTO) abstractDto;
		dto.setId( getId() );
		dto.setLayerId( getLayerId() );
		dto.setTagId( getTagId() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The LayerTagDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		LayerTagDTO dto = (LayerTagDTO) abstractDto;		
		setId( dto.getId() );
		setLayerId( dto.getLayerId() );
		setTagId( dto.getTagId() );
	}	
}