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
	public static Block blockCropHemp;
	public static Block blockCropHops;
	public static Block blockCropBarley;
	public static Block blockCropWeed;
	public static Block blockCropCoca;
	public static Block blockCropSassafras;
	public static Block blockCropErgot;
	public static Block blockCropRye;
	public static Block blockCropRice;
	public static Block blockCropBeetroot;

	//root plants should not be picked on right-click
	
	public static void add(){
		
		blockTest=new BlockTest(Material.wood).setBlockName(References.modid+":"+"blockTest").setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockTest, "blockTest");
		
		fertile=new BlockFertile(Material.wood).setBlockName(References.modid+":"+"fertile").setBlockTextureName(References.modid+":"+"blockFertile").setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(fertile, "fertile");
		
		blockCropFlax=new BlockBCrop("blockCropFlax", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropFlax, "blockCropFlax");
		
		blockCropCotton=new BlockBCrop("blockCropCotton", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropCotton, "blockCropCotton");
		
		blockCropHemp=new BlockBCrop("blockCropHemp", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropHemp, "blockCropHemp");
		
		blockCropHops=new BlockBCrop("blockCropHops", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropHops, "blockCropHops");
		
		blockCropBarley=new BlockBCrop("blockCropBarley", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropBarley, "blockCropBarley");
	
		blockCropWeed=new BlockBCrop("blockCropWeed", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropWeed, "blockCropWeed");
		
		blockCropCoca=new BlockBCrop("blockCropCoca", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropCoca, "blockCropCoca");
		
		blockCropSassafras=new BlockBCrop("blockCropSassafras", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropSassafras, "blockCropSassafras");
		
		blockCropErgot=new BlockBCrop("blockCropErgot", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropErgot, "blockCropErgot");
		
		blockCropRye=new BlockBCrop("blockCropRye", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropRye, "blockCropRye");
		
		blockCropRice=new BlockBCrop("blockCropRice", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropRice, "blockCropRice");
		
		blockCropBeetroot=new BlockBCrop("blockCropBeetroot", new ItemStack(Items.apple),new ItemStack(Items.dye,1,1)).setCreativeTab(B0bCraft.test);
		GameRegistry.registerBlock(blockCropBeetroot, "blockCropBeetroot");
		
	
	
	}

}
