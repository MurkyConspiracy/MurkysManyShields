package murkyconspiracy.shieldmod.item.mineable;

import java.util.Random;
import java.util.function.Consumer;

import murkyconspiracy.shieldmod.ShieldMod;
import murkyconspiracy.shieldmod.config.MineableConfig;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RedstoneShield extends Item {
	
	static Properties properties = new Properties().group(ShieldMod.shieldmodIG).maxDamage(MineableConfig.redstone_shield_durability.get()).setNoRepair();
	public RedstoneShield() {
		super(properties);
		this.setRegistryName(new ResourceLocation(ShieldMod.modid, "redstoneshield"));
		this.addPropertyOverride(new ResourceLocation("blocking"), (p_210314_0_, p_210314_1_, p_210314_2_) -> {
	         return p_210314_2_ != null && p_210314_2_.isHandActive() && p_210314_2_.getActiveItemStack() == p_210314_0_ ? 1.0F : 0.0F;
	      });
	      DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BLOCK;
	}	
	
	@Override
	public int getUseDuration(ItemStack stack) {
		return 350;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		playerIn.setActiveHand(handIn);
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem().equals(Items.REDSTONE_BLOCK);
	}
    
    @Override
    public boolean isShield(ItemStack stack, LivingEntity entity) {
    	return true;
    }
    
    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
    	if(entity.getType() == EntityType.PLAYER)
    	{
    		PlayerEntity player = (PlayerEntity)entity;
    		if(player.inventory.count(Items.REDSTONE)>=1)
    		{
    			int i = player.inventory.getSlotFor(new ItemStack(Items.REDSTONE));
    			player.inventory.getStackInSlot(i).shrink(1);
    			player.addPotionEffect(new EffectInstance(Effects.SPEED, 45, 1));
    			if(new Random().nextBoolean())
    				return super.damageItem(stack, amount, entity, onBroken);
    			else
    				return stack.getDamage();
    		}
    	}
    	return super.damageItem(stack, amount, entity, onBroken);
    }
	
}
