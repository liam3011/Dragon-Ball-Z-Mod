package com.dragonballzmod.packets.clientbound;

import com.dragonballzmod.packets.ClientPacketHandler;
import com.dragonballzmod.packets.DragonBallZMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientSoundPacket extends DragonBallZMessage implements IMessageHandler<ClientSoundPacket, IMessage> {
    public ClientSoundPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ClientSoundPacket() {
    }

    public IMessage onMessage(ClientSoundPacket message, MessageContext ctx) {
        ClientPacketHandler.handleSoundData(message.packet);
        return null;
    }
}