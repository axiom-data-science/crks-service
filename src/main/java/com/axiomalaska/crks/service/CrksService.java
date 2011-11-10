package com.axiomalaska.crks.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.axiomalaska.crks.dto.DataLayerDTO;
import com.axiomalaska.crks.dto.DataProviderDTO;
import com.axiomalaska.crks.dto.LayerGroupDTO;
import com.axiomalaska.crks.dto.LayerSubtypeDTO;
import com.axiomalaska.crks.dto.LayerTypeDTO;
import com.axiomalaska.crks.dto.ModuleDTO;
import com.axiomalaska.crks.dto.RasterLayerDTO;
import com.axiomalaska.crks.dto.VectorLayerDTO;
import com.axiomalaska.crks.exception.LayerTypeException;
import com.axiomalaska.crks.service.result.LayerServiceResult;
import com.axiomalaska.crks.service.result.LonelyLayerGroupServiceResult;
import com.axiomalaska.crks.service.result.LonelyModuleServiceResult;
import com.axiomalaska.crks.service.result.ModuleServiceResult;
import com.axiomalaska.crks.service.result.PortalDataServiceResult;
import com.axiomalaska.crks.service.result.PortalServiceResult;
import com.axiomalaska.crks.service.result.RasterTimeElevationStrataServiceResult;
import com.axiomalaska.crks.util.DTOUtil;
import com.axiomalaska.crks.util.HibernateUtil;
import com.axiomalaska.crks.visitor.LayerResolver;
import com.axiomalaska.crks.visitor.SingleLayerResolver;
import com.axiomalaska.crks.vo.DataProvider;
import com.axiomalaska.crks.vo.Layer;
import com.axiomalaska.crks.vo.LayerGroup;
import com.axiomalaska.crks.vo.LayerSubtype;
import com.axiomalaska.crks.vo.LayerType;
import com.axiomalaska.crks.vo.Module;
import com.axiomalaska.crks.vo.ModuleStickyLayerGroup;
import com.axiomalaska.crks.vo.Parameter;
import com.axiomalaska.crks.vo.ParameterType;
import com.axiomalaska.crks.vo.Portal;
import com.axiomalaska.crks.vo.PortalLayerGroup;
import com.axiomalaska.crks.vo.PortalModule;
import com.axiomalaska.crks.vo.RasterLayer;
import com.axiomalaska.crks.vo.VectorLayer;

public final class CrksService {
    static {
    	TimeZone.setDefault( TimeZone.getTimeZone("UTC") );
    }
 		
    @SuppressWarnings("unused")
	private static Logger log = Logger.getLogger( CrksService.class );

    @SuppressWarnings("unchecked")
	public static final RasterTimeElevationStrataServiceResult getRasterTimeAndElevationStrata( int layerId ){
        RasterTimeElevationStrataServiceResult result = new RasterTimeElevationStrataServiceResult();
        result.setLayerId( layerId );

        RasterLayer layer = (RasterLayer) HibernateUtil.currentSession().get( RasterLayer.class , result.getLayerId() );
        if( layer == null ){
            result.setError("Invalid layer id: " + layerId );
            HibernateUtil.closeSession();
            return result;
        }

        result.setTimeStrata( DTOUtil.getDTOSet( layer.getRasterTimeStratas() ) );
        result.setElevationStrata( DTOUtil.getDTOSet( layer.getRasterElevationStratas() ) );

        HibernateUtil.closeSession();
        return result;
    }

    public static final LayerServiceResult getLayer( int layerId ) throws LayerTypeException{
        return getLayer( layerId, false );
    }

