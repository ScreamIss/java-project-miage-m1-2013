/**
 * Activator.java
 */
package com.pluginsacceptor.plugin.dummy;


import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.pluginsacceptor.api.Activator;

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
    public JComponent activate(final String[] metadata) {
        LOG.info("Activate dummy plugin");
        final JComponent component = new JPanel();
        final JTextField textField = new JTextField("Dummy plugin succesfully activated ");
        component.add(textField);
        return component;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deactivate() {
        LOG.info("Deactivate dummy plugin");
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setObserver(final Observer observer) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see com.pluginsacceptor.api.Activator#getObserver()
     */
    @Override
    public Observer getObserver() {
        // TODO Auto-generated method stub
        return null;
    }
}
