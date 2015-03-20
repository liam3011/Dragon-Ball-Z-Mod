package com.dragonballzmod.client;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;

public class SoundEffects {

    public static void play(int soundID, EntityClientPlayerMP playerMP, double posX, double posY, double posZ) {

        if(soundID == 1){
            playerMP.worldObj.playSound(posX, posY, posZ, "dragonBall:powerblast_sound", 0.5F, 1F, false); // fake sound name thing
        }
    }

}
