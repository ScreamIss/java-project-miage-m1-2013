/**
 * BeautifyActivator.java
 */
package com.pluginsacceptor.plugin.beautify;

import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.pluginsacceptor.api.Activator;


/**
 * The beautify (font) activator
 * This plugin will be inject to acceptor menu
 *
 * This plugin sends information to another plugin (addObserver() - used)
 * This plugin doesn't receive information from another plugin (getObserver() - not used)
 *
 */
public class BeautifyActivator implements Activator {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(BeautifyActivator.class);

    /** */
    private JTextField textField;

    /**
     * {@inheritDoc}
     */
    @Override
    public JComponent activate(final String[] metadata) {
        LOG.info("Activate beautify plugin");
        final JComponent component = new JButton("Beautify plugin succesfully activated");
        return component;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deactivate() {
        LOG.info("Deactivate beautify plugin");
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addObserver(final Observer observer) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Observer getObserver() {
        throw new UnsupportedOperationException("The method is not used");
    }

}