package com.urjuhh.prefab.handler;


import com.urjuhh.prefab.client.gui.inventory.GuiPrefabBench;
import com.urjuhh.prefab.inventory.ContainerPrefabBench;
import com.urjuhh.prefab.reference.Gui;
import com.urjuhh.prefab.tileentity.TileEntityPrefabBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        if (id == Gui.PREFAB_BENCH.ordinal())
        {
            TileEntityPrefabBench tileEntityPrefabBench = (TileEntityPrefabBench) world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerPrefabBench(entityPlayer.inventory, tileEntityPrefabBench);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        if (id == Gui.PREFAB_BENCH.ordinal())
        {
            TileEntityPrefabBench tileEntityPrefabBench = (TileEntityPrefabBench) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiPrefabBench(entityPlayer.inventory, tileEntityPrefabBench );
        }

        return null;
    }
}
