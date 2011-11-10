package com.axiomalaska.crks.vo;

/**
 * DataLayer custom POJO class (extends generated class to hold custom code)
 */

import org.hibernate.Session;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.DataLayerDTO;
import com.axiomalaska.crks.visitor.LayerVisitor;

public class DataLayer extends Layer {
    private String dataRequestUrl;
    private boolean sensor;

  
   public String getDataRequestUrl() {
       return this.dataRequestUrl;
   }
   
   public void setDataRequestUrl(String dataRequestUrl) {
       this.dataRequestUrl = dataRequestUrl;
   }
   public boolean isSensor() {
       return this.sensor;
   }
   
   public void setSensor(boolean sensor) {
       this.sensor = sensor;
   }

   public void accept(LayerVisitor visitor) {
       visitor.visit(this);
   }

	/**
	 * Creates a new DataLayer DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return DataLayer DTO with values set
	 */

   public DataLayerDTO createDTO(){
       return createDTO( new DataLayerDTO() );
   }

	@Override
   protected DataLayerDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    DataLayerDTO dto = (DataLayerDTO) abstractDto;
		dto.setDataRequestUrl( getDataRequestUrl() );
		dto.setSensor( isSensor() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The DataLayerDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		DataLayerDTO dto = (DataLayerDTO) abstractDto;		
		setDataRequestUrl( dto.getDataRequestUrl() );
		setSensor( dto.isSensor() );
	}	
}
