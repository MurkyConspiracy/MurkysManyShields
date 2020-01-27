package murkyconspiracy.shieldmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MineableConfig 
{
	
	public static ForgeConfigSpec.BooleanValue mineable_shields_enabled, 
	diamond_shield_enable, 
	gold_shield_enable, 
	iron_shield_enable, 
	obsidian_shield_enable, 
	redstone_shield_enable, 
	stone_shield_enable;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client ) 
	{
		server.comment("Mineable Shields config:");
		
		mineable_shields_enabled = server.comment("Enable Mineable Shields?")
				.define("mineable.enable", true);
		
		diamond_shield_enable = server.comment("Enable Diamond Shields?")
				.define("diamond.enable", true);
		
		gold_shield_enable = server.comment("Enable Gold Shields?")
				.define("gold.enable", true);
		
		iron_shield_enable = server.comment("Enable Iron Shields?")
				.define("iron.enable", true);
		
		obsidian_shield_enable = server.comment("Enable Obsidian Shields?")
				.define("obsidian.enable", true);
		
		redstone_shield_enable = server.comment("Enable Redstone Shields?")
				.define("redstone.enable", true);
		
		stone_shield_enable = server.comment("Enable Stone Shields?")
				.define("stone.enable", true);
	}
	
}
