package com.dragonballzmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class DragonBallZItems {
    //Items:
    public static Item itemNimbus;
    public static Item itemDoomDiamond;
    public static Item itemBattleArmorChest1;
    public static Item itemDinoCap;

    private static ItemArmor.ArmorMaterial battleArmorMaterial = EnumHelper.addArmorMaterial("SHINOBI", 35, new int[]{2, 8, 5, 2}, 10);

    public static void addItems() {
        //Item :
        itemNimbus = new ItemNimbus().setUnlocalizedName("flyingNimbus");
        itemDoomDiamond = new ItemDoomDiamond().setUnlocalizedName("itemDoomDiamond");
        itemBattleArmorChest1 = new itemBattleArmorChest1(battleArmorMaterial, 4, 1).setUnlocalizedName("itemBattleArmorChest1");


        //Item Registry:
        GameRegistry.registerItem(itemNimbus, "Nimbus");
        GameRegistry.registerItem(itemDoomDiamond, "DoomDiamond");
        GameRegistry.registerItem(itemBattleArmorChest1, "Battle Armor Chest Type 1");


    }

}
