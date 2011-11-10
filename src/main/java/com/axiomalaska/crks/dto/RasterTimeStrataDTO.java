package com.axiomalaska.crks.dto;

import java.util.Date;

public class RasterTimeStrataDTO extends AbstractDTO {
    private Integer id;
    private Integer idRasterLayer;
    private Date startTimeUtc;
    private Date endTimeUtc;
    private Date startTime;
    private Date endTime;

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdRasterLayer() {
        return this.idRasterLayer;
    }
    
    public void setIdRasterLayer(Integer idRasterLayer) {
        this.idRasterLayer = idRasterLayer;
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

    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}