package io.github.ennuil.crooked_crooks.datagen;

import io.github.ennuil.crooked_crooks.item.ModItems;
import io.github.ennuil.crooked_crooks.utils.ModUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.*;
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
		generators.generateFlatItem(ModItems.WOODEN_CROOK, ModelTemplates.FLAT_HANDHELD_ITEM);
		generators.generateFlatItem(ModItems.BONE_CROOK, ModelTemplates.FLAT_HANDHELD_ITEM);
		generators.generateFlatItem(ModItems.STONE_CROOK, ModelTemplates.FLAT_HANDHELD_ITEM);
		generators.generateFlatItem(ModItems.IRON_CROOK, ModelTemplates.FLAT_HANDHELD_ITEM);
		generateLargeCrook(generators, ModItems.WOODEN_CROOK);
		generateLargeCrook(generators, ModItems.BONE_CROOK);
		generateLargeCrook(generators, ModItems.STONE_CROOK);
		generateLargeCrook(generators, ModItems.IRON_CROOK);
	}

	public final void generateLargeCrook(ItemModelGenerators generators, Item item) {
		FLAT_HANDHELD_CROOK_ITEM.create(
			ModelLocationUtils.getModelLocation(item).withSuffix("_in_hand"),
			TextureMapping.layer0(TextureMapping.getItemTexture(item).withSuffix("_long")),
			generators.output
		);
	}
}
