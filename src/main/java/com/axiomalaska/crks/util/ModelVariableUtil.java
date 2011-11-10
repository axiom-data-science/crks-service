package com.axiomalaska.crks.util;

import com.axiomalaska.crks.vo.ModelVariable;

public class ModelVariableUtil {
	public static void resetModelVariableStats( ModelVariable modelVariable ){
		modelVariable.setStatsN( 0 );
		modelVariable.setStatsMin( null );
		modelVariable.setStatsMax( null );
		modelVariable.setStatsMean( null );
		modelVariable.setStatsSum( null );
		modelVariable.setStatsSquareSum( null );
		modelVariable.setStatsStdDev( null );
		modelVariable.setStatsLastTimeSlice( null );
		HibernateUtil.currentSession().update( modelVariable );
	}
}