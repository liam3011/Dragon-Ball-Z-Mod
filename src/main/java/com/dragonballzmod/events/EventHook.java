package com.dragonballzmod.events;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class EventHook {
    @SubscribeEvent
    public void handleConstruction(EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            DataWatcher dw = event.entity.getDataWatcher();
            dw.addObject(20, "default"); // jutsu pose id (such as charging)
            dw.addObject(21, 50); // amount of chakra
            dw.addObject(22, 50); // max amount of stamina
            dw.addObject(23, 50); // amount of chakra
            dw.addObject(24, 0); // amount of kunai in player
            dw.addObject(25, 0); // animationTick (used to add smooth animation for players to different poses, is currently edited by the client :P)
            dw.addObject(26, "default"); // lastpose (so the smooth animation works between poses)
            dw.addObject(27, "default"); // lastposeClient (the last pose the client updated(so it can change the animationTick back to 0))
            //dw.addObject(27, 0); // could also possibly add a kunai throw tick.

            Side side = FMLCommonHandler.instance().getEffectiveSide();
            if (side == Side.CLIENT) {
                event.entity.getEntityData().setString("lastposeClient", "default"); // this stores the last pose for the client but only client side
            }



            //event.entity.getEntityData().setBoolean("showEyes", true); // this is so the data is initialised on both sides
        }

        // TODO add a system to save data about the player, this will probably effect the extendedProperties of the NBT data, to save it it must be registered as a extended property net.minecraft.entity.Entity;

        //if(event.entity instanceof EntityPlayerMP){ // this can be used of the else if can be added using side == Side.SERVER
        //event.entity.getEntityData().setBoolean("showEyes", true);

        // TODO add some code to send all of the current NBT data to the user on the startup such as unlocked jutsus and everything. Also the players max chakra maybe so that it takes up one less data watcher slot
        //}
    }

    @SubscribeEvent
    public void playerPunch(AttackEntityEvent event) {
        EntityLivingBase attackedEntity = event.entityLiving;
        event.target.attackEntityFrom(new EntityDamageSource("player", event.entityPlayer), 20);
    }
}
