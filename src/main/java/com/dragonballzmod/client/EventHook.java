package com.dragonballzmod.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import org.lwjgl.opengl.GL11;

public class EventHook {

    /**@ForgeSubscribe
     @SideOnly(Side.CLIENT)
     public void onLivingJumpEvent(LivingJumpEvent event)
     {
     if (event.entity instanceof EntityPlayer)
     {
     if (PlayerClientTickHandler.chakraDash)
     {
     event.entity.motionY += 0.2D;
     PlayerClientTickHandler.chakra -= 0.04F;

     ParticleEffects.addEffect(3, (EntityClientPlayerMP) event.entity);
     }
     }
     }*/


    // The tick event is in its own class
    /**@SubscribeEvent public void tick(ClientTickEvent event) {
    PlayerClientTickHandeler.firePlayerTick();
    //TickRegistry.registerTickHandler(new PlayerCommonTickHandler(), Side.SERVER);
    }*/

    /**@ForgeSubscribe public void renderWorldLastEvent(RenderWorldLastEvent evt)
    {
    // for extra render effects
    }*/

    /**@ForgeSubscribe
     @SideOnly(Side.CLIENT)
     public void entityAttacked(LivingAttackEvent event)
     {
     EntityLiving attackedEnt = event.entityLiving;
     DamageSource attackSource = event.source;
     }*/

    //@SubscribeEvent
    //public void renderHand(RenderHandEvent event) {
        //System.out.println(NarutoSettings.experimentalFirstPerson);
        //GL11.glTranslated(0,50F,0);
        //event.setCanceled(NarutoSettings.experimentalFirstPerson);

    //}

    //FogColors
    // FogDensity possibly for genjutsu

    // One of the events may be able to be used to change the camera position, also look at the player render event and other stuff
    // to see which is appropriate to render the player :)
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onFogColors(EntityViewRenderEvent.FogColors event) {
        event.blue = 0;
        event.green = 0;
        event.red = 0;
    }


    // Litteraly all usefull stuff for rendering this and possibly camera transformations can be found in the EntityRenderer
    //  found at net.minecraft.client.renderer
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onFogDensity(EntityViewRenderEvent.FogDensity event) {
        //System.out.println(event.density);
        // May be default fog, look into fog types more
        // Fog is linear in air and GL_EXP in liquids.
        //GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_LINEAR);
        EntityClientPlayerMP playerMP = FMLClientHandler.instance().getClient().thePlayer;
        // Find where the fog will be generally calculated in air and animate it from those points using special time.
        //  so there should be code in the update code of shenron as all nearby players will calculate his updates
        //
        // Look at gl lighting, see when lighting is done and stuff and see if you can make a point light
        //GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glFogf(GL11.GL_FOG_START, 2.0f);
        GL11.glFogf(GL11.GL_FOG_END, 20.0f);
        // If you want to change the fog density, you must do it with event.density
        // because cancelling the event calls
        // GL11.glFogf(GL11.GL_FOG_DENSITY, event.density);

        //event.density = 0.5F;
        event.setCanceled(true);
    }

}
