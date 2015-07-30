package com.dragonballzmod.blocks;

import com.dragonballzmod.help.RegisterHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DragonBallZBlocks {
    //Blocks:
    public static Block blockNamekianSoil;
    public static Block blockNamekianStone;
    public static Block blockNamekianGrass;
    public static Block blockNamekianMarble;
    public static Block blockNamekianCoalOre;
    public static Block blockNamekianIronOre;
    public static Block blockNamekianSand;
    public static Block blockTintGlass;
    public static Block blockDoomDiamondOre;
    public static Block blockDoomDiamondBlock;
    public static Block blockDragonBall1;
    public static Block blockDragonBall2;
    public static Block blockDragonBall3;
    public static Block blockDragonBall4;
    public static Block blockDragonBall5;
    public static Block blockDragonBall6;
    public static Block blockDragonBall7;
    public static Block blockNamekianDiamondOre;
    public static Block blockNamekianGoldOre;
    public static Block blockTempPortal;

    public static void addBlocks() {
        //Blocks Classes:
        blockNamekianSoil = new BlockNamekianSoil().setBlockName("blockNamekianSoil");
        blockNamekianStone = new BlockNamekianStone().setBlockName("blockNamekianStone");
        blockNamekianGrass = new BlockNamekianGrass().setBlockName("blockNamekianGrass");
        blockNamekianMarble = new BlockNamekianMarble().setBlockName("blockNamekianMarble");
        blockNamekianCoalOre = new BlockNamekianCoalOre().setBlockName("blockNamekianCoalOre");
        blockNamekianIronOre = new BlockNamekianIronOre().setBlockName("blockNamekianIronOre");
        blockNamekianSand = new BlockNamekianSand().setBlockName("blockNamekianSand");
        blockTintGlass = new BlockTintGlass(Material.glass, false);
        blockDoomDiamondOre = new BlockDoomDiamondOre().setBlockName("blockDoomDiamondOre");
        blockDoomDiamondBlock = new BlockDoomDiamondBlock().setBlockName("blockDoomDiamondBlock");
        blockDragonBall1 = new BlockDragonBall(1).setBlockName("blockDragonBall1");
        blockDragonBall2 = new BlockDragonBall(2).setBlockName("blockDragonBall2");
        blockDragonBall3 = new BlockDragonBall(3).setBlockName("blockDragonBall3");
        blockDragonBall4 = new BlockDragonBall(4).setBlockName("blockDragonBall4");
        blockDragonBall5 = new BlockDragonBall(5).setBlockName("blockDragonBall5");
        blockDragonBall6 = new BlockDragonBall(6).setBlockName("blockDragonBall6");
        blockDragonBall7 = new BlockDragonBall(7).setBlockName("blockDragonBall7");
        blockNamekianDiamondOre = new BlockNamekianDiamondOre().setBlockName("blockNamekianDiamondOre");
        blockNamekianGoldOre = new BlockNamekianGoldOre().setBlockName("blockNamekianGoldOre");
      //  blockTempPortal = new BlockTempPortal().setBlockName("blockTempPortal");


        //Block Register:
        RegisterHelper.registerBlock(blockNamekianSoil);
        RegisterHelper.registerBlock(blockNamekianStone);
        RegisterHelper.registerBlock(blockNamekianGrass);
        RegisterHelper.registerBlock(blockNamekianMarble);
        RegisterHelper.registerBlock(blockNamekianCoalOre);
        RegisterHelper.registerBlock(blockNamekianIronOre);
        RegisterHelper.registerBlock(blockNamekianSand);
        RegisterHelper.registerBlock(blockTintGlass);
        RegisterHelper.registerBlock(blockDoomDiamondOre);
        RegisterHelper.registerBlock(blockDoomDiamondBlock);
        RegisterHelper.registerBlock(blockDragonBall1);
        RegisterHelper.registerBlock(blockDragonBall2);
        RegisterHelper.registerBlock(blockDragonBall3);
        RegisterHelper.registerBlock(blockDragonBall4);
        RegisterHelper.registerBlock(blockDragonBall5);
        RegisterHelper.registerBlock(blockDragonBall6);
        RegisterHelper.registerBlock(blockDragonBall7);
        RegisterHelper.registerBlock(blockNamekianDiamondOre);
        RegisterHelper.registerBlock(blockNamekianGoldOre);

      //  RegisterHelper.registerBlock(blockTempPortal);

        //Recipes
        GameRegistry.addSmelting(blockNamekianIronOre, new ItemStack(Items.iron_ingot), 20F);
        GameRegistry.addSmelting(blockNamekianGoldOre, new ItemStack(Items.gold_ingot), 20F);
    }

}
