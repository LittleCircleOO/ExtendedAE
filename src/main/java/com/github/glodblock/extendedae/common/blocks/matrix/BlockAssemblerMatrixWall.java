package com.github.glodblock.extendedae.common.blocks.matrix;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.common.tileentities.matrix.TileAssemblerMatrixWall;
import net.minecraft.world.item.Item;
public class BlockAssemblerMatrixWall extends BlockAssemblerMatrixBase<TileAssemblerMatrixWall> {
    @Override
    public Item getPresentItem() {
        return EAEItemAndBlock.ASSEMBLER_MATRIX_WALL.asItem();
    }
}