package com.dragonballzmod.packets.serverbound;

import com.dragonballzmod.packets.DragonBallZMessage;
import com.dragonballzmod.packets.ServerPacketHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ServerParticleEffectPacket extends DragonBallZMessage implements IMessageHandler<ServerParticleEffectPacket, IMessage> {
    public ServerParticleEffectPacket(byte[] payload) {
        this.packet = payload;
        this.packetLength = payload.length;
    }

    public ServerParticleEffectPacket() {
    }

    public IMessage onMessage(ServerParticleEffectPacket message, MessageContext ctx) {
        ServerPacketHandler.handleParticlePacket(message.packet);
        return null;
    }
}