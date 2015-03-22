package com.dragonballzmod.common;

import com.dragonballzmod.commands.SetRace;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;

public class CommonProxy {

    public void registerEveryThing() {
       // RenderingRegistry.registerEntityRenderingHandler(EntityFlyingNimbus.class, new RenderFlyingNimbus());
        MinecraftServer server = MinecraftServer.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) command;

        ((ServerCommandManager) command).registerCommand(new SetRace());

    }

    public void registerCustomBlocks() {

    }

}
