package frime.jamm.object.item.tool;

import frime.jamm.Main;
import frime.jamm.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ToolHoeBase extends ItemHoe implements IHasModel {
	
	public ToolHoeBase(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);

//		MMItems.ITEMS.add(this);
	}

		@Override
		public void registerModels() {
			
			Main.proxy.registerItemRenderer(this, 0, "inventory");
			
		}
		
	}