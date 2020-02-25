package com.zsp.cfg.barszczsosnowski.mobs;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.merchant.villager.VillagerProfession;

public class GardenerProfession extends VillagerProfession {

    public GardenerProfession() {
        super("gardener", ModPoIs.GARDEN, ImmutableSet.of(), ImmutableSet.of());
        setRegistryName("gardener");
    }
}
