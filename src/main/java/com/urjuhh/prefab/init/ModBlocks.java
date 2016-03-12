package com.urjuhh.prefab.init;

import com.urjuhh.prefab.block.BlockPrefab;
import com.urjuhh.prefab.block.BlockPrefabBench;
import com.urjuhh.prefab.item.ItemPrefab;
import com.urjuhh.prefab.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks
{

    public static BlockPrefab prefabbench;

    public static void init()
    {
        prefabbench = new BlockPrefabBench();
    }

    public static void register()
    {
        GameRegistry.registerBlock(prefabbench, prefabbench.getUnlocalizedName().substring(5));
        //GameRegistry.registerBlock(prefabbench, "Prefab Bench");
    }

    public static void registerRenders()
    {
        registerRender(prefabbench);
    }

    public static void registerRender(BlockPrefab block)
    {
        Item item = ItemPrefab.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
