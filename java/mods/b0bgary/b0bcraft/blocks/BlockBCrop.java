package mods.b0bgary.b0bcraft.blocks;

import java.util.Random;

import mods.b0bgary.b0bcraft.core.BBlocks;
import mods.b0bgary.b0bcraft.core.References;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBCrop extends BlockBush implements IGrowable{

	    public BlockBCrop(String name, ItemStack drop, ItemStack seed)
	    {
	        this.setTickRandomly(true);
	        float f = 0.5F;
	        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
	        setHardness(0.0F);
	        setStepSound(soundTypeGrass);
	        disableStats();
	        setBlockTextureName(References.modid+":"+name+"/"+name+"_");	    
	        setBlockName(References.modid+":"+name);
	        this.drop=drop.getItem();
	        this.dropStack=drop;
	        this.dropM=drop.getItemDamage();
	        this.seed=seed.getItem();
	        this.seedM=seed.getItemDamage();
	        }
	    
	    public Item drop;
	    public int dropM;
	    public Item seed;
	    public int seedM;
	    public ItemStack dropStack;

	    protected int maxGrowthStage = 15;
	    @SideOnly(Side.CLIENT)
	    protected IIcon[] iIcon;

	    
	    
	    /**
	     * Ticks the block if it's been scheduled
	     */
	    @Override
	    public void updateTick(World parWorld, int parX, int parY, int parZ, Random parRand)
	    {
	    	{
	    		
	        super.updateTick(parWorld, parX, parY, parZ, parRand);
	        int growStage = parWorld.getBlockMetadata(parX, parY, parZ)+1;

	        if (growStage > maxGrowthStage)
	        {
	            growStage = maxGrowthStage;
	        }

	        parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);

	    }
	    }

	    /**
	     * is the block grass, dirt or farmland
	     */
	    protected boolean canPlaceBlockOn(Block p_149854_1_)
	    {
	        return p_149854_1_ == Blocks.farmland||p_149854_1_ ==BBlocks.fertile;
	    }
	    
	    public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_)
	    {
	       if(p_149718_1_.getBlock(p_149718_2_, p_149718_3_-1, p_149718_4_)==Blocks.farmland||
	    		   p_149718_1_.getBlock(p_149718_2_, p_149718_3_-1, p_149718_4_)==BBlocks.fertile){
	    	   return true;
	       }
	       return false;
	    }

	    /**
	     * The type of render function that is called for this block
	     */
	    public int getRenderType()
	    {
	        return 6;
	    }


	    public void incrementGrowStage(World parWorld, Random parRand, int parX, int parY, int parZ)
	    {
	    	   int growStage = parWorld.getBlockMetadata(parX, parY, parZ) + 
	              MathHelper.getRandomIntegerInRange(parRand, 2, 5);

	        if (growStage > maxGrowthStage)
	        {
	         growStage = maxGrowthStage;
	        }

	        parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);

	    }
	    
	    
	    
	    
	    @Override
	    public Item getItemDropped(int p_149650_1_, Random parRand, int parFortune)
	    {
	        return p_149650_1_ == maxGrowthStage ? this.func_149865_P() : this.func_149866_i();
	    }

	    public int damageDropped(int p_149692_1_)
	    {
	        return p_149692_1_==maxGrowthStage ?this.dropM:this.seedM;
	    }
	    
	    @Override
	    public int quantityDropped(int parMetadata, int parFortune, Random parRand)
	    {
	        return parMetadata==maxGrowthStage ?1:1;
	    }
	    
	    protected Item func_149866_i()
	    {
	        return this.seed;
	    }

	    protected Item func_149865_P()
	    {
	        return this.drop;
	    }
	    
	    @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	    {
	    	System.out.println("fsfsdagdzxhbd");
	        if(this.maxGrowthStage==world.getBlockMetadata(x,y,z)){
	        	world.setBlockMetadataWithNotify(parX, parY, parZ, 5, 2);
	        	ArrayList<ItemStack> drops = this.dropStack;
                for (ItemStack drop : drops) {
                    if(drop==null || drop.getItem()==null) {
                        continue;
                    }
                    this.dropBlockAsItem(world, x, y, z, drop);
	        	
	        }
	    }
	    }
	    
	    
	    
	    @Override
	    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	    { 
	        return EnumPlantType.Crop;
	    }

	    @Override
	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister parIIconRegister)
	    {
	          iIcon = new IIcon[maxGrowthStage+1];
	          // seems that crops like to have 8 growth icons, but okay to repeat actual texture if you want
	          // to make generic should loop to maxGrowthStage
	          for (int i = 0; i < maxGrowthStage+1; ++i)
	          {
	          iIcon[i] = parIIconRegister.registerIcon(textureName+i);
	          
	          }
	
	      }
	    @Override
	    @SideOnly(Side.CLIENT)
	    public IIcon getIcon(int parSide, int parGrowthStage)
	    {
			return iIcon[parGrowthStage];

	    }
	    
	    
	    
	    
	    
	    @Override
	    // checks if finished growing (a grow stage of 15 is final stage)
	    public boolean func_149851_a(World parWorld, int parX, int parY, int parZ, 
	          boolean p_149851_5_)
	    {
	    	return parWorld.getBlockMetadata(parX, parY, parZ)<this.maxGrowthStage;
	    }
	    /*
	     * (non-Javadoc)
	     * @see net.minecraft.block.IGrowable#func_149852_a(net.minecraft.world.World, 
	     * java.util.Random, int, int, int)
	     */
	    @Override
	    public boolean func_149852_a(World p_149852_1_, Random parRand, int p_149852_3_, 
	          int p_149852_4_, int p_149852_5_)
	    {
	        return true;
	    }
	    /*
	     * (non-Javadoc)
	     * @see net.minecraft.block.IGrowable#func_149853_b(net.minecraft.world.World, 
	     * java.util.Random, int, int, int)
	     */
	    @Override
	    public void func_149853_b(World parWorld, Random parRand, int parX, int parY, 
	          int parZ)
	    {
	        incrementGrowStage(parWorld, parRand, parX, parY, parZ);
	    }

}
