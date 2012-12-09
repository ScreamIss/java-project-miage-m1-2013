/**
 * PluginList.java
 */
package com.pluginsacceptor.acceptor.activator;

import java.util.ArrayList;
import java.util.List;

import com.pluginsacceptor.acceptor.activator.model.PluginInfo;

/**
 * The class storage list of active plugins
 */
public class PluginList {

    /** List of active plugings */
    private static final List<PluginInfo> activePlugins = new ArrayList<PluginInfo>();

    /**
     * Add plugin to list
     * @param pluginInfo the information about plugin
     */
    public static void addPlugin(final PluginInfo pluginInfo) {
        activePlugins.add(pluginInfo);
    }

//    /**
//     * Remove plugin to list
//     * @param pluginInfo the information about plugin
//     */
//    public static void removePlugin(final PluginInfo pluginInfo) {
//        activePlugins.remove(pluginInfo);
//    }

    /**
     * Return <code>true</code> if plugin contains in list
     * @param name the plugin name
     */
    public static boolean contains(final String name) {

        boolean result = false;
        for (final PluginInfo pluginInfo : activePlugins) {
            if (pluginInfo.getName().equals(name)) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * Get plugin instance for name
     * @param name the plugin name
     */
    public static PluginInfo getPluginInfo(final String name) {

        for (final PluginInfo pluginInfo : activePlugins) {
            if (pluginInfo.getName().equals(name)) {
                return pluginInfo;
            }
        }

        throw new UnsupportedOperationException("Plugin '" + name + "' is absent");
    }

}
