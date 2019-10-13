package frime.jamm.object.item;

import frime.jamm.Main;
import frime.jamm.init.ItemInit;
import frime.jamm.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
	
	public ItemBase(String name) {
		
	setUnlocalizedName(name);
	setRegistryName(name);
	setCreativeTab(Main.jammtab);
	
	ItemInit.ITEMS.add(this);
}

	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
}