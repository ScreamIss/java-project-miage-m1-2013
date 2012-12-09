/**
 * Activator.java
 */
package com.pluginsacceptor.api;

import java.util.Observer;

import javax.swing.JComponent;

/**
 * The interface describes method for activate plugin
 */
public interface Activator {


   /**
    * Inject plugin to root panel
    *
    * @param metadata the plugin name and etc
    * @return JComponent for injection
    */
    JComponent activate(String[] metadata);


    /**
     * Deactivate plugin
     * Plugin execute operation for stopping subprocesses and storage state
     * @return <code>true</code> if plugin was successfully deactivated
     */
    boolean deactivate();

    /**
     * Add available observer for plugin
     * @param observer the available observer for plugin
     */
    void addObserver(Observer observer);

    /**
     * Get available observer from plugin
     * @return observer from plugin
     */
    Observer getObserver();
}
