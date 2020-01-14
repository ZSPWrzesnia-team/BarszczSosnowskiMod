package com.zsp.cfg.barszczsosnowski.worldgen;

import com.mojang.datafixers.Dynamic;
import com.zsp.cfg.barszczsosnowski.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class BarszczFeature extends FlowersFeature {

    public BarszczFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49878_1_) {
        super(p_i49878_1_);
    }

    @Override
    public BlockState getRandomFlower(Random random, BlockPos blockPos) {
        return ModBlocks.BARSZCZ.getDefaultState();
    }
}
