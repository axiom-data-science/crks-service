package com.axiomalaska.crks.vo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.ParameterTypeDTO;

public class ParameterType extends AbstractVO {
     private Integer id;
     private String label;
     private Set<ModelVariable> modelVariables = new HashSet<ModelVariable>(0);
     private Set<Layer> layers = new HashSet<Layer>(0);
     private Set<Parameter> parameters = new HashSet<Parameter>(0);

   
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
    public Set<ModelVariable> getModelVariables() {
        return this.modelVariables;
    }
    
    public void setModelVariables(Set<ModelVariable> modelVariables) {
        this.modelVariables = modelVariables;
    }
    public Set<Layer> getLayers() {
        return this.layers;
    }
    
    public void setLayers(Set<Layer> layers) {
        this.layers = layers;
    }
    public Set<Parameter> getParameters() {
        return this.parameters;
    }
    
    public void setParameters(Set<Parameter> parameters) {
        this.parameters = parameters;
    }




	/**
	 * Creates a new ParameterType DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return ParameterType DTO with values set
	 */

    public ParameterTypeDTO createDTO(){
        return createDTO( new ParameterTypeDTO() );
    }

	@Override
    protected ParameterTypeDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    ParameterTypeDTO dto = (ParameterTypeDTO) abstractDto;
		dto.setId( getId() );
		dto.setLabel( getLabel() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The ParameterTypeDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		ParameterTypeDTO dto = (ParameterTypeDTO) abstractDto;		
		setId( dto.getId() );
		setLabel( dto.getLabel() );
	}	
}