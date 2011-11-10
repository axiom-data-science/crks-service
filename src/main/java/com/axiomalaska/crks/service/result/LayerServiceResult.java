package com.axiomalaska.crks.service.result;

import com.axiomalaska.crks.dto.DataLayerDTO;
import com.axiomalaska.crks.dto.RasterLayerDTO;
import com.axiomalaska.crks.dto.VectorLayerDTO;

public class LayerServiceResult extends ServiceResult {
    private VectorLayerDTO vectorLayer;
    private RasterLayerDTO rasterLayer;
    private DataLayerDTO dataLayer;

    public VectorLayerDTO getVectorLayer() {
        return vectorLayer;
    }
    public void setVectorLayer(VectorLayerDTO vectorLayer) {
        this.vectorLayer = vectorLayer;
    }
    public RasterLayerDTO getRasterLayer() {
        return rasterLayer;
    }
    public void setRasterLayer(RasterLayerDTO rasterLayer) {
        this.rasterLayer = rasterLayer;
    }
    public DataLayerDTO getDataLayer() {
        return dataLayer;
    }
    public void setDataLayer(DataLayerDTO dataLayer) {
        this.dataLayer = dataLayer;
    }
}