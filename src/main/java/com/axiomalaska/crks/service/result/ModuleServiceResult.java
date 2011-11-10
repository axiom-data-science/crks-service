package com.axiomalaska.crks.service.result;

import java.util.Set;

import com.axiomalaska.crks.dto.DataLayerDTO;
import com.axiomalaska.crks.dto.LayerGroupDTO;
import com.axiomalaska.crks.dto.ModuleDTO;
import com.axiomalaska.crks.dto.ModuleStickyLayerGroupDTO;
import com.axiomalaska.crks.dto.RasterLayerDTO;
import com.axiomalaska.crks.dto.VectorLayerDTO;

public class ModuleServiceResult extends ServiceResult {
    private ModuleDTO module;
    private Set<ModuleStickyLayerGroupDTO> stickyLayerGroups;
    private Set<LayerGroupDTO> layerGroups;
    private Set<VectorLayerDTO> vectorLayers;
    private Set<RasterLayerDTO> rasterLayers;
    private Set<DataLayerDTO> dataLayers;

    public ModuleDTO getModule() {
		return module;
	}
	public void setModule(ModuleDTO module) {
		this.module = module;
	}
	public Set<ModuleStickyLayerGroupDTO> getStickyLayerGroups() {
		return stickyLayerGroups;
	}
	public void setStickyLayerGroups(
			Set<ModuleStickyLayerGroupDTO> stickyLayerGroups) {
		this.stickyLayerGroups = stickyLayerGroups;
	}
	public Set<LayerGroupDTO> getLayerGroups() {
		return layerGroups;
	}
	public void setLayerGroups(Set<LayerGroupDTO> layerGroups) {
		this.layerGroups = layerGroups;
	}
	public Set<VectorLayerDTO> getVectorLayers() {
		return vectorLayers;
	}
	public void setVectorLayers(Set<VectorLayerDTO> vectorLayers) {
		this.vectorLayers = vectorLayers;
	}
	public Set<RasterLayerDTO> getRasterLayers() {
		return rasterLayers;
	}
	public void setRasterLayers(Set<RasterLayerDTO> rasterLayers) {
		this.rasterLayers = rasterLayers;
	}
	public Set<DataLayerDTO> getDataLayers() {
		return dataLayers;
	}
	public void setDataLayers(Set<DataLayerDTO> dataLayers) {
		this.dataLayers = dataLayers;
	}
}