package com.zsp.cfg.barszczsosnowski.worldgen;

import com.zsp.cfg.barszczsosnowski.setup.BarszczConfig;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class BarszczGen {
    public static void init() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (BarszczConfig.BARSZCZ_SPAWN_CHANCE > 0 && BarszczConfig.BARSZCZ_SPAWN_CHANCE <= 1) {
                ConfiguredFeature<?> barszczConfFeature = Biome.createDecoratedFeature(new BarszczFeature(NoFeatureConfig::deserialize), new NoFeatureConfig(), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(4));

                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, barszczConfFeature);
            } else if (BarszczConfig.BARSZCZ_SPAWN_CHANCE > 1 || BarszczConfig.BARSZCZ_SPAWN_CHANCE < 0)
                throw new IllegalStateException("BARSZCZ_SPAWN_CHANCE config is invalid. Cannot continue.");
        }
    }
}
