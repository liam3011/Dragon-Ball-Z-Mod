package com.dragonballzmod.commands;

import com.dragonballzmod.player.extendedproperties.PlayerInfo;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.ChatComponentText;

public class SetRace extends IDBZCommand {

    @Override
    public String getCommandName()
    {
        return "setrace";
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender)
    {
        return "Set the race by typing the race (/setrace [race])";
    }

    @Override
    public void processCommand(ICommandSender icommandsender, String[] string)
    {
        if(icommandsender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) icommandsender;
            //PlayerInfo info = PlayerInfo.get(player);
            //info.setRace(string[0]);
            player.getDataWatcher().updateObject(21, string[0]);
            player.addChatMessage(new ChatComponentText("Race set to: " + string[0]));
        }
    }

    @Override
    public void ProcessPlayer(EntityPlayer player, String[] params) {

    }

    @Override
    public void ProcessCommandBlock(TileEntityCommandBlock commandBlock, String[] params) {

    }

    @Override
    public void ProcessServerConsole(ICommandSender console, String[] params) {

    }
}
