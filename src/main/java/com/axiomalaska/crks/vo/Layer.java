package com.axiomalaska.crks.vo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.LayerDTO;
import com.axiomalaska.crks.visitor.LayerVisitor;

public class Layer extends AbstractVO {
     private Integer id;
     private LayerSubtype layerSubtype;
     private LayerGroup layerGroup;
     private ParameterType parameterType;
     private Parameter parameter;
     private DataProvider dataProvider;
     private String label;
     private String description;
     private boolean complexSymbology;
     private String legendImageUrl;
     private String dataUrl;
     private String metadataUrl;
     private Double minLng;
     private Double minLat;
     private Double maxLng;
     private Double maxLat;
     private String v1CatalogControlSourceUrl;
     private String v1CatalogControlJsObject;
     private Integer itisTsn;
     private Date startTimeUtc;
     private Date endTimeUtc;
     private Integer preferredEpsg;
     private int ZIndex;

     public boolean hasMetadata() {
         return true;
     }

     public void accept( LayerVisitor visitor ){}
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public LayerSubtype getLayerSubtype() {
        return this.layerSubtype;
    }
    
    public void setLayerSubtype(LayerSubtype layerSubtype) {
        this.layerSubtype = layerSubtype;
    }
    public LayerGroup getLayerGroup() {
        return this.layerGroup;
    }
    
    public void setLayerGroup(LayerGroup layerGroup) {
        this.layerGroup = layerGroup;
    }
    public ParameterType getParameterType() {
        return this.parameterType;
    }
    
    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
    }
    public Parameter getParameter() {
        return this.parameter;
    }
    
    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
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
    public boolean isComplexSymbology() {
        return this.complexSymbology;
    }
    
    public void setComplexSymbology(boolean complexSymbology) {
        this.complexSymbology = complexSymbology;
    }
    public String getLegendImageUrl() {
        return this.legendImageUrl;
    }
    
    public void setLegendImageUrl(String legendImageUrl) {
        this.legendImageUrl = legendImageUrl;
    }
    public String getDataUrl() {
        return this.dataUrl;
    }
    
    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }
    public String getMetadataUrl() {
        return this.metadataUrl;
    }
    
    public void setMetadataUrl(String metadataUrl) {
        this.metadataUrl = metadataUrl;
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
    public String getV1CatalogControlSourceUrl() {
        return this.v1CatalogControlSourceUrl;
    }
    
    public void setV1CatalogControlSourceUrl(String v1CatalogControlSourceUrl) {
        this.v1CatalogControlSourceUrl = v1CatalogControlSourceUrl;
    }
    public String getV1CatalogControlJsObject() {
        return this.v1CatalogControlJsObject;
    }
    
    public void setV1CatalogControlJsObject(String v1CatalogControlJsObject) {
        this.v1CatalogControlJsObject = v1CatalogControlJsObject;
    }
    public Integer getItisTsn() {
        return this.itisTsn;
    }
    
    public void setItisTsn(Integer itisTsn) {
        this.itisTsn = itisTsn;
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
    public Integer getPreferredEpsg() {
        return this.preferredEpsg;
    }
    
    public void setPreferredEpsg(Integer preferredEpsg) {
        this.preferredEpsg = preferredEpsg;
    }
    public int getZIndex() {
        return this.ZIndex;
    }
    
    public void setZIndex(int ZIndex) {
        this.ZIndex = ZIndex;
    }




	/**
	 * Creates a new Layer DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return Layer DTO with values set
	 */

    public LayerDTO createDTO(){
        return createDTO( new LayerDTO() );
    }

	@Override
    protected LayerDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    LayerDTO dto = (LayerDTO) abstractDto;
		dto.setId( getId() );
		if( getLayerSubtype() != null ){
			dto.setIdLayerSubtype( getLayerSubtype().getId() );
		}
		if( getLayerGroup() != null ){
			dto.setIdLayerGroup( getLayerGroup().getId() );
		}
		if( getParameterType() != null ){
			dto.setIdParameterType( getParameterType().getId() );
		}
		if( getParameter() != null ){
			dto.setIdParameter( getParameter().getId() );
		}
		if( getDataProvider() != null ){
			dto.setIdDataProvider( getDataProvider().getId() );
		}
		dto.setLabel( getLabel() );
		dto.setDescription( getDescription() );
		dto.setComplexSymbology( isComplexSymbology() );
		dto.setLegendImageUrl( getLegendImageUrl() );
		dto.setDataUrl( getDataUrl() );
		dto.setMetadataUrl( getMetadataUrl() );
		dto.setMinLng( getMinLng() );
		dto.setMinLat( getMinLat() );
		dto.setMaxLng( getMaxLng() );
		dto.setMaxLat( getMaxLat() );
		dto.setV1CatalogControlSourceUrl( getV1CatalogControlSourceUrl() );
		dto.setV1CatalogControlJsObject( getV1CatalogControlJsObject() );
		dto.setItisTsn( getItisTsn() );
		dto.setStartTimeUtc( getStartTimeUtc() );
		dto.setEndTimeUtc( getEndTimeUtc() );
		dto.setPreferredEpsg( getPreferredEpsg() );
		dto.setZIndex( getZIndex() );
        dto.setHasMetadata( hasMetadata() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The LayerDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		LayerDTO dto = (LayerDTO) abstractDto;		
		setId( dto.getId() );
			
		if( dto.getIdLayerSubtype() != null ){ 
			setLayerSubtype(
				(LayerSubtype) session
				.createCriteria(LayerSubtype.class)
				.add( Restrictions.idEq( dto.getIdLayerSubtype() ) )
				.uniqueResult()			
			);
		} else {
			setLayerSubtype( null );		
		}
			
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
			
		if( dto.getIdParameter() != null ){ 
			setParameter(
				(Parameter) session
				.createCriteria(Parameter.class)
				.add( Restrictions.idEq( dto.getIdParameter() ) )
				.uniqueResult()			
			);
		} else {
			setParameter( null );		
		}
			
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
		setComplexSymbology( dto.isComplexSymbology() );
		setLegendImageUrl( dto.getLegendImageUrl() );
		setDataUrl( dto.getDataUrl() );
		setMetadataUrl( dto.getMetadataUrl() );
		setMinLng( dto.getMinLng() );
		setMinLat( dto.getMinLat() );
		setMaxLng( dto.getMaxLng() );
		setMaxLat( dto.getMaxLat() );
		setV1CatalogControlSourceUrl( dto.getV1CatalogControlSourceUrl() );
		setV1CatalogControlJsObject( dto.getV1CatalogControlJsObject() );
		setItisTsn( dto.getItisTsn() );
		setStartTimeUtc( dto.getStartTimeUtc() );
		setEndTimeUtc( dto.getEndTimeUtc() );
		setPreferredEpsg( dto.getPreferredEpsg() );
		setZIndex( dto.getZIndex() );
	}	
}


