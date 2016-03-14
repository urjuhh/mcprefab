package com.urjuhh.prefab.client.gui.inventory;

import com.urjuhh.prefab.inventory.ContainerPrefabBench;
import com.urjuhh.prefab.reference.Names;
import com.urjuhh.prefab.reference.Textures;
import com.urjuhh.prefab.tileentity.TileEntityPrefabBench;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiPrefabBench extends GuiContainer
{
    private TileEntityPrefabBench tileEntityPrefabBench;

    public GuiPrefabBench(InventoryPlayer inventoryPlayer, TileEntityPrefabBench prefabBench)
    {
        super(new ContainerPrefabBench(inventoryPlayer, prefabBench));
        tileEntityPrefabBench = prefabBench;
        xSize = 200;
        ySize = 224;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        if (tileEntityPrefabBench.getState() == 0 || tileEntityPrefabBench.getState() == 1)
        {
//            fontRendererObj.drawString(StatCollector.translateToLocal(tileEntityPrefabBench.getInventoryName()), 8, 6, 4210752);
//            fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.VANILLA_INVENTORY), 35, ySize - 95 + 2, 4210752);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(Textures.Gui.PREFAB_BENCH_BASIC);

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}
