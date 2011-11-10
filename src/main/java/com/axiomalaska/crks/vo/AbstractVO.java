package com.axiomalaska.crks.vo;

import org.hibernate.Session;

import com.axiomalaska.crks.dto.AbstractDTO;

public class AbstractVO {
    public AbstractDTO createDTO(){
        return new AbstractDTO();
    }

    protected AbstractDTO createDTO( AbstractDTO dto ){
        return dto;
    }

    public void ingestDTO( Session session, AbstractDTO abstractDto ){
        //do nothing
    }
}
