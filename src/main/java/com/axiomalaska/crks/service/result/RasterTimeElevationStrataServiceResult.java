package com.axiomalaska.crks.service.result;

import java.util.Set;

import com.axiomalaska.crks.dto.RasterElevationStrataDTO;
import com.axiomalaska.crks.dto.RasterTimeStrataDTO;

public class RasterTimeElevationStrataServiceResult extends ServiceResult {
    private int layerId;
    private Set<RasterTimeStrataDTO> timeStrata;
    private Set<RasterElevationStrataDTO> elevationStrata;

    public int getLayerId() {
        return layerId;
    }
    public void setLayerId(int layerId) {
        this.layerId = layerId;
    }
    public Set<RasterTimeStrataDTO> getTimeStrata() {
        return timeStrata;
    }
    public void setTimeStrata(Set<RasterTimeStrataDTO> timeStrata) {
        this.timeStrata = timeStrata;
    }
    public Set<RasterElevationStrataDTO> getElevationStrata() {
        return elevationStrata;
    }
    public void setElevationStrata(Set<RasterElevationStrataDTO> elevationStrata) {
        this.elevationStrata = elevationStrata;
    }
}