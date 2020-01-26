package murkyconspiracy.shieldmod.handlers;

import murkyconspiracy.shieldmod.item.mineable.*;
import murkyconspiracy.shieldmod.item.natural.*;
import murkyconspiracy.shieldmod.lists.ItemList;
import net.minecraft.item.Item;
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
				
				
				//Mineable Shields
				ItemList.diamond_shield = new DiamondShield(),
				ItemList.gold_shield = new GoldShield(),
				ItemList.iron_shield = new IronShield(),
				ItemList.obsidian_shield = new ObsidianShield(),
				ItemList.redstone_shield = new RedstoneShield(),
				ItemList.stone_shield = new StoneShield(),
				
				
				//Natural Shelds
				ItemList.brick_shield = new BrickShield(),
				ItemList.clay_shield = new ClayShield(),
				ItemList.dirt_shield = new DirtShield(),
				ItemList.grass_shield = new GrassShield(),
				ItemList.leather_shield = new LeatherShield(),
				ItemList.wooden_shield = new WoodenShield(),
				ItemList.wooly_shield = new WoolyShield()
				

		
		);
		
	}
	
}
