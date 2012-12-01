/**
 * PluginActivator.java
 */
package com.plugin.activator;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;

import com.plugin.activator.utils.ClassUtils;
import com.plugin.activator.utils.JarClassLoader;
import com.plugin.exception.TechnicalException;

/**
 * Check jar file and load all classes for create plugin instance
 */
public class PluginActivator {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(PluginActivator.class);

    /** */
    private static final String ACTIVATOR_CLASS = "Activator-Class";

    /** */
    private static final String MANIFEST = "META-INF/MANIFEST.MF";


    /** Plugin file instanse */
    private final ZipFile pluginFile;

    /** Pluqin file entries */
    private final Enumeration<? extends ZipEntry> pluginFileEntries;




    /**
     * Constructor
     * @param path the path to plugin file
     * @throws IOException
     * @throws ZipException
     */
    public PluginActivator(final String path) throws ZipException, IOException {
        super();
        this.pluginFile = new ZipFile(new File(path));
        this.pluginFileEntries = pluginFile.entries();
    }

    /**
     * Activate plugin
     * @param path the path to plugin
     * @return <code>true</code> if plugin was loaded
     * @throws TechnicalException if we has invalid jar file
     */
    public static Class activate(final String path) throws TechnicalException {

        try {
            final ZipFile plugin = new ZipFile(new File(path));
            final Enumeration<? extends ZipEntry> entries = plugin.entries();
            final String activatorClassName = getActivatorClassName(plugin);
            if (!isActivatorClassExist(plugin, activatorClassName)) {
                throw new TechnicalException(
                    "Activator class'" + activatorClassName + "' wasn't found"
                );
            }

            final ClassLoader classLoader = loadAllClasses(path, entries);


            return createActivatorInstanse(activatorClassName, classLoader);

        } catch (final Exception e) {
            LOG.error("Activate error for '" + path + "'", e);
            throw new TechnicalException("Activate error for '" + path + "'", e);
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
     * Create instance of activator class
     * @param className the class name
     * @return activator instance
     * @throws TechnicalException if error has occurred
     */
    private static Class createActivatorInstanse(final String className, final ClassLoader classLoader)
        throws TechnicalException {

        try {
            final Class clazz = Class.forName(className, true, classLoader);

            return clazz;
        } catch (final Exception e) {
            throw new TechnicalException(e);
        }
    }


    /**
     * Get manifest from jar and search activator-class name in attributes
     * @param plugin the source archive
     * @return activator class entry or null if class not found
     * @throws IOException if IO error has occurred
     * @throws ClassNotFoundException  if manifest not found
     */
    private static String getActivatorClassName(final ZipFile plugin)
        throws IOException, ClassNotFoundException {

        final ZipEntry entry = plugin.getEntry(MANIFEST);
        if (entry == null) {
            throw new ClassNotFoundException(
                "Manifest '" + MANIFEST + "' not found in '" + plugin.toString() + "'"
            );
        }
        final Manifest manifest = new Manifest(plugin.getInputStream(entry));
        final Attributes attributes = manifest.getMainAttributes();
        final Name activatoClassName = new Name(ACTIVATOR_CLASS);

        if (!attributes.containsKey(activatoClassName)) {
            throw new ClassNotFoundException(
                "Activator class '" + ACTIVATOR_CLASS + "' not found in '" + MANIFEST + "'"
            );
        }

        return attributes.getValue(activatoClassName);
    }

    /**
     * Load all classes in jar file
     * @param path the path to source file
     * @param entries the list of entries for load
     * @throws IOException if IO error has occurred
     * @throws ClassNotFoundException if class not found
     */
    private static ClassLoader loadAllClasses(
        final String path,
        final Enumeration<? extends ZipEntry> entries
    ) throws IOException, ClassNotFoundException {

        LOG.info("Load " + path);
        final ClassLoader classLoader = new JarClassLoader(path);

        while (entries.hasMoreElements()) {
            final String enEntry = entries.nextElement().getName();
            if (enEntry.endsWith(".class")) {
                classLoader.loadClass(enEntry);
                LOG.info("Loaded: " + enEntry);
            }
        }

        return classLoader;
    }
}