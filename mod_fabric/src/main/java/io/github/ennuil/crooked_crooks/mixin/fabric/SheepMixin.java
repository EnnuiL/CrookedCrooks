package io.github.ennuil.crooked_crooks.mixin.fabric;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.ennuil.crooked_crooks.utils.Portals;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Sheep.class)
public abstract class SheepMixin extends Animal {
	private SheepMixin(EntityType<? extends Animal> entityType, Level level) {
		super(entityType, level);
	}

	@ModifyReturnValue(method = "createAttributes", at = @At("RETURN"))
	private static AttributeSupplier.Builder addCustomAttribute(AttributeSupplier.Builder original) {
		return original.add(Portals.getHerdingRange(), 20.0F);
	}
}
