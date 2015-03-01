package com.dragonballzmod.model.parts;

import com.dragonballzmod.player.ModelDBZBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelBattleArmorLegs1 extends ModelDBZBiped
{
  //fields
    ModelRenderer rightLegClothTop;
    ModelRenderer rightLegClothBottom;
    ModelRenderer leftLegClothTop;
    ModelRenderer leftLegClothBottom;
    ModelRenderer bodyPlateBottom;
    ModelRenderer legPlateMidIn;
    ModelRenderer legPlateMidSide1;
    ModelRenderer legPlateMidSideB;
    ModelRenderer legPlateMidSide2;
    ModelRenderer legPlateLeftIn;
    ModelRenderer legPlateLeftSide1;
    ModelRenderer legPlateLeftSide2;
    ModelRenderer legPlateLeftSideB;
    ModelRenderer LegPlateRightIn;
    ModelRenderer LegPlateRightSide1;
    ModelRenderer LegPlateRightSide2;
    ModelRenderer LegPlateRightSideB;
  
  public modelBattleArmorLegs1()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      rightLegClothTop = new ModelRenderer(this, 103, 0);
      rightLegClothTop.addBox(-2F, 0F, -2F, 4, 6, 4);
      rightLegClothTop.setRotationPoint(-2F, 12F, 0F);
      rightLegClothTop.setTextureSize(128, 64);
      rightLegClothTop.mirror = true;
      setRotation(rightLegClothTop, 0F, 0F, 0F);
      rightLegClothBottom = new ModelRenderer(this, 103, 0);
      rightLegClothBottom.addBox(-2F, 0F, -2F, 4, 3, 4);
      rightLegClothBottom.setRotationPoint(-2F, 18F, 0F);
      rightLegClothBottom.setTextureSize(128, 64);
      rightLegClothBottom.mirror = true;
      setRotation(rightLegClothBottom, 0F, 0F, 0F);
      leftLegClothTop = new ModelRenderer(this, 103, 0);
      leftLegClothTop.addBox(-2F, 0F, -2F, 4, 6, 4);
      leftLegClothTop.setRotationPoint(2F, 12F, 0F);
      leftLegClothTop.setTextureSize(128, 64);
      leftLegClothTop.mirror = true;
      setRotation(leftLegClothTop, 0F, 0F, 0F);
      leftLegClothBottom = new ModelRenderer(this, 103, 0);
      leftLegClothBottom.addBox(-2F, 0F, -2F, 4, 3, 4);
      leftLegClothBottom.setRotationPoint(2F, 18F, 0F);
      leftLegClothBottom.setTextureSize(128, 64);
      leftLegClothBottom.mirror = true;
      setRotation(leftLegClothBottom, 0F, 0F, 0F);
      bodyPlateBottom = new ModelRenderer(this, 40, 57);
      bodyPlateBottom.addBox(-4.5F, 0F, -2.5F, 9, 1, 5);
      bodyPlateBottom.setRotationPoint(0F, 11F, 0F);
      bodyPlateBottom.setTextureSize(128, 64);
      bodyPlateBottom.mirror = true;
      setRotation(bodyPlateBottom, 0F, 0F, 0F);
      legPlateMidIn = new ModelRenderer(this, 0, 58);
      legPlateMidIn.addBox(-1.5F, 0F, -1F, 3, 5, 1);
      legPlateMidIn.setRotationPoint(0F, 12F, -2F);
      legPlateMidIn.setTextureSize(128, 64);
      legPlateMidIn.mirror = true;
      setRotation(legPlateMidIn, 0F, 0F, 0F);
      legPlateMidSide1 = new ModelRenderer(this, 40, 57);
      legPlateMidSide1.addBox(0F, -3F, 0F, 1, 5, 1);
      legPlateMidSide1.setRotationPoint(1.5F, 15F, -2.5F);
      legPlateMidSide1.setTextureSize(128, 64);
      legPlateMidSide1.mirror = true;
      setRotation(legPlateMidSide1, 0F, 0F, 0F);
      legPlateMidSideB = new ModelRenderer(this, 40, 57);
      legPlateMidSideB.addBox(-1.5F, 0F, 0F, 3, 1, 1);
      legPlateMidSideB.setRotationPoint(0F, 17F, -2.5F);
      legPlateMidSideB.setTextureSize(128, 64);
      legPlateMidSideB.mirror = true;
      setRotation(legPlateMidSideB, 0F, 0F, 0F);
      legPlateMidSide2 = new ModelRenderer(this, 40, 57);
      legPlateMidSide2.addBox(-1F, -2F, -1F, 1, 5, 1);
      legPlateMidSide2.setRotationPoint(-1.5F, 14F, -1.5F);
      legPlateMidSide2.setTextureSize(128, 64);
      legPlateMidSide2.mirror = true;
      setRotation(legPlateMidSide2, 0F, 0F, 0F);
      legPlateLeftIn = new ModelRenderer(this, 0, 55);
      legPlateLeftIn.addBox(0F, 0F, -2F, 1, 5, 4);
      legPlateLeftIn.setRotationPoint(4F, 12F, 0F);
      legPlateLeftIn.setTextureSize(128, 64);
      legPlateLeftIn.mirror = true;
      setRotation(legPlateLeftIn, 0F, 0F, 0F);
      legPlateLeftSide1 = new ModelRenderer(this, 40, 57);
      legPlateLeftSide1.addBox(-1F, -2F, -1F, 1, 5, 1);
      legPlateLeftSide1.setRotationPoint(4.5F, 14F, -2F);
      legPlateLeftSide1.setTextureSize(128, 64);
      legPlateLeftSide1.mirror = true;
      setRotation(legPlateLeftSide1, 0F, 0F, 0F);
      legPlateLeftSide2 = new ModelRenderer(this, 40, 57);
      legPlateLeftSide2.addBox(-1F, -2F, 0F, 1, 5, 1);
      legPlateLeftSide2.setRotationPoint(4.5F, 14F, 2F);
      legPlateLeftSide2.setTextureSize(128, 64);
      legPlateLeftSide2.mirror = true;
      setRotation(legPlateLeftSide2, 0F, 0F, 0F);
      legPlateLeftSideB = new ModelRenderer(this, 40, 57);
      legPlateLeftSideB.addBox(-1F, 0F, -2F, 1, 1, 4);
      legPlateLeftSideB.setRotationPoint(4.5F, 17F, 0F);
      legPlateLeftSideB.setTextureSize(128, 64);
      legPlateLeftSideB.mirror = true;
      setRotation(legPlateLeftSideB, 0F, 0F, 0F);
      LegPlateRightIn = new ModelRenderer(this, 0, 55);
      LegPlateRightIn.addBox(-1F, 0F, -2F, 1, 5, 4);
      LegPlateRightIn.setRotationPoint(-4F, 12F, 0F);
      LegPlateRightIn.setTextureSize(128, 64);
      LegPlateRightIn.mirror = true;
      setRotation(LegPlateRightIn, 0F, 0F, 0F);
      LegPlateRightSide1 = new ModelRenderer(this, 40, 57);
      LegPlateRightSide1.addBox(0F, -2F, -1F, 1, 5, 1);
      LegPlateRightSide1.setRotationPoint(-4.5F, 14F, -2F);
      LegPlateRightSide1.setTextureSize(128, 64);
      LegPlateRightSide1.mirror = true;
      setRotation(LegPlateRightSide1, 0F, 0F, 0F);
      LegPlateRightSide2 = new ModelRenderer(this, 40, 57);
      LegPlateRightSide2.addBox(0F, -2F, 0F, 1, 5, 1);
      LegPlateRightSide2.setRotationPoint(-4.5F, 14F, 2F);
      LegPlateRightSide2.setTextureSize(128, 64);
      LegPlateRightSide2.mirror = true;
      setRotation(LegPlateRightSide2, 0F, 0F, 0F);
      LegPlateRightSideB = new ModelRenderer(this, 40, 57);
      LegPlateRightSideB.addBox(0F, 0F, -2F, 1, 1, 4);
      LegPlateRightSideB.setRotationPoint(-4.5F, 17F, 0F);
      LegPlateRightSideB.setTextureSize(128, 64);
      LegPlateRightSideB.mirror = true;
      setRotation(LegPlateRightSideB, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    rightLegClothTop.render(f5);
    rightLegClothBottom.render(f5);
    leftLegClothTop.render(f5);
    leftLegClothBottom.render(f5);
    bodyPlateBottom.render(f5);
    legPlateMidIn.render(f5);
    legPlateMidSide1.render(f5);
    legPlateMidSideB.render(f5);
    legPlateMidSide2.render(f5);
    legPlateLeftIn.render(f5);
    legPlateLeftSide1.render(f5);
    legPlateLeftSide2.render(f5);
    legPlateLeftSideB.render(f5);
    LegPlateRightIn.render(f5);
    LegPlateRightSide1.render(f5);
    LegPlateRightSide2.render(f5);
    LegPlateRightSideB.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
