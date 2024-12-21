package io.github.ennuil.crooked_crooks;

import io.github.ennuil.crooked_crooks.entity.ModAttributes;
import io.github.ennuil.crooked_crooks.entity.effects.ModMobEffects;
import io.github.ennuil.crooked_crooks.item.ModItems;
import io.github.ennuil.crooked_crooks.satire_config.SatireConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class ModInit implements ModInitializer {
	@Override
	public void onInitialize() {
		SatireConfig.setConfigPath(FabricLoader.getInstance().getConfigDir().resolve("crooked_crooks"));
		SatireConfig.init();
		ModItems.init();
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
			entries.addAfter(Items.WOODEN_HOE, ModItems.WOODEN_CROOK);
			entries.addAfter(Items.STONE_HOE, ModItems.STONE_CROOK);
			entries.addAfter(Items.IRON_HOE, ModItems.IRON_CROOK);
			entries.addBefore(Items.BUCKET, ModItems.BONE_CROOK);
		});
		ModAttributes.init();
		ModMobEffects.init();
	}
}
