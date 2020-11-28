package com.actuallily.materialcabinet.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MaterialCabinetBlock extends Block {

    public MaterialCabinetBlock() {
        super(Block.Properties.create(Material.WOOD)
                .hardnessAndResistance(3.0f, 5.0f)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
        );
    }
}
