package com.urjuhh.prefab.block;

import com.urjuhh.prefab.Prefab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockPrefab extends Block
{
    public BlockPrefab() {
        this(Material.rock);
        this.setCreativeTab(Prefab.tabPrefab);
    }

    public BlockPrefab(Material material)
    {
        super(material);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        if (world.isRemote){return;}

        TileEntity tile = world.getTileEntity(pos);
        if(tile instanceof IInventory)
        {
            IInventory inventory = (IInventory) tile;
            dropInventory(inventory, world, pos);
        }

        super.breakBlock(world, pos, state);
    }

    protected void dropInventory(IInventory inventory, World world, BlockPos pos)
    {
        //TileEntity tileEntity = world.getTileEntity(pos);
        //if(!(tileEntity instanceof IInventory)){return;}

        //IInventory inventory = (IInventory) tileEntity);

        for (int i=0; i < inventory.getSizeInventory(); i++)
        {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if (itemStack != null && itemStack.stackSize > 0)
            {
                Random rand = new Random();
                float dX = rand.nextFloat() * 0.8F + 0.1F;
                float dY = rand.nextFloat() * 0.8F + 0.1F;
                float dZ = rand.nextFloat() * 0.8F + 0.1F;
                EntityItem entityItem = new EntityItem(world, pos.getX()+dX, pos.getY()+dY, pos.getZ()+dZ, itemStack.copy());

                if(itemStack.hasTagCompound())
                {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
                }
                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor+0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                itemStack.stackSize = 0;
            }
        }
    }
}
