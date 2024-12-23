package io.github.ennuil.crooked_crooks.compat.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.ennuil.crooked_crooks.satire_config.SatireConfig;

public class ModModMenuCompat implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return SatireConfig::wrapConfigScreen;
	}
}
