package com.axiomalaska.crks.util;

import java.util.Iterator;

import org.hibernate.criterion.Restrictions;

import com.axiomalaska.crks.vo.LayerGroup;
import com.axiomalaska.crks.vo.Module;
import com.axiomalaska.crks.vo.Portal;
import com.axiomalaska.crks.vo.PortalLayerGroup;
import com.axiomalaska.crks.vo.PortalModule;

public class PortalUtil {
	public static void addAllModulesToPortal( Portal portal ){
        Iterator<PortalModule> portalModules = portal.getPortalModules().iterator();
        while( portalModules.hasNext() ){
            HibernateUtil.currentSession().delete( portalModules.next() );
        }
        
        @SuppressWarnings("unchecked")
        Iterator<Module> modules = HibernateUtil.currentSession().createCriteria( Module.class ).list().iterator();
        while( modules.hasNext() ){
            PortalModule pomo = new PortalModule();
            pomo.setPortal( portal );
            pomo.setModule( modules.next() );
            HibernateUtil.currentSession().save( pomo );
        }
    }

    public static void addAllLayerGroupsToPortal( Portal portal ){
        Iterator<PortalLayerGroup> portalLayerGroups = portal.getPortalLayerGroups().iterator();
        while( portalLayerGroups.hasNext() ){
            HibernateUtil.currentSession().delete( portalLayerGroups.next() );
        }

        Iterator<PortalModule> portalModules = portal.getPortalModules().iterator();
        int limit = 5;
        while( portalModules.hasNext() && limit > 0 ){
            Module module = portalModules.next().getModule();
                LayerGroup layerGroup = (LayerGroup) HibernateUtil.currentSession().createCriteria( LayerGroup.class )
                    .add( Restrictions.eq( "module", module ) ).setMaxResults( 1 ).uniqueResult();

                if( layerGroup != null ){
                    PortalLayerGroup portalLayerGroup = new PortalLayerGroup();
                    portalLayerGroup.setPortal( portal );
                    portalLayerGroup.setLayerGroup( layerGroup );
                    HibernateUtil.currentSession().save( portalLayerGroup );
                    limit--;
                }
        }
    }
}