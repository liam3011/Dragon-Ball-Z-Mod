package com.dragonballzmod;

import com.dragonballzmod.animation.DBZAnimator;
import com.dragonballzmod.animation.Pose;
import com.dragonballzmod.blocks.DragonBallZBlocks;
import com.dragonballzmod.common.CommonProxy;
import com.dragonballzmod.entity.DragonBallZEntitys;
import com.dragonballzmod.events.EventHook;
import com.dragonballzmod.help.Reference;
import com.dragonballzmod.items.DragonBallZItems;
import com.dragonballzmod.packets.clientbound.ClientAnimationPacket;
import com.dragonballzmod.packets.clientbound.ClientAbilityPacket;
import com.dragonballzmod.packets.clientbound.ClientParticleEffectPacket;
import com.dragonballzmod.packets.clientbound.ClientSoundPacket;
import com.dragonballzmod.packets.serverbound.ServerAnimationPacket;
import com.dragonballzmod.packets.serverbound.ServerAbilityPacket;
import com.dragonballzmod.packets.serverbound.ServerParticleEffectPacket;
import com.dragonballzmod.packets.serverbound.ServerSoundPacket;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;


@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class DragonBallZMod {

    public static final String modid = Reference.MODID;
    public static final String version = Reference.VERSION;

    public static SimpleNetworkWrapper packetNetwork;

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

        this.packetNetwork();

        //DragonBallZBlocks.addBlocks();
        //DragonBallZItems.addItems();
        //DragonBallZEntitys.addEntitys(this);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        entityAnimator = new DBZAnimator();

        DBZAnimator.playerPoses = new Pose[1];
        DBZAnimator.playerPoses[0] = new Pose("default");
        
        MinecraftForge.EVENT_BUS.register(new EventHook());
        DragonBallZBlocks.addBlocks();
        DragonBallZItems.addItems();
        DragonBallZEntitys.addEntitys(this);

        GameRegistry.addRecipe(new ItemStack(DragonBallZBlocks.blockDoomDiamondBlock), "XXX",
                "XXX",
                "XXX",
                'X', DragonBallZItems.itemDoomDiamond);

        GameRegistry.addShapelessRecipe(new ItemStack(DragonBallZItems.itemDoomDiamond, 9), DragonBallZBlocks.blockDoomDiamondBlock);

        proxy.registerEveryThing();
        proxy.registerCustomBlocks();
    }

    private void packetNetwork() {
        // Stands for Sekwah's Naruto Mod
        packetNetwork = NetworkRegistry.INSTANCE.newSimpleChannel("SNM");
        packetNetwork.registerMessage(ClientParticleEffectPacket.class, ClientParticleEffectPacket.class, 0, Side.CLIENT);
        packetNetwork.registerMessage(ClientAbilityPacket.class, ClientAbilityPacket.class, 1, Side.CLIENT);
        packetNetwork.registerMessage(ClientSoundPacket.class, ClientSoundPacket.class, 2, Side.CLIENT);
        packetNetwork.registerMessage(ClientAnimationPacket.class, ClientAnimationPacket.class, 3, Side.CLIENT);

        packetNetwork.registerMessage(ServerParticleEffectPacket.class, ServerParticleEffectPacket.class, 4, Side.SERVER);
        packetNetwork.registerMessage(ServerAbilityPacket.class, ServerAbilityPacket.class, 5, Side.SERVER);
        packetNetwork.registerMessage(ServerAnimationPacket.class, ServerAnimationPacket.class, 6, Side.SERVER);
        packetNetwork.registerMessage(ServerSoundPacket.class, ServerSoundPacket.class, 7, Side.SERVER);

    }
}
