package murkyconspiracy.shieldmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class NaturalConfig 
{
	public static ForgeConfigSpec.BooleanValue natural_shields_enable,
	brick_shield_enable,
	clay_shield_enable,
	dirt_shield_enable,
	grass_shield_enable,
	leather_shield_enable,
	wooden_shield_enable,
	wooly_shield_enable;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client ) 
	{
		
		server.comment("Natural Shields config:");
		
		server.push("Natural");
		
		natural_shields_enable = server.comment("Enable Natural Shields?")
				.define("natural.enable", true);
		
		brick_shield_enable = server.comment("Enable Brick Shields?")
				.define("brick.enable", true);
		
		clay_shield_enable = server.comment("Enable Clay Shields?")
				.define("clay.enable", true);
		
		dirt_shield_enable = server.comment("Enable Dirt Shields?")
				.define("dirt.enable", true);
		
		grass_shield_enable = server.comment("Enable Grass Shields?")
				.define("grass.enable", true);
		
		leather_shield_enable = server.comment("Enable leather Shields?")
				.define("leather.enable", true);

		wooden_shield_enable = server.comment("Enable Wooden Shields?")
				.define("wood.enable", true);
		
		wooly_shield_enable = server.comment("Enable Wooly Shields?")
				.define("wooly.enable", true);
		
		server.pop();
	}
}
