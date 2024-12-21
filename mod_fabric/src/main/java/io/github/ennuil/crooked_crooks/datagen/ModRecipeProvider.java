package io.github.ennuil.crooked_crooks.datagen;

import io.github.ennuil.crooked_crooks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
	protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
		super(registries, output);
	}

	@Override
	public void buildRecipes() {
		crook(ModItems.WOODEN_CROOK, Items.STICK);
		crook(ModItems.BONE_CROOK, Items.BONE);
		crook(ModItems.STONE_CROOK, ItemTags.STONE_TOOL_MATERIALS);
		crook(ModItems.IRON_CROOK, ItemTags.IRON_TOOL_MATERIALS);
	}

	public void crook(ItemLike crook, ItemLike material) {
		this.shaped(RecipeCategory.TOOLS, crook)
			.define('#', material)
			.pattern("##")
			.pattern(" #")
			.pattern(" #")
			.unlockedBy(getHasName(material), this.has(material))
			.save(this.output);
	}

	public void crook(ItemLike crook, TagKey<Item> material) {
		this.shaped(RecipeCategory.TOOLS, crook)
			.define('#', material)
			.pattern("##")
			.pattern(" #")
			.pattern(" #")
			.unlockedBy("has_" + material.location().getPath(), this.has(material))
			.save(this.output);
	}

	static class ModRecipeProviderRunner extends FabricRecipeProvider {
		public ModRecipeProviderRunner(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
			return new ModRecipeProvider(registryLookup, exporter);
		}

		@Override
		public String getName() {
			return "Crooked Crooks Recipe Provider Runner";
		}
	}
}
