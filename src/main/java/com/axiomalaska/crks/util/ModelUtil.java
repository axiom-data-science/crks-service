package com.axiomalaska.crks.util;

import java.util.Iterator;

import com.axiomalaska.crks.vo.Model;
import com.axiomalaska.crks.vo.ModelVariable;

public class ModelUtil {
	public static void resetAllModelVariableStats( Model model ){
		Iterator<ModelVariable> i = model.getModelVariables().iterator();
		while( i.hasNext() ){
			ModelVariableUtil.resetModelVariableStats( i.next() );
		}
	}
}
