package com.dragonballzmod.animation;

import com.dragonballzmod.animation.dynamicplayerposes.FlyingPose;
import com.dragonballzmod.client.PlayerRenderTickEvent;
import com.dragonballzmod.json.JSONObject;
import com.dragonballzmod.packets.PacketAnimationUpdate;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;

import java.io.*;
import java.util.ArrayList;

public class DBZAnimator {

    public static Pose[] playerPoses;

    // If you think its nessasary, change it so there is an animator for the player and one for all other mobs(if you think it'll create a significant difference)
    public DBZAnimator() {
        // Setup the default pose, used as a placeholder to stop crashes or potentially replace the playerModels default pose to reduce lag.
        playerPoses = new Pose[2];
        playerPoses[0] = new Pose("default");
        playerPoses[1] = new FlyingPose("flying");
    }

    public static Pose[] sortAnimations(Pose[] poses) {
        for (int i = poses.length - 1; i >= 1; i--) {
            for (int z = 0; z < i; z++) {
                for (int j = 0; j < poses[z].poseName.length(); j++) {
                    if (j <= poses[z].poseName.length() - 1 && j <= poses[z + 1].poseName.length() - 1) {
                        char animChar = poses[z].poseName.charAt(j);
                        char poseChar = poses[z + 1].poseName.charAt(j);
                        if (animChar > poseChar) {
                            Pose tempPose = poses[z];
                            poses[z] = poses[z + 1];
                            poses[z + 1] = tempPose;
                            break;
                        } else if (animChar < poseChar) {
                            break;
                        }
                    } else if (j >= poses[z].poseName.length() - 1) {
                        Pose tempPose = poses[z];
                        poses[z] = poses[z + 1];
                        poses[z + 1] = tempPose;
                        break;
                    }
                }
            }
        }
        return poses;
    }

    public static PartData[] sortParts(PartData[] parts) {
        for (int i = parts.length - 1; i >= 1; i--) {
            for (int z = 0; z < i; z++) {
                for (int j = 0; j < parts[z].partName.length(); j++) {
                    if (j <= parts[z].partName.length() - 1 && j <= parts[z + 1].partName.length() - 1) {
                        char animChar = parts[z].partName.charAt(j);
                        char poseChar = parts[z + 1].partName.charAt(j);
                        if (animChar > poseChar) {
                            PartData tempPart = parts[z];
                            parts[z] = parts[z + 1];
                            parts[z + 1] = tempPart;
                            break;
                        } else if (animChar < poseChar) {
                            break;
                        }
                    } else if (j >= parts[z].partName.length() - 1) {
                        PartData tempPart = parts[z];
                        parts[z] = parts[z + 1];
                        parts[z + 1] = tempPart;
                        break;
                    }
                }
            }
        }
        return parts;
    }

    public static boolean animationExists(String animationID, Pose[] poseArray) {
        if (getPose(animationID, poseArray) != null) {
            return true;
        } else {
            return false;
        }
    }

    public static Pose getPose(String animationID, Pose[] poseArray) {
        int first = 0;
        int last = poseArray.length - 1;
        int currentCharacter = 0;
        int center = -1;
        while (last - first >= 0) {
            center = (int) Math.ceil(first + (last - first) / 2F);
            if (poseArray[center].poseName.equals(animationID)) {
                return poseArray[center];
            }
            int difference = last - first;
            for (int i = 0; i < animationID.length(); i++) {
                if (i <= poseArray[center].poseName.length() - 1 && i <= animationID.length() - 1) {
                    char animChar = animationID.charAt(i);
                    char poseChar = poseArray[center].poseName.charAt(i);
                    if (animChar < poseChar) {
                        last = center - 1;
                        break;
                    } else if (animChar > poseChar) {
                        first = center;
                        break;
                    }
                } else if (i > poseArray[center].poseName.length() - 1) {
                    first = center;
                    break;
                } else if (i > animationID.length() - 1) {
                    last = center;
                    break;
                }
            }
            if (last - first == difference) {
                last -= 1;
            }
        }
        return null;
    }

