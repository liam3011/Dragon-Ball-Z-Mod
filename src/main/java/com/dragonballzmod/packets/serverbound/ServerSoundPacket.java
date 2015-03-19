package com.dragonballzmod.packets.serverbound;

import com.dragonballzmod.packets.DragonBallZMessage;
import com.dragonballzmod.packets.ServerPacketHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ServerSoundPacket extends DragonBallZMessage implements IMessageHandler<ServerSoundPacket, IMessage> {
    public ServerSoundPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ServerSoundPacket() {
    }

    public IMessage onMessage(ServerSoundPacket message, MessageContext ctx) {
        ServerPacketHandler.handleSoundPacket(message.packet);
        return null;
    }
}