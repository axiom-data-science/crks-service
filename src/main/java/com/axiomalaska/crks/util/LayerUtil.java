package com.axiomalaska.crks.util;

import java.util.Iterator;

import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.visitor.SingleLayerResolver;
import com.axiomalaska.crks.vo.Layer;
import com.axiomalaska.crks.vo.RasterElevationStrata;
import com.axiomalaska.crks.vo.RasterLayer;
import com.axiomalaska.crks.vo.RasterTimeStrata;

public class LayerUtil {
    public static void deleteLayer( Layer layer ){
    	deleteRasterLayerStrata( layer );
    	HibernateUtil.currentSession().delete( layer );
    }

    public static void deleteOrphanLayers(){
        @SuppressWarnings("unchecked")
		Iterator<Layer> i = HibernateUtil.currentSession().createCriteria( Layer.class )
        	.add( Restrictions.sizeEq( "moduleLayers", 0 ) )
        	.list().iterator();

        while( i.hasNext() ){
        	Layer layer = i.next();
        	deleteRasterLayerStrata( layer );
        	HibernateUtil.currentSession().delete( layer );
        }
    }

    public static void deleteRasterLayerStrata( Layer layer ){
        SingleLayerResolver resolver = new SingleLayerResolver();
        layer.accept( resolver );
        if( resolver.getRasterLayer() != null ){
            deleteRasterLayerStrata( resolver.getRasterLayer() );
        }
    }

    public static void deleteRasterLayerStrata( RasterLayer layer ){
        deleteRasterLayerTimeStrata( layer );
        deleteRasterLayerElevationStrata( layer );
    }

    public static void deleteRasterLayerTimeStrata( Layer layer ){
        SingleLayerResolver resolver = new SingleLayerResolver();
        layer.accept( resolver );
        if( resolver.getRasterLayer() != null ){
            deleteRasterLayerTimeStrata( resolver.getRasterLayer() );
        }
    }

    public static void deleteRasterLayerTimeStrata( RasterLayer layer ){
        Iterator<RasterTimeStrata> i = layer.getRasterTimeStratas().iterator();
        while( i.hasNext() ){
            HibernateUtil.currentSession().delete( i.next() );
        }
    }

    public static void deleteRasterLayerElevationStrata( Layer layer ){
        SingleLayerResolver resolver = new SingleLayerResolver();
        layer.accept( resolver );
        if( resolver.getRasterLayer() != null ){
            deleteRasterLayerElevationStrata( resolver.getRasterLayer() );
        }
    }
    public static void deleteRasterLayerElevationStrata( RasterLayer layer ){
        Iterator<RasterElevationStrata> i = layer.getRasterElevationStratas().iterator();
        while( i.hasNext() ){
            HibernateUtil.currentSession().delete( i.next() );
        }
    }
}