    public static PartData getPart(String animationID, PartData[] partArray) {
        int first = 0;
        int last = partArray.length - 1;
        int currentCharacter = 0;
        int center = -1;
        while (last - first >= 0) {
            center = (int) Math.ceil(first + (last - first) / 2F);
            if (partArray[center].partName.equals(animationID)) {
                return partArray[center];
            }
            int difference = last - first;
            for (int i = 0; i < animationID.length(); i++) {
                if (i <= partArray[center].partName.length() - 1 && i <= animationID.length() - 1) {
                    char animChar = animationID.charAt(i);
                    char poseChar = partArray[center].partName.charAt(i);
                    if (animChar < poseChar) {
                        last = center - 1;
                        break;
                    } else if (animChar > poseChar) {
                        first = center;
                        break;
                    }
                } else if (i > partArray[center].partName.length() - 1) {
                    first = center;
                    break;
                } else if (i > animationID.length() - 1) {
                    last = center;
                    break;
                }
            }
            if (last - first == difference) {
                last -= 1;
            }
        }
        return null;
    }

    public static void animate(String animationID, String animationlastID, int animationTick, ArrayList<AnimModelRenderer> animatedParts, Pose[] poseArray) {
        /**if(animationID != "default"){
         if(poses.has(animationID)){
         JSONObject lastPoseInfo = poses.getJSONObject(animationID);
         JSONObject locData = lastPoseInfo.getJSONObject("locData");

         if(locData.has("rightArmUpper")){lastPosePart(modelBiped.bipedRightArm, locData.getJSONObject("rightArm"));}

         if(locData.has("leftArmUpper")){lastPosePart(modelBiped.bipedLeftArm, locData.getJSONObject("leftArm"));}

         }
         }*/

        //System.out.println("anim:" + animationID + " lastAnim:" + animationlastID + " animationTick:" + animationTick);
        if (animationID.equals("default") && !animationlastID.equals("default")) { // add animation to default too!
            // TODO Switch code to get poses from the pose array
            Pose lastPose = getPose(animationlastID, poseArray);
            if (lastPose != null) {
                /**JSONObject poseInfo = poses.getJSONObject(animationlastID);
                 JSONObject locData = poseInfo.getJSONObject("locData");*/
                int animLength = lastPose.animLength;

                if (animLength > animationTick) {
                    for (AnimModelRenderer part : animatedParts) {
                        PartData partData = getPart(part.boxName, lastPose.partData);
                        animPosePart(part, partData, animLength - animationTick, animLength);
                    }
                    // Old format    if(locData.has("rightArmUpper")){animPosePart(modelBiped.bipedRightArmUpper, locData.getJSONObject("rightArmUpper"), animLength - animationTick, animLength);}
                }
            } else {
               // NarutoMod.LOGGER.error("PoseData not found for: " + animationID);
                throw new NullPointerException("PoseData not found for: " + animationID + ". Either the data is missing or an there is something wrong.");
            }
        } else if (!animationlastID.equals("default")) {
            Pose lastPose = getPose(animationlastID, poseArray);
            if (lastPose != null) {
                //JSONObject lastPoseInfo = poses.getJSONObject(animationlastID);
                //JSONObject locData = lastPoseInfo.getJSONObject("locData");


                for (AnimModelRenderer part : animatedParts) {
                    PartData partData = getPart(part.boxName, lastPose.partData);
                    setPosePart(part, partData);
                }

                // Old format    if(locData.has("rightArmUpper")){setPosePart(modelBiped.bipedRightArmUpper, locData.getJSONObject("rightArmUpper"));}
            } else {
               // NarutoMod.LOGGER.error("PoseData not found for: " + animationID);
                throw new NullPointerException("PoseData not found for: " + animationID + ". Either the data is missing or an there is something wrong.");
            }
        }

        if (!animationID.equals("default")) { // add animation to default too!
            Pose currentPose = getPose(animationID, poseArray);
            if (currentPose != null) {
                //JSONObject poseInfo = poses.getJSONObject(animationID);
                //JSONObject locData = poseInfo.getJSONObject("locData");
                int animLength = currentPose.animLength;

                if (animLength > animationTick) {
                    for (AnimModelRenderer part : animatedParts) {
                        PartData partData = getPart(part.boxName, currentPose.partData);
                        animPosePart(part, partData, animationTick, animLength);
                    }

                    // Old format    if(locData.has("rightArmUpper")){animPosePart(modelBiped.bipedRightArmUpper, locData.getJSONObject("rightArmUpper"), animationTick, animLength);}
                } else {

                    for (AnimModelRenderer part : animatedParts) {
                        PartData partData = getPart(part.boxName, currentPose.partData);
                        setPosePart(part, partData);
                    }

                    // Old format    if(locData.has("rightArmUpper")){setPosePart(modelBiped.bipedRightArmUpper, locData.getJSONObject("rightArmUpper"));}
                }
            } else {
              //  NarutoMod.LOGGER.error("PoseData not found for: " + animationID);
                throw new NullPointerException("PoseData not found for: " + animationID + ". Either the data is missing or an there is something wrong.");
            }
        }

    }

