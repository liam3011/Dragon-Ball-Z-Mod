package com.dragonballzmod.blocks;


import com.dragonballzmod.DragonBallZMod;
import com.dragonballzmod.blocks.tileentity.TileEntityThinTree;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockThinTree extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    private IIcon[] blockIcons;
    public BlockThinTree()
    {
        super(Material.wood);
        this.setHardness(3F);
        this.setStepSound(soundTypeWood);
        this.setBlockBounds(1F/16F*6, 0F, 1F/16F*6F, 1F-1F/16F*6F, 1F-1F/16F*0F, 1F-1F/16F*6F);
        setCreativeTab(DragonBallZMod.dbTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(DragonBallZMod.modid + ":blockThinTree.png");
    }

    public int getRenderType()
    {
        return -3011;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityThinTree();
    }


}
