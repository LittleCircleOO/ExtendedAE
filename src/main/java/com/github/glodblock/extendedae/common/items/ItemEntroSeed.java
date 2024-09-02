package com.github.glodblock.extendedae.common.items;

import appeng.core.definitions.AEBlocks;
import appeng.items.AEBaseItem;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

public class ItemEntroSeed extends AEBaseItem {

    public ItemEntroSeed() {
        super(new Properties());
    }

    @NotNull
    @Override
    public InteractionResult useOn(@NotNull UseOnContext context) {
        var world = context.getLevel();
        var pos = context.getClickedPos();
        var block = world.getBlockState(pos);
        if (block.getBlock() == AEBlocks.FLUIX_BLOCK.block()) {
            context.getItemInHand().shrink(1);
            world.setBlockAndUpdate(pos, EAEItemAndBlock.FULLY_ENTROIZED_FLUIX_BUDDING.defaultBlockState());
            return InteractionResult.sidedSuccess(world.isClientSide);
        }
        return InteractionResult.PASS;
    }

}