    private static void animPosePart(AnimModelRenderer bodyPart, PartData partData, int animationTick, int animLength) {
        if (partData != null) {
            if (partData.shouldRot[0]) {
                bodyPart.rotateAngleX -= ((bodyPart.rotateAngleX - partData.rotateAngleX) / animLength) * animationTick;
            }
            if (partData.shouldRot[1]) {
                bodyPart.rotateAngleY -= ((bodyPart.rotateAngleY - partData.rotateAngleY) / animLength) * animationTick;
            }
            if (partData.shouldRot[2]) {
                bodyPart.rotateAngleZ -= ((bodyPart.rotateAngleZ - partData.rotateAngleZ) / animLength) * animationTick;
            }

            if (partData.hasPos[0]) {
                bodyPart.rotationPointX -= ((bodyPart.rotationPointX - partData.rotationPointX) / animLength) * animationTick;
            }
            if (partData.hasPos[1]) {
                bodyPart.rotationPointY -= ((bodyPart.rotationPointY - partData.rotationPointY) / animLength) * animationTick;
            }
            if (partData.hasPos[2]) {
                bodyPart.rotationPointZ -= ((bodyPart.rotationPointZ - partData.rotationPointZ) / animLength) * animationTick;
            }
        }
    }

    private static void setPosePart(AnimModelRenderer bodyPart, PartData partData) {
        if (partData != null) {
            if (partData.shouldRot[0]) {
                bodyPart.rotateAngleX = partData.rotateAngleX;
            }
            if (partData.shouldRot[1]) {
                bodyPart.rotateAngleY = partData.rotateAngleY;
            }
            if (partData.shouldRot[2]) {
                bodyPart.rotateAngleZ = partData.rotateAngleZ;
            }

            if (partData.hasPos[0]) {
                bodyPart.rotationPointX = partData.rotationPointX;
            }
            if (partData.hasPos[1]) {
                bodyPart.rotationPointY = partData.rotationPointY;
            }
            if (partData.hasPos[2]) {
                bodyPart.rotationPointZ = partData.rotationPointZ;
            }
        }
    }

    /**
     * At the moment this is just updating players
     *
     * @param dw
     * @param entity
     */
    public static void updateEntity(DataWatcher dw, Entity entity, Pose[] poseArray) { // this is for client updates

        NBTTagCompound data = entity.getEntityData();

        if (!dw.getWatchableObjectString(20).equals(dw.getWatchableObjectString(27))) {
            dw.updateObject(25, 0);
            dw.updateObject(27, dw.getWatchableObjectString(20));
        }

        if (dw.getWatchableObjectString(20).equals(dw.getWatchableObjectString(27)) && getPose(dw.getWatchableObjectString(20), poseArray) != null && getPose(dw.getWatchableObjectString(20), poseArray).animLength > dw.getWatchableObjectInt(25)) {
            int delta = PlayerRenderTickEvent.delta;
            while (delta-- >= 1) {
                if (getPose(dw.getWatchableObjectString(20), poseArray).animLength > dw.getWatchableObjectInt(25)) {
                    dw.updateObject(25, dw.getWatchableObjectInt(25) + 1);
                }
            }
        } else {
            dw.updateObject(26, dw.getWatchableObjectString(20));
        }
    }

