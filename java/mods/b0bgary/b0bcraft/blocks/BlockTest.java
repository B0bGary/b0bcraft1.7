package mods.b0bgary.b0bcraft.blocks;

import mods.b0bgary.b0bcraft.core.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockTest extends Block{

	public BlockTest(Material p_i45394_1_) {
		super(p_i45394_1_);
		setBlockTextureName(References.modid+":"+"blockTest");
		
	}
	
	
    public void onBlockAdded(World world, int posX, int posY, int posZ) {
    	if(!world.isRemote){
    		world.playSoundEffect(posX + 0.5D, posY + 0.5D, posZ + 0.5D, "mob.endermen.portal", 1.0F, 1.0F);
    	}
    	
    }


	
}
