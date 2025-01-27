package com.github.glodblock.extendedae.common.blocks.matrix;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.common.tileentities.matrix.TileAssemblerMatrixSpeed;
import net.minecraft.world.item.Item;
public class BlockAssemblerMatrixSpeed extends BlockAssemblerMatrixBase<TileAssemblerMatrixSpeed> {
    @Override
    public Item getPresentItem() {
        return EAEItemAndBlock.ASSEMBLER_MATRIX_SPEED.asItem();
    }
}