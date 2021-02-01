package net.mobz.Mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(RaiderEntity.class)
public abstract class RaiderEntityMixin {
	@Redirect(method = "tickMovement()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/raid/RaiderEntity;canJoinRaid()Z"))
	private boolean shouldJoinRaid(RaiderEntity raider) {
		World world = raider.getEntityWorld();
		BlockPos pos = raider.getBlockPos();
		return raider.canJoinRaid() && world.isSkyVisible(pos);
	}
}
