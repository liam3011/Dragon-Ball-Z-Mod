package com.dragonballzmod;

import com.dragonballzmod.animation.DBZAnimator;
import com.dragonballzmod.animation.Pose;
import com.dragonballzmod.blocks.DragonBallZBlocks;
import com.dragonballzmod.common.CommonProxy;
import com.dragonballzmod.entity.DragonBallZEntitys;
import com.dragonballzmod.events.EventHook;
import com.dragonballzmod.help.Reference;
import com.dragonballzmod.items.DragonBallZItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;


@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class DragonBallZMod {
    public static final String modid = Reference.MODID;
    public static final String version = Reference.VERSION;

    //Proxy:
    @SidedProxy(clientSide = "com.dragonballzmod.client.ClientProxy", serverSide = "com.dragonballzmod.common.CommonProxy")
    public static CommonProxy proxy;


    public static CreativeTabs dbTab = new CreativeTabs("dragonBallZModTab") {
        public Item getTabIconItem() {
            return Items.apple;
        }
    };

    public static DBZAnimator entityAnimator;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //DragonBallZBlocks.addBlocks();
        //DragonBallZItems.addItems();
        //DragonBallZEntitys.addEntitys(this);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        entityAnimator = new DBZAnimator();

        entityAnimator.playerPoses = new Pose[1];
        entityAnimator.playerPoses[0] = new Pose("default");
        
        MinecraftForge.EVENT_BUS.register(new EventHook());
        DragonBallZBlocks.addBlocks();
        DragonBallZItems.addItems();
        DragonBallZEntitys.addEntitys(this);

        GameRegistry.addRecipe(new ItemStack(DragonBallZBlocks.blockDoomDiamondBlock), new Object[]
                {
                        "XXX",
                        "XXX",
                        "XXX",
                        'X', DragonBallZItems.itemDoomDiamond
                });

        GameRegistry.addShapelessRecipe(new ItemStack(DragonBallZItems.itemDoomDiamond, 9), new Object[]
                {
                        DragonBallZBlocks.blockDoomDiamondBlock
                });

        proxy.registerEveryThing();
        proxy.registerCustomBlocks();
    }
}
