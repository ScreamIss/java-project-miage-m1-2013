/**
 * FormulaActivator.java
 */
package com.pluginsacceptor.plugin.formula;

import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.pluginsacceptor.api.Activator;

/**
 * The formula plugin activator
 * This plugin will be inject to acceptor main panel
 *
 * This plugin doesn't send information to another plugin (addObserver() - not used)
 * This plugin receives information from another plugin (getObserver() - used)
 */
public class FormulaActivator implements Activator {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(FormulaActivator.class);

    /** */
    private JTextField textField;

    /**
     * {@inheritDoc}
     */
    @Override
    public JComponent activate(final String[] metadata) {
        LOG.info("Activate Formula plugin");
        final JComponent component = new JPanel();
        textField = new JTextField("Formula plugin succesfully activated ");
        component.add(textField);
        return component;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deactivate() {
        LOG.info("Deactivate Formula plugin");
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addObserver(final Observer observer) {
        throw new UnsupportedOperationException("The method is not used");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Observer getObserver() {
        return new FormulaObserver(textField);
    }

}
