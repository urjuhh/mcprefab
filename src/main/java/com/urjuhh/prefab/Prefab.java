package com.urjuhh.prefab;

import com.urjuhh.prefab.handler.ConfigurationHandler;
import com.urjuhh.prefab.handler.GuiHandler;
import com.urjuhh.prefab.init.ModBlocks;
import com.urjuhh.prefab.init.ModItems;
import com.urjuhh.prefab.init.Recipes;
import com.urjuhh.prefab.init.TileEntities;
import com.urjuhh.prefab.network.PacketHandler;
import com.urjuhh.prefab.proxy.IProxy;
import com.urjuhh.prefab.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Prefab {
    @Mod.Instance(Reference.MOD_ID)
    public static Prefab instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    public static final CreativeTabs tabPrefab = new CreativeTabs(Reference.MOD_ID + ".creativeTab") {
        @Override
        public Item getTabIconItem() {
            return ModItems.trowel;
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        //FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());

        PacketHandler.init();

        ModBlocks.init();
        ModBlocks.register();
        ModItems.init();
        ModItems.register();
        //ModItems.registerRenders();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        TileEntities.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        proxy.registerRenders();
        Recipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
