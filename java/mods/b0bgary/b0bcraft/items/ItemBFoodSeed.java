package mods.b0bgary.b0bcraft.items;

import mods.b0bgary.b0bcraft.core.B0bCraft;
import mods.b0bgary.b0bcraft.core.BBlocks;
import mods.b0bgary.b0bcraft.core.References;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemBFoodSeed extends ItemFood implements IPlantable
{
    private final Block theBlockPlant;
    /**
     * Block ID of the soil this seed food should be planted on.
     */
    private final Block soilId;

    public ItemBFoodSeed(int parHealAmount, float parSaturationModifier, 
          Block parBlockPlant, Block parSoilBlock, String name)
    {
        super(parHealAmount, parSaturationModifier, false);
        theBlockPlant = parBlockPlant;
        soilId = parSoilBlock;
        setUnlocalizedName(name);
        setTextureName(References.modid+":"+name);
        setCreativeTab(B0bCraft.test);
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
                parWorld.setBlock(parX, parY+1, parZ, theBlockPlant);
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

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return theBlockPlant;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return 0;
    }

    public Block getSoilId() 
    {
        return soilId;
    }
}