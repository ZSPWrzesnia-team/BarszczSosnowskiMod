package com.zsp.cfg.barszczsosnowski.blocks;

import com.zsp.cfg.barszczsosnowski.setup.BarszczConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        //TODO: Naprawić desynchronizacje ilości użyć
        if (!entityIn.isInvulnerableTo(DamageSource.IN_FIRE)) {
            Iterable<ItemStack> armor = entityIn.getArmorInventoryList();
            int armorPieces = 4;
            Item[] requiredArmor = new Item[]{Items.LEATHER_HELMET, Items.LEATHER_CHESTPLATE, Items.LEATHER_LEGGINGS, Items.LEATHER_BOOTS, Items.LEATHER_HORSE_ARMOR};
            for (ItemStack itemStack : armor)
                if (Arrays.asList(requiredArmor).contains(itemStack.getItem())) {
                    armorPieces--;
                    if (new Random().nextFloat() <= 0.02f) {
                        itemStack.setDamage(itemStack.getDamage() + 1);
                        if (itemStack.getDamage() > itemStack.getMaxDamage()) {
                            itemStack.shrink(1);
                            itemStack.setDamage(0);
                        }
                    }
                }
            entityIn.setFireTimer(Math.max(160 / 4 * Math.max(0, armorPieces), entityIn.getFireTimer()));
        }
    }
}
