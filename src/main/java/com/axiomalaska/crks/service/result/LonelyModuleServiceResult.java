package com.axiomalaska.crks.service.result;

import com.axiomalaska.crks.dto.ModuleDTO;

public class LonelyModuleServiceResult extends ServiceResult {
    private ModuleDTO module;

    public ModuleDTO getModule() {
        return module;
    }

    public void setModule(ModuleDTO module) {
        this.module = module;
    }
}