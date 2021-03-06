package com.dragonballzmod;

import com.dragonballzmod.animation.DBZAnimator;
import com.dragonballzmod.animation.Pose;
import com.dragonballzmod.animation.dynamicplayerposes.FlyingPose;
import com.dragonballzmod.blocks.DragonBallZBlocks;
import com.dragonballzmod.commands.SetRace;
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
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;


@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class DragonBallZMod {

    public static final String modid = Reference.MODID;
    public static final String version = Reference.VERSION;

    public static SimpleNetworkWrapper packetNetwork;

    public static final Logger LOGGER = LogManager.getLogger("DragonBallZ");

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

        DBZAnimator.playerPoses = new Pose[2];
        DBZAnimator.playerPoses[0] = new Pose("default");
        DBZAnimator.playerPoses[1] = new FlyingPose();

        InputStream fileStreamJson = DragonBallZMod.class.getResourceAsStream("/assets/dragonballzmod/mod/poseData.json");
        entityAnimator.playerPoses = entityAnimator.addPoses(fileStreamJson, entityAnimator.playerPoses);

        MinecraftForge.EVENT_BUS.register(new EventHook());
        DragonBallZBlocks.addBlocks();
        DragonBallZItems.addItems();
        DragonBallZEntitys.addEntitys(this);



        proxy.registerEveryThing();
        proxy.registerCustomBlocks();

    }

    @EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
        MinecraftServer server = MinecraftServer.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) command;
        manager.registerCommand(new SetRace());
    }

    private void packetNetwork() {
        // Stands for DragonBall Z
        packetNetwork = NetworkRegistry.INSTANCE.newSimpleChannel("DBZ");
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
