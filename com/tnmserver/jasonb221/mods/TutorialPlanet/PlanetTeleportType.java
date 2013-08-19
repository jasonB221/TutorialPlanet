package com.tnmserver.jasonb221.mods.TutorialPlanet;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import micdoodle8.mods.galacticraft.api.vector.Vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;
import micdoodle8.mods.galacticraft.core.entities.GCCorePlayerMP;

public class PlanetTeleportType implements ITeleportType {

	@Override
    public boolean useParachute() {
            return true;//whether to use a parachute on spawn. Sets to false on moon and spacestation, and true on the overworld.
    }

    @Override
    public Vector3 getPlayerSpawnLocation(WorldServer world, EntityPlayerMP player) {
            GCCorePlayerMP p = null;
            if(player instanceof GCCorePlayerMP){
                    p = (GCCorePlayerMP) player;
            }
            if(p == null){
                    return getEntitySpawnLocation(world, player);
            }
            else{
                    return new Vector3(p.getCoordsTeleportedFromX(), 250, p.getCoordsTeleportedFromZ());//This is where the player spawns, same place he tp'd from.
            }
    }

    @Override
    public Vector3 getEntitySpawnLocation(WorldServer world, Entity entity) {
            return new Vector3(entity.posX, 250, entity.posZ);
    }

    @Override
    public Vector3 getParaChestSpawnLocation(WorldServer world, EntityPlayerMP player, Random rand) {
            return new Vector3(player.posX, 250, player.posZ);//this determines the chest spawn location
    }

    @Override
    public void onSpaceDimensionChanged(World newWorld, EntityPlayerMP player) {}//I honestly dont know what this method does.

}
