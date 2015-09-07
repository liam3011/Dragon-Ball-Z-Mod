package com.dragonballzmod.blocks;


import com.dragonballzmod.DragonBallZMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class BlockNamekianWoodSlab extends BlockSlab
{
    private Block extendingBlock;

    public BlockNamekianWoodSlab(boolean par2, Block block, Material par3Material)
    {
        super(par2, par3Material);
        useNeighborBrightness = true;
        this.extendingBlock = block;

        if(!par2)
        {
            this.setCreativeTab(DragonBallZMod.dbTab);
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon(DragonBallZMod.modid + ":" + this.extendingBlock.getUnlocalizedName().substring(5));
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(DragonBallZBlocks.blockNamekianWoodHalfslab);
    }

    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        if(par1World.getBlock(par2, par3 - 1, par4) == DragonBallZBlocks.blockNamekianWoodHalfslab)
        {
            par1World.setBlock(par2, par3 - 1, par4, DragonBallZBlocks.blockNamekianWoodDoubleslab);
        }
        if(par1World.getBlock(par2, par3 + 1, par4) == DragonBallZBlocks.blockNamekianWoodHalfslab)
        {
            par1World.setBlock(par2, par3 + 1, par4, DragonBallZBlocks.blockNamekianWoodDoubleslab);
        }
    }

    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(DragonBallZBlocks.blockNamekianWoodHalfslab, 2, par1 & 7);
    }


    @Override
    public String func_150002_b(int p_150002_1_) {
        return super.getUnlocalizedName();
    }


}
