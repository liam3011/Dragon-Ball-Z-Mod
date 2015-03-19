package com.dragonballzmod.packets.clientbound;

import com.dragonballzmod.packets.ClientPacketHandler;
import com.dragonballzmod.packets.DragonBallZMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientParticleEffectPacket extends DragonBallZMessage implements IMessageHandler<ClientParticleEffectPacket, IMessage> {
    public ClientParticleEffectPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ClientParticleEffectPacket() {
    }

    public IMessage onMessage(ClientParticleEffectPacket message, MessageContext ctx) {
        ClientPacketHandler.handleParticleEffect(message.packet);
        return null;
    }
}