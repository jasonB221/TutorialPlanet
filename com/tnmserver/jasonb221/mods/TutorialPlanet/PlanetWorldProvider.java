package com.tnmserver.jasonb221.mods.TutorialPlanet;

import micdoodle8.mods.galacticraft.api.world.IExitHeight;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class PlanetWorldProvider extends WorldProvider implements
		IGalacticraftWorldProvider, IExitHeight, ISolarLevel {

	@Override
    public double getSolarEnergyMultiplier() {
        return 3.0;//This is optional, it allows you to change how much energy is produced by solar panels from the default
    }

    @Override
    public double getYCoordinateToTeleport() {
        return 1200;//This is from IExitHeight, and it is at this y-coord that the planet selection gui opens up. 1200 is the overworld value
    }

    @Override
    public float getGravity() {
        return 1.0F;//This is pretty explanatory, 1.0 is like the overworld.
    }

    @Override
    public double getMeteorFrequency() {
        return 7;//This determines how often meteors spawn in the world. 7 is the value from the moon, i'm pretty sure
    }

    @Override
    public double getFuelUsageMultiplier() {
        return 1.0;//This helps determine how much fuel is used up, and should probably be related to the gravity level
    }

    @Override
    public boolean canSpaceshipTierPass(int tier) {
        return tier>0;//As the only current space ship in the game is tier one, if you made the required tier greater than one the planet would be unaccesible
    }

    @Override
    public String getDimensionName() {
        return "TutorialPlanet";//This is how you reference the planet, and this value should be unique between dimensions
    }
   
    @Override
    public void registerWorldChunkManager()
    {
    	this.worldChunkMgr = new PlanetWorldChunkManager();
    }
    @Override
    public IChunkProvider createChunkGenerator()
    {
    	return new PlanetWorldChunkProvider(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled());
    }
}
