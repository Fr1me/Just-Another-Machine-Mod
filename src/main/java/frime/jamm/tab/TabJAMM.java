package frime.jamm.tab;

import frime.jamm.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabJAMM extends CreativeTabs {
	
	public TabJAMM(String label) {
		super("jammtab");
		}
	

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.COPPER_INGOT);
	}

}
