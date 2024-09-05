package com.github.glodblock.extendedae.datagen;

import appeng.api.ids.AETags;
import appeng.datagen.providers.tags.ConventionTags;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.common.RegistryHandler;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class EAEBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public EAEBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        for (var block : RegistryHandler.INSTANCE.getBlocks()) {
            this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
        }
        this.getOrCreateTagBuilder(AETags.GROWTH_ACCELERATABLE)
                .add(EAEItemAndBlock.FULLY_ENTROIZED_FLUIX_BUDDING)
                .add(EAEItemAndBlock.MOSTLY_ENTROIZED_FLUIX_BUDDING)
                .add(EAEItemAndBlock.HALF_ENTROIZED_FLUIX_BUDDING)
                .add(EAEItemAndBlock.HARDLY_ENTROIZED_FLUIX_BUDDING);
        this.getOrCreateTagBuilder(ConventionTags.BUDDING_BLOCKS_BLOCKS)
                .add(EAEItemAndBlock.FULLY_ENTROIZED_FLUIX_BUDDING)
                .add(EAEItemAndBlock.MOSTLY_ENTROIZED_FLUIX_BUDDING)
                .add(EAEItemAndBlock.HALF_ENTROIZED_FLUIX_BUDDING)
                .add(EAEItemAndBlock.HARDLY_ENTROIZED_FLUIX_BUDDING);
        this.getOrCreateTagBuilder(ConventionTags.BUDS_BLOCKS)
                .add(EAEItemAndBlock.ENTRO_BUD_SMALL)
                .add(EAEItemAndBlock.ENTRO_BUD_MEDIUM)
                .add(EAEItemAndBlock.ENTRO_BUD_LARGE);
    }
}
