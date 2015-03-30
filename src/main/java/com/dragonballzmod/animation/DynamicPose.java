package com.dragonballzmod.animation;


import net.minecraft.entity.Entity;

public class DynamicPose extends Pose {

    public String poseName;

    public int animLength = 14;

    public String nextPose;

    public int completeAction = 0;

    public PartData[] partData;

    public DynamicPose(String poseName) {
        super(poseName);
    }

    public DynamicPose(String poseName, PartData... partData) {
        super(poseName, partData);
    }

    public void updatePose(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
    }
}
