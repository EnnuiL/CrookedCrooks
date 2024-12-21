package io.github.ennuil.crooked_crooks.block;

import io.github.ennuil.crooked_crooks.utils.ModUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class FabricBlockTags {
	public static final TagKey<Block> MULTIPLIES_DROPS = TagKey.create(Registries.BLOCK, ModUtils.id("multiplies_drops"));
}
