package com.dragonballzmod.packets.clientbound;

import com.dragonballzmod.packets.ClientPacketHandler;
import com.dragonballzmod.packets.DragonBallZMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientUpdatePropertiesPacket extends DragonBallZMessage implements IMessageHandler<ClientUpdatePropertiesPacket, IMessage> {
    public ClientUpdatePropertiesPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ClientUpdatePropertiesPacket() {
    }

    public IMessage onMessage(ClientUpdatePropertiesPacket message, MessageContext ctx) {
        ClientPacketHandler.handleSoundData(message.packet);
        return null;
    }
}