package com.axiomalaska.crks.dto;


public class VectorLayerDTO extends OgcLayerDTO {
    private Integer minDepth;
    private Integer maxDepth;
    private String timeProperty;
    private String sld;

	private boolean hasSld;
	
    public Integer getMinDepth() {
        return this.minDepth;
    }
    
    public void setMinDepth(Integer minDepth) {
        this.minDepth = minDepth;
    }

    public Integer getMaxDepth() {
        return this.maxDepth;
    }
    
    public void setMaxDepth(Integer maxDepth) {
        this.maxDepth = maxDepth;
    }

    public String getTimeProperty() {
        return this.timeProperty;
    }
    
    public void setTimeProperty(String timeProperty) {
        this.timeProperty = timeProperty;
    }

    public String getSld() {
        return this.sld;
    }
    
    public void setSld(String sld) {
        this.sld = sld;
    }
    
	public boolean isHasSld() {
		return hasSld;
	}

	public void setHasSld(boolean hasSld) {
		this.hasSld = hasSld;
	}    
}