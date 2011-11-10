package com.axiomalaska.crks.vo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.RasterTimeStrataDTO;

public class RasterTimeStrata extends AbstractVO {
     private Integer id;
     private RasterLayer rasterLayer;
     private Date startTimeUtc;
     private Date endTimeUtc;
     private Date startTime;
     private Date endTime;

   
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
    public Date getStartTimeUtc() {
        return this.startTimeUtc;
    }
    
    public void setStartTimeUtc(Date startTimeUtc) {
        this.startTimeUtc = startTimeUtc;
    }
    public Date getEndTimeUtc() {
        return this.endTimeUtc;
    }
    
    public void setEndTimeUtc(Date endTimeUtc) {
        this.endTimeUtc = endTimeUtc;
    }
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }




	/**
	 * Creates a new RasterTimeStrata DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return RasterTimeStrata DTO with values set
	 */

    public RasterTimeStrataDTO createDTO(){
        return createDTO( new RasterTimeStrataDTO() );
    }

	@Override
    protected RasterTimeStrataDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    RasterTimeStrataDTO dto = (RasterTimeStrataDTO) abstractDto;
		dto.setId( getId() );
		if( getRasterLayer() != null ){
			dto.setIdRasterLayer( getRasterLayer().getId() );
		}
		dto.setStartTimeUtc( getStartTimeUtc() );
		dto.setEndTimeUtc( getEndTimeUtc() );
		dto.setStartTime( getStartTime() );
		dto.setEndTime( getEndTime() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The RasterTimeStrataDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		RasterTimeStrataDTO dto = (RasterTimeStrataDTO) abstractDto;		
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
		setStartTimeUtc( dto.getStartTimeUtc() );
		setEndTimeUtc( dto.getEndTimeUtc() );
		setStartTime( dto.getStartTime() );
		setEndTime( dto.getEndTime() );
	}	
}