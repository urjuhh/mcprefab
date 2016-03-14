package com.urjuhh.prefab.reference;
import com.urjuhh.prefab.utility.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public final class Textures
{
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    public static final class Armor
    {
    }

    public static final class Model
    {
        private static final String MODEL_TEXTURE_LOCATION = "textures/models/";
        public static final ResourceLocation PREFAB_BENCH_BASIC = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "prefabBench_basic.png");
    }

    public static final class Gui
    {
        private static final String GUI_SHEET_LOCATION = "textures/gui/";
        public static final ResourceLocation PREFAB_BENCH_BASIC = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "prefabBench_basic.png");
    }

    public static final class Effect
    {
        private static final String EFFECTS_LOCATION = "textures/effects/";
    }
}
