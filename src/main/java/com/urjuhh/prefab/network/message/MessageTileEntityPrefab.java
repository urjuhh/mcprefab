package com.urjuhh.prefab.network.message;

import com.urjuhh.prefab.tileentity.TileEntityPrefab;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageTileEntityPrefab implements IMessage, IMessageHandler<MessageTileEntityPrefab, IMessage>
{
    public BlockPos pos;
    public byte orientation, state;
    public String customName, owner;

    public MessageTileEntityPrefab()
    {

    }

    public MessageTileEntityPrefab(TileEntityPrefab tileEntityPrefab)
    {
        this.pos = tileEntityPrefab.getPos();
        this.orientation = (byte) tileEntityPrefab.getOrientation().ordinal();
        this.state = (byte) tileEntityPrefab.getState();
        this.customName = tileEntityPrefab.getCustomName();
        this.owner = tileEntityPrefab.getOwner();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        PacketBuffer myPacket = new PacketBuffer(buf);
        this.pos = myPacket.readBlockPos();
        this.orientation = buf.readByte();
        this.state = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());
        int ownerLength = buf.readInt();
        this.owner = new String(buf.readBytes(ownerLength).array());
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        PacketBuffer myPacket = new PacketBuffer(buf);
        myPacket.writeBlockPos(pos);
        buf.writeByte(orientation);
        buf.writeByte(state);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());
        buf.writeInt(owner.length());
        buf.writeBytes(owner.getBytes());
    }

    @Override
    public IMessage onMessage(MessageTileEntityPrefab message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.pos);

        if (tileEntity instanceof TileEntityPrefab)
        {
            ((TileEntityPrefab) tileEntity).setOrientation(message.orientation);
            ((TileEntityPrefab) tileEntity).setState(message.state);
            ((TileEntityPrefab) tileEntity).setCustomName(message.customName);
            ((TileEntityPrefab) tileEntity).setOwner(message.owner);
        }

        return null;
    }
}
