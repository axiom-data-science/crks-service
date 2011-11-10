package com.axiomalaska.crks.util;

import java.util.Iterator;
import java.util.List;

import com.axiomalaska.crks.vo.LayerGroup;
import com.axiomalaska.crks.vo.Module;
import com.axiomalaska.crks.vo.PortalModule;
import com.vividsolutions.jts.geom.Envelope;

public class ModuleUtil {
    public static void deleteLayerGroups( Module module ){
        Iterator<LayerGroup> i = module.getLayerGroups().iterator();
        while( i.hasNext() ){
            LayerGroupUtil.deleteLayerGroup( i.next() );
        }
    }

    public static void deletePortalModules( Module module ){
        Iterator<PortalModule> i = module.getPortalModules().iterator();
        while( i.hasNext() ){
            HibernateUtil.currentSession().delete( i.next() );
        }
    }

    public static void deleteModule( Module module ){
        deleteLayerGroups( module );
        deletePortalModules( module );
        HibernateUtil.currentSession().delete( module );
    }

    public static void calculateModuleExtent( Module module ){
        Iterator<LayerGroup> i = module.getLayerGroups().iterator();
        Envelope bounds = new Envelope();
        while( i.hasNext() ){
        	LayerGroup layerGroup = i.next();
        	if( layerGroup.getMinLng() != null && layerGroup.getMinLat() != null ){
        		bounds.expandToInclude( layerGroup.getMinLng(), layerGroup.getMinLat() );
        	}
        	if( layerGroup.getMaxLng() != null && layerGroup.getMaxLat() != null ){
        		bounds.expandToInclude( layerGroup.getMaxLng(), layerGroup.getMaxLat() );
        	}
        }

        if( !bounds.isNull() ){
        	module.setMinLng( bounds.getMinX() );
        	module.setMinLat( bounds.getMinY() );
        	module.setMaxLng( bounds.getMaxX() );
        	module.setMaxLat( bounds.getMaxY() );
        }

        HibernateUtil.currentSession().save( module );
    }

    public static void calculateAllModuleExtents(){
    	@SuppressWarnings("unchecked")
		List<Module> modules = HibernateUtil.currentSession().createCriteria( Module.class ).list();
    	Iterator<Module> i = modules.iterator();

    	int count = 0;
    	int size = modules.size();

    	while( i.hasNext() ){
    		Module module = i.next();
    		System.out.println( "Calculating extent for module " + module.getLabel()
    		        + " " + ++count + "/" + size );
    		calculateModuleExtent( module );
    	}
    }
}