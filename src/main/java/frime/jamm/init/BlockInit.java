package frime.jamm.init;

import java.util.ArrayList;
import java.util.List;

import frime.jamm.object.block.BlockBase;
import frime.jamm.object.block.BlockOreBase;
import frime.jamm.object.block.blast_furnace.BlockBlastFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block COPPER_BLOCK = new BlockBase("copper_block", Material.IRON, SoundType.METAL, 5.0F, 20.0F, 2, "pickaxe");
	public static final Block MALACHITE_ORE = new BlockOreBase("malachite", 4.0F, 10.0F, 1);
	
	public static final Block BLAST_FURNACE_OFF = new BlockBlastFurnace("blast_furnace_off", false);
	public static final Block BLAST_FURNACE_ON = new BlockBlastFurnace("blast_furnace_on", true);
	
}
