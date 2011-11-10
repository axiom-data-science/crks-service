package com.axiomalaska.crks.vo;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.PortalModuleDTO;

public class PortalModule extends AbstractVO {
     private Integer id;
     private Module module;
     private Portal portal;
     private int sortOrder;

   
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
	 * Creates a new PortalModule DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return PortalModule DTO with values set
	 */

    public PortalModuleDTO createDTO(){
        return createDTO( new PortalModuleDTO() );
    }

	@Override
    protected PortalModuleDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    PortalModuleDTO dto = (PortalModuleDTO) abstractDto;
		dto.setId( getId() );
		if( getModule() != null ){
			dto.setIdModule( getModule().getId() );
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
	 * @param dto The PortalModuleDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		PortalModuleDTO dto = (PortalModuleDTO) abstractDto;		
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