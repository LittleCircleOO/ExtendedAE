package com.github.glodblock.extendedae.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CommonTags {
    public static final TagKey<Item> DUSTS = tag("c:dusts");
    public static final TagKey<Item> GEMS = tag("c:gems");
    public static final TagKey<Item> INGOTS = tag("c:ingots");
    public static final TagKey<Item> STORAGE_BLOCKS = tag("c:storage_blocks");
    public static final TagKey<Item> SANDS = tag("c:sands");

    private static TagKey<Item> tag(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(name));
    }

    private static TagKey<Block> blockTag(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(name));
    }
}
