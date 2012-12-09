/**
 * PluginClassLoader.java
 */
package com.pluginsacceptor.acceptor.activator;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

import org.apache.log4j.Logger;

import com.pluginsacceptor.acceptor.activator.utils.JarClassLoader;

/**
 * The class contains methods for load classes of plugins
 */
public class PluginClassLoader {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(PluginClassLoader.class);

    /**
     * Load all classes in jar file
     * @param path the path to source file
     * @param entries the list of entries for load
     * @throws IOException if IO error has occurred
     * @throws ClassNotFoundException if class not found
     */
    public static ClassLoader loadAllClasses(
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
