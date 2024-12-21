package io.github.ennuil.crooked_crooks.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class RegistryUtils {
	private static ResourceKey<Item> itemId(String name) {
		return ResourceKey.create(Registries.ITEM, ModUtils.id(name));
	}

	public static Item registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
		return Items.registerItem(itemId(name), factory, properties);
	}
}
