package com.axiomalaska.crks.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.axiomalaska.crks.vo.AbstractVO;

public class DTOUtil {
    static public List getDTOList( Collection pojoList ){
        List dtoList = new ArrayList();
        if (pojoList.size() > 0) {
            Iterator it = pojoList.iterator();
            while( it.hasNext() ){
                dtoList.add( ( (AbstractVO) it.next() ).createDTO() );
            }
        }
        return dtoList;
    }
    
    static public Set getDTOSet( Collection pojoList ){
        Set dtoSet = new HashSet();
        if (pojoList.size() > 0) {
            Iterator it = pojoList.iterator();
            while( it.hasNext() ){
            	dtoSet.add( ( (AbstractVO) it.next() ).createDTO() );
            }
        }
        return dtoSet;
    }   
}