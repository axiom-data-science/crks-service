package com.axiomalaska.crks.vo;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.RasterElevationStrataDTO;

public class RasterElevationStrata extends AbstractVO {
     private Integer id;
     private RasterLayer rasterLayer;
     private double elevationMeters;

   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public RasterLayer getRasterLayer() {
        return this.rasterLayer;
    }
    
    public void setRasterLayer(RasterLayer rasterLayer) {
        this.rasterLayer = rasterLayer;
    }
    public double getElevationMeters() {
        return this.elevationMeters;
    }
    
    public void setElevationMeters(double elevationMeters) {
        this.elevationMeters = elevationMeters;
    }




	/**
	 * Creates a new RasterElevationStrata DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return RasterElevationStrata DTO with values set
	 */

    public RasterElevationStrataDTO createDTO(){
        return createDTO( new RasterElevationStrataDTO() );
    }

	@Override
    protected RasterElevationStrataDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    RasterElevationStrataDTO dto = (RasterElevationStrataDTO) abstractDto;
		dto.setId( getId() );
		if( getRasterLayer() != null ){
			dto.setIdRasterLayer( getRasterLayer().getId() );
		}
		dto.setElevationMeters( getElevationMeters() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The RasterElevationStrataDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		RasterElevationStrataDTO dto = (RasterElevationStrataDTO) abstractDto;		
		setId( dto.getId() );
			
		if( dto.getIdRasterLayer() != null ){ 
			setRasterLayer(
				(RasterLayer) session
				.createCriteria(RasterLayer.class)
				.add( Restrictions.idEq( dto.getIdRasterLayer() ) )
				.uniqueResult()			
			);
		} else {
			setRasterLayer( null );		
		}
		setElevationMeters( dto.getElevationMeters() );
	}	
}