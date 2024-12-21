package io.github.ennuil.crooked_crooks.mixin.fabric;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import com.llamalad7.mixinextras.sugar.ref.LocalDoubleRef;
import io.github.ennuil.crooked_crooks.item.CrookItem;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@Inject(
		method = "addModifierTooltip",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/entity/ai/attributes/AttributeModifier;is(Lnet/minecraft/resources/ResourceLocation;)Z",
			ordinal = 0
		)
	)
	private void fancifyBaseRangeModifiers(Consumer<Component> tooltipAdder, Player player, Holder<Attribute> attribute, AttributeModifier modifier, CallbackInfo ci, @Local LocalDoubleRef d, @Local LocalBooleanRef bl) {
		// player != null is always true here
		if (modifier.is(CrookItem.BASE_BLOCK_REACH)) {
			d.set(d.get() + player.getAttributeBaseValue(Attributes.BLOCK_INTERACTION_RANGE));
			bl.set(true);
		} else if (modifier.is(CrookItem.BASE_ENTITY_REACH)) {
			d.set(d.get() + player.getAttributeBaseValue(Attributes.ENTITY_INTERACTION_RANGE));
			bl.set(true);
		}
	}
}
