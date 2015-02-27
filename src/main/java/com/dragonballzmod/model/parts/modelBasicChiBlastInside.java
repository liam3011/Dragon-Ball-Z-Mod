package com.dragonballzmod.model.parts;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class modelBasicChiBlastInside extends ModelBase
    {
        //fields
        ModelRenderer mid;
        ModelRenderer left;
        ModelRenderer right;
        ModelRenderer top;
        ModelRenderer bottom;
        ModelRenderer front;
        ModelRenderer back;

        public modelBasicChiBlastInside()
        {
            textureWidth = 64;
            textureHeight = 32;

            mid = new ModelRenderer(this, 0, 0);
            mid.addBox(-3F, -3F, -3F, 6, 6, 6);
            mid.setRotationPoint(0F, 0F, 0F);
            mid.setTextureSize(64, 32);
            mid.mirror = true;
            setRotation(mid, 0F, 0F, 0F);
            left = new ModelRenderer(this, 0, 0);
            left.addBox(0F, -2F, -2F, 1, 4, 4);
            left.setRotationPoint(3F, 0F, 0F);
            left.setTextureSize(64, 32);
            left.mirror = true;
            setRotation(left, 0F, 0F, 0F);
            right = new ModelRenderer(this, 0, 0);
            right.addBox(-1F, -2F, -2F, 1, 4, 4);
            right.setRotationPoint(-3F, 0F, 0F);
            right.setTextureSize(64, 32);
            right.mirror = true;
            setRotation(right, 0F, 0F, 0F);
            top = new ModelRenderer(this, 0, 0);
            top.addBox(-2F, -1F, -2F, 4, 1, 4);
            top.setRotationPoint(0F, -3F, 0F);
            top.setTextureSize(64, 32);
            top.mirror = true;
            setRotation(top, 0F, 0F, 0F);
            bottom = new ModelRenderer(this, 0, 0);
            bottom.addBox(-2F, 0F, -2F, 4, 1, 4);
            bottom.setRotationPoint(0F, 3F, 0F);
            bottom.setTextureSize(64, 32);
            bottom.mirror = true;
            setRotation(bottom, 0F, 0F, 0F);
            front = new ModelRenderer(this, 0, 0);
            front.addBox(-2F, -2F, -1F, 4, 4, 1);
            front.setRotationPoint(0F, 0F, -3F);
            front.setTextureSize(64, 32);
            front.mirror = true;
            setRotation(front, 0F, 0F, 0F);
            back = new ModelRenderer(this, 0, 0);
            back.addBox(-2F, -2F, 0F, 4, 4, 1);
            back.setRotationPoint(0F, 0F, 3F);
            back.setTextureSize(64, 32);
            back.mirror = true;
            setRotation(back, 0F, 0F, 0F);
        }

        public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
            super.render(entity, f, f1, f2, f3, f4, f5);
            setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            mid.render(f5);
            left.render(f5);
            right.render(f5);
            top.render(f5);
            bottom.render(f5);
            front.render(f5);
            back.render(f5);
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
