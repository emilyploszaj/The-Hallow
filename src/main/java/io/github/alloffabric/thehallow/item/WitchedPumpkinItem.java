package io.github.alloffabric.thehallow.item;

import io.github.alloffabric.thehallow.registry.HallowedNetworking;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class WitchedPumpkinItem extends BlockItem {
	public WitchedPumpkinItem(Block block, Settings settings) {
		super(block, settings);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) {
		if (isFood() && !world.isClient && entity instanceof PlayerEntity) {
			ServerSidePacketRegistry.INSTANCE.sendToPlayer((PlayerEntity) entity, HallowedNetworking.SHOW_FLOATING_ITEM_S2C, HallowedNetworking.createShowFloatingItemPacket(this));
			((PlayerEntity) entity).playSound(SoundEvents.ENTITY_ILLUSIONER_CAST_SPELL, SoundCategory.PLAYERS, 0.5f, 1f);
		}

		return super.finishUsing(stack, world, entity);
	}
}
