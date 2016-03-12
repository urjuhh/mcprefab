package com.urjuhh.prefab.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.trowel), "  i", "ls ", "   ", 'l', Blocks.log, 'i', Items.iron_ingot, 's', Items.stick));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.prefabbench), "cwc", "cfc", "cbc", 'c', Blocks.cobblestone, 'w', Blocks.crafting_table, 'f', Blocks.furnace, 'b', Blocks.chest));

    }
}
