package io.github.alloffabric.thehallow.block;

import io.github.alloffabric.thehallow.registry.HallowedBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.EntityContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class DeaderBushBlock extends PlantBlock {
	public static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	public DeaderBushBlock(Settings settings) {
		super(settings);
	}

	@SuppressWarnings("deprecation")
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
		return SHAPE;
	}

	@Override
	protected boolean canPlantOnTop(BlockState state, BlockView view, BlockPos pos) {
		Block block = state.getBlock();
		return block == HallowedBlocks.TAINTED_SAND || block == Blocks.SAND || block == Blocks.RED_SAND;
	}
}
