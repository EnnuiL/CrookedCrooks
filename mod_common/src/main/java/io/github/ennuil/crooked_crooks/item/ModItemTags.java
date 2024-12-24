package io.github.ennuil.crooked_crooks.item;

import io.github.ennuil.crooked_crooks.utils.ModUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
	public static final TagKey<Item> CROOKS = TagKey.create(Registries.ITEM, ModUtils.id("crooks"));
	public static final TagKey<Item> BONE_TOOL_MATERIALS = TagKey.create(Registries.ITEM, ModUtils.id("bone_tool_materials"));
}
