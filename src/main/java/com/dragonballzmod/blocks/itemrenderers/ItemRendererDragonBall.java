package com.dragonballzmod.blocks.itemrenderers;

import com.dragonballzmod.model.parts.dragonBallModel;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRendererDragonBall implements IItemRenderer {

    private dragonBallModel model;

    public ItemRendererDragonBall() {
        model = new dragonBallModel();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        GL11.glPushMatrix();
        //GL11.glTranslatef((float)par2 + 0.5F, (float)par4, (float)par6 + 0.5F);

        //int dir = par1TileEntityBonsai.getBlockMetadata();
        GL11.glRotatef(180, 1F, 0F, 0F);
        GL11.glScalef(1.2F, 1.2F, 1.2F);
        //GL11.glRotatef(dir * (90F), 0F, 1F, 0F);
        //GL11.glTranslatef(0.4F, 0.1F, -0.5F);
        //TileEntityRenderer.instance.renderEngine.bindTexture(new ResourceLocation("narutomod:textures/blocks/bonsaitree.png"));
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("dragonBallZMod:textures/blocks/model/dragonballtexture.png"));
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.95F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDepthMask(true);
        if (type == type.ENTITY) {
            GL11.glTranslatef(0.0F, -1.3F, 0.0F);
        } else if (type == type.INVENTORY) {
            GL11.glTranslatef(0.0F, -2.4F, 0.0F);
            GL11.glScalef(1.9F, 1.9F, 1.9F);
        } else if (type == type.EQUIPPED_FIRST_PERSON || type == type.EQUIPPED) {
            GL11.glTranslatef(0.70F, -1.9F, -0.70F);
            GL11.glScalef(1.4F, 1.4F, 1.4F);
        }
        this.model.render();

        GL11.glPopMatrix();

    }

}