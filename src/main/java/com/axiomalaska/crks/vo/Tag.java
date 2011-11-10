package com.axiomalaska.crks.vo;

import org.hibernate.Session;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.TagDTO;

public class Tag extends AbstractVO {
     private Integer id;
     private String label;
     private int tagTypeId;

   
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
    public int getTagTypeId() {
        return this.tagTypeId;
    }
    
    public void setTagTypeId(int tagTypeId) {
        this.tagTypeId = tagTypeId;
    }




	/**
	 * Creates a new Tag DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return Tag DTO with values set
	 */

    public TagDTO createDTO(){
        return createDTO( new TagDTO() );
    }

	@Override
    protected TagDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    TagDTO dto = (TagDTO) abstractDto;
		dto.setId( getId() );
		dto.setLabel( getLabel() );
		dto.setTagTypeId( getTagTypeId() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The TagDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		TagDTO dto = (TagDTO) abstractDto;		
		setId( dto.getId() );
		setLabel( dto.getLabel() );
		setTagTypeId( dto.getTagTypeId() );
	}	
}