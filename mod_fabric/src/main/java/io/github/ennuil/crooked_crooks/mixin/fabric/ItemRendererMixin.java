package io.github.ennuil.crooked_crooks.mixin.fabric;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.ennuil.crooked_crooks.item.ModItemTags;
import io.github.ennuil.crooked_crooks.item.ModItems;
import io.github.ennuil.crooked_crooks.utils.ModUtils;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
	@Unique
	private static final Map<Item, ModelResourceLocation> CROOK_ITEM_TO_MODEL_ID = Map.of(
		ModItems.WOODEN_CROOK, ModelResourceLocation.inventory(ModUtils.id("wooden_crook")),
		ModItems.STONE_CROOK, ModelResourceLocation.inventory(ModUtils.id("stone_crook")),
		ModItems.BONE_CROOK, ModelResourceLocation.inventory(ModUtils.id("bone_crook")),
		ModItems.IRON_CROOK, ModelResourceLocation.inventory(ModUtils.id("iron_crook"))
	);

	@Unique
	private static final Map<Item, ModelResourceLocation> CROOK_ITEM_TO_IN_HAND_MODEL_ID = Map.of(
		ModItems.WOODEN_CROOK, ModelResourceLocation.inventory(ModUtils.id("wooden_crook_in_hand")),
		ModItems.STONE_CROOK, ModelResourceLocation.inventory(ModUtils.id("stone_crook_in_hand")),
		ModItems.BONE_CROOK, ModelResourceLocation.inventory(ModUtils.id("bone_crook_in_hand")),
		ModItems.IRON_CROOK, ModelResourceLocation.inventory(ModUtils.id("iron_crook_in_hand"))
	);

	@Shadow
	public abstract ItemModelShaper getItemModelShaper();

	@Shadow
	@Final
	private ItemModelShaper itemModelShaper;

	@Inject(
		method = "render",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z",
			ordinal = 0
		)
	)
	private void addCrookSpecialCases(ItemStack itemStack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay, BakedModel model, CallbackInfo ci, @Local(argsOnly = true) LocalRef<BakedModel> modelRef) {
		if (itemStack.is(ModItemTags.CROOKS)) {
			modelRef.set(this.getItemModelShaper().getModelManager().getModel(CROOK_ITEM_TO_MODEL_ID.get(itemStack.getItem())));
		}
	}

	@ModifyExpressionValue(
		method = "getModel",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/renderer/ItemModelShaper;getItemModel(Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/client/resources/model/BakedModel;"
		)
	)
	private BakedModel getSpecialCaseCrookModel(BakedModel original, @Local(argsOnly = true) ItemStack stack) {
		if (stack.is(ModItemTags.CROOKS)) {
			return this.itemModelShaper.getModelManager().getModel(CROOK_ITEM_TO_IN_HAND_MODEL_ID.get(stack.getItem()));
		} else {
			return original;
		}
	}
}
