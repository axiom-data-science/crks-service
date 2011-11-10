package com.axiomalaska.crks.vo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.DataProviderDTO;

public class DataProvider extends AbstractVO {
     private Integer id;
     private String label;
     private String description;
     private byte[] logo;
     private String url;
     private Set<Module> modules = new HashSet<Module>(0);
     private Set<Model> models = new HashSet<Model>(0);
     private Set<Layer> layers = new HashSet<Layer>(0);

   
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
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public byte[] getLogo() {
        return this.logo;
    }
    
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public Set<Module> getModules() {
        return this.modules;
    }
    
    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
    public Set<Model> getModels() {
        return this.models;
    }
    
    public void setModels(Set<Model> models) {
        this.models = models;
    }
    public Set<Layer> getLayers() {
        return this.layers;
    }
    
    public void setLayers(Set<Layer> layers) {
        this.layers = layers;
    }




	/**
	 * Creates a new DataProvider DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return DataProvider DTO with values set
	 */

    public DataProviderDTO createDTO(){
        return createDTO( new DataProviderDTO() );
    }

	@Override
    protected DataProviderDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    DataProviderDTO dto = (DataProviderDTO) abstractDto;
		dto.setId( getId() );
		dto.setLabel( getLabel() );
		dto.setDescription( getDescription() );
		dto.setLogo( getLogo() );
		dto.setUrl( getUrl() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The DataProviderDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		DataProviderDTO dto = (DataProviderDTO) abstractDto;		
		setId( dto.getId() );
		setLabel( dto.getLabel() );
		setDescription( dto.getDescription() );
		setLogo( dto.getLogo() );
		setUrl( dto.getUrl() );
	}	
}


