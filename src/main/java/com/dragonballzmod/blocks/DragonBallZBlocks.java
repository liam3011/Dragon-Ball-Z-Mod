package com.dragonballzmod.blocks;

import com.dragonballzmod.blocks.tileentity.TileEntityThinTree;
import com.dragonballzmod.help.RegisterHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class DragonBallZBlocks
{
    //Blocks:
    public static Block blockDragonBall1;
    public static Block blockDragonBall2;
    public static Block blockDragonBall3;
    public static Block blockDragonBall4;
    public static Block blockDragonBall5;
    public static Block blockDragonBall6;
    public static Block blockDragonBall7;

    public static Block blockThinTree;
    public static Block blockNamekianWoodPlanks;
    public static Block blockNamekianWoodHalfslab;
    public static Block blockNamekianWoodDoubleslab;
    public static Block blockNamekianGrass;
    public static Block blockNamekianSand;
    public static Block blockNamekianSoil;
    public static Block blockNamekianStone;
    public static Block blockNamekianMarble;
    public static Block blockNamekianCoalOre;
    public static Block blockNamekianIronOre;
    public static Block blockNamekianGoldOre;
    public static Block blockNamekianDiamondOre;

    public static Block blockTintGlass;

    public static Block blockSaltWater;

    public static Fluid saltWater;

    public static void addBlocks()
    {
        //Dragon Balls
        blockDragonBall1 = new BlockDragonBall(1).setBlockName("blockDragonBall1");
        blockDragonBall2 = new BlockDragonBall(2).setBlockName("blockDragonBall2");
        blockDragonBall3 = new BlockDragonBall(3).setBlockName("blockDragonBall3");
        blockDragonBall4 = new BlockDragonBall(4).setBlockName("blockDragonBall4");
        blockDragonBall5 = new BlockDragonBall(5).setBlockName("blockDragonBall5");
        blockDragonBall6 = new BlockDragonBall(6).setBlockName("blockDragonBall6");
        blockDragonBall7 = new BlockDragonBall(7).setBlockName("blockDragonBall7");

        //NamekianBlocks
        blockThinTree = new BlockThinTree().setBlockName("blockThinTree");
        blockNamekianWoodPlanks = new BlockNamekianWoodPlanks().setBlockName("blockNamekianWoodPlanks");
        //blockNamekianWoodHalfslab = new BlockNamekianWoodSlab(false, blockNamekianWoodPlanks,  Material.wood).setBlockName("blockNamekianWoodHalfSlab");
        //blockNamekianWoodDoubleslab = new BlockNamekianWoodSlab(true, blockNamekianWoodPlanks, Material.wood).setBlockName("blockNamekianWoodDoubleSlab").setBlockTextureName(DragonBallZMod.modid + ":" + "blockNamekianWoodPlanks");
        blockNamekianGrass = new BlockNamekianGrass().setBlockName("blockNamekianGrass");
        blockNamekianSand = new BlockNamekianSand().setBlockName("blockNamekianSand");
        blockNamekianSoil = new BlockNamekianSoil().setBlockName("blockNamekianSoil");
        blockNamekianStone = new BlockNamekianStone().setBlockName("blockNamekianStone");
        blockNamekianMarble = new BlockNamekianMarble().setBlockName("blockNamekianMarble");
        blockNamekianCoalOre = new BlockNamekianCoalOre().setBlockName("blockNamekianCoalOre");
        blockNamekianIronOre = new BlockNamekianIronOre().setBlockName("blockNamekianIronOre");
        blockNamekianGoldOre = new BlockNamekianGoldOre().setBlockName("blockNamekianGoldOre");
        blockNamekianDiamondOre = new BlockNamekianDiamondOre().setBlockName("blockNamekianDiamondOre");

        //Misc
        blockTintGlass = new BlockTintGlass(Material.glass, false);

        //Liquids
        saltWater = new Fluid("saltWater");
        FluidRegistry.registerFluid(saltWater);
        blockSaltWater = new BlockSaltWater(saltWater, Material.water).setBlockName("blockSaltWater");

        //Block Register:
        RegisterHelper.registerBlock(blockDragonBall1);
        RegisterHelper.registerBlock(blockDragonBall2);
        RegisterHelper.registerBlock(blockDragonBall3);
        RegisterHelper.registerBlock(blockDragonBall4);
        RegisterHelper.registerBlock(blockDragonBall5);
        RegisterHelper.registerBlock(blockDragonBall6);
        RegisterHelper.registerBlock(blockDragonBall7);

        RegisterHelper.registerBlock(blockThinTree);
        RegisterHelper.registerBlock(blockNamekianWoodPlanks);
        //RegisterHelper.registerBlock(blockNamekianWoodHalfslab);
        //RegisterHelper.registerBlock(blockNamekianWoodDoubleslab);
        RegisterHelper.registerBlock(blockNamekianGrass);
        RegisterHelper.registerBlock(blockNamekianSand);
        RegisterHelper.registerBlock(blockNamekianSoil);
        RegisterHelper.registerBlock(blockNamekianStone);
        RegisterHelper.registerBlock(blockNamekianMarble);
        RegisterHelper.registerBlock(blockNamekianCoalOre);
        RegisterHelper.registerBlock(blockNamekianIronOre);
        RegisterHelper.registerBlock(blockNamekianGoldOre);
        RegisterHelper.registerBlock(blockNamekianDiamondOre);

        RegisterHelper.registerBlock(blockTintGlass);

        RegisterHelper.registerBlock(blockSaltWater);

        GameRegistry.registerTileEntity(TileEntityThinTree.class, "blockThinTree");

        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityThinTree.class, new TileEntityThinTreeRenderer());

        //Smelting Recipes
        GameRegistry.addSmelting(blockNamekianIronOre, new ItemStack(Items.iron_ingot), 20F);
        GameRegistry.addSmelting(blockNamekianGoldOre, new ItemStack(Items.gold_ingot), 20F);

        //Crafting Recipes
        GameRegistry.addRecipe(new ItemStack(blockNamekianWoodPlanks), new Object[]{"X", 'X', blockThinTree});
        GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[] {"X ", "X ", 'X', blockNamekianWoodPlanks});
        GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table), new Object[] {"XX", "XX", 'X', blockNamekianWoodPlanks});


    }

}
