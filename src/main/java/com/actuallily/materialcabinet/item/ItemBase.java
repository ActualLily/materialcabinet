package com.actuallily.materialcabinet.item;

import com.actuallily.materialcabinet.MaterialCabinet;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(MaterialCabinet.TAB));
    }
}
