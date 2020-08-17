package adudecalledleo.longfallboots4fabric.mixin;

import adudecalledleo.longfallboots4fabric.item.LongFallBootsItem;
import adudecalledleo.longfallboots4fabric.item.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity_DisableFallDamage {
    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot equipmentSlot);

    @Inject(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isInvulnerableTo(Lnet/minecraft/entity/damage/DamageSource;)Z"),
            cancellable = true)
    public void longfallboots4fabric$disableFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (source == DamageSource.FALL) {
            ItemStack boots = getEquippedStack(EquipmentSlot.FEET);
            if (boots.getItem() == ModItems.LONG_FALL_BOOTS) {
                LongFallBootsItem.handleBootsDamage(boots, (LivingEntity) (Object) this, amount);
                cir.setReturnValue(true);
            }
        }
    }
}
