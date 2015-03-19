package com.dragonballzmod.packets.clientbound;

import com.dragonballzmod.packets.ClientPacketHandler;
import com.dragonballzmod.packets.DragonBallZMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientAnimationPacket extends DragonBallZMessage implements IMessageHandler<ClientAnimationPacket, IMessage> {
    public ClientAnimationPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ClientAnimationPacket() {
    }

    public IMessage onMessage(ClientAnimationPacket message, MessageContext ctx) {
        ClientPacketHandler.handleAnimationData(message.packet);
        return null;
    }
}