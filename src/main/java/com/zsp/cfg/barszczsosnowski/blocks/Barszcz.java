package com.zsp.cfg.barszczsosnowski.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Barszcz extends Block {

    public Barszcz() {
        super(Properties.create(Material.CORAL)
                .sound(SoundType.CORAL)
                .hardnessAndResistance(1.0f)
                .doesNotBlockMovement()
                .harvestTool(ToolType.SHOVEL)
                .noDrops());
        setRegistryName("barszcz");
    }
}
