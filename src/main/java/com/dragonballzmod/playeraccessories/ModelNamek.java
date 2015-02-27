package com.dragonballzmod.playeraccessories;


import com.dragonballzmod.player.ModelDBZBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNamek extends ModelDBZBiped {
    public ModelRenderer RightAntenna1;
    public ModelRenderer RightAntenna2;
    public ModelRenderer LeftAntenna1;
    public ModelRenderer LeftAntenna2;
    public ModelRenderer LeftEar;
    public ModelRenderer RightEar;

    public ModelRenderer bipedHeadTracker;

    public ModelNamek() {
        textureWidth = 32;
        textureHeight = 32;

        bipedHeadTracker = new ModelRenderer(this, 0, 0);

        RightAntenna1 = new ModelRenderer(this, 0, 4);
        RightAntenna1.mirror = true;
        RightAntenna1.addBox(0F, 0F, -2.2F, 1, 1, 3);
        RightAntenna1.setRotationPoint(-3F, -6.866667F, -3.666667F);
        RightAntenna1.setTextureSize(32, 32);
        setRotation(RightAntenna1, -0.2974289F, 0.4089647F, 0F);
        RightAntenna2 = new ModelRenderer(this, 5, 4);
        RightAntenna2.mirror = true;
        RightAntenna2.addBox(0.1333333F, 0.1333333F, -0.06666667F, 1, 1, 1);
        RightAntenna2.setRotationPoint(-4.15F, -6.2F, -6F);
        RightAntenna2.setTextureSize(32, 32);
        setRotation(RightAntenna2, 2.267895F, 0.4089647F, 0F);
        LeftAntenna1 = new ModelRenderer(this, 0, 4);
        LeftAntenna1.addBox(-1F, 0F, -2.2F, 1, 1, 3);
        LeftAntenna1.setRotationPoint(3F, -6.9F, -3.7F);
        LeftAntenna1.setTextureSize(32, 32);

        setRotation(LeftAntenna1, -0.2974216F, -0.4089656F, 0F);
        LeftAntenna2 = new ModelRenderer(this, 5, 4);
        LeftAntenna2.addBox(-0.1F, 0F, 0.3333333F, 1, 1, 1);
        LeftAntenna2.setRotationPoint(3F, -6F, -6F);
        LeftAntenna2.setTextureSize(32, 32);

        setRotation(LeftAntenna2, 2.267895F, -0.39733F, 0F);
        LeftEar = new ModelRenderer(this, 0, -3);
        LeftEar.addBox(0F, 0F, 0F, 0, 4, 3);
        LeftEar.setRotationPoint(4F, -2F, -1F);
        LeftEar.setTextureSize(32, 32);
        setRotation(LeftEar, 1.813593F, 0.7807508F, 0.1858931F);
        RightEar = new ModelRenderer(this, 0, -3);
        RightEar.addBox(0F, 0F, 0F, 0, 4, 3);
        RightEar.setRotationPoint(-4F, -2F, -1F);
        RightEar.setTextureSize(32, 32);
        RightEar.mirror = true;
        setRotation(RightEar, 1.813589F, -0.7807556F, -0.185895F);

        bipedHeadTracker.addChild(LeftAntenna1);
        bipedHeadTracker.addChild(LeftAntenna2);
        bipedHeadTracker.addChild(RightAntenna1);
        bipedHeadTracker.addChild(RightAntenna2);
        bipedHeadTracker.addChild(LeftEar);
        bipedHeadTracker.addChild(RightEar);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        bipedHeadTracker.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}