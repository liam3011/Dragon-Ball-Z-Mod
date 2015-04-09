package com.dragonballzmod.animation.dynamicplayerposes;

import com.dragonballzmod.animation.DBZAnimator;
import com.dragonballzmod.animation.PartData;
import net.minecraft.entity.Entity;

public class FlyingPose extends DynamicPose {

    private final PartData rightArmUpper;
    private final PartData leftArmUpper;
    private final PartData rightArmLower;
    private final PartData leftArmLower;
    private final PartData head;
    private final PartData upperBody;
    private final PartData lowerBody;
    private final PartData rightLegUpper;
    private final PartData rightLegLower;
    private final PartData leftLegUpper;
    private final PartData leftLegLower;

    public FlyingPose() {
        super("flying");

        partData = new PartData[11];
        rightArmUpper = new PartData("rightArmUpper", true, true);
        partData[0] = rightArmUpper;
        rightArmLower = new PartData("rightArmLower", true, true);
        partData[1] =rightArmLower;
        leftArmUpper = new PartData("leftArmUpper", true, true);
        partData[2] = leftArmUpper;
        leftArmLower = new PartData("leftArmLower", true, true);
        partData[3] = leftArmLower;
        head = new PartData("head");
        partData[4] = head;
        upperBody = new PartData("upperBody", true, true);
        partData[5] = upperBody;
        lowerBody = new PartData("lowerBody", true, true);
        partData[6] = lowerBody;
        rightLegUpper = new PartData("rightLegUpper", true, true);
        partData[7] = rightLegUpper;
        rightLegLower = new PartData("rightLegLower", true, true);
        partData[8] =rightLegLower;
        leftLegUpper = new PartData("leftLegUpper", true, true);
        partData[9] = leftLegUpper;
        leftLegLower = new PartData("leftLegLower", true, true);
        partData[10] = leftLegLower;

        partData = DBZAnimator.sortParts(partData);
    }

    public void updatePose(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
        // TODO add code to update the part data and all sorts
        // TODO test and finish flying animation
        // SUCCESS ^.^ F**KING BRILLIANT JIM(there is noone on the team called jim but whatever)
        //leftArmUpper.rotateAngleY = (float) Math.random * 3F;

    }
}
