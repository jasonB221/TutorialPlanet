package com.tnmserver.jasonb221.mods.TutorialPlanet;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class TutorialPlanetSlotRenderer implements ICelestialBodyRenderer {

	@Override
    public ResourceLocation getPlanetSprite()
    {
        return new ResourceLocation(GalacticraftCore.TEXTURE_DOMAIN, "textures/gui/planets/overworld.png");
    }

    @Override
    public String getPlanetName()
    {
        return "TutorialPlanet";
    }

    @Override
    public void renderSlot(int index, int x, int y, float slotHeight, Tessellator tessellator)
    {
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x + 12 - slotHeight, y - 11 + slotHeight, -90.0D, 0.0, 1.0);
        tessellator.addVertexWithUV(x + 12, y - 11 + slotHeight, -90.0D, 1.0, 1.0);
        tessellator.addVertexWithUV(x + 12, y - 11, -90.0D, 1.0, 0.0);
        tessellator.addVertexWithUV(x + 12 - slotHeight, y - 11, -90.0D, 0.0, 0.0);
        tessellator.draw();
    }

}
