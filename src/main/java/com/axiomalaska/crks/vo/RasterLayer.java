package com.axiomalaska.crks.vo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.RasterLayerDTO;
import com.axiomalaska.crks.visitor.LayerVisitor;

public class RasterLayer extends OgcLayer {
     private ModelVariable modelVariable;
     private String wcsUrl;
     private Set<RasterTimeStrata> rasterTimeStratas = new HashSet<RasterTimeStrata>(0);
     private Set<RasterElevationStrata> rasterElevationStratas = new HashSet<RasterElevationStrata>(0);

   
    public ModelVariable getModelVariable() {
        return this.modelVariable;
    }
    
    public void setModelVariable(ModelVariable modelVariable) {
        this.modelVariable = modelVariable;
    }
    public String getWcsUrl() {
        return this.wcsUrl;
    }
    
    public void setWcsUrl(String wcsUrl) {
        this.wcsUrl = wcsUrl;
    }
    public Set<RasterTimeStrata> getRasterTimeStratas() {
        return this.rasterTimeStratas;
    }
    
    public void setRasterTimeStratas(Set<RasterTimeStrata> rasterTimeStratas) {
        this.rasterTimeStratas = rasterTimeStratas;
    }
    public Set<RasterElevationStrata> getRasterElevationStratas() {
        return this.rasterElevationStratas;
    }
    
    public void setRasterElevationStratas(Set<RasterElevationStrata> rasterElevationStratas) {
        this.rasterElevationStratas = rasterElevationStratas;
    }




	/**
	 * Creates a new RasterLayer DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return RasterLayer DTO with values set
	 */

    public RasterLayerDTO createDTO(){
        return createDTO( new RasterLayerDTO() );
    }

	@Override
    protected RasterLayerDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    RasterLayerDTO dto = (RasterLayerDTO) abstractDto;
		if( getModelVariable() != null ){
			dto.setIdModelVariable( getModelVariable().getId() );
		}
		dto.setWcsUrl( getWcsUrl() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The RasterLayerDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		RasterLayerDTO dto = (RasterLayerDTO) abstractDto;		
			
		if( dto.getIdModelVariable() != null ){ 
			setModelVariable(
				(ModelVariable) session
				.createCriteria(ModelVariable.class)
				.add( Restrictions.idEq( dto.getIdModelVariable() ) )
				.uniqueResult()			
			);
		} else {
			setModelVariable( null );		
		}
		setWcsUrl( dto.getWcsUrl() );
	}
	
    public void accept(LayerVisitor visitor) {
        visitor.visit(this);
    }	
}
