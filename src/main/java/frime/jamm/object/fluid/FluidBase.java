package frime.jamm.object.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidBase extends Fluid {

	public FluidBase(String name, ResourceLocation still, ResourceLocation flowing, ResourceLocation overlay) {
		super(name, still, flowing, overlay);
		setUnlocalizedName(name);
		
	}

}
