package adudecalledleo.longfallboots4fabric.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static adudecalledleo.longfallboots4fabric.LongFallBoots4Fabric.CONFIG_HOLDER;

public class ModConfigGui {
    public static ConfigBuilder getConfigBuilder() {
        final ModConfig cfg = CONFIG_HOLDER.get();
        ConfigBuilder cb = ConfigBuilder.create().setTitle(t("title"));
        cb.setSavingRunnable(CONFIG_HOLDER::save);
        addGeneralCategory(cfg, cb);
        return cb;
    }

    private static final ModConfig DEFAULTS = new ModConfig();

    private static String k(String key) {
        return "longfallboots4fabric.config." + key;
    }

    private static Text t(String key) {
        return new TranslatableText(k(key));
    }

    private static Supplier<Optional<Text[]>> tooltip(final String key) {
        final Optional<Text[]> data = Optional.of(new Text[] { new TranslatableText(key) });
        return () -> data;
    }

    private static Supplier<Optional<Text[]>> tooltip(final String... keys) {
        final Optional<Text[]> data = Optional.of(Arrays.stream(keys).map(TranslatableText::new).toArray(Text[]::new));
        return () -> data;
    }

    private static Supplier<Optional<Text[]>> tooltip(final String key, final int count) {
        if (count == 1)
            return tooltip(key);
        return tooltip(IntStream.range(0, count).mapToObj(i -> String.format("%s[%d]", key, i)).toArray(String[]::new));
    }

    private static void addGeneralCategory(ModConfig cfg, ConfigBuilder cb) {
        ConfigEntryBuilder eb = cb.entryBuilder();
        ConfigCategory cGeneral = cb.getOrCreateCategory(t("category.general"));
        cGeneral.addEntry(eb.startFloatField(t("general.boots_damage_multiplier"), cfg.bootsDamageMultiplier)
                .setSaveConsumer(value -> cfg.bootsDamageMultiplier = value)
                .setTooltipSupplier(tooltip(k("general.boots_damage_multiplier.tooltip"), 3))
                .setDefaultValue(DEFAULTS.bootsDamageMultiplier).build());
    }
}
