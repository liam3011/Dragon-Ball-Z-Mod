package com.dragonballzmod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityCommandBlock;

public abstract class IDBZCommand extends CommandBase {

    public abstract void ProcessPlayer(EntityPlayer player, String[] params);
    public abstract void ProcessCommandBlock(TileEntityCommandBlock commandBlock, String[] params);
    public abstract void ProcessServerConsole(ICommandSender console, String[] params);
}