package io.github.ennuil.crooked_crooks.utils;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.Attribute;

import java.lang.reflect.InvocationTargetException;

public class Portals {
	public static Holder<Attribute> getHerdingRange() {
		try {
			var fabricClass = getClass("io.github.ennuil.crooked_crooks.utils.FabricPortals");
			if (fabricClass != null) {
				return (Holder<Attribute>) fabricClass.getMethod("getHerdingRange").invoke(null);
			} else {
				var norgeClass = getClass("io.github.ennuil.crooked_crooks.utils.NorgePortals");
				if (norgeClass != null) {
					return (Holder<Attribute>) norgeClass.getMethod("getHerdingRange").invoke(null);
				}
			}

			return null;
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public static Holder<MobEffect> getShepherdsTouchEffect() {
		try {
			var fabricClass = getClass("io.github.ennuil.crooked_crooks.utils.FabricPortals");
			if (fabricClass != null) {
				return (Holder<MobEffect>) fabricClass.getMethod("getShepherdsTouchEffect").invoke(null);
			} else {
				var norgeClass = getClass("io.github.ennuil.crooked_crooks.utils.NorgePortals");
				if (norgeClass != null) {
					return (Holder<MobEffect>) norgeClass.getMethod("getShepherdsTouchEffect").invoke(null);
				}
			}

			return null;
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public static Class<?> getClass(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
}
