package com.dragonballzmod.packets;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.entity.EntityClientPlayerMP;
import sekwah.mods.narutomod.client.JutsuClient;
import sekwah.mods.narutomod.client.ParticleEffects;
import sekwah.mods.narutomod.client.SoundEffects;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class ClientPacketHandler {

    public static void handleJutsuData(byte[] packet) {
        EntityClientPlayerMP playerMP = FMLClientHandler.instance().getClient().thePlayer;

        ByteArrayInputStream bais = new ByteArrayInputStream(packet);
        DataInputStream dis = new DataInputStream(bais);
        int JutsuCombo = 0;
        int dimension = 0;
        try {
            JutsuCombo = dis.readInt();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JutsuClient.execute(JutsuCombo, playerMP);
    }

    public static void handleParticleEffect(byte[] packet) {
        ByteArrayInputStream bais = new ByteArrayInputStream(packet);
        DataInputStream dis = new DataInputStream(bais);
        int effectID = 0;
        double x = -1.0D;
        double y = -1.0D;
        double z = -1.0D;
        int dimension = 0;
        try {
            effectID = dis.readInt();
            x = dis.readDouble();
            y = dis.readDouble();
            z = dis.readDouble();
            dimension = dis.readInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EntityClientPlayerMP playerMP = FMLClientHandler.instance().getClient().thePlayer;
        ParticleEffects.execute(effectID, playerMP, x, y, z);
    }

    public static void handleAnimationData(byte[] packet) {
        // TODO Auto-generated method stub

    }

    public static void handleSoundData(byte[] packet) {
        ByteArrayInputStream bais = new ByteArrayInputStream(packet);
        DataInputStream dis = new DataInputStream(bais);
        int soundID = 0;
        double x = -1.0D;
        double y = -1.0D;
        double z = -1.0D;
        try {
            soundID = dis.readInt();
            x = dis.readDouble();
            y = dis.readDouble();
            z = dis.readDouble();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EntityClientPlayerMP playerMP = FMLClientHandler.instance().getClient().thePlayer;
        SoundEffects.play(soundID,playerMP,x,y,z);
    }

}
