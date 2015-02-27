package com.dragonballzmod.entity;

import com.dragonballzmod.particles.EntityColouredSmokeFX;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFlyingNimbus extends Entity {
 //   private static final String __OBFID = "CL_00001667";
    /**
     * true if no player in boat
     */
    private boolean isBoatEmpty;
    private double speedMultiplier;
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    @SideOnly(Side.CLIENT)
    private double velocityX;
    @SideOnly(Side.CLIENT)
    private double velocityY;
    @SideOnly(Side.CLIENT)
    private double velocityZ;

    private static final String __OBFID = "CL_00001667";

    public EntityFlyingNimbus(World p_i1704_1_) {
        super(p_i1704_1_);
        this.isBoatEmpty = true;
        this.speedMultiplier = 0.07D;
        this.preventEntitySpawning = true;
        this.setSize(1.5F, 0.6F);
        this.yOffset = this.height / 2.0F;
    }

  /**  protected boolean func_70041_e_()
    {
        return false;
    }

    protected void func_70088_a()
    {
        this.field_70180_af.func_75682_a(17, new Integer(0));
        this.field_70180_af.func_75682_a(18, new Integer(1));
        this.field_70180_af.func_75682_a(19, new Float(0.0F));
    }

    public AxisAlignedBB func_70114_g(Entity p_70114_1_)
    {
        return p_70114_1_.field_70121_D;
    }

    public AxisAlignedBB func_70046_E()
    {
        return this.field_70121_D;
    }

    public boolean func_70104_M()
    {
        return false;
    } **/

    public EntityFlyingNimbus(World p_i1705_1_, double p_i1705_2_, double p_i1705_4_, double p_i1705_6_) {
        this(p_i1705_1_);
        this.setPosition(p_i1705_2_, p_i1705_4_ + (double) this.yOffset, p_i1705_6_);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = p_i1705_2_;
        this.prevPosY = p_i1705_4_;
        this.prevPosZ = p_i1705_6_;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking() {
        return false;
    }

    protected void entityInit() {
        this.dataWatcher.addObject(17, new Integer(0));
        this.dataWatcher.addObject(18, new Integer(1));
        this.dataWatcher.addObject(19, new Float(0.0F));
    }

    /**
     * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
     * pushable on contact, like boats or minecarts.
     */
    public AxisAlignedBB getCollisionBox(Entity p_70114_1_) {
        return p_70114_1_.boundingBox;
    }

    /**
     * returns the bounding box for this entity
     */
    public AxisAlignedBB getBoundingBox() {
        return this.boundingBox;
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed() {
        return false;
    }

    /**
     * Returns the Y offset from the entity's position for any entity riding this one.
     */
    public double getMountedYOffset() {
        return 0.3D;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
        if (this.isEntityInvulnerable()) {
            return false;
        } else if (!this.worldObj.isRemote && !this.isDead) {
            this.setDead();

            return true;
        } else {
            return true;
        }
    }

    /**
     * Setups the entity to do the hurt animation. Only used by packets in multiplayer.
     */
    @SideOnly(Side.CLIENT)
    public void performHurtAnimation() {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0F);
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    /**
     * Sets the position and rotation. Only difference from the other one is no bounding on the rotation. Args: posX,
     * posY, posZ, yaw, pitch
     */
    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
        if (this.isBoatEmpty) {
            this.boatPosRotationIncrements = p_70056_9_ + 5;
        } else {
            double d3 = p_70056_1_ - this.posX;
            double d4 = p_70056_3_ - this.posY;
            double d5 = p_70056_5_ - this.posZ;
            double d6 = d3 * d3 + d4 * d4 + d5 * d5;

            if (d6 <= 1.0D) {
                return;
            }

            this.boatPosRotationIncrements = 3;
        }

        this.boatX = p_70056_1_;
        this.boatY = p_70056_3_;
        this.boatZ = p_70056_5_;
        this.boatYaw = (double) p_70056_7_;
        this.boatPitch = (double) p_70056_8_;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }

    /**
     * Sets the velocity to the args. Args: x, y, z
     */
    @SideOnly(Side.CLIENT)
    public void setVelocity(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
        this.velocityX = this.motionX = p_70016_1_;
        this.velocityY = this.motionY = p_70016_3_;
        this.velocityZ = this.motionZ = p_70016_5_;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate() {
        super.onUpdate();

        this.motionY = 0;

        this.posY = this.prevPosY;

        /** for(int i = 0; i < 15; i++)
         {
         double particleX = Math.random() * 1.5 - 0.75;
         double particleY = (Math.random()) * 0.5 - 0.2F;
         double particleZ = Math.random() * 1.5 - 0.75;
         Minecraft.getMinecraft().effectRenderer.addEffect(new EntityColouredSmokeFX(this.worldObj, prevPosX + particleX, prevPosY + particleY, prevPosZ + particleZ, 0, 0, 0, 1F, 1F, 0.0F));
         }*/
        if(this.worldObj.isRemote) {
            for (int i = 0; i < 15; i++) {
                double particleX = Math.random() * 1.5 - 0.75;
                double particleY = (Math.random()) * 0.5 - 0.2F;
                double particleZ = Math.random() * 1.5 - 0.75;
                double multi = 10D;
                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityColouredSmokeFX(this.worldObj, posX + particleX - motionX * multi, posY + particleY - motionY * multi, posZ + particleZ - motionZ * multi, 0, 0, 0, 1F, 1F, 0.0F));
            }

            for (int i = 0; i < 6; i++) {
                double particleX = Math.random() * 1.5 - 0.75;
                double particleY = (Math.random()) * 0.5 - 0.2F;
                double particleZ = Math.random() * 1.5 - 0.75;
                double multi = 10D;
                Minecraft.getMinecraft().effectRenderer.addEffect(new EntityColouredSmokeFX(this.worldObj, posX + particleX - motionX * multi, posY + particleY - motionY * multi, posZ + particleZ - motionZ * multi, 0, 0, 0, 1F, 1F - (float) (Math.random() * 0.2F), 0.0F));
            }
        }

        if (this.getTimeSinceHit() > 0) {
            this.setTimeSinceHit(this.getTimeSinceHit() - 1);
        }

        if (this.getDamageTaken() > 0.0F) {
            this.setDamageTaken(this.getDamageTaken() - 1.0F);
        }

        this.prevPosX = this.posX;
        this.prevPosZ = this.posZ;
        byte b0 = 5;
        double d0 = 0.0D;

        double d10 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        double d2;
        double d4;
        int j;

        /**if (d10 > 0.26249999999999996D)
         {
         d2 = Math.cos((double)this.rotationYaw * Math.PI / 180.0D);
         d4 = Math.sin((double)this.rotationYaw * Math.PI / 180.0D);

         for (j = 0; (double)j < 1.0D + d10 * 60.0D; ++j)
         {
         double d5 = (double)(this.rand.nextFloat() * 2.0F - 1.0F);
         double d6 = (double)(this.rand.nextInt(2) * 2 - 1) * 0.7D;
         double d8;
         double d9;

         if (this.rand.nextBoolean())
         {
         d8 = this.posX - d2 * d5 * 0.8D + d4 * d6;
         d9 = this.posZ - d4 * d5 * 0.8D - d2 * d6;
         this.worldObj.spawnParticle("splash", d8, this.posY - 0.125D, d9, this.motionX, this.motionY, this.motionZ);
         }
         else
         {
         d8 = this.posX + d2 + d4 * d5 * 0.7D;
         d9 = this.posZ + d4 - d2 * d5 * 0.7D;
         this.worldObj.spawnParticle("splash", d8, this.posY - 0.125D, d9, this.motionX, this.motionY, this.motionZ);
         }
         }
         }*/

        double d11;
        double d12;

        if (this.worldObj.isRemote && this.isBoatEmpty) {
            if (this.boatPosRotationIncrements > 0) {
                d2 = this.posX + (this.boatX - this.posX) / (double) this.boatPosRotationIncrements;
                d4 = this.posY + (this.boatY - this.posY) / (double) this.boatPosRotationIncrements;
                d11 = this.posZ + (this.boatZ - this.posZ) / (double) this.boatPosRotationIncrements;
                d12 = MathHelper.wrapAngleTo180_double(this.boatYaw - (double) this.rotationYaw);
                this.rotationYaw = (float) ((double) this.rotationYaw + d12 / (double) this.boatPosRotationIncrements);
                this.rotationPitch = (float) ((double) this.rotationPitch + (this.boatPitch - (double) this.rotationPitch) / (double) this.boatPosRotationIncrements);
                --this.boatPosRotationIncrements;
                this.setPosition(d2, d4, d11);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            } else {
                d2 = this.posX + this.motionX;
                d4 = this.posY + this.motionY;
                d11 = this.posZ + this.motionZ;
                this.setPosition(d2, d4, d11);

                if (this.onGround) {
                    this.motionX *= 0.5D;
                    this.motionY *= 0.5D;
                    this.motionZ *= 0.5D;
                }

                this.motionX *= 0.9900000095367432D;
                this.motionY *= 0.949999988079071D;
                this.motionZ *= 0.9900000095367432D;
            }
        } else {
            if (d0 < 1.0D) {
                d2 = d0 * 2.0D - 1.0D;
                this.motionY += 0.03999999910593033D * d2;
            } else {
                if (this.motionY < 0.0D) {
                    this.motionY /= 2.0D;
                }

                this.motionY += 0.007000000216066837D;
            }

            if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase) {
                EntityLivingBase entitylivingbase = (EntityLivingBase) this.riddenByEntity;
                float f = this.riddenByEntity.rotationYaw + -entitylivingbase.moveStrafing * 90.0F;
                this.motionY = -this.riddenByEntity.rotationPitch * this.speedMultiplier * (double) entitylivingbase.moveForward * 0.03D;
                if (this.riddenByEntity.rotationPitch > 0) {
                    this.motionX = -Math.sin((double) (f * (float) Math.PI / 180.0F)) * this.speedMultiplier * (double) entitylivingbase.moveForward * 1.5000000074505806D * (1 - (this.riddenByEntity.rotationPitch / 90));
                    this.motionZ = Math.cos((double) (f * (float) Math.PI / 180.0F)) * this.speedMultiplier * (double) entitylivingbase.moveForward * 1.5000000074505806D * (1 - (this.riddenByEntity.rotationPitch / 90));
                } else {
                    this.motionX = -Math.sin((double) (f * (float) Math.PI / 180.0F)) * this.speedMultiplier * (double) entitylivingbase.moveForward * 1.5000000074505806D * (1 - (this.riddenByEntity.rotationPitch / -90));
                    this.motionZ = Math.cos((double) (f * (float) Math.PI / 180.0F)) * this.speedMultiplier * (double) entitylivingbase.moveForward * 1.5000000074505806D * (1 - (this.riddenByEntity.rotationPitch / -90));
                }
            }

            if (this.inWater) {
                this.motionY += 2;
            }

            d2 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

            if (d2 > 0.35D) {
                d4 = 0.35D / d2;
                this.motionX *= d4;
                this.motionZ *= d4;
                d2 = 0.35D;
            }

            if (d2 > d10 && this.speedMultiplier < 0.35D) {
                this.speedMultiplier += (0.35D - this.speedMultiplier) / 35.0D;

                if (this.speedMultiplier > 0.35D) {
                    this.speedMultiplier = 0.35D;
                }
            } else {
                this.speedMultiplier -= (this.speedMultiplier - 0.07D) / 35.0D;

                if (this.speedMultiplier < 0.07D) {
                    this.speedMultiplier = 0.07D;
                }
            }

            int l;

            for (l = 0; l < 4; ++l) {
                int i1 = MathHelper.floor_double(this.posX + ((double) (l % 2) - 0.5D) * 0.8D);
                j = MathHelper.floor_double(this.posZ + ((double) (l / 2) - 0.5D) * 0.8D);

                for (int j1 = 0; j1 < 2; ++j1) {
                    int k = MathHelper.floor_double(this.posY) + j1;
                    Block block = this.worldObj.getBlock(i1, k, j);

                    if (block == Blocks.snow_layer) {
                        this.worldObj.setBlockToAir(i1, k, j);
                        this.isCollidedHorizontally = false;
                    } else if (block == Blocks.waterlily) {
                        this.worldObj.func_147480_a(i1, k, j, true);
                        this.isCollidedHorizontally = false;
                    }
                }
            }
            this.posY = this.prevPosY;
            if (this.riddenByEntity == null) {
                motionX = 0;
                motionY = 0;
                motionZ = 0;
            }

            this.moveEntity(this.motionX * 2, this.motionY, this.motionZ * 2);


            this.posY += 0.00D;
            //this.motionY = this.velocityY = 0.2D;
            this.fallDistance = 0;


            this.motionX *= 0.9900000095367432D;
            this.motionY *= 0.949999988079071D;
            this.motionZ *= 0.9900000095367432D;

            this.rotationPitch = 0.0F;
            d4 = (double) this.rotationYaw;
            d11 = this.prevPosX - this.posX;
            d12 = this.prevPosZ - this.posZ;

            if (d11 * d11 + d12 * d12 > 0.001D) {
                d4 = (double) ((float) (Math.atan2(d12, d11) * 180.0D / Math.PI));
            }

            double d7 = MathHelper.wrapAngleTo180_double(d4 - (double) this.rotationYaw);

            if (d7 > 20.0D) {
                d7 = 20.0D;
            }

            if (d7 < -20.0D) {
                d7 = -20.0D;
            }

            this.rotationYaw = (float) ((double) this.rotationYaw + d7);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }

    }

    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ);
        }
    }


    /**public void updateRiderPosition()
     {
     if (this.riddenByEntity != null)
     {
     this.riddenByEntity.setPosition(this.posX, this.posY + 1.3D, this.posZ);
     }
     } **/

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize() {
        return 0.0F;
    }

    /**
     * First layer of player interaction
     */
    public boolean interactFirst(EntityPlayer p_130002_1_) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != p_130002_1_) {
            return true;
        } else {
            if (!this.worldObj.isRemote) {
                p_130002_1_.mountEntity(this);
            }

            return true;
        }
    }

    /**
     * Takes in the distance the entity has fallen this tick and whether its on the ground to update the fall distance
     * and deal fall damage if landing on the ground.  Args: distanceFallenThisTick, onGround
     */
    protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
        this.fallDistance = 0;
    }

    /**
     * Gets the damage taken from the last hit.
     */
    public float getDamageTaken() {
        return this.dataWatcher.getWatchableObjectFloat(19);
    }

    /**
     * Sets the damage taken from the last hit.
     */
    public void setDamageTaken(float p_70266_1_) {
        this.dataWatcher.updateObject(19, Float.valueOf(p_70266_1_));
    }

    /**
     * Gets the time since the last hit.
     */
    public int getTimeSinceHit() {
        return this.dataWatcher.getWatchableObjectInt(17);
    }

    /**
     * Sets the time to count down from since the last time entity was hit.
     */
    public void setTimeSinceHit(int p_70265_1_) {
        this.dataWatcher.updateObject(17, Integer.valueOf(p_70265_1_));
    }

    /**
     * Gets the forward direction of the entity.
     */
    public int getForwardDirection() {
        return this.dataWatcher.getWatchableObjectInt(18);
    }

    /**
     * Sets the forward direction of the entity.
     */
    public void setForwardDirection(int p_70269_1_) {
        this.dataWatcher.updateObject(18, Integer.valueOf(p_70269_1_));
    }

    /**
     * true if no player in boat
     */
    @SideOnly(Side.CLIENT)
    public void setIsBoatEmpty(boolean p_70270_1_) {
        this.isBoatEmpty = p_70270_1_;
    }
}