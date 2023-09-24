

package com.gibby.dungeon.mobs;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.village.*;
import net.minecraft.potion.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.monster.*;
import cpw.mods.fml.common.registry.*;
import com.gibby.dungeon.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;

public class EntityOreDealer extends EntityVillager
{
    private String[] villagerGreetings;
    private int randomTickDivider;
    private boolean isMating;
    private boolean isPlaying;
    Village villageObj;
    private EntityPlayer buyingPlayer;
    private MerchantRecipeList buyingList;
    private int timeUntilReset;
    private boolean needsInitilization;
    private int wealth;
    private String lastBuyingPlayer;
    private boolean isLookingForHome;
    private float field_82191_bN;
    public static final Map villagersSellingList;
    public static final Map blacksmithSellingList;

    public EntityOreDealer(final World par1World) {
        this(par1World, 0);
    }

    public EntityOreDealer(final World par1World, final int par2) {
        super(par1World);
        this.villagerGreetings = new String[] { "Welcome to our village", "Hi", "Hello traveler", "Hmm?", "Who are you?", "I have fantastic items for sale!" };
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
    }

    public boolean isAIEnabled() {
        return true;
    }

    protected void updateAITick() {
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            this.worldObj.villageCollectionObj.addVillagerPosition(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);
            if (this.villageObj == null) {
                this.detachHome();
            }
            else {
                final ChunkCoordinates chunkcoordinates = this.villageObj.getCenter();
                this.setHomeArea(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, (int)(this.villageObj.getVillageRadius() * 0.6f));
                if (this.isLookingForHome) {
                    this.isLookingForHome = false;
                    this.villageObj.setDefaultPlayerReputation(5);
                }
            }
        }
        if (!this.isTrading() && this.timeUntilReset > 0) {
            --this.timeUntilReset;
            if (this.timeUntilReset <= 0) {
                if (this.needsInitilization) {
                    if (this.buyingList.size() > 1) {
                        for (final Object obj : this.buyingList) {
                            if (obj instanceof MerchantRecipe) {
                                MerchantRecipe merchantrecipe = (MerchantRecipe) obj;
                            if (merchantrecipe.isRecipeDisabled()) {
                                merchantrecipe.func_82783_a(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                            }
                        }
                        }
                    }
                    this.addDefaultEquipmentAndRecipies(1);
                    this.needsInitilization = false;
                    if (this.villageObj != null && this.lastBuyingPlayer != null) {
                        this.worldObj.setEntityState((Entity)this, (byte)14);
                        this.villageObj.setReputationForPlayer(this.lastBuyingPlayer, 1);
                    }
                }
                this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
            }
        }
        super.updateAITick();
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        final ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        final boolean flag = itemstack != null && itemstack.getItem() == Items.spawn_egg;
        if (!flag && this.isEntityAlive() && !this.isTrading() && !this.isChild() && !par1EntityPlayer.isSneaking()) {
            if (!this.worldObj.isRemote) {
                this.setCustomer(par1EntityPlayer);
                par1EntityPlayer.addChatMessage((IChatComponent)new ChatComponentText("Merchant: " + this.villagerGreetings[this.rand.nextInt(6)]));
                par1EntityPlayer.displayGUIMerchant((IMerchant)this, this.getCustomNameTag());
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(31, (Object)0);
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Profession", this.getProfession());
        par1NBTTagCompound.setInteger("Riches", this.wealth);
        if (this.buyingList != null) {
            par1NBTTagCompound.setTag("Offers", (NBTBase)this.buyingList.getRecipiesAsTags());
        }
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setProfession(par1NBTTagCompound.getInteger("Profession"));
        this.wealth = par1NBTTagCompound.getInteger("Riches");
        if (par1NBTTagCompound.hasKey("Offers", 10)) {
            final NBTTagCompound nbttagcompound1 = par1NBTTagCompound.getCompoundTag("Offers");
            this.buyingList = new MerchantRecipeList(nbttagcompound1);
        }
    }

    protected boolean canDespawn() {
        return false;
    }

    protected String getLivingSound() {
        return this.isTrading() ? "mob.villager.haggle" : "mob.villager.idle";
    }

    protected String getHurtSound() {
        return "mob.villager.hit";
    }

    protected String getDeathSound() {
        return "mob.villager.death";
    }

    public void setProfession(final int par1) {
        this.dataWatcher.updateObject(16, (Object)par1);
    }

    public int getProfession() {
        return this.dataWatcher.getWatchableObjectInt(16);
    }

    public boolean isMating() {
        return this.isMating;
    }

    public void setMating(final boolean par1) {
        this.isMating = par1;
    }

    public void setPlaying(final boolean par1) {
        this.isPlaying = par1;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setRevengeTarget(final EntityLivingBase par1EntityLivingBase) {
        super.setRevengeTarget(par1EntityLivingBase);
        if (this.villageObj != null && par1EntityLivingBase != null) {
            this.villageObj.addOrRenewAgressor(par1EntityLivingBase);
            if (par1EntityLivingBase instanceof EntityPlayer) {
                byte b0 = -1;
                if (this.isChild()) {
                    b0 = -3;
                }
                this.villageObj.setReputationForPlayer(par1EntityLivingBase.getCommandSenderName(), (int)b0);
                if (this.isEntityAlive()) {
                    this.worldObj.setEntityState((Entity)this, (byte)13);
                }
            }
        }
    }

    public void onDeath(final DamageSource par1DamageSource) {
        if (this.villageObj != null) {
            final Entity entity = par1DamageSource.getEntity();
            if (entity != null) {
                if (entity instanceof EntityPlayer) {
                    this.villageObj.setReputationForPlayer(entity.getCommandSenderName(), -2);
                }
                else if (entity instanceof IMob) {
                    this.villageObj.endMatingSeason();
                }
            }
            else if (entity == null) {
                final EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity((Entity)this, 16.0);
                if (entityplayer != null) {
                    this.villageObj.endMatingSeason();
                }
            }
        }
        super.onDeath(par1DamageSource);
    }

    public void setCustomer(final EntityPlayer par1EntityPlayer) {
        this.buyingPlayer = par1EntityPlayer;
    }

    public EntityPlayer getCustomer() {
        return this.buyingPlayer;
    }

    public boolean isTrading() {
        return this.buyingPlayer != null;
    }

    public void useRecipe(final MerchantRecipe par1MerchantRecipe) {
        par1MerchantRecipe.incrementToolUses();
        this.livingSoundTime = -this.getTalkInterval();
        this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());
        if (par1MerchantRecipe.hasSameIDsAs((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1))) {
            this.timeUntilReset = 40;
            this.needsInitilization = true;
            if (this.buyingPlayer != null) {
                this.lastBuyingPlayer = this.buyingPlayer.getCommandSenderName();
            }
            else {
                this.lastBuyingPlayer = null;
            }
        }
        if (par1MerchantRecipe.getItemToBuy().getItem() == Items.emerald) {
            this.wealth += par1MerchantRecipe.getItemToBuy().stackSize;
        }
    }

    public void func_110297_a_(final ItemStack par1ItemStack) {
        if (!this.worldObj.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
            this.livingSoundTime = -this.getTalkInterval();
            if (par1ItemStack != null) {
                this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());
            }
            else {
                this.playSound("mob.villager.no", this.getSoundVolume(), this.getSoundPitch());
            }
        }
    }

    public MerchantRecipeList getRecipes(final EntityPlayer par1EntityPlayer) {
        if (this.buyingList == null) {
            this.addDefaultEquipmentAndRecipies(1 + this.rand.nextInt(6));
        }
        return this.buyingList;
    }

    private float adjustProbability(final float par1) {
        final float f1 = par1 + this.field_82191_bN;
        return (f1 > 0.9f) ? (0.9f - (f1 - 0.9f)) : f1;
    }

    private void addDefaultEquipmentAndRecipies(final int par1) {
        if (this.buyingList != null) {
            this.field_82191_bN = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2f;
        }
        else {
            this.field_82191_bN = 0.0f;
        }
        final MerchantRecipeList merchantrecipelist = new MerchantRecipeList();
        VillagerRegistry.manageVillagerTrades(merchantrecipelist, (EntityVillager)this, this.getProfession(), this.rand);
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.metalCoin, 1), new ItemStack(Items.redstone, 9)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.metalCoin, 4), new ItemStack(Items.diamond, 2)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.metalCoin, 2), new ItemStack(Items.iron_ingot, 14)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.metalCoin, 4), new ItemStack(Dungeons.bedrock, 2)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.metalCoin, 4), new ItemStack(Dungeons.ruby, 4)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.metalCoin, 3), new ItemStack(Dungeons.amazonite, 9)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.amazonite, 6 + this.rand.nextInt(6)), new ItemStack(Dungeons.metalCoin, 1)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.silver, 5 + this.rand.nextInt(4)), new ItemStack(Dungeons.metalCoin, 1)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Items.gold_ingot, 5 + this.rand.nextInt(4)), new ItemStack(Dungeons.metalCoin, 1)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.ruby, 3 + this.rand.nextInt(2)), new ItemStack(Dungeons.metalCoin, 1)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.amethyst, 2 + this.rand.nextInt(2)), new ItemStack(Dungeons.metalCoin, 1)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.lithium, 2 + this.rand.nextInt(2)), new ItemStack(Dungeons.metalCoin, 1)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.copper, 10 + this.rand.nextInt(5)), new ItemStack(Dungeons.metalCoin, 1)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Items.iron_ingot, 10 + this.rand.nextInt(5)), new ItemStack(Dungeons.metalCoin, 1)));
        merchantrecipelist.add((Object)new MerchantRecipe(new ItemStack(Dungeons.ruby, 3 + this.rand.nextInt(3)), new ItemStack(Dungeons.metalCoin, 1)));
        if (merchantrecipelist.isEmpty()) {
            func_146091_a(merchantrecipelist, Items.gold_ingot, this.rand, 1.0f);
        }
        Collections.shuffle((List<?>)merchantrecipelist);
        if (this.buyingList == null) {
            this.buyingList = new MerchantRecipeList();
        }
        for (int l = 0; l < par1 && l < merchantrecipelist.size(); ++l) {
            this.buyingList.addToListWithCheck((MerchantRecipe)merchantrecipelist.get(l));
        }
    }

    @SideOnly(Side.CLIENT)
    public void setRecipes(final MerchantRecipeList par1MerchantRecipeList) {
    }

    public static void func_146091_a(final MerchantRecipeList p_146091_0_, final Item p_146091_1_, final Random p_146091_2_, final float p_146091_3_) {
        if (p_146091_2_.nextFloat() < p_146091_3_) {
            p_146091_0_.add((Object)new MerchantRecipe(func_146088_a(p_146091_1_, p_146091_2_), Items.emerald));
        }
    }

    private static ItemStack func_146088_a(final Item p_146088_0_, final Random p_146088_1_) {
        return new ItemStack(p_146088_0_, func_146092_b(p_146088_0_, p_146088_1_), 0);
    }

    private static int func_146092_b(final Item p_146092_0_, final Random p_146092_1_) {
        final Tuple tuple = (Tuple) EntityOreDealer.villagersSellingList.get(p_146092_0_);
        return (int)((tuple == null) ? 1 : (((int)tuple.getFirst() >= (int)tuple.getSecond()) ? tuple.getFirst() : ((int)tuple.getFirst() + p_146092_1_.nextInt((int)tuple.getSecond() - (int)tuple.getFirst()))));
    }

    public static void func_146089_b(final MerchantRecipeList p_146089_0_, final Item p_146089_1_, final Random p_146089_2_, final float p_146089_3_) {
        if (p_146089_2_.nextFloat() < p_146089_3_) {
            final int i = func_146090_c(p_146089_1_, p_146089_2_);
            ItemStack itemstack;
            ItemStack itemstack2;
            if (i < 0) {
                itemstack = new ItemStack(Items.emerald, 1, 0);
                itemstack2 = new ItemStack(p_146089_1_, -i, 0);
            }
            else {
                itemstack = new ItemStack(Items.emerald, i, 0);
                itemstack2 = new ItemStack(p_146089_1_, 1, 0);
            }
            p_146089_0_.add((Object)new MerchantRecipe(itemstack, itemstack2));
        }
    }

    private static int func_146090_c(final Item p_146090_0_, final Random p_146090_1_) {
        final Tuple tuple = (Tuple) EntityOreDealer.blacksmithSellingList.get(p_146090_0_);
        return ((tuple == null) ? 1 : (((int)tuple.getFirst() >= (int)tuple.getSecond()) ? (int) tuple.getFirst() : ((int)tuple.getFirst() + p_146090_1_.nextInt((int)tuple.getSecond() - (int)tuple.getFirst()))));
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(final byte par1) {
        if (par1 == 12) {
            this.generateRandomParticles("heart");
        }
        else if (par1 == 13) {
            this.generateRandomParticles("angryVillager");
        }
        else if (par1 == 14) {
            this.generateRandomParticles("happyVillager");
        }
        else {
            super.handleHealthUpdate(par1);
        }
    }

    @SideOnly(Side.CLIENT)
    private void generateRandomParticles(final String par1Str) {
        for (int i = 0; i < 5; ++i) {
            final double d0 = this.rand.nextGaussian() * 0.02;
            final double d2 = this.rand.nextGaussian() * 0.02;
            final double d3 = this.rand.nextGaussian() * 0.02;
            this.worldObj.spawnParticle(par1Str, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 1.0 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, d0, d2, d3);
        }
    }

    public void setLookingForHome() {
        this.isLookingForHome = true;
    }

    public EntityOreDealer createChild(final EntityAgeable par1EntityAgeable) {
        final EntityOreDealer entityvillager = new EntityOreDealer(this.worldObj);
        entityvillager.onSpawnWithEgg((IEntityLivingData)null);
        return entityvillager;
    }

    public boolean allowLeashing() {
        return false;
    }

    static {
        villagersSellingList = new HashMap();
        blacksmithSellingList = new HashMap();
        EntityOreDealer.villagersSellingList.put(Dungeons.copper, new Tuple((Object)10, (Object)15));
        EntityOreDealer.villagersSellingList.put(Items.iron_ingot, new Tuple((Object)10, (Object)15));
        EntityOreDealer.villagersSellingList.put(Dungeons.ruby, new Tuple((Object)7, (Object)12));
        EntityOreDealer.villagersSellingList.put(Items.diamond, new Tuple((Object)2, (Object)2));
        EntityOreDealer.villagersSellingList.put(Dungeons.windStaff, new Tuple((Object)6, (Object)10));
        EntityOreDealer.villagersSellingList.put(Dungeons.shimmerPearl, new Tuple((Object)5, (Object)8));
        EntityOreDealer.villagersSellingList.put(Items.ender_pearl, new Tuple((Object)7, (Object)12));
        EntityOreDealer.villagersSellingList.put(Items.porkchop, new Tuple((Object)15, (Object)20));
        EntityOreDealer.villagersSellingList.put(Items.beef, new Tuple((Object)15, (Object)20));
        EntityOreDealer.villagersSellingList.put(Items.chicken, new Tuple((Object)15, (Object)20));
        EntityOreDealer.villagersSellingList.put(Items.melon_seeds, new Tuple((Object)30, (Object)38));
        EntityOreDealer.villagersSellingList.put(Items.pumpkin_seeds, new Tuple((Object)30, (Object)38));
        EntityOreDealer.blacksmithSellingList.put(Items.iron_helmet, new Tuple((Object)4, (Object)6));
        EntityOreDealer.blacksmithSellingList.put(Items.diamond_helmet, new Tuple((Object)7, (Object)8));
        EntityOreDealer.blacksmithSellingList.put(Items.iron_chestplate, new Tuple((Object)10, (Object)14));
        EntityOreDealer.blacksmithSellingList.put(Items.diamond_chestplate, new Tuple((Object)16, (Object)19));
        EntityOreDealer.blacksmithSellingList.put(Items.iron_leggings, new Tuple((Object)8, (Object)10));
        EntityOreDealer.blacksmithSellingList.put(Items.diamond_leggings, new Tuple((Object)11, (Object)14));
        EntityOreDealer.blacksmithSellingList.put(Dungeons.copper, new Tuple((Object)5, (Object)7));
        EntityOreDealer.blacksmithSellingList.put(Dungeons.silver, new Tuple((Object)5, (Object)7));
        EntityOreDealer.blacksmithSellingList.put(Items.blaze_powder, new Tuple((Object)11, (Object)15));
        EntityOreDealer.blacksmithSellingList.put(Items.slime_ball, new Tuple((Object)9, (Object)11));
    }
}
