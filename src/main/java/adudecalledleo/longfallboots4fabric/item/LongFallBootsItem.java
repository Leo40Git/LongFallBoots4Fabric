package adudecalledleo.longfallboots4fabric.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

import static adudecalledleo.longfallboots4fabric.LongFallBoots4Fabric.CONFIG_HOLDER;

public class LongFallBootsItem extends ArmorItem {
    private static final Text FLAVOR_TEXT =
            new TranslatableText("item.longfallboots4fabric.long_fall_boots.flavor")
                    .styled(style -> style.withColor(Formatting.GRAY));

    public LongFallBootsItem(Settings settings) {
        super(LongFallBootsArmorMaterial.INSTANCE, EquipmentSlot.FEET, settings);
    }

    public static void handleBootsDamage(ItemStack boots, LivingEntity entity, float amount) {
        boots.damage((int) ((amount + entity.getRandom().nextFloat() * 2)  * CONFIG_HOLDER.get().bootsDamageMultiplier),
                entity, livingEntity -> livingEntity.sendEquipmentBreakStatus(EquipmentSlot.FEET));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(FLAVOR_TEXT);
    }
}
