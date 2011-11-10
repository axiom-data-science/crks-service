package com.axiomalaska.crks.service.result;

import java.util.Set;

import com.axiomalaska.crks.dto.DataLayerDTO;
import com.axiomalaska.crks.dto.DataProviderDTO;
import com.axiomalaska.crks.dto.LayerGroupDTO;
import com.axiomalaska.crks.dto.LayerSubtypeDTO;
import com.axiomalaska.crks.dto.LayerTypeDTO;
import com.axiomalaska.crks.dto.ModuleDTO;
import com.axiomalaska.crks.dto.ModuleStickyLayerGroupDTO;
import com.axiomalaska.crks.dto.ParameterDTO;
import com.axiomalaska.crks.dto.ParameterTypeDTO;
import com.axiomalaska.crks.dto.PortalDTO;
import com.axiomalaska.crks.dto.PortalLayerGroupDTO;
import com.axiomalaska.crks.dto.PortalModuleDTO;
import com.axiomalaska.crks.dto.RasterLayerDTO;
import com.axiomalaska.crks.dto.VectorLayerDTO;

public class PortalDataServiceResult extends ServiceResult{

    private PortalDTO portal;
    private Set<PortalModuleDTO> portalModules;
    private Set<PortalLayerGroupDTO> portalLayerGroups;
    private Set<ModuleDTO> modules;
    private Set<ModuleStickyLayerGroupDTO> moduleStickyLayerGroups;
    private Set<LayerGroupDTO> layerGroups;

    private Set<RasterLayerDTO> rasterLayers;
    private Set<VectorLayerDTO> vectorLayers;
    private Set<DataLayerDTO> dataLayers;

    private Set<ParameterTypeDTO> parameterTypes;
    private Set<ParameterDTO> parameters;

    private Set<LayerTypeDTO> layerTypes;
    private Set<LayerSubtypeDTO> layerSubtypes;
    private Set<DataProviderDTO> dataProviders;

    public PortalDTO getPortal() {
		return portal;
	}
	public void setPortal(PortalDTO portal) {
		this.portal = portal;
	}
	public Set<PortalModuleDTO> getPortalModules() {
		return portalModules;
	}
	public void setPortalModules(Set<PortalModuleDTO> portalModules) {
		this.portalModules = portalModules;
	}
	public Set<PortalLayerGroupDTO> getPortalLayerGroups() {
		return portalLayerGroups;
	}
	public void setPortalLayerGroups(Set<PortalLayerGroupDTO> portalLayerGroups) {
		this.portalLayerGroups = portalLayerGroups;
	}
	public Set<ModuleDTO> getModules() {
		return modules;
	}
	public void setModules(Set<ModuleDTO> modules) {
		this.modules = modules;
	}
	public Set<ModuleStickyLayerGroupDTO> getModuleStickyLayerGroups() {
		return moduleStickyLayerGroups;
	}
	public void setModuleStickyLayerGroups(
			Set<ModuleStickyLayerGroupDTO> moduleStickyLayerGroups) {
		this.moduleStickyLayerGroups = moduleStickyLayerGroups;
	}
	public Set<LayerGroupDTO> getLayerGroups() {
		return layerGroups;
	}
	public void setLayerGroups(Set<LayerGroupDTO> layerGroups) {
		this.layerGroups = layerGroups;
	}
	public Set<RasterLayerDTO> getRasterLayers() {
		return rasterLayers;
	}
	public void setRasterLayers(Set<RasterLayerDTO> rasterLayers) {
		this.rasterLayers = rasterLayers;
	}
	public Set<VectorLayerDTO> getVectorLayers() {
		return vectorLayers;
	}
	public void setVectorLayers(Set<VectorLayerDTO> vectorLayers) {
		this.vectorLayers = vectorLayers;
	}
	public Set<DataLayerDTO> getDataLayers() {
		return dataLayers;
	}
	public void setDataLayers(Set<DataLayerDTO> dataLayers) {
		this.dataLayers = dataLayers;
	}
	public Set<ParameterTypeDTO> getParameterTypes() {
		return parameterTypes;
	}
	public void setParameterTypes(Set<ParameterTypeDTO> parameterTypes) {
		this.parameterTypes = parameterTypes;
	}
	public Set<ParameterDTO> getParameters() {
		return parameters;
	}
	public void setParameters(Set<ParameterDTO> parameters) {
		this.parameters = parameters;
	}
	public Set<LayerTypeDTO> getLayerTypes() {
		return layerTypes;
	}
	public void setLayerTypes(Set<LayerTypeDTO> layerTypes) {
		this.layerTypes = layerTypes;
	}
	public Set<LayerSubtypeDTO> getLayerSubtypes() {
		return layerSubtypes;
	}
	public void setLayerSubtypes(Set<LayerSubtypeDTO> layerSubtypes) {
		this.layerSubtypes = layerSubtypes;
	}
	public Set<DataProviderDTO> getDataProviders() {
		return dataProviders;
	}
	public void setDataProviders(Set<DataProviderDTO> dataProviders) {
		this.dataProviders = dataProviders;
	}
}