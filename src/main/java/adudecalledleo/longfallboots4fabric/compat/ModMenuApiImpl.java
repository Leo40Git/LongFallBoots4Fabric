package adudecalledleo.longfallboots4fabric.compat;

import adudecalledleo.longfallboots4fabric.config.ModConfigGui;
import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

public class ModMenuApiImpl implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> ModConfigGui.getConfigBuilder().setParentScreen(parent).build();
    }
}
