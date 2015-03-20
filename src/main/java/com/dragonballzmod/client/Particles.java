package com.dragonballzmod.client;

import com.dragonballzmod.particles.EntityColouredSmokeFX;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;


public class Particles {
    public static void addParticle(Particle particle, World worldObj, double x, double y, double z, float... args) {
        switch(particle){
            case COLOURED_SMOKE:
                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityColouredSmokeFX(worldObj, x,y,z,(int) args[0], (int) args[1],(int) args[2], args[3], args[4], args[5]));
                return;
        }
    }
}
