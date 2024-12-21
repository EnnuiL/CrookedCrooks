package io.github.ennuil.crooked_crooks.utils;

import io.github.ennuil.crooked_crooks.entity.ModAttributes;
import io.github.ennuil.crooked_crooks.entity.effects.ModMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class FabricPortals {
	public static Holder<Attribute> getHerdingRange() {
		return ModAttributes.HERDING_RANGE;
	}

	public static Holder<MobEffect> getShepherdsTouchEffect() {
		return ModMobEffects.SHEPHERDS_TOUCH;
	}
}
