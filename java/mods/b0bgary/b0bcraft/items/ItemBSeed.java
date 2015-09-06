package mods.b0bgary.b0bcraft.items;

import java.util.List;

import mods.b0bgary.b0bcraft.core.B0bCraft;
import mods.b0bgary.b0bcraft.core.BBlocks;
import mods.b0bgary.b0bcraft.core.References;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBSeed extends Item implements IPlantable
{
    //private final Block theBlockPlant;
    /**
     * Block ID of the soil this seed food should be planted on.
     */
    private final Block soilId;

    public ItemBSeed(Block parSoilBlock, String name)
    {
        super();
        soilId = parSoilBlock;
        setUnlocalizedName(name);
        setTextureName(References.modid+":"+name);
        setCreativeTab(B0bCraft.test);
        setHasSubtypes(true);
    }

    @Override
    public boolean onItemUse(ItemStack parItemStack, EntityPlayer parPlayer, 
          World parWorld, int parX, int parY, int parZ, int par7, float par8, 
          float par9, float par10)
    {
     // not sure what this parameter does, copied it from potato
        if (par7 != 1)
        {
            return false;
        }
        // check if player has capability to edit
        else if (parPlayer.canPlayerEdit(parX, parY+1, parZ, par7, parItemStack))
        {
            // check that the soil block can sustain the plant
            // and that block above is air so there is room for plant to grow
            if (parWorld.getBlock(parX, parY, parZ).canSustainPlant(parWorld, 
                  parX, parY, parZ, ForgeDirection.UP, this) && parWorld
                  .isAirBlock(parX, parY+1, parZ)||parWorld.getBlock(parX, parY, parZ)==BBlocks.fertile)
            {
             // place the plant block
            	switch(parItemStack.getItemDamage()){
            	case 0:
                parWorld.setBlock(parX, parY+1, parZ, BBlocks.blockCropFlax);
                break;
            	case 1:
                    parWorld.setBlock(parX, parY+1, parZ, BBlocks.blockCropCotton);
                    break;
            	case 2:
                   // parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 3:
                   // parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 4:
                   // parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 5:
                   // parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 6:
                   // parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 7:
                  //  parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 8:
                 //   parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 9:
               //     parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 10:
                 //   parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 11:
                 //   parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 12:
                  //  parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 13:
                 //   parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 14:
                //    parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	case 15:
                 //   parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
                    break;
            	}
                // decrement the stack of seed items
                --parItemStack.stackSize;
                return true;
            	
            }
            
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.Crop;
    }

   /* @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return ;
    }
    */

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return 0;
    }

    public Block getSoilId() 
    {
        return soilId;
    }
    
    
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
     
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
    icons = new IIcon[2];
     
    for (int i = 0; i < icons.length; i++)
    {
    icons[i] = par1IconRegister.registerIcon(References.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
    }
    }
     
    public static final String[] names = new String[] { "flax", "cotton" };
     
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
    int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
    return super.getUnlocalizedName() + "_" + names[i];
    }
     
    @Override
    public IIcon getIconFromDamage(int par1)
    {
    return icons[par1];
    }
     
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
    for (int x = 0; x < 2; x++)
    {
    par3List.add(new ItemStack(this, 1, x));
    }
    }

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {

		return BBlocks.blockCropFlax;
	}
	
}