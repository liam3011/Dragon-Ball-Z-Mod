package com.dragonballzmod.blocks.itemrenderers;


import com.dragonballzmod.model.parts.thinTreeModel;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRendererThinTree implements IItemRenderer
{
    private thinTreeModel model;

    public ItemRendererThinTree() {model = new thinTreeModel();}

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
        GL11.glRotatef(180, 1F, 0F, 0F);
        GL11.glScalef(0.8F, 0.8F, 0.8F);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("dragonballzmod:textures/blocks/model/blockThinTree.png"));
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.95F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDepthMask(true);

        if (type == ItemRenderType.ENTITY) {
            GL11.glTranslatef(0.0F, 1F, 0.0F);
        } else if (type == ItemRenderType.INVENTORY) {
            GL11.glTranslatef(0.0F, -2.4F, 0.0F);
            GL11.glScalef(1.9F, 1.9F, 1.9F);
        } else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON || type == ItemRenderType.EQUIPPED) {
            GL11.glTranslatef(0.70F, -1.9F, -0.70F);
            GL11.glScalef(1.4F, 1.4F, 1.4F);
        }
        this.model.render();

        GL11.glPopMatrix();
    }
}
