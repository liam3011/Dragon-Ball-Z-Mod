package com.dragonballzmod.animation.dynamicposes;

import com.dragonballzmod.animation.PartData;
import com.dragonballzmod.animation.Pose;

public class FlyingPose extends Pose {

    public FlyingPose(String poseName, PartData... partData) {
        super(poseName, partData);
    }

    public void updatePose() {
        // Add code here to update he pose positions dynamically(used for poses that arnt linear but may stay on for a while
    }
}
