package com.github.glodblock.extendedae.common.blocks.matrix;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.common.tileentities.matrix.TileAssemblerMatrixPattern;
import net.minecraft.world.item.Item;
public class BlockAssemblerMatrixPattern extends BlockAssemblerMatrixBase<TileAssemblerMatrixPattern> {
    @Override
    public Item getPresentItem() {
        return EAEItemAndBlock.ASSEMBLER_MATRIX_PATTERN.asItem();
    }
}