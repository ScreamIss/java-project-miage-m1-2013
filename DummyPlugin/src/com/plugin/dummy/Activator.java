/**
 * Activator.java
 */
package com.plugin.dummy;

import javax.swing.JComponent;

/**
 * The interface describes method for activate plugin
 */
public interface Activator {


   /**
    * Inject plugin to root panel
    *
    * @param metadata the plugin name and etc
    * @param numCol the root plugin number of columns
    * @param numRow the root plugin number of rows
    * @return JComponent for injection
    */
    JComponent activate(String[] metadata,  int numCol, int numRow);


    /**
     * Deactivate plugin
     * Plugin execute operation for stopping subprocesses and storage state
     * @return <code>true</code> if plugin was successfully deactivated
     */
    boolean deactivate();


    /**
     * Plugin update root plugin date and redraw UI
     * @param data the root plugin date
     */
    void update(String[][] data);
}
