package com.axiomalaska.crks.service.result;

import com.axiomalaska.crks.dto.LayerGroupDTO;

public class LonelyLayerGroupServiceResult extends ServiceResult {
    private LayerGroupDTO layerGroup;

    public LayerGroupDTO getLayerGroup() {
        return layerGroup;
    }

    public void setLayerGroup(LayerGroupDTO layerGroup) {
        this.layerGroup = layerGroup;
    }
}
