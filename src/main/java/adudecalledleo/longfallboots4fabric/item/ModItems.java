package adudecalledleo.longfallboots4fabric.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static adudecalledleo.longfallboots4fabric.LongFallBoots4Fabric.id;

public final class ModItems {
    private ModItems() {
        throw new UnsupportedOperationException();
    }

    public static final LongFallBootsItem LONG_FALL_BOOTS = new LongFallBootsItem(new Item.Settings()
            .group(ItemGroup.COMBAT));

    public static void register() {
        Registry.register(Registry.ITEM, id("long_fall_boots"), LONG_FALL_BOOTS);
    }
}
