package com.axiomalaska.crks.vo;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.SupportedEpsgDTO;

public class SupportedEpsg extends AbstractVO {
     private Integer id;
     private OgcLayer ogcLayer;
     private int epsg;

   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public OgcLayer getOgcLayer() {
        return this.ogcLayer;
    }
    
    public void setOgcLayer(OgcLayer ogcLayer) {
        this.ogcLayer = ogcLayer;
    }
    public int getEpsg() {
        return this.epsg;
    }
    
    public void setEpsg(int epsg) {
        this.epsg = epsg;
    }




	/**
	 * Creates a new SupportedEpsg DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return SupportedEpsg DTO with values set
	 */

    public SupportedEpsgDTO createDTO(){
        return createDTO( new SupportedEpsgDTO() );
    }

	@Override
    protected SupportedEpsgDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    SupportedEpsgDTO dto = (SupportedEpsgDTO) abstractDto;
		dto.setId( getId() );
		if( getOgcLayer() != null ){
			dto.setIdOgcLayer( getOgcLayer().getId() );
		}
		dto.setEpsg( getEpsg() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The SupportedEpsgDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		SupportedEpsgDTO dto = (SupportedEpsgDTO) abstractDto;		
		setId( dto.getId() );
			
		if( dto.getIdOgcLayer() != null ){ 
			setOgcLayer(
				(OgcLayer) session
				.createCriteria(OgcLayer.class)
				.add( Restrictions.idEq( dto.getIdOgcLayer() ) )
				.uniqueResult()			
			);
		} else {
			setOgcLayer( null );		
		}
		setEpsg( dto.getEpsg() );
	}	
}