    public static void updateClient(EntityClientPlayerMP playerMP, Pose[] poseArray) {

        NBTTagCompound data = playerMP.getEntityData();

        DataWatcher dw = playerMP.getDataWatcher();
        if (!dw.getWatchableObjectString(20).equals(dw.getWatchableObjectString(27))) {
            dw.updateObject(25, 0);
            dw.updateObject(27, dw.getWatchableObjectString(20));
            PlayerRenderTickEvent.hasFiredAnimationUpdate = false;
        }

        if (dw.getWatchableObjectString(20).equals(dw.getWatchableObjectString(27)) && getPose(dw.getWatchableObjectString(20), poseArray) != null && getPose(dw.getWatchableObjectString(20), poseArray).animLength > dw.getWatchableObjectInt(25)) {
            int delta = PlayerRenderTickEvent.delta;
            //while (delta-- >= 1) {
            Pose currentPose = getPose(dw.getWatchableObjectString(20), poseArray);
            if (currentPose.animLength > dw.getWatchableObjectInt(25)) {
                if(dw.getWatchableObjectInt(25) + delta >= currentPose.animLength){
                    dw.updateObject(25, currentPose.animLength);
                }
                else{
                    dw.updateObject(25, dw.getWatchableObjectInt(25) + delta);
                }
            } else {
                if (!PlayerRenderTickEvent.hasFiredAnimationUpdate) {
                    animationComplete(playerMP, poseArray);
                }
                PlayerRenderTickEvent.hasFiredAnimationUpdate = true;
            }
            //}
//            if (NarutoSettings.experimentalFirstPersonMode == 2) {
//                NarutoSettings.experimentalFirstPerson = true;
//            }
        } else {
            if (!PlayerRenderTickEvent.hasFiredAnimationUpdate) {
                animationComplete(playerMP, poseArray);
                PlayerRenderTickEvent.hasFiredAnimationUpdate = true;
            }

           /* if (dw.getWatchableObjectString(20).equals("default")) {
                if (NarutoSettings.experimentalFirstPersonMode == 2) {
                    NarutoSettings.experimentalFirstPerson = false;
                }
            }*/
            /**if(NarutoSettings.experimentalFirstPersonMode == 2){
             if(dw.getWatchableObjectString(20).equals("default") && dw.getWatchableObjectString(27).equals("default")){
             NarutoSettings.experimentalFirstPerson = false;
             }
             else{
             NarutoSettings.experimentalFirstPerson = true;
             }
             }*/
        }
    }

