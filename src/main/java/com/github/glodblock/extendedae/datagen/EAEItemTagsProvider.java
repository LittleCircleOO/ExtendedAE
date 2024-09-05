package com.github.glodblock.extendedae.datagen;

import appeng.datagen.providers.tags.ConventionTags;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.util.CommonTags;
import com.github.glodblock.extendedae.util.EAETags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class EAEItemTagsProvider extends FabricTagProvider.ItemTagProvider {

    public EAEItemTagsProvider(FabricDataOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, FabricTagProvider.BlockTagProvider blockTagsProvider) {
        super(packOutput, registries, blockTagsProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.getOrCreateTagBuilder(EAETags.EX_PATTERN_PROVIDER)
                .add(EAEItemAndBlock.EX_PATTERN_PROVIDER_PART)
                .add(EAEItemAndBlock.EX_PATTERN_PROVIDER.asItem());
        this.getOrCreateTagBuilder(EAETags.EX_INTERFACE)
                .add(EAEItemAndBlock.EX_INTERFACE_PART)
                .add(EAEItemAndBlock.EX_INTERFACE.asItem());
        this.getOrCreateTagBuilder(CommonTags.DUSTS)
                .add(EAEItemAndBlock.ENTRO_DUST);
        this.getOrCreateTagBuilder(CommonTags.GEMS)
                .add(EAEItemAndBlock.ENTRO_CRYSTAL);
        this.getOrCreateTagBuilder(EAETags.ENTRO_CRYSTAL)
                .add(EAEItemAndBlock.ENTRO_CRYSTAL);
        this.getOrCreateTagBuilder(EAETags.ENTRO_DUST)
                .add(EAEItemAndBlock.ENTRO_DUST);
        this.getOrCreateTagBuilder(CommonTags.INGOTS)
                .add(EAEItemAndBlock.ENTRO_INGOT);
        this.getOrCreateTagBuilder(EAETags.ENTRO_INGOT)
                .add(EAEItemAndBlock.ENTRO_INGOT);
        this.getOrCreateTagBuilder(CommonTags.STORAGE_BLOCKS)
                .add(EAEItemAndBlock.ENTRO_BLOCK.asItem());
        this.getOrCreateTagBuilder(EAETags.ENTRO_BLOCK)
                .add(EAEItemAndBlock.ENTRO_BLOCK.asItem());
        this.getOrCreateTagBuilder(ConventionTags.INSCRIBER_PRESSES)
                .add(EAEItemAndBlock.CONCURRENT_PROCESSOR_PRESS);
        this.getOrCreateTagBuilder(ConventionTags.BUDDING_BLOCKS)
                .add(EAEItemAndBlock.FULLY_ENTROIZED_FLUIX_BUDDING.asItem())
                .add(EAEItemAndBlock.MOSTLY_ENTROIZED_FLUIX_BUDDING.asItem())
                .add(EAEItemAndBlock.HALF_ENTROIZED_FLUIX_BUDDING.asItem())
                .add(EAEItemAndBlock.HARDLY_ENTROIZED_FLUIX_BUDDING.asItem());
        this.getOrCreateTagBuilder(ConventionTags.BUDS)
                .add(EAEItemAndBlock.ENTRO_BUD_SMALL.asItem())
                .add(EAEItemAndBlock.ENTRO_BUD_MEDIUM.asItem())
                .add(EAEItemAndBlock.ENTRO_BUD_LARGE.asItem());

    }
}
