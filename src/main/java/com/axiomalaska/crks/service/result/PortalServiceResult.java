package com.axiomalaska.crks.service.result;

import com.axiomalaska.crks.dto.PortalDTO;

public class PortalServiceResult extends ServiceResult {
    private PortalDTO portal;

    public PortalDTO getPortal() {
        return portal;
    }

    public void setPortal(PortalDTO portal) {
        this.portal = portal;
    }
}
