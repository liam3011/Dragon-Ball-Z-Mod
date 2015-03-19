package com.dragonballzmod.packets;

import com.dragonballzmod.DragonBallZMod;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketDispatcher {

    public static void sendPacketToServer(DragonBallZMessage message) {
        DragonBallZMod.packetNetwork.sendToServer(message);
    }

    public static void sendPacketToPlayer(DragonBallZMessage message, EntityPlayerMP player) {
        DragonBallZMod.packetNetwork.sendTo(message, player);
    }

    public static void sendPacketToAll(DragonBallZMessage message) {
        DragonBallZMod.packetNetwork.sendToAll(message);
    }

    public static void sendPacketToAllAround(DragonBallZMessage message, TargetPoint point) {
        DragonBallZMod.packetNetwork.sendToAllAround(message, point);
    }

}
