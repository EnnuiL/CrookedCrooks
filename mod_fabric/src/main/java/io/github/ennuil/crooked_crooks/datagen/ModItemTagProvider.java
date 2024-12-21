package io.github.ennuil.crooked_crooks.datagen;

import io.github.ennuil.crooked_crooks.item.ModItemTags;
import io.github.ennuil.crooked_crooks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
		super(output, completableFuture, new ModBlockTagProvider(output, completableFuture));
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
		getOrCreateTagBuilder(ModItemTags.CROOKS)
			.add(ModItems.WOODEN_CROOK)
			.add(ModItems.BONE_CROOK)
			.add(ModItems.STONE_CROOK)
			.add(ModItems.IRON_CROOK);

		getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
			.addTag(ModItemTags.CROOKS);

		getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
			.addTag(ModItemTags.CROOKS);

		getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
			.addTag(ModItemTags.CROOKS);
	}
}
