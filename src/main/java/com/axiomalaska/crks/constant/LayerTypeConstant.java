package com.axiomalaska.crks.constant;

import com.axiomalaska.crks.util.HibernateUtil;
import com.axiomalaska.crks.vo.LayerType;

public enum LayerTypeConstant {
	 VECTOR( 1 )
	,RASTER( 2 )
	,DATA( 3 );
	
	private final LayerType layerType;
	
	LayerTypeConstant( int id ){
		layerType = (LayerType) HibernateUtil.currentSession().get( LayerType.class, id );
	}
	
	public LayerType layerType(){
		return layerType;
	}
}
