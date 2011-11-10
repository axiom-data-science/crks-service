package com.axiomalaska.crks.constant;

import com.axiomalaska.crks.util.HibernateUtil;
import com.axiomalaska.crks.vo.LayerSubtype;

public enum LayerSubtypeConstant {
	 COVERAGE_SATURATED( 1 )
	,COVERAGE_UNSATURATED( 4 )
	,POLYGON_LARGE( 5 )
	,POLYGON_MEDIUM( 6 )
	,POLYGON_SMALL( 7 )
	,LINE_THICK( 8 )
	,LINE_MEDIUM( 9 )
	,LINE_THIN( 10 )
	,MIXED_GEOMETRY( 11 )
	,POINT_DENSE( 12 )
	,POINT_SPARSE( 13 );	 
	
	private final LayerSubtype layerSubtype;
	
	LayerSubtypeConstant( int id ){
		layerSubtype = (LayerSubtype) HibernateUtil.currentSession().get( LayerSubtype.class, id );
	}
	
	public LayerSubtype layerSubtype(){
		return layerSubtype;
	}
}
