package com.dragonballzmod.blocks;


import com.dragonballzmod.DragonBallZMod;
import com.dragonballzmod.items.DragonBallZItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.Item;


import java.util.Random;

public class BlockNamekianDiamondOre extends Block
{
    protected BlockNamekianDiamondOre() {
        super(Material.rock);
        this.setHardness(1.3F);
        this.setResistance(10F);
        setCreativeTab(DragonBallZMod.dbTab);
        setBlockTextureName(DragonBallZMod.modid + ":" + "blockNamekianDiamondOre");
    }

    public Item getItemDropped(int damage, Random random, int fortune) {
        return Items.diamond;
    }

    public int quantityDropped(Random random) {
        return 1;
    }

    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0) {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0) {
                j = 0;
            }

            return quantityDropped(random) * (j + 1);
        } else {
            return quantityDropped(random);
        }
    }
}
