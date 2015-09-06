package mods.b0bgary.b0bcraft.core;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class ConfigHandler {
	
	 @EventHandler
	public static void initConfiguration(FMLInitializationEvent event){
		Configuration config = new Configuration(new File("config/B0bCraft/main.cfg"));
		config.load();
	
	
	
		config.save();
	}

}
