package com.axiomalaska.crks.visitor;

import java.util.HashSet;
import java.util.Set;

import com.axiomalaska.crks.dto.DataLayerDTO;
import com.axiomalaska.crks.dto.RasterLayerDTO;
import com.axiomalaska.crks.dto.VectorLayerDTO;
import com.axiomalaska.crks.vo.DataLayer;
import com.axiomalaska.crks.vo.RasterLayer;
import com.axiomalaska.crks.vo.VectorLayer;

public class LayerResolver extends LayerVisitorAdapter {
    private Set<VectorLayerDTO> vectorLayerDTOs;
    private Set<RasterLayerDTO> rasterLayerDTOs;
    private Set<DataLayerDTO> dataLayerDTOs;

    public LayerResolver(){
        super();
        this.vectorLayerDTOs = new HashSet<VectorLayerDTO>();
        this.rasterLayerDTOs = new HashSet<RasterLayerDTO>();
        this.dataLayerDTOs = new HashSet<DataLayerDTO>();
    }

    public Set<VectorLayerDTO> getVectorLayerDTOs(){
        return vectorLayerDTOs;
    }

    public Set<RasterLayerDTO> getRasterLayerDTOs(){
        return rasterLayerDTOs;
    }

    public Set<DataLayerDTO> getDataLayerDTOs(){
        return dataLayerDTOs;
    }

    @Override
    public void visit( VectorLayer vectorLayer ){
        vectorLayerDTOs.add( vectorLayer.createDTO() );
    }

    @Override
    public void visit( RasterLayer rasterLayer ){
        rasterLayerDTOs.add( rasterLayer.createDTO() );
    }

    @Override
    public void visit( DataLayer dataLayer ){
        dataLayerDTOs.add( dataLayer.createDTO() );
    }

}