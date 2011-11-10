package com.axiomalaska.crks.util;

import java.util.Iterator;
import java.util.List;

import com.axiomalaska.crks.vo.Layer;
import com.axiomalaska.crks.vo.LayerGroup;
import com.axiomalaska.crks.vo.PortalLayerGroup;
import com.vividsolutions.jts.geom.Envelope;

public class LayerGroupUtil {
    public static void deleteLayerGroup( LayerGroup layerGroup ){
        Iterator<Layer> i = layerGroup.getLayers().iterator();
        while( i.hasNext() ){
        	LayerUtil.deleteLayer( i.next() );
        }

        deletePortalLayerGroups( layerGroup );
        HibernateUtil.currentSession().delete( layerGroup );
    }

    public static void deletePortalLayerGroups( LayerGroup layerGroup ){
        Iterator<PortalLayerGroup> i = layerGroup.getPortalLayerGroups().iterator();
        while( i.hasNext() ){
        	HibernateUtil.currentSession().delete( i.next() );
        }
    }

    public static void calculateLayerGroupExtent( LayerGroup layerGroup ){
        Iterator<Layer> i = layerGroup.getLayers().iterator();
        Envelope bounds = new Envelope();
        while( i.hasNext() ){
        	Layer layer = i.next();
        	if( layer.getMinLng() != null && layer.getMinLat() != null ){
        		bounds.expandToInclude( layer.getMinLng(), layer.getMinLat() );
        	}
        	if( layer.getMaxLng() != null && layer.getMaxLat() != null ){
        		bounds.expandToInclude( layer.getMaxLng(), layer.getMaxLat() );
        	}
        }

        if( !bounds.isNull() ){
        	layerGroup.setMinLng( bounds.getMinX() );
        	layerGroup.setMinLat( bounds.getMinY() );
        	layerGroup.setMaxLng( bounds.getMaxX() );
        	layerGroup.setMaxLat( bounds.getMaxY() );
        }

        HibernateUtil.currentSession().save( layerGroup );
    }

    public static void calculateAllLayerGroupExtents(){
    	@SuppressWarnings("unchecked")
		List<LayerGroup> layerGroups = HibernateUtil.currentSession().createCriteria( LayerGroup.class ).list();
    	Iterator<LayerGroup> i = layerGroups.iterator();

    	int count = 0;
    	int size = layerGroups.size();
    	while( i.hasNext() ){
    		LayerGroup layerGroup = i.next();
    		System.out.println("Calculating extent for layerGroup " + layerGroup.getLabel()
    		        + " " + ++count + "/" + size );
    		calculateLayerGroupExtent( layerGroup );
    	}
    }
}