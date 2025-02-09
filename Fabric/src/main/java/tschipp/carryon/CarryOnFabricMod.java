/*
 * GNU Lesser General Public License v3
 * Copyright (C) 2024 Tschipp
 * mrtschipp@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package tschipp.carryon;

import net.fabricmc.api.ModInitializer;
import tschipp.carryon.config.fabric.ConfigLoaderImpl;
import tschipp.carryon.events.CommonEvents;

import java.io.IOException;

public class CarryOnFabricMod implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.
        CarryOnCommon.registerConfig();


        try {
            ConfigLoaderImpl.initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CommonEvents.registerEvents();
        CarryOnCommon.registerServerPackets();
        CarryOnCommon.registerClientPackets(false);

    }
}
