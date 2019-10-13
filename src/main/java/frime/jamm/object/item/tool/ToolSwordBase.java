package frime.jamm.object.item.tool;

import frime.jamm.Main;
import frime.jamm.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ToolSwordBase extends ItemSword implements IHasModel {

	public ToolSwordBase(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);

//		MMItems.ITEMS.add(this);
	}

		@Override
		public void registerModels() {
			
			Main.proxy.registerItemRenderer(this, 0, "inventory");
			
		}
		
	}