package com.dragonballzmod.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;

public class PlayerClientTickEvent {
    // to do with the keypress data for jutsus
    public static String JutsuCombo = "";

    public static int JutsuKeyDelay = 0;

    /*public static float chakra = 100;
    public static float maxChakra = 100;
    public static int chakraCooldown;*/
    public static boolean isChakraFocus;
    public static String jutsuPoseID = "default"; // finish this so it is set by the different jutsu, for chakra charge it when its turned off and on. and for other jutsus set a delay untill its changed back
    private static boolean ChakraCharge = false;
    private static int ChakraChargeDelay = 20;
    private static double lastX;
    private static double lastY;
    private static double lastZ;
    private static boolean playerMoved;

    public static String defaultPose = "default";

    public int animationUpdate; // use at some point to update animations after they have been set.

    public static String getJutsuPoseID() {
        if (jutsuPoseID == "default") {
            //if(isChakraFocus){
            //	return "chakraCharging";
            //}
            //else{
            return "default";
            //}
        }
        return jutsuPoseID;
    }

    @SubscribeEvent
    public void tick(ClientTickEvent event) {
        GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
        if (guiscreen == null || guiscreen instanceof GuiInventory || guiscreen instanceof GuiChat) {


            boolean ChakraFocus = false;

            EntityClientPlayerMP playerMP = FMLClientHandler.instance().getClient().thePlayer;

            if(playerMP.capabilities.isFlying){
                defaultPose = "flying";
            }
            else{
                defaultPose = "default";
            }

            if (lastX == playerMP.posX && lastY == playerMP.posY && lastZ == playerMP.posZ) {
                playerMoved = false;
            } else {
                playerMoved = true;
            }


            lastX = playerMP.posX;
            lastY = playerMP.posY;
            lastZ = playerMP.posZ;

        }
    }
}
