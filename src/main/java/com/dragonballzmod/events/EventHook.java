package com.dragonballzmod.events;

import com.dragonballzmod.player.extendedproperties.PlayerInfo;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class EventHook {
    @SubscribeEvent
    public void handleConstruction(EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            DataWatcher dw = event.entity.getDataWatcher();
            dw.addObject(20, "default"); // pose id (such as charging)
            dw.addObject(21, "None"); // player's race
            // 22-24 are free atm, may need to shift all values if you want it to work with the naruto mod, or just have an extra one which is saying if
            //  its a ninja or squishysaiyan
            dw.addObject(25, 0); // animationTick (used to add smooth animation for players to different poses, is currently edited by the client :P)
            dw.addObject(26, "default"); // lastpose (so the smooth animation works between poses)
            dw.addObject(27, "default"); // poseClient (the last pose the client updated(so it can change the animationTick back to 0))
            //dw.addObject(27, 0); // could also possibly add a kunai throw tick.

            event.entity.registerExtendedProperties(PlayerInfo.IDENTIFIER, new PlayerInfo((EntityPlayer) event.entity));

            /*Side side = FMLCommonHandler.instance().getEffectiveSide();
            if (side == Side.CLIENT) {
                event.entity.getEntityData().setString("lastposeClient", "default"); // this stores the last pose for the client but only client side
            }*/



            //event.entity.getEntityData().setBoolean("showEyes", true); // this is so the data is initialised on both sides
        }


        // TODO add a system to save data about the player, this will probably effect the extendedProperties of the NBT data, to save it it must be registered as a extended property net.minecraft.entity.Entity;

        //if(event.entity instanceof EntityPlayerMP){ // this can be used of the else if can be added using side == Side.SERVER
        //event.entity.getEntityData().setBoolean("showEyes", true);

        // TODO add some code to send all of the current NBT data to the user on the startup such as unlocked jutsus and everything. Also the players max chakra maybe so that it takes up one less data watcher slot
        //}
    }

    @SubscribeEvent
    public void onClonePlayer(PlayerEvent.Clone event) {
        PlayerInfo.get(event.entityPlayer).copyData(PlayerInfo.get(event.original));
    }

    @SubscribeEvent
    public void onJoinWorld(EntityJoinWorldEvent event) {
        // If you have any non-DataWatcher fields in your extended properties that
        // need to be synced to the client, you must send a packet each time the
        // player joins the world; this takes care of dying, changing dimensions, etc.
        if (event.entity instanceof EntityPlayerMP) {
            EntityPlayer player = (EntityPlayer) event.entity;
            PlayerInfo.get(player).reloadDW();
            //PacketDispatcher.sendTo(new SyncPlayerPropsMessage((EntityPlayer) event.entity), (EntityPlayerMP) event.entity);
        }
    }

    @SubscribeEvent
    public void playerPunch(AttackEntityEvent event) {
        EntityLivingBase attackedEntity = event.entityLiving;
        event.target.attackEntityFrom(new EntityDamageSource("player", event.entityPlayer), 1);
    }
}
