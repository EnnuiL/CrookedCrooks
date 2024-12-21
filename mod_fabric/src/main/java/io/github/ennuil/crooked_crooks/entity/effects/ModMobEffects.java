package io.github.ennuil.crooked_crooks.entity.effects;

import io.github.ennuil.crooked_crooks.utils.ModUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.CommonColors;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ModMobEffects {
	public static final Holder<MobEffect> SHEPHERDS_TOUCH = Registry.registerForHolder(
		BuiltInRegistries.MOB_EFFECT,
		ModUtils.id("shepherds_touch"),
		new ShepherdMobEffect(MobEffectCategory.BENEFICIAL, CommonColors.WHITE)
	);

	public static void init() {}
}
