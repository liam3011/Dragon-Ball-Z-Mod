package com.dragonballzmod.client;


import com.dragonballzmod.blocks.DragonBallZBlocks;
import com.dragonballzmod.blocks.itemrenderers.ItemRendererDragonBall;
import com.dragonballzmod.blocks.renderers.TileEntityDragonBallRenderer;
import com.dragonballzmod.blocks.tileentity.TileEntityBase;
import com.dragonballzmod.blocks.tileentity.TileEntityDragonBall;
import com.dragonballzmod.common.CommonProxy;
import com.dragonballzmod.entity.EntityFlyingNimbus;
import com.dragonballzmod.player.RenderDBZPlayer;
import com.dragonballzmod.render.RenderFlyingNimbus;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
    public void registerEveryThing() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNimbus.class, new RenderFlyingNimbus());
        RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderDBZPlayer());
        MinecraftForge.EVENT_BUS.register(new PlayerRenderTickEvent());
    }

    public void registerCustomBlocks() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDragonBall.class, new TileEntityDragonBallRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall1), (IItemRenderer) new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall2), (IItemRenderer) new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall3), (IItemRenderer) new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall4), (IItemRenderer) new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall5), (IItemRenderer) new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall6), (IItemRenderer) new ItemRendererDragonBall());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DragonBallZBlocks.blockDragonBall7), (IItemRenderer) new ItemRendererDragonBall());
    }
}
