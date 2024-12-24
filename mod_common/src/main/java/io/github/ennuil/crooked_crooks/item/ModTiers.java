package io.github.ennuil.crooked_crooks.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class ModTiers {
	public static final Tier BONE = new Tier() {
		@Override
		public int getUses() {
			return Tiers.STONE.getUses();
		}

		@Override
		public float getSpeed() {
			return Tiers.STONE.getSpeed();
		}

		@Override
		public float getAttackDamageBonus() {
			return Tiers.STONE.getAttackDamageBonus();
		}

		@Override
		public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
			return Tiers.STONE.getIncorrectBlocksForDrops();
		}

		@Override
		public int getEnchantmentValue() {
			return Tiers.STONE.getEnchantmentValue();
		}

		@Override
		public @NotNull Ingredient getRepairIngredient() {
			return Ingredient.of(ModItemTags.BONE_TOOL_MATERIALS);
		}
	};
}
