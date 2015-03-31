package com.dragonballzmod.animation;


public class Pose {

    public String poseName;

    public int animLength = 14;

    public String nextPose;

    public int completeAction = 0;

    public PartData[] partData;

    public Pose(String poseName) {
        this.poseName = poseName;
    }

    public Pose(String poseName, PartData... partData) {
        this.poseName = poseName;
        this.partData = partData;
    }

}
