/**
 * Main.java
 */
package com.plugin;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.plugin.root.RootPlaginWindow;

/**
 * The main class for plugin project
 */
public class Main {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(Main.class);

    /** Path to log properties */
    private static final String LOG_PROPERTIES_FILE = "log4j.properties";

    /**  */
    public static void main(final String[] args) {
        // initialisation du fichier properties

        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);

        LOG.info("------------------ Start -------------------");

        new RootPlaginWindow().create();

        LOG.info("------------------  End  -------------------");

    }

}