package com.urjuhh.prefab.proxy;

import com.urjuhh.prefab.init.ModBlocks;
import com.urjuhh.prefab.init.ModItems;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenders()
    {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }
}
