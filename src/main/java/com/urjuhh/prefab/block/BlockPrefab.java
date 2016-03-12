package com.urjuhh.prefab.block;

import com.urjuhh.prefab.Prefab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPrefab extends Block
{
    public BlockPrefab() {
        this(Material.rock);
        this.setCreativeTab(Prefab.tabPrefab);
    }

    public BlockPrefab(Material material)
    {
        super(material);
        //this.setCreativeTab(CreativeTabPrefab.Prefab_TAB);
    }
}
