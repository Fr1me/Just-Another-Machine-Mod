package frime.jamm.util.handlers;

import frime.jamm.object.block.blast_furnace.TileEntityBlastFurnace;
import frime.jamm.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityBlastFurnace.class, new ResourceLocation(Reference.MOD_ID + "blast_furnace"));
	}

}
