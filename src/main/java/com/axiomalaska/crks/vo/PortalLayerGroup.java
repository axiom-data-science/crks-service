package com.axiomalaska.crks.vo;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.PortalLayerGroupDTO;

public class PortalLayerGroup extends AbstractVO {
     private Integer id;
     private LayerGroup layerGroup;
     private Portal portal;
     private int sortOrder;

   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public LayerGroup getLayerGroup() {
        return this.layerGroup;
    }
    
    public void setLayerGroup(LayerGroup layerGroup) {
        this.layerGroup = layerGroup;
    }
    public Portal getPortal() {
        return this.portal;
    }
    
    public void setPortal(Portal portal) {
        this.portal = portal;
    }
    public int getSortOrder() {
        return this.sortOrder;
    }
    
    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }




	/**
	 * Creates a new PortalLayerGroup DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return PortalLayerGroup DTO with values set
	 */

    public PortalLayerGroupDTO createDTO(){
        return createDTO( new PortalLayerGroupDTO() );
    }

	@Override
    protected PortalLayerGroupDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    PortalLayerGroupDTO dto = (PortalLayerGroupDTO) abstractDto;
		dto.setId( getId() );
		if( getLayerGroup() != null ){
			dto.setIdLayerGroup( getLayerGroup().getId() );
		}
		if( getPortal() != null ){
			dto.setIdPortal( getPortal().getId() );
		}
		dto.setSortOrder( getSortOrder() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The PortalLayerGroupDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		PortalLayerGroupDTO dto = (PortalLayerGroupDTO) abstractDto;		
		setId( dto.getId() );
			
		if( dto.getIdLayerGroup() != null ){ 
			setLayerGroup(
				(LayerGroup) session
				.createCriteria(LayerGroup.class)
				.add( Restrictions.idEq( dto.getIdLayerGroup() ) )
				.uniqueResult()			
			);
		} else {
			setLayerGroup( null );		
		}
			
		if( dto.getIdPortal() != null ){ 
			setPortal(
				(Portal) session
				.createCriteria(Portal.class)
				.add( Restrictions.idEq( dto.getIdPortal() ) )
				.uniqueResult()			
			);
		} else {
			setPortal( null );		
		}
		setSortOrder( dto.getSortOrder() );
	}	
}