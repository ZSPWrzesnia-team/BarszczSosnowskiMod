package com.zsp.cfg.barszczsosnowski.worldgen;

import com.mojang.datafixers.Dynamic;
import com.zsp.cfg.barszczsosnowski.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class BarszczFeature extends Feature<NoFeatureConfig> {

    public BarszczFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49878_1_) {
        super(p_i49878_1_);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        BlockState state = ModBlocks.BARSZCZ.getDefaultState();
        int whatever = 0;

        for (int i = 0; i < 64; ++i) {
            BlockPos pos2 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            if (worldIn.isAirBlock(pos2) && pos2.getY() < 255 && state.isValidPosition(worldIn, pos2)) {
                worldIn.setBlockState(pos2, state, 2);
                ++whatever;
            }
        }

        return whatever > 0;
    }
}
