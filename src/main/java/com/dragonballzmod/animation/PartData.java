package com.dragonballzmod.animation;


public class PartData {

    public String partName;

    // LocationData
    public boolean[] hasPos = {false, false, false};
    public float rotationPointX = 0;
    public float rotationPointY = 0;
    public float rotationPointZ = 0;
    public boolean[] shouldRot = {false, false, false};
    public float rotateAngleX = 0;
    public float rotateAngleY = 0;
    public float rotateAngleZ = 0;

    public PartData(String partName) {
        this.partName = partName;
    }

}
