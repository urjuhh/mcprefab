package com.urjuhh.prefab.init;

import com.urjuhh.prefab.tileentity.TileEntityPrefabBench;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileEntityPrefabBench.class, "prefabbench");
    }
}
