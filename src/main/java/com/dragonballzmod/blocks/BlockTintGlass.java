package com.dragonballzmod.blocks;

import com.dragonballzmod.DragonBallZMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;

import java.util.Random;

public class BlockTintGlass extends BlockBreakable {
    private static final String __OBFID = "CL_00000249";

    public BlockTintGlass(Material glass, boolean p_i45408_2_) {
        super("glass", Material.glass, p_i45408_2_);
        this.setBlockTextureName(DragonBallZMod.modid + ":" + "blockNameTintGlass");
        setBlockName("blockTintGlass");
        //setCreativeTab(DragonBallZMod.dbTab);
        setBlockTextureName(DragonBallZMod.modid + ":" + "blockNameTintGlass");
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_) {
        return 0;
    }

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest() {
        return true;
    }

}
