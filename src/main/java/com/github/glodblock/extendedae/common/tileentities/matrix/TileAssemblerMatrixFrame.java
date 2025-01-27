package com.github.glodblock.extendedae.common.tileentities.matrix;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.util.FCUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
public class TileAssemblerMatrixFrame extends TileAssemblerMatrixBase {
    public TileAssemblerMatrixFrame(BlockPos pos, BlockState blockState) {
        super(FCUtil.getTileType(TileAssemblerMatrixFrame.class, TileAssemblerMatrixFrame::new, EAEItemAndBlock.ASSEMBLER_MATRIX_FRAME), pos, blockState);
    }
}