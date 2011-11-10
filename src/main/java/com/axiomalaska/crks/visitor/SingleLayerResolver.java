package com.axiomalaska.crks.visitor;

import com.axiomalaska.crks.vo.DataLayer;
import com.axiomalaska.crks.vo.RasterLayer;
import com.axiomalaska.crks.vo.VectorLayer;

public class SingleLayerResolver extends LayerVisitorAdapter {
    private VectorLayer vectorLayer;
    private RasterLayer rasterLayer;
    private DataLayer dataLayer;

    public SingleLayerResolver(){
        super();
    }

    public VectorLayer getVectorLayer() {
        return vectorLayer;
    }

    public RasterLayer getRasterLayer() {
        return rasterLayer;
    }

    public DataLayer getDataLayer() {
        return dataLayer;
    }

    @Override
    public void visit( VectorLayer vectorLayer ){
        this.vectorLayer = vectorLayer;
    }

    @Override
    public void visit( RasterLayer rasterLayer ){
        this.rasterLayer = rasterLayer;
    }

    @Override
    public void visit( DataLayer dataLayer ){
        this.dataLayer = dataLayer;
    }
}