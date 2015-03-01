package com.dragonballzmod.client;

import com.dragonballzmod.animation.DBZAnimator;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import org.lwjgl.opengl.GL11;

public class PlayerRenderTickEvent {

    public static int delta;
    public static boolean hasFiredAnimationUpdate = false;
    private long lastTime;

    @SubscribeEvent
    public void tick(RenderTickEvent event) {
        GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
        if (guiscreen == null || guiscreen instanceof GuiInventory || guiscreen instanceof GuiChat) {
            //double nsPerTick = 1000000000D / 120D; change that number to increase the update rate.

            EntityClientPlayerMP playerMP = FMLClientHandler.instance().getClient().thePlayer;

            DBZAnimator.updateClient(playerMP, DBZAnimator.playerPoses);

            // TODO finish this code so it works with the morph mod
            // also make sure that if the first person is set to false in the config it igores this completely
            //Render renderer = RenderManager.instance.getEntityRenderObject(playerMP);
            //if(renderer instanceof RenderPlayer){
            //	NarutoMod.experimentalFirstPerson = true;
            //}
            //else{
            //	NarutoMod.experimentalFirstPerson = false;
            //}

            GL11.glTranslatef(0F, 0F, 0F);

            double nsPerTick = 1000000000D / 120D;

            delta = 0;

            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            if (delta >= 1) {
                lastTime = now;
            } else if (delta < 0) {
                lastTime = now;
              //  NarutoMod.LOGGER.error("[Naruto Mod] Your computer seems to have traveled back in time :O");
            }
        }
        /**if (guiscreen == null) {
            for (int i = 0; i < NarutoKeyHandler.keys.length; i++) {
                if (NarutoKeyHandler.ispressed[i] != NarutoKeyHandler.keys[i].getIsKeyPressed()) {
                    NarutoKeyHandler.ispressed[i] = NarutoKeyHandler.keys[i].getIsKeyPressed();
                    NarutoKeyHandler.keyPressed(i);
                }
            }
        }**/
    }
}