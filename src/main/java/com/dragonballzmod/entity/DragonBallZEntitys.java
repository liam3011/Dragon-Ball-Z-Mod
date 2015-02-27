package com.dragonballzmod.entity;

import com.dragonballzmod.DragonBallZMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;


public class DragonBallZEntitys {
    public static void addEntitys(DragonBallZMod dragonBallZMod) {
        EntityRegistry.registerModEntity(EntityFlyingNimbus.class, "FlyingNimbus", 70, dragonBallZMod, 80, 1, true);
        EntityList.IDtoClassMapping.put(70, EntityFlyingNimbus.class);

    }

}
