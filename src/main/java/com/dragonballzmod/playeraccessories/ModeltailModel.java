package com.dragonballzmod.playeraccessories;

import com.dragonballzmod.player.ModelDBZBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModeltailModel extends ModelDBZBiped {
    //fields
    public ModelRenderer lowerBodyTrack;
    public ModelRenderer Tail1;
    public ModelRenderer Tail2;
    public ModelRenderer Tail4;
    public ModelRenderer Tail3;
    public ModelRenderer Tail5;
    public ModelRenderer Tail6;
    public ModelRenderer Tail7;

    public float tailSwing;

    public ModeltailModel() {
        textureWidth = 64;
        textureHeight = 32;

        lowerBodyTrack = new ModelRenderer(this, 0, 0);
        Tail1 = new ModelRenderer(this, 0, 0);
        Tail1.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tail1.setRotationPoint(0F, 4F, 2F);
        Tail1.setTextureSize(64, 32);
        Tail1.mirror = true;
        setRotation(Tail1, 0F, 0F, 0F);
        Tail2 = new ModelRenderer(this, 0, 0);
        Tail2.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tail2.setRotationPoint(0F, 0F, 3F);
        Tail2.setTextureSize(64, 32);
        Tail2.mirror = true;
        setRotation(Tail2, 0F, 0F, 0F);
        Tail4 = new ModelRenderer(this, 0, 0);
        Tail4.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tail4.setRotationPoint(0F, 0F, 3F);
        Tail4.setTextureSize(64, 32);
        Tail4.mirror = true;
        setRotation(Tail4, 0F, 0F, 0F);
        Tail3 = new ModelRenderer(this, 0, 0);
        Tail3.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tail3.setRotationPoint(0F, 0F, 3F);
        Tail3.setTextureSize(64, 32);
        Tail3.mirror = true;
        setRotation(Tail3, 0F, 0F, 0F);
        Tail5 = new ModelRenderer(this, 0, 0);
        Tail5.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tail5.setRotationPoint(0F, 0F, 3F);
        Tail5.setTextureSize(64, 32);
        Tail5.mirror = true;
        setRotation(Tail5, 0F, 0F, 0F);
        Tail6 = new ModelRenderer(this, 0, 0);
        Tail6.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tail6.setRotationPoint(0F, 0F, 3F);
        Tail6.setTextureSize(64, 32);
        Tail6.mirror = true;
        setRotation(Tail6, 0F, 0F, 0F);
        Tail7 = new ModelRenderer(this, 0, 0);
        Tail7.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tail7.setRotationPoint(0F, 0F, 3F);
        Tail7.setTextureSize(64, 32);
        Tail7.mirror = true;
        setRotation(Tail7, 0F, 0F, 0F);

        lowerBodyTrack.addChild(Tail1);
        Tail1.addChild(Tail2);
        Tail2.addChild(Tail3);
        Tail3.addChild(Tail4);
        Tail4.addChild(Tail5);
        Tail5.addChild(Tail6);
        Tail6.addChild(Tail7);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        lowerBodyTrack.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void updateRotations() {
        if (this.isSprinting) {
            setRotation(Tail1, 0.1F + -MathHelper.cos(this.tailSwing * 0.89F) * 0.02F, MathHelper.cos(this.tailSwing * 0.7062F) * 0.09F, 0F);
            setRotation(Tail2, 0.2F + MathHelper.cos(this.tailSwing * 0.89F + 0.4F) * 0.02F, MathHelper.cos(this.tailSwing * 0.7536F) * 0.09F, 0F);
            setRotation(Tail4, 0.2F + MathHelper.cos(this.tailSwing * 0.89F + 0.8F) * 0.02F, MathHelper.cos(this.tailSwing * 0.7315F) * 0.09F, 0F);
            setRotation(Tail3, 0.2F + MathHelper.cos(this.tailSwing * 0.89F + 1.2F) * 0.02F, MathHelper.cos(this.tailSwing * 0.7262F) * 0.0923F, 0F);
            setRotation(Tail5, 0.2F + MathHelper.cos(this.tailSwing * 0.89F + 1.8F) * 0.02F + MathHelper.sin(this.tailSwing * 0.09F + 0.6F) * 0.09F, MathHelper.cos(this.tailSwing * 0.7612F) * 0.19F, 0F);
            setRotation(Tail6, -0.3F + MathHelper.cos(this.tailSwing * 0.89F + 0.2F) * 0.02F + MathHelper.sin(this.tailSwing * 0.09F + 0.6F) * 0.09F, MathHelper.cos(this.tailSwing * 0.7952F) * 0.19F, 0F);
            setRotation(Tail7, -0.3F + MathHelper.cos(this.tailSwing * 0.89F + 0.6F) * 0.02F + MathHelper.sin(this.tailSwing * 0.09F + 0.6F) * 0.09F, MathHelper.cos(this.tailSwing * 0.7934F) * 0.19F, 0F);
        } else {
            float addMulti = MathHelper.cos(this.tailSwing * 0.009F) * 0.89F;
            setRotation(Tail1, 0.1F + -MathHelper.cos(this.tailSwing * 0.09F) * (0.29F * addMulti), MathHelper.cos(this.tailSwing * 0.1062F) * 0.19F, 0F);
            setRotation(Tail2, 0.4F + MathHelper.cos(this.tailSwing * 0.09F + 0.4F) * (0.19F * addMulti), MathHelper.cos(this.tailSwing * 0.0536F) * (0.19F * addMulti), 0F);
            setRotation(Tail4, 0.4F + MathHelper.cos(this.tailSwing * 0.09F + 0.8F) * (0.27F * addMulti), MathHelper.cos(this.tailSwing * 0.1315F) * (0.19F * addMulti), 0F);
            setRotation(Tail3, 0.3F + MathHelper.cos(this.tailSwing * 0.09F + 1.2F) * (0.29F * addMulti), MathHelper.cos(this.tailSwing * 0.1262F) * (0.1923F * addMulti), 0F);
            setRotation(Tail5, 0.2F + MathHelper.cos(this.tailSwing * 0.09F + 1.8F) * (0.49F * addMulti) + MathHelper.sin(this.tailSwing * 0.09F + 0.6F) * (0.19F * addMulti), MathHelper.cos(this.tailSwing * 0.0612F) * (0.19F * addMulti), 0F);
            setRotation(Tail6, -0.3F + MathHelper.cos(this.tailSwing * 0.09F + 0.2F) * (0.49F * addMulti) + MathHelper.sin(this.tailSwing * 0.09F + 0.6F) * (0.19F * addMulti), MathHelper.cos(this.tailSwing * 0.0952F) * (0.19F * addMulti), 0F);
            setRotation(Tail7, -0.3F + MathHelper.cos(this.tailSwing * 0.09F + 0.6F) * (0.19F * addMulti) + MathHelper.sin(this.tailSwing * 0.09F + 0.6F) * (0.19F * addMulti), MathHelper.cos(this.tailSwing * 0.0934F) * (0.19F * addMulti), 0F);
        }
    }

}