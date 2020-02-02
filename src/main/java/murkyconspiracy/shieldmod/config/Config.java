package murkyconspiracy.shieldmod.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import murkyconspiracy.shieldmod.ShieldMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class Config 
{

	private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec server_config;
	private static final ForgeConfigSpec.Builder client_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec client_config;
	
	static
	{
		
		MineableConfig.init(server_builder, client_builder);
		NaturalConfig.init(server_builder, client_builder);
		
		server_config = server_builder.build();
		client_config = client_builder.build();
		
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		ShieldMod.logger.info("Loading configurations for Murky\'s Many Shields: " + path);
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).preserveInsertionOrder().build();
		ShieldMod.logger.info("Build config: " + path);
		file.load();
		ShieldMod.logger.info("Config loaded: " + path);
		config.setConfig(file);
		
	}
	
}
