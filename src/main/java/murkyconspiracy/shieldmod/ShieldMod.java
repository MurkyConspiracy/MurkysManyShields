package murkyconspiracy.shieldmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import murkyconspiracy.shieldmod.config.Config;
import murkyconspiracy.shieldmod.handlers.RegistryHandler;
import murkyconspiracy.shieldmod.handlers.ShieldModItemGroup; 
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("shieldmod")
public class ShieldMod 
{
	
	public static ShieldMod instance;
	
	public static final String modid = "shieldmod";
	public static final ItemGroup shieldmodIG = new ShieldModItemGroup();
	
	public static final Logger logger = LogManager.getLogger(modid);
	
	public ShieldMod() 
	{
		
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config);

		Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("shieldmod-server.toml").toString());
		Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("shieldmod-client.toml").toString());
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{

	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	private static class RegistryEvents
	{
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{RegistryHandler.registerItems(event);}
				
	}
}
