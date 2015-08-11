package com.dragonballzmod.items;


import com.dragonballzmod.DragonBallZMod;
import com.dragonballzmod.blocks.DragonBallZBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemNamekianWoodSlab extends ItemSlab
{
    public ItemNamekianWoodSlab(Block block)
    {
        super(block, (BlockSlab) DragonBallZBlocks.blockNamekianWoodHalfslab, (BlockSlab)DragonBallZBlocks.blockNamekianWoodDoubleslab, false);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

}
