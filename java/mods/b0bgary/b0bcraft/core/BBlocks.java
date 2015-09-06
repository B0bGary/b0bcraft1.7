package mods.b0bgary.b0bcraft.core;

import mods.b0bgary.b0bcraft.blocks.BlockBCrop;
import mods.b0bgary.b0bcraft.blocks.BlockFertile;
import mods.b0bgary.b0bcraft.blocks.BlockTest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class BBlocks {
	
	public static Block blockTest;
	public static Block fertile;
		
	public static Block blockCropCotton;
	public static Block blockCropFlax;

	
	
	public static void add(){
		
		blockTest=new BlockTest(Material.wood).setBlockName(References.modid+":"+"blockTest").setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockTest, "blockTest");
		
		fertile=new BlockFertile(Material.wood).setBlockName(References.modid+":"+"fertile").setBlockTextureName(References.modid+":"+"blockFertile").setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(fertile, "fertile");
		
		blockCropFlax=new BlockBCrop("blockCropFlax", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropFlax, "blockCropFlax");
		
		blockCropCotton=new BlockBCrop("blockCropCotton", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropCotton, "blockCropCotton");
	}

}
