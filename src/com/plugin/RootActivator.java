/**
 * Activator.java
 */
package com.plugin;

import javax.swing.JPanel;

import com.plugin.activator.Activator;

/**
 * The activator dummy
 */
public class RootActivator implements Activator {

    /**
     * {@inheritDoc}
     */
    @Override
    public JPanel inject() {
        System.out.println("Inject success");
        return null;
    }
}
