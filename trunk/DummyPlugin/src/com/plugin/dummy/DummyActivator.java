/**
 * Activator.java
 */
package com.plugin.dummy;


import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

/**
 * The activator dummy
 */
public class DummyActivator implements Activator {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(DummyActivator.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JComponent activate(final String[] metadata, final int numCol, final int numRow) {
        LOG.info("Activate ");
        final JComponent component = new JPanel();
        final JTextField textField = new JTextField("Plugin succesfully activated " + metadata[0]);
        component.add(textField);
        return component;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deactivate() {
        LOG.info("Deactivate");
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final String[][] data) {

        LOG.info("Update");
        // TODO Auto-generated method stub

    }

}
