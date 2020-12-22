package us.tmd.tmd;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import us.tmd.tmd.events.OnRenderGameOverlayEventPost;

@Mod(modid = Main.MODID, name = Main.MOD_NAME, version = Main.VERSION)
public class Main
{
    public static final String MODID = "tmd";
    public static final String MOD_NAME = "Too Many Dungeons";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new OnRenderGameOverlayEventPost());
        System.out.println("Thank you for using the TMD mod! With <3 by the TMD team");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
