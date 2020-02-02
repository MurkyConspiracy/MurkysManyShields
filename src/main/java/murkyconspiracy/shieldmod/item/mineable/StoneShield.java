package murkyconspiracy.shieldmod.item.mineable;

import murkyconspiracy.shieldmod.ShieldMod;
import murkyconspiracy.shieldmod.config.MineableConfig;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class StoneShield extends Item {
	
	static Properties properties = new Properties().group(ShieldMod.shieldmodIG).maxDamage(MineableConfig.stone_shield_durability.get());
	public StoneShield() {
		super(properties);
		this.setRegistryName(new ResourceLocation(ShieldMod.modid, "stoneshield"));
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
	public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
		player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 0, 1));
		player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 0, 0));
		super.onUsingTick(stack, player, count);
	}
	
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(entityIn.isLiving())
			if(isSelected || ((LivingEntity)entityIn).getHeldItemOffhand() == stack)
				((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 0, 0));
	}
	
	@Override
	public int getUseDuration(ItemStack stack) {
		return 500;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		playerIn.setActiveHand(handIn);
		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return ItemTags.STONE_BRICKS.contains(repair.getItem()) || super.getIsRepairable(toRepair, repair);
	}
    
    @Override
    public boolean isShield(ItemStack stack, LivingEntity entity) {
    	return true;
    }
	
}
