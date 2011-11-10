package com.axiomalaska.crks.dto;


public class TagDTO extends AbstractDTO {
    private Integer id;
    private String label;
    private int tagTypeId;

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

    public int getTagTypeId() {
        return this.tagTypeId;
    }
    
    public void setTagTypeId(int tagTypeId) {
        this.tagTypeId = tagTypeId;
    }
}