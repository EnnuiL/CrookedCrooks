package io.github.ennuil.crooked_crooks.item;

import io.github.ennuil.crooked_crooks.utils.ModUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class ModItems {
	public static final Item WOODEN_CROOK = Registry.register(
		BuiltInRegistries.ITEM,
		ModUtils.id("wooden_crook"),
		new CrookItem(Tiers.WOOD, 0, -3, 0.4F, new Item.Properties())
	);

	public static final Item STONE_CROOK = Registry.register(
		BuiltInRegistries.ITEM,
		ModUtils.id("stone_crook"),
		new CrookItem(Tiers.STONE, 0, -3, 0.4F, new Item.Properties())
	);

	public static final Item BONE_CROOK = Registry.register(
		BuiltInRegistries.ITEM,
		ModUtils.id("bone_crook"),
		new CrookItem(ModTiers.BONE, 0, -3, 0.4F, new Item.Properties())
	);

	public static final Item IRON_CROOK = Registry.register(
		BuiltInRegistries.ITEM,
		ModUtils.id("iron_crook"),
		new CrookItem(Tiers.IRON, 0, -3, 0.4F, new Item.Properties())
	);

	public static void init() {}
}
