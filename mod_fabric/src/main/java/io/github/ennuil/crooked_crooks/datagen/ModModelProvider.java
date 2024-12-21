package io.github.ennuil.crooked_crooks.datagen;

import io.github.ennuil.crooked_crooks.item.ModItems;
import io.github.ennuil.crooked_crooks.utils.ModUtils;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.world.item.Item;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
	private static final ModelTemplate FLAT_HANDHELD_CROOK_ITEM = new ModelTemplate(
		Optional.of(ModUtils.id("item/handheld_crook")), Optional.empty(), TextureSlot.LAYER0
	);

	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {}

	@Override
	public void generateItemModels(ItemModelGenerators generators) {
		generateCrook(generators, ModItems.WOODEN_CROOK);
		generateCrook(generators, ModItems.BONE_CROOK);
		generateCrook(generators, ModItems.STONE_CROOK);
		generateCrook(generators, ModItems.IRON_CROOK);
	}

	public final void generateCrook(ItemModelGenerators generators, Item item) {
		var unbaked = ItemModelUtils.plainModel(generators.createFlatItemModel(item, FLAT_HANDHELD_CROOK_ITEM));
		var unbaked2 = ItemModelUtils.plainModel(
			generators.createFlatItemModel(item, "_long", FLAT_HANDHELD_CROOK_ITEM)
		);
		var conditionalUnbaked = ItemModelUtils.conditional(ItemModelUtils.isUsingItem(), unbaked, unbaked2);
		generators.itemModelOutput.accept(item, ItemModelGenerators.createFlatModelDispatch(unbaked, conditionalUnbaked));
	}
}
