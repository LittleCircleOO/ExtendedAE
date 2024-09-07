package com.github.glodblock.extendedae.util;

import com.github.glodblock.extendedae.EAE;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class EPPTags {

    public static final TagKey<Item> EX_PATTERN_PROVIDER = TagKey.create(Registries.ITEM, EAE.id("extended_pattern_provider"));
    public static final TagKey<Item> EX_INTERFACE = TagKey.create(Registries.ITEM, EAE.id("extended_interface"));
    public static final TagKey<Item> SILICON_BLOCK = TagKey.create(Registries.ITEM, new ResourceLocation("c", "storage_blocks/silicon"));

}
