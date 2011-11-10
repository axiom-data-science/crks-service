package com.axiomalaska.crks.vo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.ParameterDTO;

public class Parameter extends AbstractVO {
     private Integer id;
     private ParameterType parameterType;
     private String label;
     private String unit;
     private Set<Layer> layers = new HashSet<Layer>(0);
     private Set<ModelVariable> modelVariables = new HashSet<ModelVariable>(0);

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public ParameterType getParameterType() {
        return this.parameterType;
    }
    
    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
    }
    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public Set<Layer> getLayers() {
        return this.layers;
    }
    
    public void setLayers(Set<Layer> layers) {
        this.layers = layers;
    }
    public Set<ModelVariable> getModelVariables() {
        return this.modelVariables;
    }
    
    public void setModelVariables(Set<ModelVariable> modelVariables) {
        this.modelVariables = modelVariables;
    }




	/**
	 * Creates a new Parameter DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return Parameter DTO with values set
	 */

    public ParameterDTO createDTO(){
        return createDTO( new ParameterDTO() );
    }

	@Override
    protected ParameterDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    ParameterDTO dto = (ParameterDTO) abstractDto;
		dto.setId( getId() );
		if( getParameterType() != null ){
			dto.setIdParameterType( getParameterType().getId() );
		}
		dto.setLabel( getLabel() );
		dto.setUnit( getUnit() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The ParameterDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		ParameterDTO dto = (ParameterDTO) abstractDto;		
		setId( dto.getId() );
			
		if( dto.getIdParameterType() != null ){ 
			setParameterType(
				(ParameterType) session
				.createCriteria(ParameterType.class)
				.add( Restrictions.idEq( dto.getIdParameterType() ) )
				.uniqueResult()			
			);
		} else {
			setParameterType( null );		
		}
		setLabel( dto.getLabel() );
		setUnit( dto.getUnit() );
	}	
}