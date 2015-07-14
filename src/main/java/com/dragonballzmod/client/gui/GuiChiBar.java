package com.dragonballzmod.client.gui;

import com.dragonballzmod.DragonBallZMod;
import com.dragonballzmod.client.PlayerClientTickEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

/**
 * Created by liam on 20/06/2015.
 */
public class GuiChiBar extends Gui
{
    private static final ResourceLocation NOCHI = new ResourceLocation("DragonBallZMod", "textures/gui/nochi.png");
    private static final ResourceLocation BLUECHI = new ResourceLocation("DragonBallZMod", "textures/gui/bluechi.png");
    private static final int BUFF_ICON_SIZE = 18;
    private static final int BUFF_ICON_SPACING = 20;
    private static final int BUFF_ICON_BASE_U_OFFSET = 0;
    private static final int BUFF_ICON_BASE_V_OFFSET = 198;
    private static final int BUFF_ICONS_PER_ROW = 8;
    private Minecraft mc;

    public GuiChiBar(Minecraft mc)
    {
        this.mc = mc;
    }

    @SubscribeEvent
    public void onRenderExperienceBar(RenderGameOverlayEvent event)
    {
        if ((event.isCancelable()) || (event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE))
        {
            return;
        }

        ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayHeight, this.mc.displayWidth);

        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);


        GL11.glEnable(3008);

        int OffsetX = 2;
        int OffsetY = 2;

        int chiHeight = (int)(PlayerClientTickEvent.chi / PlayerClientTickEvent.maxChi * 100.0F);

        GL11.glDisable(2896);

        GL11.glPopMatrix();
    }

    }
