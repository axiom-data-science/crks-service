package com.axiomalaska.crks.vo;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.ModuleStickyLayerGroupDTO;

public class ModuleStickyLayerGroup extends AbstractVO {
     private Integer id;
     private LayerGroup layerGroup;
     private Module module;
     private boolean top;

   
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
    public Module getModule() {
        return this.module;
    }
    
    public void setModule(Module module) {
        this.module = module;
    }
    public boolean isTop() {
        return this.top;
    }
    
    public void setTop(boolean top) {
        this.top = top;
    }




	/**
	 * Creates a new ModuleStickyLayerGroup DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return ModuleStickyLayerGroup DTO with values set
	 */

    public ModuleStickyLayerGroupDTO createDTO(){
        return createDTO( new ModuleStickyLayerGroupDTO() );
    }

	@Override
    protected ModuleStickyLayerGroupDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    ModuleStickyLayerGroupDTO dto = (ModuleStickyLayerGroupDTO) abstractDto;
		dto.setId( getId() );
		if( getLayerGroup() != null ){
			dto.setIdLayerGroup( getLayerGroup().getId() );
		}
		if( getModule() != null ){
			dto.setIdModule( getModule().getId() );
		}
		dto.setTop( isTop() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The ModuleStickyLayerGroupDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		ModuleStickyLayerGroupDTO dto = (ModuleStickyLayerGroupDTO) abstractDto;		
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
		setTop( dto.isTop() );
	}	
}