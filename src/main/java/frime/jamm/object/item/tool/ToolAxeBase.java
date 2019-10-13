package frime.jamm.object.item.tool;

import frime.jamm.Main;
import frime.jamm.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ToolAxeBase extends ItemAxe implements IHasModel {
	
	public ToolAxeBase(String name, ToolMaterial material) {
		super(material, 8.0F, -3.2F);
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
