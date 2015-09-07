
package com.dragonballzmod.model.parts;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class thinTreeModel extends ModelBase
{
    //fields
    ModelRenderer modelThinTreePart;

    public thinTreeModel()
    {
        textureWidth = 64;
        textureHeight = 32;

        modelThinTreePart = new ModelRenderer(this, 0, 0);
        modelThinTreePart.addBox(-2F, -16F, -2F, 4, 16, 4);
        modelThinTreePart.setRotationPoint(0F, 24F, 0F);
        modelThinTreePart.setTextureSize(64, 32);
        modelThinTreePart.mirror = true;
        setRotation(modelThinTreePart, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        modelThinTreePart.render(f5);
    }

    public void render()
    {
        modelThinTreePart.render(0.0625F);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}

