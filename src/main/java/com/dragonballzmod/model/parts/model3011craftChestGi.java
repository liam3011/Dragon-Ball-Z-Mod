package com.dragonballzmod.model.parts;

import com.dragonballzmod.player.ModelDBZBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class model3011craftChestGi extends ModelDBZBiped
{
    //fields
    ModelRenderer bodyUpper;
    ModelRenderer bodyLower;
    ModelRenderer frontGiPart;
    ModelRenderer backGiPart;
    ModelRenderer rightArmUpper;
    ModelRenderer rightArmLower;
    ModelRenderer leftArmUpper;
    ModelRenderer leftArmLower;
    ModelRenderer mainBelt;
    ModelRenderer beltBuck;
    ModelRenderer beltRight;
    ModelRenderer beltLeft;

    ModelRenderer bodyLockUpper;
    ModelRenderer bodyLockLower;
    ModelRenderer armLockUpperRight;
    ModelRenderer armLockLowerRight;
    ModelRenderer armLockUpperLeft;
    ModelRenderer armLockLowerLeft;

    public model3011craftChestGi()
    {
        textureWidth = 64;
        textureHeight = 32;

        bodyUpper = new ModelRenderer(this, 0, 0);
        bodyUpper.addBox(-4F, 0F, -2F, 8, 6, 4);
        bodyUpper.setRotationPoint(0F, 0F, 0F);
        bodyUpper.setTextureSize(64, 32);
        bodyUpper.mirror = true;
        setRotation(bodyUpper, 0F, 0F, 0F);
        bodyLower = new ModelRenderer(this, 0, 10);
        bodyLower.addBox(-4F, 0F, -2F, 8, 6, 4);
        bodyLower.setRotationPoint(0F, 6F, 0F);
        bodyLower.setTextureSize(64, 32);
        bodyLower.mirror = true;
        setRotation(bodyLower, 0F, 0F, 0F);
        frontGiPart = new ModelRenderer(this, 24, 20);
        frontGiPart.addBox(-4F, 0F, 0F, 8, 6, 0);
        frontGiPart.setRotationPoint(0F, 10F, -2F);
        frontGiPart.setTextureSize(64, 32);
        frontGiPart.mirror = true;
        setRotation(frontGiPart, -0.0349066F, 0F, 0F);
        backGiPart = new ModelRenderer(this, 24, 20);
        backGiPart.addBox(-4F, 0F, 0F, 8, 6, 0);
        backGiPart.setRotationPoint(0F, 10F, 2F);
        backGiPart.setTextureSize(64, 32);
        backGiPart.mirror = true;
        setRotation(backGiPart, 0.0349066F, 0F, 0F);
        rightArmUpper = new ModelRenderer(this, 24, 0);
        rightArmUpper.addBox(-3F, -2F, -2F, 4, 6, 4);
        rightArmUpper.setRotationPoint(-5F, 2F, 0F);
        rightArmUpper.setTextureSize(64, 32);
        rightArmUpper.mirror = true;
        setRotation(rightArmUpper, 0F, 0F, 0F);
        rightArmLower = new ModelRenderer(this, 24, 10);
        rightArmLower.addBox(-2F, 0F, -2F, 4, 6, 4);
        rightArmLower.setRotationPoint(-6F, 6F, 0F);
        rightArmLower.setTextureSize(64, 32);
        rightArmLower.mirror = true;
        setRotation(rightArmLower, 0F, 0F, 0F);
        leftArmUpper = new ModelRenderer(this, 24, 0);
        leftArmUpper.addBox(0F, -2F, -2F, 4, 6, 4);
        leftArmUpper.setRotationPoint(4F, 2F, 0F);
        leftArmUpper.setTextureSize(64, 32);
        leftArmUpper.mirror = true;
        setRotation(leftArmUpper, 0F, 0F, 0F);
        leftArmLower = new ModelRenderer(this, 24, 10);
        leftArmLower.addBox(-2F, 0F, -2F, 4, 6, 4);
        leftArmLower.setRotationPoint(6F, 6F, 0F);
        leftArmLower.setTextureSize(64, 32);
        leftArmLower.mirror = true;
        setRotation(leftArmLower, 0F, 0F, 0F);
        mainBelt = new ModelRenderer(this, 0, 20);
        mainBelt.addBox(-4F, -1F, -2F, 8, 2, 4);
        mainBelt.setRotationPoint(0F, 9F, 0F);
        mainBelt.setTextureSize(64, 32);
        mainBelt.mirror = true;
        setRotation(mainBelt, 0F, 0F, 0F);
        beltBuck = new ModelRenderer(this, 0, 23);
        beltBuck.addBox(-1F, -1F, -1.4F, 2, 2, 1);
        beltBuck.setRotationPoint(0F, 9F, -1F);
        beltBuck.setTextureSize(64, 32);
        beltBuck.mirror = true;
        setRotation(beltBuck, 0F, 0F, 0F);
        beltRight = new ModelRenderer(this, 0, 20);
        beltRight.addBox(-0.5F, 0F, 0F, 1, 7, 0);
        beltRight.setRotationPoint(-0.4666667F, 10F, -2F);
        beltRight.setTextureSize(64, 32);
        beltRight.mirror = true;
        setRotation(beltRight, -0.0523599F, 0F, 0.0523599F);
        beltLeft = new ModelRenderer(this, 2, 20);
        beltLeft.addBox(-0.5F, 0F, 0F, 1, 7, 0);
        beltLeft.setRotationPoint(0.5F, 10F, -2F);
        beltLeft.setTextureSize(64, 32);
        beltLeft.mirror = true;
        setRotation(beltLeft, -0.0523599F, 0F, -0.0523599F);

        bodyLockUpper = new ModelRenderer(this);
        bodyLockUpper.addBox(0, 0, 0, 0, 0, 0);
        bodyLockUpper.setRotationPoint(0, 0, 0);

        bodyLockLower = new ModelRenderer(this);
        bodyLockLower.addBox(0, 0, 0, 0, 0, 0);
        bodyLockLower.setRotationPoint(0, 0, 0);

        bodyLockUpper.addChild(bodyUpper);

        bodyLockLower.addChild(bodyLower);
        bodyLockLower.addChild(frontGiPart);
        bodyLockLower.addChild(backGiPart);
        bodyLockLower.addChild(mainBelt);
        bodyLockLower.addChild(beltBuck);
        bodyLockLower.addChild(beltRight);
        bodyLockLower.addChild(beltLeft);


    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {

        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        renderWithLock(bipedBody, bodyLockUpper, f5);
        renderWithLock(bipedLowerBody, bodyLockLower, f5);


    }

    private void renderWithLock(ModelRenderer bipedBody, ModelRenderer lockblock, float f5) {

        setRotation(lockblock, bipedBody.rotateAngleX, bipedBody.rotateAngleY, bipedBody.rotateAngleZ);

        lockblock.setRotationPoint(bipedBody.rotationPointX, bipedBody.rotationPointY, bipedBody.rotationPointZ);

        lockblock.render(f5);
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
