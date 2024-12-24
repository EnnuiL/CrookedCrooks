package io.github.ennuil.crooked_crooks.mixin.fabric;

import io.github.ennuil.crooked_crooks.item.ModItems;
import io.github.ennuil.crooked_crooks.utils.ModUtils;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ModelBakery.class)
public abstract class ModelBakeryMixin {
	@Unique
	private static final Map<Item, ModelResourceLocation> CROOK_ITEM_TO_IN_HAND_MODEL_ID = Map.of(
		ModItems.WOODEN_CROOK, ModelResourceLocation.inventory(ModUtils.id("wooden_crook_in_hand")),
		ModItems.STONE_CROOK, ModelResourceLocation.inventory(ModUtils.id("stone_crook_in_hand")),
		ModItems.BONE_CROOK, ModelResourceLocation.inventory(ModUtils.id("bone_crook_in_hand")),
		ModItems.IRON_CROOK, ModelResourceLocation.inventory(ModUtils.id("iron_crook_in_hand"))
	);

	@Shadow
	protected abstract void loadSpecialItemModelAndDependencies(ModelResourceLocation modelLocation);

	@Inject(
		method = "<init>",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/resources/model/ModelBakery;loadSpecialItemModelAndDependencies(Lnet/minecraft/client/resources/model/ModelResourceLocation;)V",
			ordinal = 0
		)
	)
	private void loadCrookInHandModels(BlockColors blockColors, ProfilerFiller profilerFiller, Map<?, ?> modelResources, Map<?, ?> blockStateResources, CallbackInfo ci) {
		CROOK_ITEM_TO_IN_HAND_MODEL_ID.values().forEach(this::loadSpecialItemModelAndDependencies);
	}
}
