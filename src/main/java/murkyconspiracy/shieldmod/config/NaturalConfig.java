package murkyconspiracy.shieldmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class NaturalConfig 
{
	public static ForgeConfigSpec.BooleanValue 
	natural_shields_enable,
	brick_shield_enable,
	clay_shield_enable,
	dirt_shield_enable,
	grass_shield_enable,
	leather_shield_enable,
	wooden_shield_enable,
	wooly_shield_enable;
	
	public static ForgeConfigSpec.IntValue
	brick_shield_durability,
	clay_shield_durability,
	dirt_shield_durability,
	grass_shield_durability,
	leather_shield_durability,
	wooden_shield_durability,
	wooly_shield_durability;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client ) 
	{
		
		
		server
			.comment("Natural Shield Config")
			.push("Natural");
		
		natural_shields_enable = server
				.comment("Enable Natural Shields?")
				.define("natural_enable", true);
		
		server
			.comment("Configure Brick Shield")
			.push("Brick Shield");
		
		brick_shield_enable = server
				.comment("Enable Brick Shields?")
				.define("brick_enable", true);
		
		brick_shield_durability = server
				.comment("Brick Shield Durability")
				.defineInRange("brick_durability", 450, 15, 100000);
		
		server.pop();
		
		server
			.comment("Configure Clay Shield")
			.push("Clay Shield");
		
		clay_shield_enable = server
				.comment("Enable Clay Shields?")
				.define("clay_enable", true);
		
		clay_shield_durability = server
				.comment("Clay Shield Durability")
				.defineInRange("clay_durability", 150, 0, 100000);
		
		server.pop();
		
		server
			.comment("Configure Dirt Shield")
			.push("Dirt Sheld");
		
		dirt_shield_enable = server
				.comment("Enable Dirt Shields?")
				.define("dirt_enable", true);
		
		dirt_shield_durability = server
				.comment("Dirt Shield Durability")
				.defineInRange("dirt_durability", 15, 15, 100000);
		
		server.pop();
		
		server
			.comment("Configure Grass Shield")
			.push("Grass Shield");
		
		grass_shield_enable = server
				.comment("Enable Grass Shields?")
				.define("grass_enable", true);
		
		grass_shield_durability = server
				.comment("Grass Shield Durability)")
				.defineInRange("grass_durability", 35, 15, 100000);
		
		server.pop();
		
		server
			.comment("Configure Leather Shield")
			.push("Leather Shield");
		
		leather_shield_enable = server
				.comment("Enable leather Shields?")
				.define("leather_enable", true);
		
		leather_shield_durability = server
				.comment("Leather Shield Durability")
				.defineInRange("leather_durability", 350, 15, 100000);
		
		server.pop();
		
		server
			.comment("Configure Wooden Shield")
			.push("Wooden Shield");

		wooden_shield_enable = server
				.comment("Enable Wooden Shields?")
				.define("wood_enable", true);
		
		wooden_shield_durability = server
				.comment("Wooden Shield Durability")
				.defineInRange("wood_durability", 250, 15, 100000);
		
		server.pop();
		
		server
			.comment("Configure Wooly Shield")
			.push("Wooly Shield");
		
		wooly_shield_enable = server
				.comment("Enable Wooly Shields?")
				.define("wooly_enable", true);
		
		wooly_shield_durability = server
				.comment("Wooly Shield Durability")
				.defineInRange("wooly_durability", 95, 15, 100000);
		
		server.pop(2);
		
	}
}
