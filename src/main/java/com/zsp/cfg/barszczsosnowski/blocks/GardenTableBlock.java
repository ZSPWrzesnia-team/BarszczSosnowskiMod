package com.zsp.cfg.barszczsosnowski.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class GardenTableBlock extends Block {

    public GardenTableBlock() {
        super(Properties.create(Material.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(2.5f)
                .harvestTool(ToolType.AXE));
        setRegistryName("garden_table");
    }
}
