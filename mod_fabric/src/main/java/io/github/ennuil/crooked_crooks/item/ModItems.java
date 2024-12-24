package io.github.ennuil.crooked_crooks.item;

import io.github.ennuil.crooked_crooks.utils.RegistryUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class ModItems {
	public static final Item WOODEN_CROOK = RegistryUtils.registerItem(
		"wooden_crook",
		properties -> new CrookItem(ToolMaterial.WOOD, 0, -3, 0.4F, properties),
		new Item.Properties()
	);

	public static final Item STONE_CROOK = RegistryUtils.registerItem(
		"stone_crook",
		properties -> new CrookItem(ToolMaterial.STONE, 0, -3, 0.4F, properties),
		new Item.Properties()
	);

	public static final Item BONE_CROOK = RegistryUtils.registerItem(
		"bone_crook",
		properties -> new CrookItem(ModToolMaterials.BONE, 0, -3, 0.5F, properties),
		new Item.Properties()
	);

	public static final Item IRON_CROOK = RegistryUtils.registerItem(
		"iron_crook",
		properties -> new CrookItem(ToolMaterial.IRON, 0, -3, 0.7F, properties),
		new Item.Properties()
	);

	public static void init() {}
}
