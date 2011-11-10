package com.axiomalaska.crks.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.ModelDTO;

public class Model extends AbstractVO {
     private Integer id;
     private DataProvider dataProvider;
     private String label;
     private String description;
     private String ncwmsName;
     private String lefteyePath;
     private Date lastUpdateTimeUtc;
     private String spatialResolution;
     private Double temporalResolutionHours;
     private Double modelRunFrequencyHours;
     private Double forecastThresholdHours;
     private String region;
     private String metadataUrl;
     private Boolean enabled;
     private Double minLng;
     private Double minLat;
     private Double maxLng;
     private Double maxLat;
     private Set<ModelVariable> modelVariables = new HashSet<ModelVariable>(0);

   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public DataProvider getDataProvider() {
        return this.dataProvider;
    }
    
    public void setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
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
    public String getNcwmsName() {
        return this.ncwmsName;
    }
    
    public void setNcwmsName(String ncwmsName) {
        this.ncwmsName = ncwmsName;
    }
    public String getLefteyePath() {
        return this.lefteyePath;
    }
    
    public void setLefteyePath(String lefteyePath) {
        this.lefteyePath = lefteyePath;
    }
    public Date getLastUpdateTimeUtc() {
        return this.lastUpdateTimeUtc;
    }
    
    public void setLastUpdateTimeUtc(Date lastUpdateTimeUtc) {
        this.lastUpdateTimeUtc = lastUpdateTimeUtc;
    }
    public String getSpatialResolution() {
        return this.spatialResolution;
    }
    
    public void setSpatialResolution(String spatialResolution) {
        this.spatialResolution = spatialResolution;
    }
    public Double getTemporalResolutionHours() {
        return this.temporalResolutionHours;
    }
    
    public void setTemporalResolutionHours(Double temporalResolutionHours) {
        this.temporalResolutionHours = temporalResolutionHours;
    }
    public Double getModelRunFrequencyHours() {
        return this.modelRunFrequencyHours;
    }
    
    public void setModelRunFrequencyHours(Double modelRunFrequencyHours) {
        this.modelRunFrequencyHours = modelRunFrequencyHours;
    }
    public Double getForecastThresholdHours() {
        return this.forecastThresholdHours;
    }
    
    public void setForecastThresholdHours(Double forecastThresholdHours) {
        this.forecastThresholdHours = forecastThresholdHours;
    }
    public String getRegion() {
        return this.region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    public String getMetadataUrl() {
        return this.metadataUrl;
    }
    
    public void setMetadataUrl(String metadataUrl) {
        this.metadataUrl = metadataUrl;
    }
    public Boolean getEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public Double getMinLng() {
        return this.minLng;
    }
    
    public void setMinLng(Double minLng) {
        this.minLng = minLng;
    }
    public Double getMinLat() {
        return this.minLat;
    }
    
    public void setMinLat(Double minLat) {
        this.minLat = minLat;
    }
    public Double getMaxLng() {
        return this.maxLng;
    }
    
    public void setMaxLng(Double maxLng) {
        this.maxLng = maxLng;
    }
    public Double getMaxLat() {
        return this.maxLat;
    }
    
    public void setMaxLat(Double maxLat) {
        this.maxLat = maxLat;
    }
    public Set<ModelVariable> getModelVariables() {
        return this.modelVariables;
    }
    
    public void setModelVariables(Set<ModelVariable> modelVariables) {
        this.modelVariables = modelVariables;
    }




	/**
	 * Creates a new Model DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return Model DTO with values set
	 */

    public ModelDTO createDTO(){
        return createDTO( new ModelDTO() );
    }

	@Override
    protected ModelDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    ModelDTO dto = (ModelDTO) abstractDto;
		dto.setId( getId() );
		if( getDataProvider() != null ){
			dto.setIdDataProvider( getDataProvider().getId() );
		}
		dto.setLabel( getLabel() );
		dto.setDescription( getDescription() );
		dto.setNcwmsName( getNcwmsName() );
		dto.setLefteyePath( getLefteyePath() );
		dto.setLastUpdateTimeUtc( getLastUpdateTimeUtc() );
		dto.setSpatialResolution( getSpatialResolution() );
		dto.setTemporalResolutionHours( getTemporalResolutionHours() );
		dto.setModelRunFrequencyHours( getModelRunFrequencyHours() );
		dto.setForecastThresholdHours( getForecastThresholdHours() );
		dto.setRegion( getRegion() );
		dto.setMetadataUrl( getMetadataUrl() );
		dto.setEnabled( getEnabled() );
		dto.setMinLng( getMinLng() );
		dto.setMinLat( getMinLat() );
		dto.setMaxLng( getMaxLng() );
		dto.setMaxLat( getMaxLat() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The ModelDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		ModelDTO dto = (ModelDTO) abstractDto;		
		setId( dto.getId() );
			
		if( dto.getIdDataProvider() != null ){ 
			setDataProvider(
				(DataProvider) session
				.createCriteria(DataProvider.class)
				.add( Restrictions.idEq( dto.getIdDataProvider() ) )
				.uniqueResult()			
			);
		} else {
			setDataProvider( null );		
		}
		setLabel( dto.getLabel() );
		setDescription( dto.getDescription() );
		setNcwmsName( dto.getNcwmsName() );
		setLefteyePath( dto.getLefteyePath() );
		setLastUpdateTimeUtc( dto.getLastUpdateTimeUtc() );
		setSpatialResolution( dto.getSpatialResolution() );
		setTemporalResolutionHours( dto.getTemporalResolutionHours() );
		setModelRunFrequencyHours( dto.getModelRunFrequencyHours() );
		setForecastThresholdHours( dto.getForecastThresholdHours() );
		setRegion( dto.getRegion() );
		setMetadataUrl( dto.getMetadataUrl() );
		setEnabled( dto.getEnabled() );
		setMinLng( dto.getMinLng() );
		setMinLat( dto.getMinLat() );
		setMaxLng( dto.getMaxLng() );
		setMaxLat( dto.getMaxLat() );
	}	
}