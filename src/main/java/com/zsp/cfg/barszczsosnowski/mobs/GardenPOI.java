package com.zsp.cfg.barszczsosnowski.mobs;

import com.google.common.collect.ImmutableSet;
import com.zsp.cfg.barszczsosnowski.blocks.ModBlocks;
import net.minecraft.village.PointOfInterestType;

public class GardenPOI extends PointOfInterestType {
    public GardenPOI() {
        //TODO: Create the garden block
        super("gardener",
                ImmutableSet.copyOf(ModBlocks.GARDEN_TABLE.getStateContainer().getValidStates()),
                1,
                null,
                1);
        setRegistryName("gardener");
    }
}
