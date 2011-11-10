package com.axiomalaska.crks.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ModelVariableDTO extends AbstractDTO {
    private Integer id;
    private Integer idParameterType;
    private Integer idParameter;
    private Integer idModel;
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

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdParameterType() {
        return this.idParameterType;
    }
    
    public void setIdParameterType(Integer idParameterType) {
        this.idParameterType = idParameterType;
    }

    public Integer getIdParameter() {
        return this.idParameter;
    }
    
    public void setIdParameter(Integer idParameter) {
        this.idParameter = idParameter;
    }

    public Integer getIdModel() {
        return this.idModel;
    }
    
    public void setIdModel(Integer idModel) {
        this.idModel = idModel;
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
}