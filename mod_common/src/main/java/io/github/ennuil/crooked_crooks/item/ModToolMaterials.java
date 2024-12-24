package io.github.ennuil.crooked_crooks.item;

import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {
	public static final ToolMaterial BONE = new ToolMaterial(
		ToolMaterial.STONE.incorrectBlocksForDrops(),
		ToolMaterial.STONE.durability(),
		ToolMaterial.STONE.speed(),
		ToolMaterial.STONE.attackDamageBonus(),
		ToolMaterial.STONE.enchantmentValue(),
		ModItemTags.BONE_TOOL_MATERIALS
	);
}
