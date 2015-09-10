package mods.b0bgary.b0bcraft.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="b0bcraft", name="B0bCraft", version=References.VERSION_NUMBER,dependencies = References.DEPENDENCIES)


public class B0bCraft {
	
	@Instance("B0bCraft")
	public static B0bCraft instance;
	
	
	public static final CreativeTabs test = new TabHandler("test", Item.getItemFromBlock(Blocks.dirt), "ur fat");
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
	}
    
    @EventHandler
	public void init(FMLInitializationEvent event) {
		
			ConfigHandler.initConfiguration(event);
			FMLLog.info("Jet fuel can't melt steel beams.");
			FMLLog.info("The moon landing was faked.");

			
			BRenderers.add();
			BTiles.add();
			BBlocks.add();
			BItems.add();
			Recipes.add();
			EventHandlers.add();
			
    }
    
    @EventHandler
   	public void postInit(FMLPostInitializationEvent event){
     	}
       
	
	

}
