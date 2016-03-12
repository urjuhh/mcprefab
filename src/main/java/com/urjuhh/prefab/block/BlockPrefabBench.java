package com.urjuhh.prefab.block;

public class BlockPrefabBench extends BlockPrefab
{
    public BlockPrefabBench()
    {
        this.setUnlocalizedName("prefabbench");
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }
}
