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
        rightArmUpper = new PartData("rightArmUpper");
        partData[0] = rightArmUpper;
        rightArmLower = new PartData("rightArmLower");
        partData[1] =rightArmLower;
        leftArmUpper = new PartData("leftArmUpper");
        partData[2] = leftArmUpper;
        leftArmLower = new PartData("leftArmLower");
        partData[3] = leftArmLower;
        head = new PartData("head");
        partData[4] = head;
        upperBody = new PartData("upperBody");
        partData[5] = upperBody;
        lowerBody = new PartData("lowerBody");
        partData[6] = lowerBody;
        rightLegUpper = new PartData("rightLegUpper");
        partData[7] = rightLegUpper;
        rightLegLower = new PartData("rightLegLower");
        partData[8] =rightLegLower;
        leftLegUpper = new PartData("leftLegUpper");
        partData[9] = leftLegUpper;
        leftLegLower = new PartData("leftLegLower");
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