    private static void animationComplete(EntityClientPlayerMP playerMP, Pose[] poseArray) { // triggered by the client to get the next animation
        DataWatcher dw = playerMP.getDataWatcher();
        dw.updateObject(26, dw.getWatchableObjectString(20));
        String animationID = dw.getWatchableObjectString(20);
        Pose pose = getPose(animationID, poseArray);
        if (pose != null) {
            if (pose.nextPose != null) {
              PacketAnimationUpdate.animationUpdate(pose.nextPose, playerMP);
            }
            if (pose.completeAction != 0) {

                ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
                DataOutputStream outputStream = new DataOutputStream(bos);
                try {
                    outputStream.writeInt(pose.completeAction);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

              //  PacketDispatcher.sendPacketToServer(new ServerJutsuPacket(bos.toByteArray()));

            }
        }
    }

    public Pose[] addPoses(InputStream filestreamJson, Pose[] poseArray) {
        JSONObject poseFile;
        JSONObject poseData;
        try {
            String json = readJSONFileStream(filestreamJson);
            poseFile = new JSONObject(json);
            poseData = poseFile.getJSONObject("poses");
           // NarutoMod.LOGGER.info(poseFile.getNames("poses"));
            String[] poseNames = JSONObject.getNames(poseData);

            Pose[] oldPoses = poseArray;

            poseArray = new Pose[poseArray.length + poseNames.length];

            for (int i = 0; i < oldPoses.length; i++) {
                poseArray[i] = oldPoses[i];
            }

            for (int i = oldPoses.length; i < poseArray.length; i++) {
                // each pose
                // TODO add code to generate the objects and data from the json

                String currentPoseName = poseNames[i - oldPoses.length];

               // NarutoMod.LOGGER.info("Adding pose: " + currentPoseName);

                JSONObject poseInfo = poseData.getJSONObject(currentPoseName);

                JSONObject locData = poseInfo.getJSONObject("locData");
                String[] positionNames = JSONObject.getNames(locData);

                PartData[] partArray = new PartData[positionNames.length];

                for (int n = 0; n < positionNames.length; n++) {
                    // body parts
                    //NarutoMod.LOGGER.info("Pose data: " + positionNames[n]);
                    JSONObject partData = locData.getJSONObject(positionNames[n]);
                  //  NarutoMod.LOGGER.info(positionNames[n]);
                    //String[] partNames = poseFile.getNames(partData);

                    PartData currentPart = new PartData(positionNames[n]);

                    if (partData.has("posX")) {
                        currentPart.hasPos[0] = true;
                        currentPart.rotationPointX = partData.getFloat("posX");
                    }
                    if (partData.has("posY")) {
                        currentPart.hasPos[1] = true;
                        currentPart.rotationPointY = partData.getFloat("posY");
                    }
                    if (partData.has("posZ")) {
                        currentPart.hasPos[2] = true;
                        currentPart.rotationPointZ = partData.getFloat("posZ");
                    }
                    if (partData.has("rotX")) {
                        currentPart.shouldRot[0] = true;
                        currentPart.rotateAngleX = partData.getFloat("rotX");
                    }
                    if (partData.has("rotY")) {
                        currentPart.shouldRot[1] = true;
                        currentPart.rotateAngleY = partData.getFloat("rotY");
                    }
                    if (partData.has("rotZ")) {
                        currentPart.shouldRot[2] = true;
                        currentPart.rotateAngleZ = partData.getFloat("rotZ");
                    }

                    partArray[n] = currentPart;
                }

                Pose currentPose = new Pose(currentPoseName, sortParts(partArray));

                currentPose.poseName = currentPoseName;

                // TODO Add other data stuff
                if (poseInfo.has("animLength")) {
                    currentPose.animLength = poseInfo.getInt("animLength");
                }
                if (poseInfo.has("nextPose")) {
                    currentPose.nextPose = poseInfo.getString("nextPose");
                }
                if (poseInfo.has("completeAction")) {
                    currentPose.completeAction = poseInfo.getInt("completeAction");
                }

                poseArray[i] = currentPose;
            }

        } catch (IOException e) {
           // NarutoMod.LOGGER.error("Error loading poseData");
            e.printStackTrace();
        }

        poseArray = sortAnimations(poseArray);


        /**for(Pose pose: poseArray){
         System.out.println(pose.poseName);
         }
         System.out.println("");
         System.out.println("-----------------------------------");
         System.out.println("");
         System.out.println(getPose("chakraCharging",poseArray));*/

        return poseArray;
    }

    private String readJSONFileStream(InputStream filestreamJson) throws IOException {
        InputStreamReader inr = new InputStreamReader(filestreamJson, "ASCII");
        BufferedReader br = new BufferedReader(inr);
        StringBuffer sb = new StringBuffer();
        while (true) {
            String line = br.readLine();
            if (line == null)
                break;
            sb.append(line);
            sb.append("\n");
        }

        br.close();
        inr.close();

        return sb.toString();
    }

    public String readJSONFile(File file) throws IOException {
        FileInputStream fin = new FileInputStream(file);
        InputStreamReader inr = new InputStreamReader(fin, "ASCII");
        BufferedReader br = new BufferedReader(inr);
        StringBuffer sb = new StringBuffer();
        while (true) {
            String line = br.readLine();
            if (line == null)
                break;
            sb.append(line);
            sb.append("\n");
        }

        br.close();
        inr.close();
        fin.close();

        return sb.toString();
    }
}
