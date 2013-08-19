package com.tnmserver.jasonb221.mods.TutorialPlanet;

import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.Configuration;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GCCoreGalaxyBlockyWay;

public class TutorialPlanetPlanet implements IPlanet {

	@Override
    public String getName() {
            return "TutorialPlanet";//This string must be the same as the one in the PlanetWorldProvider class
    }

    @Override
    public boolean isReachable() {
            return true;//Whether or not you can get to this planet, or is it just there for something else, like moons, to exist off of.
    }

    @Override
    public IMapObject getMapObject() {
            return new TutorialPlanetMapObject();//This renders the planet in the universe map.
    }

    @Override
    public boolean addToList() {
            return true;//This is whether or not the planet should be visible in the Planet Selection GUI when you leave the atmosphere
    }

    @Override
    public boolean autoRegister() {
            return false;//We already registered the planet, but you can let GC take care of it of you want to.
    }

    @Override
    public Class<? extends WorldProvider> getWorldProvider() {
            return PlanetWorldProvider.class;
    }

    @Override
    public int getDimensionID() {
            return TutorialPlanet.config./*Replace with the name of your @mod file and what you use to refernce the config file*/get(Configuration.CATEGORY_GENERAL, "MyOwnDimensionID", -30).getInt();
            }

    @Override
    public IGalaxy getParentGalaxy() {
            return new GCCoreGalaxyBlockyWay();
    }
	
}
