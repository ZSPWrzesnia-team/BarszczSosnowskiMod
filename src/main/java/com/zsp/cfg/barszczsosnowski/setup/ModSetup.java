package com.zsp.cfg.barszczsosnowski.setup;

import com.zsp.cfg.barszczsosnowski.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {
    public ItemGroup itemGroup = new ItemGroup("barszczsosnowski") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.BARSZCZ);
        }
    };

    public void init() {

    }
}