    public static final LayerServiceResult getLayer( int layerId, boolean returnSld ) throws LayerTypeException{
        LayerServiceResult result = new LayerServiceResult();

        Layer layer = (Layer) HibernateUtil.currentSession().get( Layer.class , layerId );
        if( layer == null ){
            result.setError("Invalid layer id: " + layerId );
            HibernateUtil.closeSession();
            return result;
        }

        //metadata cascade
        if( layer.getMetadataUrl() == null ){
        	if( layer.getLayerGroup().getMetadataUrl() != null ){
        		layer.setMetadataUrl( layer.getLayerGroup().getMetadataUrl() );
        	} else {
        		layer.setMetadataUrl( layer.getLayerGroup().getModule().getMetadataUrl() );
        	}
        }
        if( layer.getDescription() == null ){
        	if( layer.getLayerGroup().getDescription() != null ){
        		layer.setDescription( layer.getLayerGroup().getDescription() );
        	} else {
        		layer.setDescription( layer.getLayerGroup().getModule().getDescription() );
        	}
        }        
        
        
        SingleLayerResolver layerResolver = new SingleLayerResolver();
        layer.accept( layerResolver );

        if( layerResolver.getVectorLayer() != null ){
            result.setVectorLayer( layerResolver.getVectorLayer().createDTO() );
            if( !returnSld ){
                result.getVectorLayer().setSld( null );
            }
        } else if( layerResolver.getRasterLayer() != null ){
            result.setRasterLayer( layerResolver.getRasterLayer().createDTO() );
        } else if( layerResolver.getDataLayer() != null ){
            result.setDataLayer( layerResolver.getDataLayer().createDTO() );
        } else {
            throw new LayerTypeException( layer );
        }

        HibernateUtil.closeSession();
        return result;
    }

    public static final PortalServiceResult getPortal( int portalId ){
        PortalServiceResult result = new PortalServiceResult();

        Portal portal = (Portal) HibernateUtil.currentSession().get( Portal.class , portalId );
        if( portal == null ){
            result.setError("Invalid application id: " + portalId );
            HibernateUtil.closeSession();
            return result;
        }
        result.setPortal( portal.createDTO() );

        HibernateUtil.closeSession();
        return result;
    }

    public static final PortalDataServiceResult getPortalData( int portalId ){
    	return getPortalData( portalId, false );
    }

