package com.dragonballzmod.commands;

import com.dragonballzmod.player.extendedproperties.PlayerInfo;
import com.mojang.authlib.GameProfile;
import cpw.mods.fml.client.config.GuiConfigEntries;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class SetRace extends IDBZCommand {

    @Override
    public String getCommandName()
    {
        return "setrace";
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender)
    {
        return "Set the race by typing the race (/setrace [race]). " +
                "This is designed for debugging and not general use " +
                "using this once you have a race selected may cause unexpected" +
                " errors and potentially crash your mc.";
    }

    @Override
    public void processCommand(ICommandSender icommandsender, String[] string)
    {
        if(icommandsender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) icommandsender;
            if(isOp(player.getGameProfile())){
                PlayerInfo info = PlayerInfo.get(player);
                info.setRace(string[0]);
                info.reloadDW();
                player.addChatMessage(new ChatComponentText("Race set to: " + string[0]));
            }
            else{
                player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "You must be opped!"));
            }
        }
    }

    public static boolean isOp(GameProfile gameProfile)
    {
        return MinecraftServer.getServer().getConfigurationManager().func_152596_g(gameProfile);
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
