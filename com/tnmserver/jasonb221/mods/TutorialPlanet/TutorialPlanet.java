package com.tnmserver.jasonb221.mods.TutorialPlanet;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid = "jasonb221_Tutorial_Planet", name = "Tutorial Planet", version = "1.0.0")
@NetworkMod(serverSideRequired=false, clientSideRequired=true)
public class TutorialPlanet {
	
	public static Configuration config; //The configuration file reference
	public static int dimID; //Your dimension id

	@Instance("jasonb221_Tutorial_Planet")
	public static TutorialPlanet instance;
	
	@SidedProxy(clientSide="com.tnmserver.jasonb221.mods.TutorialPlanet.ClientProxy", serverSide="com.tnmserver.jasonb221.mods.TutorialPlanet.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		config.save();
		
		dimID = config.get(Configuration.CATEGORY_GENERAL, "TutorialPlanetDimensionID", -30).getInt();//This gets the dimension id from the config file
		//I know I said to put that code in the FMLInitializationEvent method, but it can go here as well
		
		GalacticraftRegistry.registerTeleportType(PlanetWorldProvider.class, new PlanetTeleportType());
		GalacticraftRegistry.registerCelestialBody(new TutorialPlanetPlanet());			
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		DimensionManager.registerProviderType(dimID, PlanetWorldProvider.class, false);
		DimensionManager.registerDimension(dimID, dimID);
	}
	
}
