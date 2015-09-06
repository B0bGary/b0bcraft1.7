package mods.b0bgary.b0bcraft.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public final class TabHandler extends CreativeTabs
{
	
	public Item icon;
	public String unlocTabName;
	
        public TabHandler(String par1, Item par2, String par3)
        {
                super( par1);
                icon=par2;
                unlocTabName=par3;
        }

                

   
        public String getTranslatedTabLabel()
        {
         return unlocTabName;
        }
        
		@Override
		public Item getTabIconItem() {
			// TODO Auto-generated method stub
			return icon;
			
		}
}