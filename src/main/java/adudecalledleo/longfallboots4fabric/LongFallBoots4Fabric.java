package adudecalledleo.longfallboots4fabric;

import adudecalledleo.lionutils.LoggerUtil;
import adudecalledleo.lionutils.config.ConfigHolder;
import adudecalledleo.longfallboots4fabric.config.ModConfig;
import adudecalledleo.longfallboots4fabric.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LongFallBoots4Fabric implements ModInitializer {
    public static final String MOD_ID = "longfallboots4fabric";
    public static final String MOD_NAME = "Long Fall Boots";

    public static final Logger LOGGER = LoggerUtil.getLogger(MOD_NAME);
    public static final ConfigHolder<ModConfig> CONFIG_HOLDER = ConfigHolder.builder(MOD_ID + ".json", ModConfig.class, ModConfig::new)
            .setLogger(LOGGER)
            .build();

    @Override
    public void onInitialize() {
        CONFIG_HOLDER.load();
        ModItems.register();
        LOGGER.info("Aperture Science(TM) Long Fall Boots have been added to the game.");
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
