
package com.axiomalaska.crks.service;

import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;

import junit.framework.TestCase;

import com.axiomalaska.crks.dto.LayerGroupDTO;
import com.axiomalaska.crks.dto.ModuleDTO;
import com.axiomalaska.crks.dto.PortalDTO;
import com.axiomalaska.crks.dto.PortalLayerGroupDTO;
import com.axiomalaska.crks.dto.PortalModuleDTO;
import com.axiomalaska.crks.dto.RasterLayerDTO;
import com.axiomalaska.crks.dto.VectorLayerDTO;
import com.axiomalaska.crks.exception.LayerTypeException;
import com.axiomalaska.crks.service.result.LayerServiceResult;
import com.axiomalaska.crks.service.result.LonelyLayerGroupServiceResult;
import com.axiomalaska.crks.service.result.LonelyModuleServiceResult;
import com.axiomalaska.crks.service.result.ModuleServiceResult;
import com.axiomalaska.crks.service.result.PortalDataServiceResult;
import com.axiomalaska.crks.service.result.PortalServiceResult;
import com.axiomalaska.crks.service.result.ServiceResult;
import com.axiomalaska.crks.util.HibernateUtil;
import com.axiomalaska.crks.vo.LayerGroup;
import com.axiomalaska.crks.vo.Module;
import com.axiomalaska.crks.vo.VectorLayer;

public class TestCrksService extends TestCase {
	private static int portalId = 10;

    static {
    	TimeZone.setDefault( TimeZone.getTimeZone("UTC") );
    }
    
    public static void testInvalidPortalId(){
        ServiceResult result = CrksService.getPortalData( -1 );
        assertNotNull( result.getError() );
    }

    /*
    public static void testGetRasterTimeAndElevationStrata(){
        RasterLayer rasterLayer = (RasterLayer) HibernateUtil.currentSession().createQuery("from RasterLayer")
            .setMaxResults( 1 ).uniqueResult();

        RasterTimeElevationStrataServiceResult result = CrksService.getRasterTimeAndElevationStrata( rasterLayer.getId() );

        assertNotNull( result.getTimeStrata() );
        //assertTrue( result.getTimeStrata().size() > 0 );

        assertNotNull( result.getElevationStrata() );
        //assertTrue( result.getElevationStrata().size() > 0 );

        HibernateUtil.closeSession();
    }
	*/
    
    public static void testGetPortal(){
        PortalServiceResult result = CrksService.getPortal( portalId );
        assertNotNull( result.getPortal() );
    }

    public static void testGetPortalData(){
        PortalDataServiceResult result = CrksService.getPortalData( portalId );

        boolean foundAwcStream = false;
        Iterator<VectorLayerDTO> i = result.getVectorLayers().iterator();
        while( i.hasNext() ){
        	VectorLayerDTO v = i.next();
        	if( v.getLabel().equals("AWC Stream")){
        		foundAwcStream = true;
        		break;
        	}
        }

//        assertTrue( foundAwcStream );

        assertNotNull( result.getModuleStickyLayerGroups() );

        assertNotNull( result.getLayerTypes() );
        assertTrue( result.getLayerTypes().size() > 0 );

        assertNotNull( result.getLayerSubtypes() );
        assertTrue( result.getLayerSubtypes().size() > 0 );

        assertNotNull( result.getDataProviders() );
        //assertTrue( result.getDataProviders().size() > 0 );

        PortalDTO portalDTO = result.getPortal();
        assertNotNull( portalDTO );

        Set<PortalModuleDTO> portalModuleDTOs = result.getPortalModules();
        assertNotNull( portalModuleDTOs );
        assertTrue( portalModuleDTOs.size() > 0 );

        Set<PortalLayerGroupDTO> portalLayerGroupDTOs = result.getPortalLayerGroups();
        assertNotNull( portalLayerGroupDTOs );
        assertTrue( portalLayerGroupDTOs.size() > 0 );

        Set<ModuleDTO> moduleDTOs = result.getModules();
        assertNotNull( moduleDTOs );
        assertTrue( moduleDTOs.size() > 0 );
        assertTrue( moduleDTOs.iterator().next().getHasMetadata() );

        Set<LayerGroupDTO> layerGroupDTOs = result.getLayerGroups();
        assertNotNull( layerGroupDTOs );
        assertTrue( layerGroupDTOs.size() > 0 );
        assertTrue( layerGroupDTOs.iterator().next().getHasMetadata() );

        Set<VectorLayerDTO> vectorLayerDTOs = result.getVectorLayers();
        assertNotNull( vectorLayerDTOs );
        assertTrue( vectorLayerDTOs.size() > 10 );

        Iterator<VectorLayerDTO> vectorLayerIterator = vectorLayerDTOs.iterator();
        if( vectorLayerIterator.hasNext() ){
        	VectorLayerDTO vl = vectorLayerIterator.next();
            assertNull( vl.getDescription() );
            assertTrue( vl.getHasMetadata() );
        }

        Set<RasterLayerDTO> rasterLayerDTOs = result.getRasterLayers();
        assertNotNull( rasterLayerDTOs );
        //assertTrue( rasterLayerDTOs.size() > 10 );

        /*
        boolean foundIt = false;
        Iterator<RasterLayerDTO> rasterIterator = rasterLayerDTOs.iterator();
        while( rasterIterator.hasNext() ){
            RasterLayerDTO raster = rasterIterator.next();
            if( raster.getId() == 22006 ){
                foundIt = true;
                break;
            }
        }
        assertTrue( foundIt );
         */

        assertNotNull( result.getParameterTypes() );
        assertTrue( result.getParameterTypes().size() > 0 );

        assertNotNull( result.getParameters() );
        assertTrue( result.getParameters().size() > 0 );
    }

    public static void testGetModule(){
    	Module module = (Module) HibernateUtil.currentSession().createCriteria( Module.class )
    		.setMaxResults( 1 ).uniqueResult();

        ModuleServiceResult result = CrksService.getModule( module.getId() );

        HibernateUtil.closeSession();

        assertNotNull( result.getModule() );
        assertNotNull( result.getVectorLayers() );
    }

    public static void testGetLonelyModule(){
        Module module = (Module) HibernateUtil.currentSession().createCriteria( Module.class )
            .setMaxResults( 1 ).uniqueResult();

        LonelyModuleServiceResult result = CrksService.getLonelyModule( module.getId() );

        HibernateUtil.closeSession();

        assertNotNull( result.getModule() );
    }

    public static void testGetLonelyLayerGroup(){
        LayerGroup layerGroup = (LayerGroup) HibernateUtil.currentSession().createCriteria( LayerGroup.class )
            .setMaxResults( 1 ).uniqueResult();

        LonelyLayerGroupServiceResult result = CrksService.getLonelyLayerGroup( layerGroup.getId() );

        HibernateUtil.closeSession();

        assertNotNull( result.getLayerGroup() );
    }

    public static void testGetLayer() throws LayerTypeException{
        VectorLayer layer = (VectorLayer) HibernateUtil.currentSession().createCriteria( VectorLayer.class )
            .setMaxResults( 1 ).uniqueResult();

        LayerServiceResult result = CrksService.getLayer( layer.getId() );

        HibernateUtil.closeSession();

        assertNotNull( result.getVectorLayer() );
    }

    public static void testMetadataCascade() throws LayerTypeException{
        LayerServiceResult result = CrksService.getLayer( 828 );
        assertNotNull( result.getVectorLayer().getDescription() );

    }
}
