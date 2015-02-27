package com.dragonballzmod.blocks.renderers;

import com.dragonballzmod.blocks.tileentity.TileEntityBase;
import com.dragonballzmod.blocks.tileentity.TileEntityDragonBall;
import com.dragonballzmod.model.parts.dragonBallModel;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityDragonBallRenderer extends TileEntitySpecialRenderer {

    public final dragonBallModel model = new dragonBallModel();

    //This method is called when minecraft renders a tile entity
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float f) {
        /**GL11.glPushMatrix();
         //This will move our renderer so that it will be on proper place in the world
         GL11.glTranslatef((float)d, (float)d1, (float)d2);
         TileEntityBonsai tileEntityYour = (TileEntityBonsai)tileEntity;
         GL11.glPopMatrix();*/

        this.renderBonsaiBlock((TileEntityDragonBall) tileEntity, d, d1, d2, f);
    }

    // this method isnt called yet sadly, make sure its called before fixing this code
    public void renderBonsaiBlock(TileEntityDragonBall par1TileEntityBall, double par2, double par4, double par6, float par8) {
        //System.out.println("renderTest");
        GL11.glPushMatrix();
        GL11.glTranslatef((float) par2 + 0.5F, (float) par4 + 1.5F, (float) par6 + 0.5F);
        int dir = par1TileEntityBall.getBlockMetadata();

        GL11.glPushMatrix();

        this.bindTexture(new ResourceLocation("dragonBallZMod:textures/blocks/stars/" + par1TileEntityBall.getStars() + "star.png"));

        EntityClientPlayerMP playerMP = FMLClientHandler.instance().getClient().thePlayer;

        GL11.glTranslatef(0F, -1.25F, 0F);
        GL11.glRotatef(-playerMP.rotationYawHead - 180 , 0F, 1F, 0F);
        GL11.glRotatef(-playerMP.rotationPitch + 180, 1F, 0F, 0F);

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.model.renderStar();

        GL11.glPopMatrix();



        GL11.glPushMatrix();
        this.bindTexture(new ResourceLocation("dragonBallZMod:textures/blocks/model/dragonballtexture.png"));
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.95F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDepthMask(true);

        GL11.glRotatef(180, 1F, 0F, 0F);
        GL11.glRotatef(dir * (45F), 0F, 1F, 0F);
        //GL11.glTranslatef(0.5F, -1.5F, -0.4F);

        //GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        //GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.8F);
        this.model.render();

        GL11.glPopMatrix();

        GL11.glPopMatrix();
        //  GL11.glEnable(GL11.GL_ALPHA_TEST);
    }
}