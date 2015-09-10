package mods.b0bgary.b0bcraft.events

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class EventHandlerVanillaCrop {

	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	    public void vanillaSeedPlanting(PlayerInteractEvent event) {
	        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
	            Block block = event.world.getBlock(event.x, event.y, event.z);
	            if (event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().stackSize > 0 && event.entityPlayer.getCurrentEquippedItem().getItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() instanceof IPlantable) {
	                if (GrowthRequirementHandler.isSoilValid(event.world, event.x, event.y, event.z)) {
	                    if (ConfigurationHandler.disableVanillaFarming) {
	                        if(!SeedHelper.allowVanillaPlanting(event.entityPlayer.getCurrentEquippedItem())) {
	                            this.denyEvent(event, false);
	                            return;
	                        }
	                    }
	                }
	            }
	        }
	    }
	}
