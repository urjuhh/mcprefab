package com.urjuhh.prefab.init;

import com.urjuhh.prefab.item.ItemPrefab;
import com.urjuhh.prefab.item.ItemTrowel;
import com.urjuhh.prefab.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
    public static ItemPrefab trowel;

    public static void init()
    {
        trowel = new ItemTrowel();
    }

    public static void register()
    {
        GameRegistry.registerItem(trowel,trowel.getUnlocalizedName().substring(5));
    }

    public static void registerRenders()
    {
        registerRender(trowel);
    }

    public static void registerRender(ItemPrefab item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
