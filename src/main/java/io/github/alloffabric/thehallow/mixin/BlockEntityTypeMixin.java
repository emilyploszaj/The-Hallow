package io.github.alloffabric.thehallow.mixin;

import io.github.alloffabric.thehallow.block.HallowedSign;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {
	@Inject(method = "supports(Lnet/minecraft/block/Block;)Z", at = @At("HEAD"), cancellable = true)
	private void supports(Block block, CallbackInfoReturnable<Boolean> info) {
		if (BlockEntityType.SIGN.equals(this) && block instanceof HallowedSign) {
			info.setReturnValue(true);
		}
	}
}
