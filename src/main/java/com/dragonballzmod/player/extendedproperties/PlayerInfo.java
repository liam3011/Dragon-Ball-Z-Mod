package com.dragonballzmod.player.extendedproperties;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerInfo implements IExtendedEntityProperties
{

    public final static String IDENTIFIER = "dragonballz_playerdata";

    // could be usefull but not currently used, also this will only exist on a player and will not change so its reasonably safe
    private final EntityPlayer player;

    private String race;

    private int currentKi, maxKi;

    /*
    The default constructor takes no arguments, but I put in the Entity so I can initialize the above variable 'player'

    Also, it's best to initialize any other variables you may have added, just like in any constructor.
    */
    public PlayerInfo(EntityPlayer player)
    {
        this.player = player;

        race = "Unpicked";

        // Load with max mana, maybe save the mana amount and load it to stop it messing with single player, also have stats and stuff change the max ki
        this.currentKi = this.currentKi = 50;
    }

    /**
     * Used to register these extended properties for the player during EntityConstructing event and is used to register its self
     * also it makes the code look nice so why not
     */
    public static final void register(EntityPlayer player)
    {
        player.registerExtendedProperties(PlayerInfo.IDENTIFIER, new PlayerInfo(player));
    }

    /**
     * Returns ExtendedPlayer properties for player
     * This method is for convenience only
     */
    public static final PlayerInfo get(EntityPlayer player)
    {
        return (PlayerInfo) player.getExtendedProperties(IDENTIFIER);
    }

    // Save any custom data that needs saving here
    @Override
    public void saveNBTData(NBTTagCompound compound)
    {
        NBTTagCompound properties = new NBTTagCompound();

        properties.setString("Race", this.race);
        properties.setInteger("CurrentKi", this.currentKi);
        properties.setInteger("MaxKi", this.maxKi);// possibly calculate the maxKi when a player loads to stop potential cheating with nbt data

        compound.setTag(IDENTIFIER, properties);
    }

    // Load whatever data you saved
    @Override
    public void loadNBTData(NBTTagCompound compound)
    {
        NBTTagCompound properties = (NBTTagCompound) compound.getTag(IDENTIFIER);
        this.race = properties.getString("Race");
        this.currentKi = properties.getInteger("CurrentKi");
        this.maxKi = properties.getInteger("MaxKi");
        System.out.println("[Dragon Ball Z] Current Ki for player from NBT: " + this.currentKi + "/" + this.maxKi);
    }

    @Override
    public void init(Entity entity, World world)
    {
    }

    // Extra custom methods to interact with data

    /**
     * Returns true if the amount of mana was consumed or false
     * if the player's current mana was insufficient
     */
    public boolean consumeKi(int amount)
    {
        // Does the player have enough ki?
        boolean sufficient = amount <= this.currentKi;
        // Consume the amount anyway; if it's more than the player's current ki,
        // ki will be set to 0
        this.currentKi -= (amount < this.currentKi ? amount : this.currentKi);
        // Return true if the player had enough ki
        return sufficient;
    }

    /**
     * Refill the entire Ki bar
     */
    public void replenishKi()
    {
        this.currentKi = this.maxKi;
    }
}