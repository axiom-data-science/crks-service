package com.axiomalaska.crks.dto;


public class LayerTagDTO extends AbstractDTO {
    private Integer id;
    private int layerId;
    private int tagId;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public int getLayerId() {
        return this.layerId;
    }
    
    public void setLayerId(int layerId) {
        this.layerId = layerId;
    }

    public int getTagId() {
        return this.tagId;
    }
    
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}