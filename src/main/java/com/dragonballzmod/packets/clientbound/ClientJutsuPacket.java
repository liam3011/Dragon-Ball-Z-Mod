package com.dragonballzmod.packets.clientbound;

import com.dragonballzmod.packets.ClientPacketHandler;
import com.dragonballzmod.packets.DragonBallZMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientJutsuPacket extends DragonBallZMessage implements IMessageHandler<ClientJutsuPacket, IMessage> {
    public ClientJutsuPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ClientJutsuPacket() {
    }

    public IMessage onMessage(ClientJutsuPacket message, MessageContext ctx) {
        ClientPacketHandler.handleJutsuData(message.packet);
        return null;
    }
}