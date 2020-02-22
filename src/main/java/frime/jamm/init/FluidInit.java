package frime.jamm.init;

import frime.jamm.object.fluid.FluidBase;
import frime.jamm.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidInit {
	
	public static final Fluid AQUA_REGIA_FLUID = new FluidBase("aqua_regia", new ResourceLocation(Reference.MOD_ID + ":blocks/aqua_regia_still"), new ResourceLocation(Reference.MOD_ID + ":blocks/aqua_regia_flow"), new ResourceLocation(Reference.MOD_ID + ":blocks/aqua_regia_overlay"));
	public static final Fluid NITRIC_ACID_FLUID = new FluidBase("nitric_acid", new ResourceLocation(Reference.MOD_ID + ":blocks/nitric_acid_still"), new ResourceLocation(Reference.MOD_ID + ":blocks/nitric_acid_flow"), new ResourceLocation(Reference.MOD_ID + ":blocks/nitric_acid_overlay"));
	
	public static void registerFluids() {
		registerFluid(AQUA_REGIA_FLUID);
		registerFluid(NITRIC_ACID_FLUID);
	}
	
	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
	
}
