package com.zsp.cfg.barszczsosnowski.mobs;

import com.google.common.collect.ImmutableSet;
import net.minecraft.village.PointOfInterestType;

public class GardenPOI extends PointOfInterestType {
    public GardenPOI() {
        //TODO: Create the garden block
        super("garden",
                ImmutableSet.of(),
                1,
                null,
                1);
        setRegistryName("garden");
    }
}