    @SuppressWarnings("unchecked")
    public static final PortalDataServiceResult getPortalData( int portalId, boolean returnSlds ){
        PortalDataServiceResult result = new PortalDataServiceResult();
        Set<DataProvider> dataProviderSet = new HashSet<DataProvider>();
        Set<PortalModule> portalModuleSet = new HashSet<PortalModule>();
        Set<PortalLayerGroup> portalLayerGroupSet = new HashSet<PortalLayerGroup>();
        Set<Module> moduleSet = new HashSet<Module>();
        Set<LayerGroup> layerGroupSet = new HashSet<LayerGroup>();
        Set<ModuleStickyLayerGroup> moduleStickyLayerGroupSet = new HashSet<ModuleStickyLayerGroup>();

        result.setLayerTypes( getLayerTypes() );
        result.setLayerSubtypes( getLayerSubtypes() );
        result.setDataProviders( new HashSet<DataProviderDTO>() );

        // portal
        Portal portal = (Portal) HibernateUtil.currentSession().get( Portal.class , portalId );
        if( portal == null ){
            result.setError("Invalid application id: " + portalId );
            HibernateUtil.closeSession();
            return result;
        }

        result.setPortal( portal.createDTO() );

        Iterator<PortalModule> portalModuleIterator = portal.getPortalModules().iterator();

        LayerResolver layerResolver = new LayerResolver();
        while( portalModuleIterator.hasNext() ){
            PortalModule portalModule = portalModuleIterator.next();
            portalModuleSet.add( portalModule );
            moduleSet.add( portalModule.getModule() );

            //add the data provider
            DataProvider dataProvider = portalModule.getModule().getDataProvider();
            if( dataProvider != null ){
            	dataProviderSet.add( dataProvider );
            }

            Iterator<LayerGroup> moduleLayerGroups = portalModule.getModule().getLayerGroups().iterator();

            while( moduleLayerGroups.hasNext() ){
                LayerGroup layerGroup = moduleLayerGroups.next();
                layerGroupSet.add( layerGroup );

                Iterator<Layer> layerGroupLayers = layerGroup.getLayers().iterator();
                while( layerGroupLayers.hasNext() ){
                    Layer layer = layerGroupLayers.next();

                    //add the data provider
                    DataProvider layerDataProvider = layer.getDataProvider();
                    if( layerDataProvider != null ){
                    	dataProviderSet.add( layerDataProvider );
                    }
                    layer.accept( layerResolver );
                }
            }


            //sticky layer groups
            Set<ModuleStickyLayerGroup> stickyLayerGroups = portalModule.getModule().getModuleStickyLayerGroups();

            for( ModuleStickyLayerGroup stickyLayerGroup : stickyLayerGroups ){
            	moduleStickyLayerGroupSet.add( stickyLayerGroup );

            	//add these layer groups and layers too
            	layerGroupSet.add( stickyLayerGroup.getLayerGroup() );
            	Set<Layer> layers = stickyLayerGroup.getLayerGroup().getLayers();
            	for( Layer layer : layers ){
                   //add the data provider
            		DataProvider stickyLayerDataProvider = layer.getDataProvider();
            		if( stickyLayerDataProvider != null ){
            		    dataProviderSet.add( stickyLayerDataProvider );
            		}
                	layer.accept( layerResolver );
               }
            }
        }

        Iterator<PortalLayerGroup> portalLayerGroups = portal.getPortalLayerGroups().iterator();
        while( portalLayerGroups.hasNext() ){
            portalLayerGroupSet.add( portalLayerGroups.next() );
        }

        result.setPortalModules( DTOUtil.getDTOSet( portalModuleSet ) );
        result.setModules( DTOUtil.getDTOSet( moduleSet ) );

        Iterator<ModuleDTO> mi = result.getModules().iterator();
        while( mi.hasNext() ){
            ModuleDTO moduleDTO = mi.next();
            moduleDTO.setDescription( null );
            moduleDTO.setMetadataUrl( null );
        }

        result.setPortalLayerGroups( DTOUtil.getDTOSet( portalLayerGroupSet ) );
        result.setLayerGroups( DTOUtil.getDTOSet( layerGroupSet ) );

        Iterator<LayerGroupDTO> lgi = result.getLayerGroups().iterator();
        while( lgi.hasNext() ){
            LayerGroupDTO layerGroupDTO = lgi.next();
            layerGroupDTO.setDescription( null );
            layerGroupDTO.setMetadataUrl( null );
        }



        result.setVectorLayers( layerResolver.getVectorLayerDTOs() );
        result.setRasterLayers( layerResolver.getRasterLayerDTOs() );
        result.setDataLayers( layerResolver.getDataLayerDTOs() );

        Iterator<VectorLayerDTO> vi = result.getVectorLayers().iterator();
        while( vi.hasNext() ){
            VectorLayerDTO layer = vi.next();
            layer.setDescription( null );
            layer.setMetadataUrl( null );
            layer.setDataUrl( null );
            if( !returnSlds ){
                layer.setSld( null );
            }
        }

        Iterator<RasterLayerDTO> ri = result.getRasterLayers().iterator();
        while( ri.hasNext() ){
            RasterLayerDTO layer = ri.next();
            layer.setDescription( null );
            layer.setMetadataUrl( null );
            layer.setDataUrl( null );
        }

        Iterator<DataLayerDTO> di = result.getDataLayers().iterator();
        while( di.hasNext() ){
            DataLayerDTO layer = di.next();
            layer.setDescription( null );
            layer.setMetadataUrl( null );
            layer.setDataUrl( null );
        }

        //parameter types
        List<ParameterType> parameterTypes = HibernateUtil.currentSession().createCriteria( ParameterType.class ).list();
        result.setParameterTypes( DTOUtil.getDTOSet( parameterTypes ) );

        List<Parameter> parameters = HibernateUtil.currentSession().createCriteria( Parameter.class ).list();
        result.setParameters( DTOUtil.getDTOSet( parameters ) );

        result.setDataProviders( DTOUtil.getDTOSet( dataProviderSet ) );
        result.setModuleStickyLayerGroups( DTOUtil.getDTOSet( moduleStickyLayerGroupSet ) );
        
        HibernateUtil.closeSession();
        return result;
    }

    public static final ModuleServiceResult getModule( int moduleId ){
        return getModule( moduleId, false );
    }

