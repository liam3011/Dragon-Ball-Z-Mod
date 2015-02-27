package com.dragonballzmod.blocks;

import com.dragonballzmod.DragonBallZMod;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class BlockNamekianSand extends BlockFalling {
    public BlockNamekianSand() {
        super(Material.sand);
        this.setStepSound(soundTypeSand);
        setCreativeTab(DragonBallZMod.dbTab);
        setBlockTextureName(DragonBallZMod.modid + ":" + "blockNamekianSand");
    }
}
