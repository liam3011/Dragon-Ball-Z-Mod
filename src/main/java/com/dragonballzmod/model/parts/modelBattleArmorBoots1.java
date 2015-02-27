
package com.dragonballzmod.model.parts;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelBattleArmorBoots1 extends ModelBase
{
  //fields
    ModelRenderer rightBoot;
    ModelRenderer leftBoot;
  
  public modelBattleArmorBoots1()
  {
    textureWidth = 128;
    textureHeight = 64;

      rightBoot = new ModelRenderer(this, 40, 57);
      rightBoot.addBox(-2F, -1F, -2F, 4, 3, 4);
      rightBoot.setRotationPoint(-2F, 22F, 0F);
      rightBoot.setTextureSize(128, 64);
      rightBoot.mirror = true;
      setRotation(rightBoot, 0F, 0F, 0F);
      leftBoot = new ModelRenderer(this, 40, 57);
      leftBoot.addBox(-2F, -1F, -2F, 4, 3, 4);
      leftBoot.setRotationPoint(2F, 22F, 0F);
      leftBoot.setTextureSize(128, 64);
      leftBoot.mirror = true;
      setRotation(leftBoot, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    rightBoot.render(f5);
    leftBoot.render(f5);
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
