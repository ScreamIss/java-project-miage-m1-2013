/**
 * PluginActivator.java
 */
package com.pluginsacceptor.acceptor.activator;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;

import com.pluginsacceptor.acceptor.activator.model.PluginInfo;
import com.pluginsacceptor.acceptor.activator.utils.ClassUtils;
import com.pluginsacceptor.acceptor.exception.TechnicalException;

/**
 * Check jar file and load all classes for create plugin instance
 */
public class PluginActivator {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(PluginActivator.class);

    /** */
    private static final String ACTIVATOR_CLASS = "Activator-Class";

    /** */
    private static final String REQUIRED_PLUGINS = "Required-Plugins";

    /** */
    private static final String PLUGIN_LOCATION = "Plugin-location";

    /** */
    private static final String MANIFEST = "META-INF/MANIFEST.MF";

    /**
     * Activate plugin
     * @param path the path to plugin
     * @return {@link PluginInfo}
     * @throws TechnicalException if we has invalid jar file
     */
    public static PluginInfo activate(final String path) throws TechnicalException {

        try {
            final ZipFile plugin = new ZipFile(new File(path));
            final Enumeration<? extends ZipEntry> entries = plugin.entries();
            final Attributes attributes = retrieveManifestAttributes(plugin);

            final String activatorClassName = getActivatorClassName(attributes);
            if (!isActivatorClassExist(plugin, activatorClassName)) {
                throw new TechnicalException(
                    "Activator class'" + activatorClassName + "' wasn't found"
                );
            }

            if (PluginList.contains(activatorClassName)) {
                throw new TechnicalException(
                    "Plugin already '" + activatorClassName + "' activated"
                );
            }

            final String[] requiredPluginsName = getRequiredPlugins(attributes);
            for (final String reqPluginName : requiredPluginsName) {
                if (!PluginList.contains(reqPluginName.trim())) {
                    throw new TechnicalException(
                        "Required plugin '" + reqPluginName + "' doesn't activated."
                    );
                }
            }

            final ClassLoader classLoader = PluginClassLoader.loadAllClasses(path, entries);

            return new PluginInfo(
                activatorClassName,
                requiredPluginsName,
                getPluginLocation(attributes),
                Class.forName(activatorClassName, true, classLoader)
            );
        } catch (final Exception e) {
            LOG.error("Activate error for '" + path + "'", e);
            throw new TechnicalException("Root cause:: " + e.getMessage());
        }
    }

    /**
     * Return <code>true</code> if activator class exist
     * @param plugin the plugin file
     * @param activatorClassName the activator class name
     * @return <code>true</code> if activator class exist
     */
    public static boolean isActivatorClassExist(
        final ZipFile plugin,
        final String activatorClassName
    ) {
        final String classPath = ClassUtils.packageToFileNotation(activatorClassName);
        LOG.debug("Class path '" + classPath + "'");
        return plugin.getEntry(classPath) != null;
    }

    /**
     * Get manifest from jar and search activator-class name in attributes
     * @param attributes the manifest attributes
     * @return activator class entry or null if class not found
     * @throws IOException if IO error has occurred
     * @throws ClassNotFoundException  if manifest not found
     */
    private static String getActivatorClassName(final Attributes attributes)
        throws IOException, ClassNotFoundException {

        final Name activatoClassName = new Name(ACTIVATOR_CLASS);

        if (!attributes.containsKey(activatoClassName)) {
            throw new ClassNotFoundException(
                "Activator class '" + ACTIVATOR_CLASS + "' not found in '" + MANIFEST + "'"
            );
        }

        return attributes.getValue(activatoClassName);
    }

    /**
     * Get manifest from jar and search activator-class name in attributes
     * @param attributes the manifest attributes
     * @return activator class entry or null if class not found
     * @throws IOException if IO error has occurred
     * @throws ClassNotFoundException  if manifest not found
     */
    private static String getPluginLocation(final Attributes attributes)
        throws IOException, ClassNotFoundException {

        final Name activatoClassName = new Name(PLUGIN_LOCATION);
        return attributes.getValue(activatoClassName);
    }

    /**
     * Return array of required plugins activator names
     * @param attributes the manifest attributes
     * @return array of required plugins activator names
     * @throws IOException if IO error has occurred
     * @throws ClassNotFoundException  if manifest not found
     */
    private static String[] getRequiredPlugins(final Attributes attributes)
        throws IOException, ClassNotFoundException {

        final Name requiredPlugins = new Name(REQUIRED_PLUGINS);

        if (!attributes.containsKey(requiredPlugins)) {
            throw new ClassNotFoundException(
                "Activator class '" + REQUIRED_PLUGINS + "' not found in '" + MANIFEST + "'"
            );
        }
        final String value = attributes.getValue(requiredPlugins);
        return (value == null || value.trim().isEmpty()) ? new String[] {} : value.split(",");
    }

    /**
     * Return Manifest Attributes
     * @param plugin the source archive
     * @return Manifest Attributes
     * @throws IOException if IO error has occurred
     * @throws ClassNotFoundException  if manifest not found
     */
    private static Attributes retrieveManifestAttributes(final ZipFile plugin)
            throws ClassNotFoundException, IOException {
        final ZipEntry entry = plugin.getEntry(MANIFEST);
        if (entry == null) {
            throw new ClassNotFoundException(
                "Manifest '" + MANIFEST + "' not found in '" + plugin.toString() + "'"
            );
        }
        final Manifest manifest = new Manifest(plugin.getInputStream(entry));
        final Attributes attributes = manifest.getMainAttributes();
        return attributes;
    }


}