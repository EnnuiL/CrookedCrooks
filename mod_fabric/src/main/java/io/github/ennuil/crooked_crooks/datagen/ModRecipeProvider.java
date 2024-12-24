package io.github.ennuil.crooked_crooks.datagen;

import io.github.ennuil.crooked_crooks.item.ModItemTags;
import io.github.ennuil.crooked_crooks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
	protected ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void buildRecipes(RecipeOutput output) {
		crook(output, ModItems.WOODEN_CROOK, Items.STICK);
		crook(output, ModItems.BONE_CROOK, ModItemTags.BONE_TOOL_MATERIALS);
		crook(output, ModItems.STONE_CROOK, ItemTags.STONE_TOOL_MATERIALS);
		crook(output, ModItems.IRON_CROOK, Items.IRON_INGOT);
	}

	public void crook(RecipeOutput output, ItemLike crook, ItemLike material) {
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, crook)
			.define('#', material)
			.pattern("##")
			.pattern(" #")
			.pattern(" #")
			.unlockedBy(getHasName(material), this.has(material))
			.save(output);
	}

	public void crook(RecipeOutput output, ItemLike crook, TagKey<Item> material) {
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, crook)
			.define('#', material)
			.pattern("##")
			.pattern(" #")
			.pattern(" #")
			.unlockedBy("has_" + material.location().getPath(), this.has(material))
			.save(output);
	}
}
