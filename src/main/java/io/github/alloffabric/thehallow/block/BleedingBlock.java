package io.github.alloffabric.thehallow.block;

import io.github.alloffabric.thehallow.registry.HallowedBlocks;
import io.github.alloffabric.thehallow.registry.HallowedTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Random;

public class BleedingBlock extends Block {
	public BleedingBlock(Settings settings) {
		super(settings);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		WitchWaterBubbleColumnBlock.update(world, pos.up(), true);
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction dir, BlockState state2, IWorld iworld, BlockPos pos1, BlockPos pos2) {
		if (dir == Direction.UP && state2.getBlock() == HallowedBlocks.WITCH_WATER_BLOCK) {
			iworld.getBlockTickScheduler().schedule(pos1, this, this.getTickRate(iworld));
		}

		return super.getStateForNeighborUpdate(state, dir, state2, iworld, pos1, pos2);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos1, Random rand) {
		BlockPos pos2 = pos1.up();
		if (world.getFluidState(pos1).matches(HallowedTags.Fluids.WITCH_WATER)) {
			world.playSound(null, pos1, SoundEvents.ENTITY_DROWNED_HURT_WATER, SoundCategory.BLOCKS, 0.5F, 2.6F + (world.random.nextFloat() - world.random.nextFloat()) * 0.8F);
			world.spawnParticles(ParticleTypes.CURRENT_DOWN, (double) pos2.getX() + 0.5D, (double) pos2.getY() + 0.25D, (double) pos2.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
		}
	}

	@Override
	public int getTickRate(WorldView viewableworld) {
		return 20;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState state2, boolean bool) {
		world.getBlockTickScheduler().schedule(pos, this, this.getTickRate(world));
	}
}
