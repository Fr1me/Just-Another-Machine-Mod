package frime.jamm.object.block;

import frime.jamm.Main;
import frime.jamm.init.BlockInit;
import frime.jamm.init.ItemInit;
import frime.jamm.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockOreBase extends BlockBase implements IHasModel {

	public BlockOreBase(String name, float hardness, float resistance, int harvestLevel) {
		super(name + "_ore", Material.ROCK, SoundType.STONE, hardness, resistance, harvestLevel, "pickaxe");
	}

}
