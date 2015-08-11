package com.dragonballzmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class DragonBallZItems
{
    //Items:
    public static Item itemNimbus;
    public static Item itemDoomDiamond;
    public static Item itemBattleArmorChest1;
    public static Item itemBattleArmorLegs1;
    public static Item item3011craftChestGi;

    private static ItemArmor.ArmorMaterial battleArmorMaterial = EnumHelper.addArmorMaterial("SHINOBI", 40, new int[]{2, 8, 5, 2}, 10);
    private static ItemArmor.ArmorMaterial giArmorMaterial = EnumHelper.addArmorMaterial("GI", 10, new int[]{1, 3, 2, 1}, 12);


    public static void addItems()
    {
        //Item :
        itemNimbus = new ItemNimbus().setUnlocalizedName("flyingNimbus");
        itemDoomDiamond = new ItemDoomDiamond().setUnlocalizedName("itemDoomDiamond");
        itemBattleArmorChest1 = new itemBattleArmorChest1(battleArmorMaterial, 4, 1).setUnlocalizedName("itemBattleArmorChest1");
        itemBattleArmorLegs1 = new itemBattleArmorLegs1(battleArmorMaterial, 4, 1).setUnlocalizedName("itemBattleArmorLegs1");
        item3011craftChestGi = new Item3011craftChestGi(giArmorMaterial, 4, 1).setUnlocalizedName("item3011craftChestGi");


        //Item Registry:
        GameRegistry.registerItem(itemNimbus, "Nimbus");
        GameRegistry.registerItem(itemDoomDiamond, "DoomDiamond");
        GameRegistry.registerItem(itemBattleArmorChest1, "Battle Armor Chest Type 1");
        GameRegistry.registerItem(itemBattleArmorLegs1, "Battle Armor Legs Type 1");
        GameRegistry.registerItem(item3011craftChestGi, "3011craft Chest Gi");
    }

}
