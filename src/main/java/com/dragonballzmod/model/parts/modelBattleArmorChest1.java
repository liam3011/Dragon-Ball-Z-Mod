package com.dragonballzmod.model.parts;

import com.dragonballzmod.player.ModelDBZBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelBattleArmorChest1 extends ModelDBZBiped
{
    //fields
    //ModelRenderer bodyClothTop;
    public ModelRenderer bodyClothBottom;
    public ModelRenderer rightArmClothTop;
    public ModelRenderer rightArmClothBottom;
    public ModelRenderer leftArmClothTop;
    public ModelRenderer leftArmClothBottom;
    public ModelRenderer amorChest;
    public ModelRenderer armorChestMiddle;
    public ModelRenderer armorChestLower;
    public ModelRenderer armorChestUpper;
    public ModelRenderer pack1;
    public ModelRenderer pack2;
    public ModelRenderer frontBodyUpper;
    public ModelRenderer backmiddle;
    public ModelRenderer frontBodyLower;
    public ModelRenderer backBodyUpper;
    public ModelRenderer backBodyLower;
    public ModelRenderer armPlateROL1;
    public ModelRenderer armPlateROL2;
    public ModelRenderer armPlateROL3;
    public ModelRenderer armPlateRP1;
    public ModelRenderer armPlateRP2;
    public ModelRenderer armPlateRP3;
    public ModelRenderer armPlateRP4;
    public ModelRenderer armPlateRP5;
    public ModelRenderer gloveRight;
    public ModelRenderer armPlateLOL1;
    public ModelRenderer armPlateLOL2;
    public ModelRenderer armPlateLOL3;
    public ModelRenderer armPlateLP1;
    public ModelRenderer armPlateLP2;
    public ModelRenderer armPlateLP3;
    public ModelRenderer armPlateLP4;
    public ModelRenderer armPlateLP5;
    public ModelRenderer gloveLeft;
    public ModelRenderer bodyClothTop;


    public ModelRenderer bodyLockUpper;
    public ModelRenderer bodyLockLower;
    public ModelRenderer bodyLockLeftArm;
    public ModelRenderer armLockRightUpper;
    public ModelRenderer armLockRightLower;
    public ModelRenderer armLockLeftUpper;
    public ModelRenderer armLockLeftLower;

    public modelBattleArmorChest1()
    {
        textureWidth = 128;
        textureHeight = 64;

        bodyClothTop = new ModelRenderer(this, 103, 0);
        bodyClothTop.addBox(-4F, -5.5F, -2F, 8, 6, 4);
        bodyClothTop.setRotationPoint(0F, 6F, 0F);
        bodyClothTop.setTextureSize(128, 64);
        bodyClothTop.mirror = true;
        setRotation(bodyClothTop, 0F, 0F, 0F);


        /**  bodyClothBottom = new ModelRenderer(this, 103, 0);
         bodyClothBottom.addBox(-4F, 0F, -2F, 8, 6, 4);
         bodyClothBottom.setRotationPoint(0F, 6F, 0F);
         bodyClothBottom.setTextureSize(128, 64);
         bodyClothBottom.mirror = true;
         setRotation(bodyClothBottom, 0F, 0F, 0F); **/

        bodyClothBottom = new ModelRenderer(this, 103, 0);
        bodyClothBottom.addBox(-4F, -6F, -2F, 8, 6, 4);
        bodyClothBottom.setRotationPoint(0F, 6F, 0F);
        bodyClothBottom.setTextureSize(128, 64);
        bodyClothBottom.mirror = true;
        setRotation(bodyClothBottom, 0F, 0F, 0F);

        rightArmClothTop = new ModelRenderer(this, 103, 0);
        rightArmClothTop.addBox(1F, -2F, -2F, 4, 6, 4, 0.01F);
        rightArmClothTop.setRotationPoint(-4F, 2F, 0F);
        rightArmClothTop.setTextureSize(128, 64);
        rightArmClothTop.mirror = true;
        setRotation(rightArmClothTop, 0F, 0F, 0F);
        rightArmClothBottom = new ModelRenderer(this, 103, 0);
        rightArmClothBottom.addBox(3F, 0F, -2F, 4, 2, 4, 0.01F);
        rightArmClothBottom.setRotationPoint(-6F, 6F, 0F);
        rightArmClothBottom.setTextureSize(128, 64);
        rightArmClothBottom.mirror = true;
        setRotation(rightArmClothBottom, 0F, 0F, 0F);
        leftArmClothTop = new ModelRenderer(this, 103, 0);
        leftArmClothTop.addBox(0F, -2F, -2F, 4, 6, 4);
        leftArmClothTop.setRotationPoint(4F, 2F, 0F);
        leftArmClothTop.setTextureSize(128, 64);
        leftArmClothTop.mirror = true;
        setRotation(leftArmClothTop, 0F, 0F, 0F);
        leftArmClothBottom = new ModelRenderer(this, 103, 0);
        leftArmClothBottom.addBox(-2F, 0F, -2F, 4, 2, 4);
        leftArmClothBottom.setRotationPoint(6F, 6F, 0F);
        leftArmClothBottom.setTextureSize(128, 64);
        leftArmClothBottom.mirror = true;
        setRotation(leftArmClothBottom, 0F, 0F, 0F);
        amorChest = new ModelRenderer(this, 103, 58);
        amorChest.addBox(-4F, -1.5F, -2.7F, 8, 4, 1);
        amorChest.setRotationPoint(0F, 2F, 0F);
        amorChest.setTextureSize(128, 64);
        amorChest.mirror = true;
        setRotation(amorChest, 0F, 0F, 0F);
        armorChestMiddle = new ModelRenderer(this, 40, 57);
        armorChestMiddle.addBox(-0.5F, -2F, -3F, 1, 3, 1);
        armorChestMiddle.setRotationPoint(0F, 3F, 0F);
        armorChestMiddle.setTextureSize(128, 64);
        armorChestMiddle.mirror = true;
        setRotation(armorChestMiddle, 0F, 0F, 0F);
        armorChestLower = new ModelRenderer(this, 40, 57);
        armorChestLower.addBox(-4F, 0F, -3F, 8, 1, 6);
        armorChestLower.setRotationPoint(0F, 4F, 0F);
        armorChestLower.setTextureSize(128, 64);
        armorChestLower.mirror = true;
        setRotation(armorChestLower, 0F, 0F, 0F);
        armorChestUpper = new ModelRenderer(this, 40, 57);
        armorChestUpper.addBox(-4F, -2F, -3F, 8, 1, 6);
        armorChestUpper.setRotationPoint(0F, 2F, 0F);
        armorChestUpper.setTextureSize(128, 64);
        armorChestUpper.mirror = true;
        setRotation(armorChestUpper, 0F, 0F, 0F);
        pack1 = new ModelRenderer(this, 0, 58);
        pack1.addBox(-3F, 0F, -2.5F, 6, 1, 1);
        pack1.setRotationPoint(0F, 5F, 0F);
        pack1.setTextureSize(128, 64);
        pack1.mirror = true;
        setRotation(pack1, 0F, 0F, 0F);

        /** pack2 = new ModelRenderer(this, 0, 59);
         pack2.addBox(-2F, -2F, -2.5F, 4, 4, 1);
         pack2.setRotationPoint(0F, 8F, 0F);
         pack2.setTextureSize(128, 64);
         pack2.mirror = true;
         setRotation(pack2, 0F, 0F, 0F);
         **/

        pack2 = new ModelRenderer(this, 0, 59);
        pack2.addBox(-2F, -8F, -2.5F, 4, 4, 1);
        pack2.setRotationPoint(0F, 8F, 0F);
        pack2.setTextureSize(128, 64);
        pack2.mirror = true;
        setRotation(pack2, 0F, 0F, 0F);

        frontBodyUpper = new ModelRenderer(this, 103, 57);
        frontBodyUpper.addBox(-4F, 0F, -2.2F, 8, 1, 1);
        frontBodyUpper.setRotationPoint(0F, 5F, 0F);
        frontBodyUpper.setTextureSize(128, 64);
        frontBodyUpper.mirror = true;
        setRotation(frontBodyUpper, 0F, 0F, 0F);
        backmiddle = new ModelRenderer(this, 40, 57);
        backmiddle.addBox(-0.5F, -2F, 2F, 1, 3, 1);
        backmiddle.setRotationPoint(0F, 3F, 0F);
        backmiddle.setTextureSize(128, 64);
        backmiddle.mirror = true;
        setRotation(backmiddle, 0F, 0F, 0F);

        /** frontBodyLower = new ModelRenderer(this, 103, 57);
         frontBodyLower.addBox(-4F, -3F, -2.2F, 8, 6, 1);
         frontBodyLower.setRotationPoint(0F, 9F, 0F);
         frontBodyLower.setTextureSize(128, 64);
         frontBodyLower.mirror = true;
         setRotation(frontBodyLower, 0F, 0F, 0F); **/

        frontBodyLower = new ModelRenderer(this, 103, 57); //Textures
        frontBodyLower.addBox(-4F, -9F, -2.2F, 8, 6, 1);
        frontBodyLower.setRotationPoint(0F, 9F, 0F);
        frontBodyLower.setTextureSize(128, 64);
        frontBodyLower.mirror = true;
        setRotation(frontBodyLower, 0F, 0F, 0F);
        backBodyUpper = new ModelRenderer(this, 103, 57);
        backBodyUpper.addBox(-4F, -3F, 1.2F, 8, 5, 1);
        backBodyUpper.setRotationPoint(0F, 4F, 0F);
        backBodyUpper.setTextureSize(128, 64);
        backBodyUpper.mirror = true;
        setRotation(backBodyUpper, 0F, 0F, 0F);

        /**backBodyLower = new ModelRenderer(this, 103, 57);
         backBodyLower = new ModelRenderer(this);
         backBodyLower.addBox(-4F, -3F, 1.2F, 8, 6, 1);
         backBodyLower.setRotationPoint(0F, 9F, 0F);
         backBodyLower.setTextureSize(128, 64);
         backBodyLower.mirror = true;
         setRotation(backBodyLower, 0F, 0F, 0F); **/

        backBodyLower = new ModelRenderer(this, 103, 57);
        backBodyLower.addBox(-4F, -9F, 1.2F, 8, 6, 1);
        backBodyLower.setRotationPoint(0F, 9F, 0F);
        backBodyLower.setTextureSize(128, 64);
        backBodyLower.mirror = true;
        setRotation(backBodyLower, 0F, 0F, 0F);

        armPlateROL1 = new ModelRenderer(this, 40, 57);
        armPlateROL1.addBox(5F, -1F, -3F, 2, 1, 6);
        armPlateROL1.setRotationPoint(-6F, 2F, 0F);
        armPlateROL1.setTextureSize(128, 64);
        armPlateROL1.mirror = true;
        setRotation(armPlateROL1, 0F, 0F, 0F);
        armPlateROL2 = new ModelRenderer(this, 40, 57);
        armPlateROL2.addBox(-1F, -2F, -3F, 6, 1, 1);
        armPlateROL2.setRotationPoint(-6F, 2F, 0F);
        armPlateROL2.setTextureSize(128, 64);
        armPlateROL2.mirror = true;
        setRotation(armPlateROL2, 0F, 0F, 0F);
        armPlateROL3 = new ModelRenderer(this, 40, 57);
        armPlateROL3.addBox(-1F, -2F, 2F, 6, 1, 1);
        armPlateROL3.setRotationPoint(-6F, 2F, 0F);
        armPlateROL3.setTextureSize(128, 64);
        armPlateROL3.mirror = true;
        setRotation(armPlateROL3, 0F, 0F, 0F);
        armPlateRP1 = new ModelRenderer(this, 110, 30);
        armPlateRP1.addBox(5F, -2F, -2.5F, 2, 1, 5);
        armPlateRP1.setRotationPoint(-6F, 2F, 0F);
        armPlateRP1.setTextureSize(128, 64);
        armPlateRP1.mirror = true;
        setRotation(armPlateRP1, 0F, 0F, 0F);
        armPlateRP2 = new ModelRenderer(this, 104, 30);
        armPlateRP2.addBox(0F, -4F, -2.5F, 7, 2, 5);
        armPlateRP2.setRotationPoint(-6F, 2F, 0F);
        armPlateRP2.setTextureSize(128, 64);
        armPlateRP2.mirror = true;
        setRotation(armPlateRP2, 0F, 0F, 0F);
        armPlateRP3 = new ModelRenderer(this, 110, 30);
        armPlateRP3.addBox(-1F, -3F, -2.5F, 1, 1, 5);
        armPlateRP3.setRotationPoint(-6F, 2F, 0F);
        armPlateRP3.setTextureSize(128, 64);
        armPlateRP3.mirror = true;
        setRotation(armPlateRP3, 0F, 0F, 0F);
        armPlateRP4 = new ModelRenderer(this, 110, 30);
        armPlateRP4.addBox(2F, -5F, -2F, 5, 1, 4);
        armPlateRP4.setRotationPoint(-6F, 2F, 0F);
        armPlateRP4.setTextureSize(128, 64);
        armPlateRP4.mirror = true;
        setRotation(armPlateRP4, 0F, 0F, 0F);
        armPlateRP5 = new ModelRenderer(this, 40, 57);
        armPlateRP5.addBox(-2F, -2F, -2F, 1, 1, 4);
        armPlateRP5.setRotationPoint(-6F, 2F, 0F);
        armPlateRP5.setTextureSize(128, 64);
        armPlateRP5.mirror = true;
        setRotation(armPlateRP5, 0F, 0F, 0F);


        /**gloveRight = new ModelRenderer(this, 40, 56);
         gloveRight.addBox(-2F, -2F, -2F, 4, 4, 4);
         gloveRight.setRotationPoint(-6F, 10F, 0F);
         gloveRight.setTextureSize(128, 64);
         gloveRight.mirror = true;
         setRotation(gloveRight, 0F, 0F, 0F); **/

        gloveRight = new ModelRenderer(this, 40, 56);
        gloveRight.addBox(3F, -4F, -2F, 4, 4, 4, 0.02F);
        gloveRight.setRotationPoint(-6F, 10F, 0F);
        gloveRight.setTextureSize(128, 64);
        gloveRight.mirror = true;
        setRotation(gloveRight, 0F, 0F, 0F);


        armPlateLOL1 = new ModelRenderer(this, 40, 57);
        armPlateLOL1.addBox(-2F, 1F, -3F, 2, 1, 6);
        armPlateLOL1.setRotationPoint(6F, 2F, 0F);
        armPlateLOL1.setTextureSize(128, 64);
        armPlateLOL1.mirror = true;
        setRotation(armPlateLOL1, 0F, 0F, 0F);
        armPlateLOL2 = new ModelRenderer(this, 40, 57);
        armPlateLOL2.addBox(0F, 0F, -3F, 6, 1, 1);
        armPlateLOL2.setRotationPoint(6F, 2F, 0F);
        armPlateLOL2.setTextureSize(128, 64);
        armPlateLOL2.mirror = true;
        setRotation(armPlateLOL2, 0F, 0F, 0F);
        armPlateLOL3 = new ModelRenderer(this, 40, 57);
        armPlateLOL3.addBox(0F, 0F, 2F, 6, 1, 1);
        armPlateLOL3.setRotationPoint(6F, 2F, 0F);
        armPlateLOL3.setTextureSize(128, 64);
        armPlateLOL3.mirror = true;
        setRotation(armPlateLOL3, 0F, 0F, 0F);
        armPlateLP1 = new ModelRenderer(this, 110, 30);
        armPlateLP1.addBox(-2F, 0F, -2.5F, 2, 1, 5);
        armPlateLP1.setRotationPoint(6F, 2F, 0F);
        armPlateLP1.setTextureSize(128, 64);
        armPlateLP1.mirror = true;
        setRotation(armPlateLP1, 0F, 0F, 0F);
        armPlateLP2 = new ModelRenderer(this, 104, 30);
        armPlateLP2.addBox(-2F, -2F, -2.5F, 7, 2, 5);
        armPlateLP2.setRotationPoint(6F, 2F, 0F);
        armPlateLP2.setTextureSize(128, 64);
        armPlateLP2.mirror = true;
        setRotation(armPlateLP2, 0F, 0F, 0F);
        armPlateLP3 = new ModelRenderer(this, 110, 31);
        armPlateLP3.addBox(5F, -1F, -2F, 1, 1, 4);
        armPlateLP3.setRotationPoint(6F, 2F, 0F);
        armPlateLP3.setTextureSize(128, 64);
        armPlateLP3.mirror = true;
        setRotation(armPlateLP3, 0F, 0F, 0F);
        armPlateLP4 = new ModelRenderer(this, 110, 30);
        armPlateLP4.addBox(-2F, -3F, -2F, 5, 1, 4);
        armPlateLP4.setRotationPoint(6F, 2F, 0F);
        armPlateLP4.setTextureSize(128, 64);
        armPlateLP4.mirror = true;
        setRotation(armPlateLP4, 0F, 0F, 0F);
        armPlateLP5 = new ModelRenderer(this, 40, 57);
        armPlateLP5.addBox(6F, 0F, -2F, 1, 1, 4);
        armPlateLP5.setRotationPoint(6F, 2F, 0F);
        armPlateLP5.setTextureSize(128, 64);
        armPlateLP5.mirror = true;
        setRotation(armPlateLP5, 0F, 0F, 0F);
        gloveLeft = new ModelRenderer(this, 40, 56);
        gloveLeft.addBox(-2F, -2F, -2F, 4, 4, 4);
        gloveLeft.setRotationPoint(6F, 10F, 0F);
        gloveLeft.setTextureSize(128, 64);
        gloveLeft.mirror = true;
        setRotation(gloveLeft, 0F, 0F, 0F);
        bodyClothTop = new ModelRenderer(this, 103, 0);
        bodyClothTop.addBox(-4F, -5.5F, -2F, 8, 6, 4);
        bodyClothTop.setRotationPoint(0F, 6F, 0F);
        bodyClothTop.setTextureSize(128, 64);
        bodyClothTop.mirror = true;
        setRotation(bodyClothTop, 0F, 0F, 0F);

        bodyLockUpper = new ModelRenderer(this, 1, 1);
        bodyLockUpper.addBox(0F, 0F, 0F, 0, 0, 0);
        bodyLockUpper.setRotationPoint(0F, 0F, 0F);

        bodyLockLower = new ModelRenderer(this, 1, 1);
        bodyLockLower.addBox(0F, 0F, 0F, 0, 0, 0);
        bodyLockLower.setRotationPoint(0F, 0F, 0F);


        bodyLockLeftArm = new ModelRenderer(this, 1, 1);
        bodyLockLeftArm.addBox(0, 0, 0, 0, 0, 0);
        bodyLockLeftArm.setRotationPoint(0F, 0F, 0F);

        armLockRightUpper = new ModelRenderer(this, 1, 1);
        armLockRightUpper.addBox(0F, 0F, 0F, 0, 0, 0);
        armLockRightUpper.setRotationPoint(0F, 0F, 0F);

        armLockRightLower = new ModelRenderer(this, 1, 1);
        armLockRightLower.addBox(0F, 0F, 0F, 0, 0, 0);
        armLockRightLower.setRotationPoint(0F, 0F, 0F);

        armLockLeftUpper = new ModelRenderer(this, 1, 1);
        armLockLeftUpper.addBox(0F, 0F, 0F, 0, 0, 0);
        armLockLeftUpper.setRotationPoint(0F, 0F, 0F);

        armLockLeftLower = new ModelRenderer(this, 1, 1);
        armLockLeftLower.addBox(0F, 0F, 0F, 0, 0, 0);
        armLockLeftLower.setRotationPoint(0F, 0F, 0F);

        bodyLockUpper.addChild(bodyClothTop);
        bodyLockUpper.addChild(amorChest);
        bodyLockUpper.addChild(armorChestMiddle);
        bodyLockUpper.addChild(armorChestUpper);
        bodyLockUpper.addChild(pack1);
        bodyLockUpper.addChild(frontBodyUpper);
        bodyLockUpper.addChild(backmiddle);
        bodyLockUpper.addChild(backBodyUpper);
        bodyLockUpper.addChild(bodyClothTop);
        bodyLockUpper.addChild(armorChestLower);

        bodyLockLower.addChild(bodyClothBottom);
        bodyLockLower.addChild(pack2);
        bodyLockLower.addChild(frontBodyLower);
        bodyLockLower.addChild(backBodyLower);

        armLockLeftUpper.addChild(armPlateLOL1);
        armLockLeftUpper.addChild(armPlateLOL2);
        armLockLeftUpper.addChild(armPlateLOL3);
        armLockLeftUpper.addChild(armPlateLP1);
        armLockLeftUpper.addChild(armPlateLP2);
        armLockLeftUpper.addChild(armPlateLP3);
        armLockLeftUpper.addChild(armPlateLP4);
        armLockLeftUpper.addChild(armPlateLP5);
        armLockLeftUpper.addChild(leftArmClothTop);

        armLockLeftUpper.addChild(leftArmClothBottom);
        armLockLeftUpper.addChild(gloveLeft);

        armLockRightUpper.addChild(armPlateROL1);
        armLockRightUpper.addChild(armPlateROL2);
        armLockRightUpper.addChild(armPlateROL3);
        armLockRightUpper.addChild(armPlateRP1);
        armLockRightUpper.addChild(armPlateRP2);
        armLockRightUpper.addChild(armPlateRP3);
        armLockRightUpper.addChild(armPlateRP4);
        armLockRightUpper.addChild(armPlateRP5);
        armLockRightUpper.addChild(rightArmClothTop);

        armLockRightUpper.addChild(rightArmClothBottom);
        armLockRightUpper.addChild(gloveRight);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        renderWithLock(bipedBody, bodyLockUpper, f5);
        renderWithLock(bipedLowerBody, bodyLockLower, f5);

        renderWithLock(this.bipedLeftArmUpper, armLockLeftUpper, f5);
        renderWithLock(this.bipedLeftArmLower, armLockLeftLower, f5);

        renderWithLock(this.bipedRightArmUpper, armLockRightUpper, f5);
        renderWithLock(this.bipedRightArmLower, armLockRightLower, f5);
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
