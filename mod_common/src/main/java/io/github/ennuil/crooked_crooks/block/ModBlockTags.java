package io.github.ennuil.crooked_crooks.block;

import io.github.ennuil.crooked_crooks.utils.ModUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
	public static final TagKey<Block> MINEABLE_WITH_CROOK = TagKey.create(Registries.BLOCK, ModUtils.id("mineable_with_crook"));
}
