package mods.b0bgary.b0bcraft.core;

import mods.b0bgary.b0bcraft.items.ItemBFoodSeed;
import mods.b0bgary.b0bcraft.items.ItemBSeed;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class BItems {
	
	public static Item itemSeed;
	
	public static Item itemSeedFood;
	
	public static void add(){
		
		itemSeed=new ItemBSeed(BBlocks.fertile, "itemSeed");
		GameRegistry.registerItem(itemSeed, "itemSeed");
		
		itemSeedFood=new ItemBFoodSeed(0, 0F, BBlocks.blockTest, BBlocks.fertile, "test");
		GameRegistry.registerItem(itemSeedFood, "itemSeedFood");
	}

}
