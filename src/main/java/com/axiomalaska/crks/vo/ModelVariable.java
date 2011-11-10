package com.axiomalaska.crks.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.dto.AbstractDTO;
import com.axiomalaska.crks.dto.ModelVariableDTO;

public class ModelVariable extends AbstractVO {
     private Integer id;
     private ParameterType parameterType;
     private Parameter parameter;
     private Model model;
     private String variableName;
     private String label;
     private String description;
     private String unit;
     private Double statsMin;
     private Double statsMax;
     private Double statsMean;
     private Double statsStdDev;
     private boolean vector;
     private long statsN;
     private BigDecimal statsSum;
     private BigDecimal statsSquareSum;
     private Date statsLastTimeSlice;
     private boolean normal;
     private Set<RasterLayer> rasterLayers = new HashSet<RasterLayer>(0);

   
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
    public Parameter getParameter() {
        return this.parameter;
    }
    
    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
    public Model getModel() {
        return this.model;
    }
    
    public void setModel(Model model) {
        this.model = model;
    }
    public String getVariableName() {
        return this.variableName;
    }
    
    public void setVariableName(String variableName) {
        this.variableName = variableName;
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
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public Double getStatsMin() {
        return this.statsMin;
    }
    
    public void setStatsMin(Double statsMin) {
        this.statsMin = statsMin;
    }
    public Double getStatsMax() {
        return this.statsMax;
    }
    
    public void setStatsMax(Double statsMax) {
        this.statsMax = statsMax;
    }
    public Double getStatsMean() {
        return this.statsMean;
    }
    
    public void setStatsMean(Double statsMean) {
        this.statsMean = statsMean;
    }
    public Double getStatsStdDev() {
        return this.statsStdDev;
    }
    
    public void setStatsStdDev(Double statsStdDev) {
        this.statsStdDev = statsStdDev;
    }
    public boolean isVector() {
        return this.vector;
    }
    
    public void setVector(boolean vector) {
        this.vector = vector;
    }
    public long getStatsN() {
        return this.statsN;
    }
    
    public void setStatsN(long statsN) {
        this.statsN = statsN;
    }
    public BigDecimal getStatsSum() {
        return this.statsSum;
    }
    
    public void setStatsSum(BigDecimal statsSum) {
        this.statsSum = statsSum;
    }
    public BigDecimal getStatsSquareSum() {
        return this.statsSquareSum;
    }
    
    public void setStatsSquareSum(BigDecimal statsSquareSum) {
        this.statsSquareSum = statsSquareSum;
    }
    public Date getStatsLastTimeSlice() {
        return this.statsLastTimeSlice;
    }
    
    public void setStatsLastTimeSlice(Date statsLastTimeSlice) {
        this.statsLastTimeSlice = statsLastTimeSlice;
    }
    public boolean isNormal() {
        return this.normal;
    }
    
    public void setNormal(boolean normal) {
        this.normal = normal;
    }
    public Set<RasterLayer> getRasterLayers() {
        return this.rasterLayers;
    }
    
    public void setRasterLayers(Set<RasterLayer> rasterLayers) {
        this.rasterLayers = rasterLayers;
    }




	/**
	 * Creates a new ModelVariable DTO and sets its values. This is useful for sending
	 * data objects to the client tier (i.e. avoiding the Hibernate lazy loading problem in the client tier).
	 * Parent/child relationships in the POJO are represented in the DTO with foreign keys.
	 * Example: POJO has getParent() that returns a Parent, DTO has getParentID() returning a key.  
	 * 
	 * @return ModelVariable DTO with values set
	 */

    public ModelVariableDTO createDTO(){
        return createDTO( new ModelVariableDTO() );
    }

	@Override
    protected ModelVariableDTO createDTO( AbstractDTO abstractDto ){
	    super.createDTO( abstractDto );
	    ModelVariableDTO dto = (ModelVariableDTO) abstractDto;
		dto.setId( getId() );
		if( getParameterType() != null ){
			dto.setIdParameterType( getParameterType().getId() );
		}
		if( getParameter() != null ){
			dto.setIdParameter( getParameter().getId() );
		}
		if( getModel() != null ){
			dto.setIdModel( getModel().getId() );
		}
		dto.setVariableName( getVariableName() );
		dto.setLabel( getLabel() );
		dto.setDescription( getDescription() );
		dto.setUnit( getUnit() );
		dto.setStatsMin( getStatsMin() );
		dto.setStatsMax( getStatsMax() );
		dto.setStatsMean( getStatsMean() );
		dto.setStatsStdDev( getStatsStdDev() );
		dto.setVector( isVector() );
		dto.setStatsN( getStatsN() );
		dto.setStatsSum( getStatsSum() );
		dto.setStatsSquareSum( getStatsSquareSum() );
		dto.setStatsLastTimeSlice( getStatsLastTimeSlice() );
		dto.setNormal( isNormal() );
		return dto;		
	}
	
	/**
	 * Ingests a DTO (sets POJO values accoring to DTO values). DTO properties containing foreign keys are 
	 * translated to POJO parent/child relationships. 
	 *
	 * @param session The hibernate session
	 * @param dto The ModelVariableDTO to be ingested 
	 */
	@Override
	public void ingestDTO( Session session, AbstractDTO abstractDto ){
		super.ingestDTO( session, abstractDto );
		ModelVariableDTO dto = (ModelVariableDTO) abstractDto;		
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
			
		if( dto.getIdModel() != null ){ 
			setModel(
				(Model) session
				.createCriteria(Model.class)
				.add( Restrictions.idEq( dto.getIdModel() ) )
				.uniqueResult()			
			);
		} else {
			setModel( null );		
		}
		setVariableName( dto.getVariableName() );
		setLabel( dto.getLabel() );
		setDescription( dto.getDescription() );
		setUnit( dto.getUnit() );
		setStatsMin( dto.getStatsMin() );
		setStatsMax( dto.getStatsMax() );
		setStatsMean( dto.getStatsMean() );
		setStatsStdDev( dto.getStatsStdDev() );
		setVector( dto.isVector() );
		setStatsN( dto.getStatsN() );
		setStatsSum( dto.getStatsSum() );
		setStatsSquareSum( dto.getStatsSquareSum() );
		setStatsLastTimeSlice( dto.getStatsLastTimeSlice() );
		setNormal( dto.isNormal() );
	}	
}