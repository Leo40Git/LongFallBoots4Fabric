package adudecalledleo.longfallboots4fabric.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public enum LongFallBootsArmorMaterial implements ArmorMaterial {
    INSTANCE;

    private static final Lazy<Ingredient> REPAIR_INGREDIENT_SUPPLIER = new Lazy<>(() -> Ingredient.ofItems(Items.IRON_INGOT));

    public int getDurability(EquipmentSlot slot) {
        return 195;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return 2;
    }

    public int getEnchantability() {
        return 9;
    }

    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    public Ingredient getRepairIngredient() {
        return REPAIR_INGREDIENT_SUPPLIER.get();
    }

    @Environment(EnvType.CLIENT)
    public String getName() {
        return "long_fall_boots";
    }

    public float getToughness() {
        return 0;
    }

    public float getKnockbackResistance() {
        return 0;
    }
}
