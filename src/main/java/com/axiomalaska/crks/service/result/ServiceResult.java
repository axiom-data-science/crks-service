package com.axiomalaska.crks.service.result;

import java.util.HashMap;
import java.util.Map;

public class ServiceResult {
    private Map<String, Object> extraData;
    private String error;

    public ServiceResult(){
        extraData = new HashMap<String, Object>();
    }

    public Map<String, Object> getExtraData() {
        return extraData;
    }
    public void setResult(Map<String, Object> extraData) {
        this.extraData = extraData;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
}