package com.urjuhh.prefab.inventory;

import com.urjuhh.prefab.tileentity.TileEntityPrefabBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerPrefabBench extends ContainerPrefab
{
    public static final int BENCH_INVENTORY_ROWS = 3;
    public static final int BENCH_INVENTORY_COLUMNS = 9;
    public static final int BENCH_INVENTORY_SIZE = BENCH_INVENTORY_ROWS * BENCH_INVENTORY_COLUMNS;

    private TileEntityPrefabBench tileEntityPrefabBench;
    private int benchInventoryRows;
    private int benchInventoryColumns;

    public ContainerPrefabBench(InventoryPlayer inventoryPlayer, TileEntityPrefabBench tileEntityPrefabBench)
    {
        this.tileEntityPrefabBench = tileEntityPrefabBench;

        this.addSlotToContainer(new Slot(tileEntityPrefabBench, TileEntityPrefabBench.CEILING_BLOCK_SELECTOR_INDEX, 19, 14));
        this.addSlotToContainer(new Slot(tileEntityPrefabBench, TileEntityPrefabBench.WALL_BLOCK_SELECTOR_INDEX, 19, 34));
        this.addSlotToContainer(new Slot(tileEntityPrefabBench, TileEntityPrefabBench.FLOOR_BLOCK_SELECTOR_INDEX, 19, 54));


        tileEntityPrefabBench.openInventory(inventoryPlayer.player);

        benchInventoryRows = BENCH_INVENTORY_ROWS;
        benchInventoryColumns = BENCH_INVENTORY_COLUMNS;

        for (int benchRowIndex = 0; benchRowIndex < benchInventoryRows; ++benchRowIndex)
        {
            for (int benchColumnIndex = 0; benchColumnIndex < benchInventoryColumns; ++benchColumnIndex)
            {
                this.addSlotToContainer(new Slot(tileEntityPrefabBench, 3 + benchColumnIndex + benchRowIndex * benchInventoryColumns, 19 + benchColumnIndex * 18, 86 + benchRowIndex * 18));
            }
        }

        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; ++inventoryRowIndex)
        {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; ++inventoryColumnIndex)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 19 + inventoryColumnIndex * 18, 142 + inventoryRowIndex * 18));
            }
        }

        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarSlotIndex)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 19 + actionBarSlotIndex * 18, 200));
        }
    }

    /**
     * Callback for when the crafting gui is closed.
     */
    @Override
    public void onContainerClosed(EntityPlayer entityPlayer)
    {
        super.onContainerClosed(entityPlayer);
        tileEntityPrefabBench.closeInventory(entityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
    {
        ItemStack newItemStack = null;
//        Slot slot = (Slot) inventorySlots.get(slotIndex);
        Slot slot = inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack = slot.getStack();
            newItemStack = itemStack.copy();

            if (slotIndex < benchInventoryRows * benchInventoryColumns)
            {
                if (!this.mergeItemStack(itemStack, benchInventoryRows * benchInventoryColumns, inventorySlots.size(), false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemStack, 0, benchInventoryRows * benchInventoryColumns, false))
            {
                return null;
            }

            if (itemStack.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return newItemStack;
    }
}
