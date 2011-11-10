package com.axiomalaska.crks.vo;

import org.hibernate.Session;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.TagTypeDTO;

public class TagType extends AbstractVO {
     private Integer id;
     private String label;

   
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


	/**
	 * Creates a new TagType DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return TagType DTO with values set
	 */

    public TagTypeDTO createDTO(){
        return createDTO( new TagTypeDTO() );
    }

	@Override
    protected TagTypeDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    TagTypeDTO dto = (TagTypeDTO) abstractDto;
		dto.setId( getId() );
		dto.setLabel( getLabel() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The TagTypeDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		TagTypeDTO dto = (TagTypeDTO) abstractDto;		
		setId( dto.getId() );
		setLabel( dto.getLabel() );
	}	
}