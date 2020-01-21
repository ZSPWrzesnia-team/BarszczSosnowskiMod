package com.zsp.cfg.barszczsosnowski.blocks;

import com.zsp.cfg.barszczsosnowski.setup.BarszczConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Barszcz extends BushBlock {

    public Barszcz() {
        super(Properties.create(Material.CORAL)
                .sound(SoundType.CORAL)
                .hardnessAndResistance(1.0f)
                .doesNotBlockMovement()
                .harvestTool(ToolType.SHOVEL)
                .noDrops()
                .tickRandomly());
        setRegistryName("barszcz");
    }

    @Override
    public void tick(BlockState state, World world, BlockPos pos, Random random) {
        if (BarszczConfig.BARSZCZ_SPREAD_CHANCE < 0 || BarszczConfig.BARSZCZ_SPREAD_CHANCE > 1)
            throw new IllegalStateException("BARSZCZ_SPREAD_CHANCE config is invalid. Cannot continue.");
        if (random.nextDouble() < BarszczConfig.BARSZCZ_SPREAD_CHANCE) {
            List<BlockPos> validBlocks = new ArrayList<BlockPos>();
            for (int x = -1; x < 2; ++x) {
                for (int y = -1; y < 2; ++y) {
                    for (int z = -1; z < 2; ++z) {
                        BlockPos placePos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                        if (isValidPosition(state, world, placePos) && world.isAirBlock(placePos)) {
                            validBlocks.add(placePos);
                        }
                    }
                }
            }
            if (validBlocks.size() > 0) {
                BlockPos sPos = validBlocks.get(random.ints(1, 0, validBlocks.size()).iterator().next());
                world.setBlockState(sPos, getDefaultState());
            }
        }
    }
}
