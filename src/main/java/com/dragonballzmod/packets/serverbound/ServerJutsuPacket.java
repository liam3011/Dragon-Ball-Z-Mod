package com.dragonballzmod.packets.serverbound;

import com.dragonballzmod.packets.DragonBallZMessage;
import com.dragonballzmod.packets.ServerPacketHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ServerJutsuPacket extends DragonBallZMessage implements IMessageHandler<ServerJutsuPacket, IMessage> {
    public ServerJutsuPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ServerJutsuPacket() {
    }

    public IMessage onMessage(ServerJutsuPacket message, MessageContext ctx) {
        ServerPacketHandler.handleJutsuPacket(message.packet, ctx.getServerHandler().playerEntity);
        return null;
    }
}