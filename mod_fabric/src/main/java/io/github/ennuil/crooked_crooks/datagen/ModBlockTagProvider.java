package io.github.ennuil.crooked_crooks.datagen;

import io.github.ennuil.crooked_crooks.block.FabricBlockTags;
import io.github.ennuil.crooked_crooks.block.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
		getOrCreateTagBuilder(ModBlockTags.MINEABLE_WITH_CROOK)
			.forceAddTag(BlockTags.LEAVES)
			.add(Blocks.SHORT_GRASS)
			.add(Blocks.TALL_GRASS)
			.add(Blocks.FERN)
			.add(Blocks.LARGE_FERN);

		getOrCreateTagBuilder(FabricBlockTags.MULTIPLIES_DROPS)
			.forceAddTag(BlockTags.LEAVES)
			.add(Blocks.SHORT_GRASS)
			.add(Blocks.TALL_GRASS)
			.add(Blocks.FERN)
			.add(Blocks.LARGE_FERN);
	}
}
