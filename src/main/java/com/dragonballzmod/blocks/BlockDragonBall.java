package com.dragonballzmod.blocks;

import com.dragonballzmod.DragonBallZMod;
import com.dragonballzmod.blocks.tileentity.TileEntityDragonBall;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockDragonBall extends BlockContainer {
    @SideOnly(Side.CLIENT)
    private IIcon[] blockIcons;

    private int stars = 0;

    private int ballStage = 0;

    public BlockDragonBall(int stars) {
        super(Material.plants);
        this.stars = stars;
        setCreativeTab(DragonBallZMod.dbTab);
        this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.6F, 0.8F);
        this.setLightLevel(0.4F);
        this.setLightOpacity((int) 0F);
        createStackedBlock(1);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(DragonBallZMod.modid + ":blockDragonBall");
    }

    public int getStars(){
        return stars;
    }

    // I want tayas panties

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return false;
    }

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        Side side = FMLCommonHandler.instance().getSide();

        if(stars == 7){
            //  par1World.spawnEntityInWorld(new EntityLightningBolt(par1World, par2, par3, par4));

            //  if(side == Side.CLIENT) {
            //    par5EntityPlayer.addChatMessage(new ChatComponentText("Eternal dragon, by your name I summon you forth! SHENRON!!!"));
            if(!par1World.isRemote){
                par5EntityPlayer.addChatMessage(new ChatComponentText("Eternal dragon, by your name I summon you forth! SHENRON!!!"));
            }
            //  par5EntityPlayer.addChatComponentMessage(new ChatComponentText("Eternal dragon, by your name I summon you forth! SHENRON!!!"));
            // par1World.spawnEntityInWorld(new EntityLightningBolt(par1World, par2, par3, par4));

            // ((EntityPlayerMP) par5EntityPlayer).playerNetServerHandler.sendPacket(new S0EPacketSpawnObject(new EntityLightningBolt(par1World, par2, par3, par4), 0));
            // par1World.spawnEntityInWorld(new EntityLightningBolt(par1World, par2, par3, par4));
            par1World.scheduleBlockUpdate(par2, par3, par4, this, 1);
            ballStage = 0;

            // if(par1World.getBiomeGenForCoords(0,0) != BiomeGenBase.sky){
            //     BiomeGenBase.getBiome(16).temperature = 0.0f;


            // }
            // event.getPlayer().getWorld().getBiome();
            // if( event.getPlayer().getWorld().getBiome() != BiomeGenBase.sky){
            //     event.getPlayer().getWorld().getBiome().temperature = 0.0F;
            // }
        }


        return true;
    }

    public void updateTick(World par1World, int x, int y, int z, Random par5Random) {
        ballStage++;
        if(ballStage <= 2){
            par1World.addWeatherEffect(new EntityLightningBolt(par1World, x,y,z));
            par1World.scheduleBlockUpdate(x,y,z, this, 40);
        }
        else if(ballStage == 3){
            par1World.addWeatherEffect(new EntityLightningBolt(par1World, x,y,z));
            EntityCaveSpider spider = new EntityCaveSpider(par1World);
            spider.setCustomNameTag("Shenron");
            spider.setPosition(x,y + 1,z);
            par1World.spawnEntityInWorld(spider);
        }
        /**for(Object player: par1World.playerEntities){
         if(player instanceof EntityPlayerMP){
         EntityPlayerMP playerMP = (EntityPlayerMP) player;
         if(playerMP.getDistance(x,y,z) <= 64){
         System.out.println("SENT PACKET TO " + playerMP.getCommandSenderName());
         playerMP.playerNetServerHandler.sendPacket(new S0EPacketSpawnObject(new EntityLightningBolt(par1World, x,y + 1,z),1));
         }
         }
         }*/
    }



    /**
     * Gets the light value of the specified block coords. Args: x, y, z
     */

    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        if (block != this) {
            return block.getLightValue(world, x, y, z);
        }
        /**
         * Gets the light value of the specified block coords. Args: x, y, z
         */
        float lightLevel = -0F;
        for (int x1 = -1; x1 <= 1; x1++) {
            for (int z1 = -1; z1 <= 1; z1++) {
                if(world.getBlock(x + x1, y, z + z1) instanceof BlockDragonBall) lightLevel += 0.15F;
            }
        }
        if (lightLevel > 1F) {
            lightLevel = 1F;


        }
        // System.out.println("LIGHT");
        return (int) (15.0F * lightLevel);
    }


    /**
     * Change this depending on the size of the summoning animal
     * <p/>
     * note: This checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        return par3 >= 255 ? false : World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4);
    }

    public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack) {
        //int dir = MathHelper.floor_double((double)((par5EntityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        int dir = MathHelper.floor_double((double) ((par5EntityLiving.rotationYaw * 8F) / 360F) + 0.5D);
        par1World.setBlockMetadataWithNotify(x, y, z, dir + 2, 0);

        for (int x1 = -1; x1 <= 1; x1++) {
            for (int z1 = -1; z1 <= 1; z1++) {
                par1World.func_147479_m(x + x1, y, z + z1);
            }
        }

    }

	/*public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
		super.onNeighborBlockChange(par1World, par2, par3, par4, Block.getBlockById(par5));
    	if (!this.canBlockStay(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
        }
    }*/

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    //public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    // {
    //    return par3 >= 255 ? false : par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4);
    //}

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World par1World, int p_149915_2_) {
        return new TileEntityDragonBall(stars);
    }

    //And this tell it that you can see through this block, and neighbor blocks should be rendered.
    public boolean isOpaqueCube() {
        return false;
    }



}