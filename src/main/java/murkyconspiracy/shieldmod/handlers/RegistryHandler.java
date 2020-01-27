package murkyconspiracy.shieldmod.handlers;

import java.util.ArrayList;
import java.util.List;

import murkyconspiracy.shieldmod.config.MineableConfig;
import murkyconspiracy.shieldmod.config.NaturalConfig;
import murkyconspiracy.shieldmod.item.mineable.DiamondShield;
import murkyconspiracy.shieldmod.item.mineable.GoldShield;
import murkyconspiracy.shieldmod.item.mineable.IronShield;
import murkyconspiracy.shieldmod.item.mineable.ObsidianShield;
import murkyconspiracy.shieldmod.item.mineable.RedstoneShield;
import murkyconspiracy.shieldmod.item.mineable.StoneShield;
import murkyconspiracy.shieldmod.item.natural.BrickShield;
import murkyconspiracy.shieldmod.item.natural.ClayShield;
import murkyconspiracy.shieldmod.item.natural.DirtShield;
import murkyconspiracy.shieldmod.item.natural.GrassShield;
import murkyconspiracy.shieldmod.item.natural.LeatherShield;
import murkyconspiracy.shieldmod.item.natural.WoodenShield;
import murkyconspiracy.shieldmod.item.natural.WoolyShield;
import murkyconspiracy.shieldmod.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class RegistryHandler 
{
	private static List<Item> ItemRegistryList = new ArrayList<Item>();
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		handleMineables();
		handleNatural();
		event.getRegistry().registerAll(convertHandledArray(ItemRegistryList));
		
	}
	
	private static void handleMineables()
	{
		if(MineableConfig.mineable_shields_enabled.get())
		{
			if(MineableConfig.diamond_shield_enable.get())
				ItemRegistryList.add(ItemList.diamond_shield = new DiamondShield());
			
			if(MineableConfig.gold_shield_enable.get())
				ItemRegistryList.add(ItemList.gold_shield = new GoldShield());
			
			if(MineableConfig.iron_shield_enable.get())
				ItemRegistryList.add(ItemList.iron_shield = new IronShield());
			
			if(MineableConfig.obsidian_shield_enable.get())
				ItemRegistryList.add(ItemList.obsidian_shield = new ObsidianShield());
			
			if(MineableConfig.redstone_shield_enable.get())
				ItemRegistryList.add(ItemList.redstone_shield = new RedstoneShield());
			
			if(MineableConfig.stone_shield_enable.get())
				ItemRegistryList.add(ItemList.stone_shield = new StoneShield());
		}
	}
	
	private static void handleNatural()
	{
		
		if(NaturalConfig.natural_shields_enable.get())
		{
			
			if(NaturalConfig.brick_shield_enable.get())
				ItemRegistryList.add(ItemList.brick_shield = new BrickShield());
			
			if(NaturalConfig.clay_shield_enable.get())
				ItemRegistryList.add(ItemList.clay_shield = new ClayShield());
			
			if(NaturalConfig.dirt_shield_enable.get())
				ItemRegistryList.add(ItemList.dirt_shield = new DirtShield());
			
			if(NaturalConfig.grass_shield_enable.get())
				ItemRegistryList.add(ItemList.grass_shield = new GrassShield());
			
			if(NaturalConfig.leather_shield_enable.get())
				ItemRegistryList.add(ItemList.leather_shield = new LeatherShield());
			
			if(NaturalConfig.wooden_shield_enable.get())
				ItemRegistryList.add(ItemList.wooden_shield = new WoodenShield());
			
			if(NaturalConfig.wooly_shield_enable.get())
				ItemRegistryList.add(ItemList.wooly_shield = new WoolyShield());
			
		}
		
	}
	
	private static Item[] convertHandledArray(List<Item> list)
	{
		Item[] items = new Item[list.size()];
		
		for(int i = 0; i < items.length; i++)
		{
			items[i] = list.get(i);
		}
		
		return items;
	}
	
}
