package mods.b0bgary.b0bcraft.blocks;

import java.util.Random;

import mods.b0bgary.b0bcraft.recipes.CropBreedingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockFertile extends Block{

	public BlockFertile(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setTickRandomly(true);
	}
	
	  
    
    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World parWorld, int parX, int parY, int parZ, Random parRand)
    {
    	{
        super.updateTick(parWorld, parX, parY, parZ, parRand);
        
        crossBreed(parWorld, parX, parY, parZ, parRand);        
    }
    }



	public static void crossBreed(World parWorld, int parX, int parY, int parZ, Random parRand) {

		Block b=parWorld.getBlock(parX, parY+1, parZ);

		
		if(CropBreedingHandler.getPossibleOutcomes(b)!=null){

			if(parWorld.getBlockMetadata(parX, parY+1, parZ)==15){

				int i=parRand.nextInt(4);
				if(i==0){
					Block o=parWorld.getBlock(parX+1, parY+1, parZ);
						if(CropBreedingHandler.getSpecificOutcome(b, o)!=null){
						parWorld.setBlock(parX, parY+1, parZ, CropBreedingHandler.getSpecificOutcome(b, o), 15, 2);

					}
				}
				if(i==1){
					Block o=parWorld.getBlock(parX-1, parY+1, parZ);
					if(CropBreedingHandler.getSpecificOutcome(b, o)!=null){
					parWorld.setBlock(parX, parY+1, parZ, CropBreedingHandler.getSpecificOutcome(b, o), 15, 2);

				}
				}
					if(i==2){
						Block o=parWorld.getBlock(parX, parY+1, parZ-1);
						if(CropBreedingHandler.getSpecificOutcome(b, o)!=null){
						parWorld.setBlock(parX, parY+1, parZ, CropBreedingHandler.getSpecificOutcome(b, o), 15, 2);

					}
					}
					if(i==3){
						Block o=parWorld.getBlock(parX, parY+1, parZ+1);
						if(CropBreedingHandler.getSpecificOutcome(b, o)!=null){
						parWorld.setBlock(parX, parY+1, parZ, CropBreedingHandler.getSpecificOutcome(b, o), 15, 2);

					}
					}
			}
		}
	}

}
