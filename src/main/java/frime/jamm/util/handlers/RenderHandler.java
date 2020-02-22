package frime.jamm.util.handlers;

import frime.jamm.init.BlockInit;
import frime.jamm.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHandler {
	
	public static void registerCustomMeshesAndStates() {
		
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockInit.AQUA_REGIA_FLUID), new ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation(Reference.MOD_ID + ":aqua_regia", "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(BlockInit.AQUA_REGIA_FLUID, new StateMapperBase() {
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation(Reference.MOD_ID + ":aqua_regia", "fluid");
			}
			
		});

		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockInit.NITRIC_ACID_FLUID), new ItemMeshDefinition() {

			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation(Reference.MOD_ID + ":nitric_acid", "fluid");
			}
		});

		ModelLoader.setCustomStateMapper(BlockInit.NITRIC_ACID_FLUID, new StateMapperBase() {

			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation(Reference.MOD_ID + ":nitric_acid", "fluid");
			}

		});
	}

}