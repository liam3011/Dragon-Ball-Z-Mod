package com.dragonballzmod.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class playerPunch {
    @SubscribeEvent
    public void playerPunch(AttackEntityEvent event) {
        EntityLivingBase attackedEntity = event.entityLiving;
        event.target.attackEntityFrom(new EntityDamageSource("player", event.entityPlayer), 1);
    }
}
