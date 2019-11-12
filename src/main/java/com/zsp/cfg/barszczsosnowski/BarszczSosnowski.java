package com.zsp.cfg.barszczsosnowski;

import com.zsp.cfg.barszczsosnowski.blocks.Barszcz;
import com.zsp.cfg.barszczsosnowski.blocks.ModBlocks;
import com.zsp.cfg.barszczsosnowski.setup.ClientProxy;
import com.zsp.cfg.barszczsosnowski.setup.IProxy;
import com.zsp.cfg.barszczsosnowski.setup.ModSetup;
import com.zsp.cfg.barszczsosnowski.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("barszczsosnowski")
public class BarszczSosnowski {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "barszczsosnowski";
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    public static ModSetup setup = new ModSetup();

    public BarszczSosnowski() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        //Block registration
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new Barszcz());
        }

        //Item registration
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);
            event.getRegistry().register(new BlockItem(ModBlocks.BARSZCZ, properties).setRegistryName("barszcz"));
        }
    }
}
