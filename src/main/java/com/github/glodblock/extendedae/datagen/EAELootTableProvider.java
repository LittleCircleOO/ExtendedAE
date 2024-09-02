package com.github.glodblock.extendedae.datagen;

import com.github.glodblock.extendedae.api.ISpecialDrop;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.common.RegistryHandler;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class EAELootTableProvider extends FabricBlockLootTableProvider {

    public EAELootTableProvider(FabricDataOutput p) {
        super(p);
    }

    @Override
    public void generate() {
        for (var block : RegistryHandler.INSTANCE.getBlocks()) {
            if(!(block instanceof ISpecialDrop)){
                dropSelf(block);
            }
            add(EAEItemAndBlock.ENTRO_BUD_SMALL, createSingleItemTableWithSilkTouch(EAEItemAndBlock.ENTRO_BUD_SMALL, Items.AIR));
            add(EAEItemAndBlock.ENTRO_BUD_MEDIUM, createSingleItemTableWithSilkTouch(EAEItemAndBlock.ENTRO_BUD_MEDIUM, Items.AIR));
            add(EAEItemAndBlock.ENTRO_BUD_LARGE, createSingleItemTableWithSilkTouch(EAEItemAndBlock.ENTRO_BUD_LARGE, Items.AIR));
            add(EAEItemAndBlock.ENTRO_CLUSTER, createSilkTouchDispatchTable(EAEItemAndBlock.ENTRO_CLUSTER,
                    LootItem.lootTableItem(EAEItemAndBlock.ENTRO_CRYSTAL)
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                            .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                            .apply(ApplyExplosionDecay.explosionDecay()))
            );
            add(EAEItemAndBlock.FULLY_ENTROIZED_FLUIX_BUDDING, createSingleItemTable(EAEItemAndBlock.ENTRO_DUST));
            add(EAEItemAndBlock.MOSTLY_ENTROIZED_FLUIX_BUDDING, createSingleItemTable(EAEItemAndBlock.ENTRO_DUST));
            add(EAEItemAndBlock.HALF_ENTROIZED_FLUIX_BUDDING, createSingleItemTable(EAEItemAndBlock.ENTRO_DUST));
            add(EAEItemAndBlock.HARDLY_ENTROIZED_FLUIX_BUDDING, createSingleItemTable(EAEItemAndBlock.ENTRO_DUST));
        }
    }

}
