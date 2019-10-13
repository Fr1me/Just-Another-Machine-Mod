package frime.jamm.object.block;

import frime.jamm.Main;
import frime.jamm.init.BlockInit;
import frime.jamm.init.ItemInit;
import frime.jamm.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel{

	public BlockBase(String name, Material mat, SoundType sound, float hardness, float resistance, int harvestLevel, String tool){
		super(mat);	
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.jammtab);
		setSoundType(sound);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, harvestLevel);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}

}
