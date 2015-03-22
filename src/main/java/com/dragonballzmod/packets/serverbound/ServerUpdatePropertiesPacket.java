package com.dragonballzmod.packets.serverbound;

import com.dragonballzmod.packets.DragonBallZMessage;
import com.dragonballzmod.packets.ServerPacketHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ServerUpdatePropertiesPacket extends DragonBallZMessage implements IMessageHandler<ServerUpdatePropertiesPacket, IMessage> {
    public ServerUpdatePropertiesPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ServerUpdatePropertiesPacket() {
    }

    public IMessage onMessage(ServerUpdatePropertiesPacket message, MessageContext ctx) {
        ServerPacketHandler.handleSoundPacket(message.packet);
        return null;
    }
}