    @SuppressWarnings("unchecked")
	public static final ModuleServiceResult getModule( int moduleId, boolean returnSlds ){
        ModuleServiceResult result = new ModuleServiceResult();

        Module module = (Module) HibernateUtil.currentSession().get( Module.class, moduleId );
        if( module == null ){
            result.setError("Invalid module id: " + moduleId );
            HibernateUtil.closeSession();
            return result;
        }

        result.setModule( module.createDTO() );

        LayerResolver layerResolver = new LayerResolver();

        Set<LayerGroup> layerGroupSet = new HashSet<LayerGroup>();
        Set<LayerGroup> layerGroups = module.getLayerGroups();
        layerGroupSet.addAll( layerGroups );


        for( LayerGroup layerGroup : layerGroups ){
           Set<Layer> layers = layerGroup.getLayers();
           for( Layer layer : layers ){
               layer.accept( layerResolver );
           }
        }

        //sticky layer groups
        Set<ModuleStickyLayerGroup> stickyLayerGroups = module.getModuleStickyLayerGroups();
        result.setStickyLayerGroups( DTOUtil.getDTOSet( stickyLayerGroups ) );

        for( ModuleStickyLayerGroup stickyLayerGroup : stickyLayerGroups ){
           // add these layer groups and layers too
           layerGroupSet.add( stickyLayerGroup.getLayerGroup() );

           Set<Layer> layers = stickyLayerGroup.getLayerGroup().getLayers();
           for( Layer layer : layers ){
               layer.accept( layerResolver );
           }
        }

        result.setLayerGroups( DTOUtil.getDTOSet( layerGroupSet ) );

        result.setVectorLayers( layerResolver.getVectorLayerDTOs() );
        result.setRasterLayers( layerResolver.getRasterLayerDTOs() );
        result.setDataLayers( layerResolver.getDataLayerDTOs() );

        if( !returnSlds ){
            Iterator<VectorLayerDTO> i = result.getVectorLayers().iterator();
            while( i.hasNext() ){
                VectorLayerDTO vectorLayerDTO = i.next();
                vectorLayerDTO.setSld( null );
            }
        }

        HibernateUtil.closeSession();
        return result;
    }

    public static final String getLayerSLD( int layerId ){
        VectorLayer layer = (VectorLayer) HibernateUtil.currentSession().get( VectorLayer.class, layerId );
        HibernateUtil.closeSession();
        return layer.getSld();
    }

    @SuppressWarnings("unchecked")
    public static final Set<LayerTypeDTO> getLayerTypes(){
        Set<LayerTypeDTO> layerTypeDTOs = DTOUtil.getDTOSet( HibernateUtil.currentSession().createCriteria( LayerType.class ).list() );
        HibernateUtil.closeSession();
        return layerTypeDTOs;
    }

    @SuppressWarnings("unchecked")
    public static final Set<LayerSubtypeDTO> getLayerSubtypes(){
        Set<LayerSubtypeDTO> layerSubtypeDTOs = DTOUtil.getDTOSet( HibernateUtil.currentSession().createCriteria( LayerSubtype.class ).list() );
        HibernateUtil.closeSession();
        return layerSubtypeDTOs;
    }

    public static final LonelyModuleServiceResult getLonelyModule( int moduleId ){
        LonelyModuleServiceResult result = new LonelyModuleServiceResult();

        Module module = (Module) HibernateUtil.currentSession().get( Module.class, moduleId );
        if( module == null ){
            result.setError("Invalid module id: " + moduleId );
            HibernateUtil.closeSession();
            return result;
        }

        result.setModule( module.createDTO() );

        HibernateUtil.closeSession();
        return result;
    }

    public static final LonelyLayerGroupServiceResult getLonelyLayerGroup( int layerGroupId ){
        LonelyLayerGroupServiceResult result = new LonelyLayerGroupServiceResult();

        LayerGroup layerGroup = (LayerGroup) HibernateUtil.currentSession().get( LayerGroup.class, layerGroupId );
        if( layerGroup == null ){
            result.setError("Invalid layer group id: " + layerGroupId );
            HibernateUtil.closeSession();
            return result;
        }

        //metadata cascade
        if( layerGroup.getMetadataUrl() == null ){
        	layerGroup.setMetadataUrl( layerGroup.getModule().getMetadataUrl() );
        }
        if( layerGroup.getDescription() == null ){
        	layerGroup.setDescription( layerGroup.getModule().getDescription() );
        }        

        result.setLayerGroup( layerGroup.createDTO() );

        HibernateUtil.closeSession();
        return result;
    }
}