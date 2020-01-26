package murkyconspiracy.shieldmod.handlers;

import murkyconspiracy.shieldmod.item.DiamondShield;
import murkyconspiracy.shieldmod.item.GoldShield;
import murkyconspiracy.shieldmod.item.IronShield;
import murkyconspiracy.shieldmod.item.ObsidianShield;
import murkyconspiracy.shieldmod.item.RedstoneShield;
import murkyconspiracy.shieldmod.item.StoneShield;
import murkyconspiracy.shieldmod.item.WoodenShield;
import murkyconspiracy.shieldmod.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class RegistryHandler 
{
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(
		ItemList.wooden_shield = new WoodenShield(),
		ItemList.stone_shield = new StoneShield(),
		ItemList.iron_shield = new IronShield(),
		ItemList.redstone_shield = new RedstoneShield(),
		ItemList.gold_shield = new GoldShield(),
		ItemList.diamond_shield = new DiamondShield(),
		ItemList.obsidian_shield = new ObsidianShield()
		
		);
		
	}
	
}
