package com.github.glodblock.extendedae.common.tileentities.matrix;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.util.FCUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
public class TileAssemblerMatrixWall extends TileAssemblerMatrixBase {
    public TileAssemblerMatrixWall(BlockPos pos, BlockState blockState) {
        super(FCUtil.getTileType(TileAssemblerMatrixWall.class, TileAssemblerMatrixWall::new, EAEItemAndBlock.ASSEMBLER_MATRIX_WALL), pos, blockState);
    }
}