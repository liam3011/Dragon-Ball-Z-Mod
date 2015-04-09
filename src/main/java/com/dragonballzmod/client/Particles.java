package com.dragonballzmod.client;

import com.dragonballzmod.particles.EntityColouredSmokeFX;
import com.dragonballzmod.particles.EntityColouredSmokeTrackingFX;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;


public class Particles {
    public static void addParticle(Particle particle, World worldObj, double x, double y, double z, float... args) {
        switch(particle){
            case COLOURED_SMOKE:
                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityColouredSmokeFX(worldObj, x,y,z,args[0], args[1],args[2], args[3], args[4], args[5]));
                return;
        }
    }

    public static void addTrackingParticle(Particle particle, World worldObj, double x, double y, double z, Entity entity, float... args) {
        switch(particle){
            case COLOURED_SMOKE:
                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityColouredSmokeTrackingFX(worldObj, x,y,z,args[0], args[1],args[2], args[3], args[4], args[5],  entity));
                return;
        }
    }
}
