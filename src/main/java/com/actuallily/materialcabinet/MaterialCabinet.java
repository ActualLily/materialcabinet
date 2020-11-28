package com.actuallily.materialcabinet;

import com.actuallily.materialcabinet.util.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("materialcabinet")
public class MaterialCabinet {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "materialcabinet";

    public MaterialCabinet() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        RegistryHandler.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
}
