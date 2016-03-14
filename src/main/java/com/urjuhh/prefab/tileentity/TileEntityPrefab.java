package com.urjuhh.prefab.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityPrefab extends TileEntity
{

    protected EnumFacing orientation;
    protected byte state;
    protected String customName;
    protected String owner;

    public TileEntityPrefab()
    {
        orientation = EnumFacing.SOUTH;
        state = 0;
        customName = "";
        owner = "";
    }

    public EnumFacing getOrientation()
    {
        return orientation;
    }

    public void setOrientation(EnumFacing orientation)
    {
        this.orientation = orientation;
    }

    public void setOrientation(int orientation)
    {
        this.orientation = EnumFacing.getFront(orientation);
    }

    public short getState()
    {
        return state;
    }

    public void setState(byte state)
    {
        this.state = state;
    }

    public String getCustomName()
    {
        return customName;
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setByte("facing", (byte) orientation.ordinal());
        nbtTagCompound.setByte("state", state);

        if (this.hasCustomName())
        {
            nbtTagCompound.setString("customname", customName);
        }

        if (this.hasOwner())
        {
            nbtTagCompound.setString("owner", owner);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey("facing"))
        {
            //this.orientation = EnumFacing.getOrientation(nbtTagCompound.getByte("facing"));
            this.orientation = EnumFacing.getFront(nbtTagCompound.getByte("facing"));

        }

        if (nbtTagCompound.hasKey("state"))
        {
            this.state = nbtTagCompound.getByte("state");
        }

        if (nbtTagCompound.hasKey("customname"))
        {
            this.customName = nbtTagCompound.getString("customname");
        }

        if (nbtTagCompound.hasKey("owner"))
        {
            this.owner = nbtTagCompound.getString("owner");
        }
    }


    public boolean hasCustomName() {
        return customName != null && customName.length() > 0;
    }

    public boolean hasOwner()
    {
        return owner != null && owner.length() > 0;
    }


}
