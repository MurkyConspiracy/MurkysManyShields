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
	
	public static ForgeConfigSpec.IntValue
	diamond_shield_durability,
	gold_shield_durability,
	iron_shield_durability,
	obsidian_shield_durability,
	redstone_shield_durability,
	stone_shield_durability;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client ) 
	{
		
		server
		.comment("Mineable Shields config:")
		.push("Mineable");
		
		mineable_shields_enabled = server
				.comment("Enable Mineable Shields?")
				.define("mineable_enable", true);
		
		server
			.comment("Configure Diamond Shield")
			.push("Diamond Shield");
		
		diamond_shield_enable = server
				.comment("Enable Diamond Shields?")
				.define("diamond_enable", true);
		
		diamond_shield_durability = server
				.comment("Diamond Shield Durability: ")
				.defineInRange("diamond_durability", 1050, 15, 100000);
		
		server.pop();
		
		server
			.comment("Configure Gold Shield")
			.push("Gold Shield");
		
		gold_shield_enable = server
				.comment("Enable Gold Shields?")
				.define("gold_enable", true);
		
		gold_shield_durability = server
				.comment("Gold Shield Durability: ")
				.defineInRange("gold_durability", 150, 15, 100000);
		
		server.pop();
		
		server
			.comment("Configure Iron Shield")
			.push("Iron Shield");
		
		iron_shield_enable = server
				.comment("Enable Iron Shields?")
				.define("iron_enable", true);
		
		iron_shield_durability = server
				.comment("Iron Shield Durability: ")
				.defineInRange("iron_durability", 600, 15, 100000);
		
		server.pop();
		
		server
			.comment("Configure Obsidian Shield")
			.push("Obsidian Shield");
		
		obsidian_shield_enable = server
				.comment("Enable Obsidian Shields?")
				.define("obsidian_enable", true);
		
		obsidian_shield_durability = server
				.comment("Obsidian Shield Durability: ")
				.defineInRange("obsidian_durability", -1, 15, 100000);
		
		server.pop();
		
		server
			.comment("Configure Redstone Shield")
			.push("Redstone Shield");
		
		redstone_shield_enable = server
				.comment("Enable Redstone Shields?")
				.define("redstone_enable", true);
		
		redstone_shield_durability = server
				.comment("Redstone Shield Durability: ")
				.defineInRange("redstone_durability", 850, 15, 100000);
		
		server.pop();
		
		server
			.comment("Configure Stone Shield")
			.push("Stone Shield");
		
		stone_shield_enable = server
				.comment("Enable Stone Shields?")
				.define("stone_enable", true);
		
		stone_shield_durability = server
				.comment("Stone Shield Durability: ")
				.defineInRange("stone_durability", 450, 15, 100000);
		
		server.pop();
		
		server.pop();
		
	}
	
}
