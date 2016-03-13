package com.urjuhh.prefab.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPrefabBench extends TileEntityPrefab
{
    public int numUsingPlayers;
    private int ticksSinceSync;
    private ItemStack[] inventory;

    public TileEntityPrefabBench() {
        super();
    }
}
