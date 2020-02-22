package frime.jamm;

import frime.jamm.proxy.CommonProxy;
import frime.jamm.tab.TabJAMM;
import frime.jamm.util.Reference;
import frime.jamm.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION) 
public class Main {
	
	@Instance
	public static Main instance;
	
	public static final CreativeTabs jammtab = new TabJAMM("jammtab");
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
		public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent e) {
		RegistryHandler.preInitRegistries();
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent e) {
		RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent e) {
		RegistryHandler.postInitRegistries();
	}
	
}
