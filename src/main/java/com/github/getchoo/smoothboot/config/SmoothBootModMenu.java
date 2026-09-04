package com.github.getchoo.smoothboot.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class SmoothBootModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return screen -> new Screen(Component.nullToEmpty("")) {
            @Override
            protected void init() {
                ConfigHandler.openConfigFile();
                this.minecraft.setScreenAndShow(screen);
            }
        };
    }
}
