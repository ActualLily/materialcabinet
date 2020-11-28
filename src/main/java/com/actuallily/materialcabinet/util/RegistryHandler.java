package com.actuallily.materialcabinet.util;

import com.actuallily.materialcabinet.MaterialCabinet;
import com.actuallily.materialcabinet.blocks.BlockItemBase;
import com.actuallily.materialcabinet.blocks.MaterialCabinetBlock;
import com.actuallily.materialcabinet.item.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MaterialCabinet.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MaterialCabinet.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // ITEMS
    public static final RegistryObject<Item> STORAGE_UNIT = ITEMS.register("storage_unit", ItemBase::new);

    // BLOCK
    public static final RegistryObject<Block> MATERIAL_CABINET_BLOCK = BLOCKS.register("storage_cabinet", MaterialCabinetBlock::new);

    // BLOCK ITEMS
    public static final RegistryObject<BlockItem> MATERIAL_CABINET_ITEM = ITEMS.register("storage_cabinet", () -> new BlockItemBase(MATERIAL_CABINET_BLOCK.get()));
}
