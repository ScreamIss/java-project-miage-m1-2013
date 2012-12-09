/**
 * ChartActivator.java
 */
package com.pluginsacceptor.plugin.chart;

import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.pluginsacceptor.api.Activator;

/**
 * Spread sheet activator
 */
public class ChartActivator implements Activator {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(ChartActivator.class);

    /** */
    private JTextField textField;

    /**
     * {@inheritDoc}
     */
    @Override
    public JComponent activate(final String[] metadata) {
        LOG.info("Activate chart plugin");
        final JComponent component = new JPanel();
        textField = new JTextField("Chart plugin succesfully activated ");
        component.add(textField);
        return component;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deactivate() {
        LOG.info("Deactivate chart plugin");
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setObserver(final Observer observer) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Observer getObserver() {
        return new ChartObserver(textField);
    }

}
