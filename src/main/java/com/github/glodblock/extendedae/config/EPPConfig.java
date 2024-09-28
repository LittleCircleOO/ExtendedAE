package com.github.glodblock.extendedae.config;

import com.github.glodblock.extendedae.EAE;
import com.github.glodblock.extendedae.util.FCUtil;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Config(id = EAE.MODID)
public class EPPConfig {

    public static EPPConfig INSTANCE;

    public static void onInit() {
        assert INSTANCE == null;
        INSTANCE = Configuration.registerConfig(EPPConfig.class, ConfigFormats.yaml()).getConfigInstance();
    }

    @Configurable
    @Configurable.Comment("ME Extend Import/Export Bus speed multiplier")
    @Configurable.Range(min = 2, max = 128)
    public int busSpeed = 8;

    @Configurable
    @Configurable.Comment("ME Infinity Cell idle energy cost (unit: AE/t)")
    @Configurable.DecimalRange(min = 0.1, max = 64.0)
    public double infCellCost = 8.0;

    @Configurable
    @Configurable.Comment("ME Infinity Cell types (item or fluid's id)")
    @Configurable.Synchronized
    public String[] infCellTypeID = new String[] {
            "minecraft:water",
            "minecraft:cobblestone"
    };

    @Configurable
    @Configurable.Comment("The max range between two wireless connector")
    @Configurable.DecimalRange(min = 10, max = 10000)
    public double wirelessConnectorMaxRange = 1000;

    @Configurable
    @Configurable.Comment("Pattern modifier multipliers")
    @Configurable.Range(min = 1)
    @Configurable.FixedSize
    public int[] patternModifierMultipliers = new int[]{2, 3, 5, 7};

    @Configurable
    @Configurable.Comment("Size multiplier of oversize interface")
    @Configurable.Synchronized
    @Configurable.Range(min = 2, max = 4096)
    public int oversizeMultiplier = 16;

    public List<Item> getInfCellItem() {
        return Arrays.stream(infCellTypeID).parallel().filter(
                s -> FCUtil.checkInvalidRL(s, BuiltInRegistries.ITEM)
        ).map(
                s -> BuiltInRegistries.ITEM.get(new ResourceLocation(s))
        ).collect(Collectors.toList());
    }

    public List<Fluid> getInfCellFluid() {
        return Arrays.stream(infCellTypeID).parallel().filter(
                s -> FCUtil.checkInvalidRL(s, BuiltInRegistries.FLUID)
        ).map(
                s -> BuiltInRegistries.FLUID.get(new ResourceLocation(s))
        ).collect(Collectors.toList());
    }

    @Configurable
    @Configurable.Comment("The AE device/part that can be packed by ME Packing Tape")
    public String[] tapeWhitelist = new String[] {
            "expatternprovider:ex_interface_part",
            "expatternprovider:ex_pattern_provider_part",
            "expatternprovider:ex_interface",
            "expatternprovider:ex_pattern_provider",
            "ae2:cable_interface",
            "ae2:cable_pattern_provider",
            "ae2:interface",
            "ae2:pattern_provider",
            "ae2:drive"
    };

}
