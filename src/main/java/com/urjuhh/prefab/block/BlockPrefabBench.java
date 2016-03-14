package com.urjuhh.prefab.block;

import com.urjuhh.prefab.Prefab;
import com.urjuhh.prefab.reference.Gui;
import com.urjuhh.prefab.tileentity.TileEntityPrefab;
import com.urjuhh.prefab.tileentity.TileEntityPrefabBench;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockPrefabBench extends BlockPrefab implements ITileEntityProvider
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

    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityPrefabBench();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (player.isSneaking() || world.isSideSolid(pos , EnumFacing.DOWN))
        {
            return true;
        }
        else
        {
            if (!world.isRemote && world.getTileEntity(pos) instanceof TileEntityPrefab)
            {
                //player.openGui(Prefab.instance, Gui.PREFAB_BENCH.ordinal(), world, x, y, z);
                player.openGui(Prefab.instance, Gui.PREFAB_BENCH.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
            }

            return true;
        }
    }

    @Override
    public boolean onBlockEventReceived(World world, BlockPos pos, IBlockState state, int eventID, int eventParam)
    {
        super.onBlockEventReceived(world, pos, state, eventID, eventParam);
        TileEntity tileentity = world.getTileEntity(pos);
        return tileentity != null && tileentity.receiveClientEvent(eventID, eventParam);
    }


}
