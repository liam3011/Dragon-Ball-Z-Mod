package com.dragonballzmod.blocks;

import com.dragonballzmod.DragonBallZMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNamekianStone extends Block {
    public BlockNamekianStone() {
        super(Material.rock);
        this.setHardness(1.3F);
        this.setResistance(10F);
        setCreativeTab(DragonBallZMod.dbTab);
        setBlockTextureName(DragonBallZMod.modid + ":" + "blockNamekianStone");
    }
}
