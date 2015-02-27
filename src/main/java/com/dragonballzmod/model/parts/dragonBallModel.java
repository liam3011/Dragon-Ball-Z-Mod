package com.dragonballzmod.model.parts;

import com.dragonballzmod.animation.modelparts.ModelTextureDisplay;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class dragonBallModel extends ModelBase {
    //fields
    ModelRenderer main;
    ModelRenderer sideRight;
    ModelRenderer sideLeft;
    ModelRenderer top;
    ModelRenderer bottum;
    ModelRenderer back;
    ModelRenderer front;

    ModelRenderer star;



    public dragonBallModel() {
        textureWidth = 64;
        textureHeight = 32;

        main = new ModelRenderer(this, 0, 0);
        main.addBox(-3F, -3F, -3F, 6, 6, 6);
        main.setRotationPoint(0F, 20F, 0F);
        main.setTextureSize(64, 32);
        main.mirror = true;
        setRotation(main, 0F, 0F, 0F);
        sideRight = new ModelRenderer(this, 0, 0);
        sideRight.addBox(-4F, -2F, -2F, 1, 4, 4);
        sideRight.setRotationPoint(0F, 20F, 0F);
        sideRight.setTextureSize(64, 32);
        sideRight.mirror = true;
        setRotation(sideRight, 0F, 0F, 0F);
        sideLeft = new ModelRenderer(this, 0, 0);
        sideLeft.addBox(3F, -2F, -2F, 1, 4, 4);
        sideLeft.setRotationPoint(0F, 20F, 0F);
        sideLeft.setTextureSize(64, 32);
        sideLeft.mirror = true;
        setRotation(sideRight, 0F, 0F, 0F);
        top = new ModelRenderer(this, 0, 0);
        top.addBox(-2F, -4F, -2F, 4, 1, 4);
        top.setRotationPoint(0F, 20F, 0F);
        top.setTextureSize(64, 32);
        top.mirror = true;
        setRotation(top, 0F, 0F, 0F);
        bottum = new ModelRenderer(this, 0, 0);
        bottum.addBox(-2F, 3F, -2F, 4, 1, 4);
        bottum.setRotationPoint(0F, 20F, 0F);
        bottum.setTextureSize(64, 32);
        bottum.mirror = true;
        setRotation(bottum, 0F, 0F, 0F);
        back = new ModelRenderer(this, 0, 0);
        back.addBox(-2F, -2F, 3F, 4, 4, 1);
        back.setRotationPoint(0F, 20F, 0F);
        back.setTextureSize(64, 32);
        back.mirror = true;
        setRotation(back, 0F, 0F, 0F);
        front = new ModelRenderer(this, 0, 0);
        front.addBox(-2F, -2F, -4F, 4, 4, 1);
        front.setRotationPoint(0F, 20F, 0F);
        front.setTextureSize(64, 32);
        front.mirror = true;
        setRotation(front, 0F, 0F, 0F);

        star = new ModelRenderer(this,0,0);
        /*lowerLeftLegBox = new ModelRetexturedBoxSharpBend(this.bipedLeftLegLower, 0, 22, -2F, 0F, -2F, 4, 6, 4, p_i1149_1_, 4, 26, 8, 16);
        this.bipedLeftLegLower.cubeList.add(lowerLeftLegBox);*/
        ModelTextureDisplay starCube = new ModelTextureDisplay(this.star, 0, 0, -3F, -3F, 0F, 6, 6, 0, 0);
        star.cubeList.add(starCube);
        star.setRotationPoint(0,0F,0);
        star.setTextureSize(197,169);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        main.render(f5);
        sideRight.render(f5);
        sideLeft.render(f5);
        top.render(f5);
        bottum.render(f5);
        back.render(f5);
        front.render(f5);
    }

    public void render() {
        main.render(0.0625F);
        sideRight.render(0.0625F);
        sideLeft.render(0.0625F);
        top.render(0.0625F);
        bottum.render(0.0625F);
        back.render(0.0625F);
        front.render(0.0625F);
    }

    public void renderStar() {
        star.render(0.0625F);
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
