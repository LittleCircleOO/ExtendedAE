package com.github.glodblock.extendedae.common.tileentities.matrix;
import com.github.glodblock.extendedae.common.EAEItemAndBlock;
import com.github.glodblock.extendedae.common.me.matrix.ClusterAssemblerMatrix;
import com.github.glodblock.extendedae.util.FCUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
public class TileAssemblerMatrixSpeed extends TileAssemblerMatrixFunction {
    public TileAssemblerMatrixSpeed(BlockPos pos, BlockState blockState) {
        super(FCUtil.getTileType(TileAssemblerMatrixSpeed.class, TileAssemblerMatrixSpeed::new, EAEItemAndBlock.ASSEMBLER_MATRIX_SPEED), pos, blockState);
    }
    @Override
    public void add(ClusterAssemblerMatrix c) {
        c.addSpeedCore();
    }
}