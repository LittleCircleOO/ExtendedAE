package com.github.glodblock.extendedae.common.blocks.matrix;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.common.tileentities.matrix.TileAssemblerMatrixCrafter;
import net.minecraft.world.item.Item;
public class BlockAssemblerMatrixCrafter extends BlockAssemblerMatrixBase<TileAssemblerMatrixCrafter> {
    @Override
    public Item getPresentItem() {
        return EAEItemAndBlock.ASSEMBLER_MATRIX_CRAFTER.asItem();
    }
}