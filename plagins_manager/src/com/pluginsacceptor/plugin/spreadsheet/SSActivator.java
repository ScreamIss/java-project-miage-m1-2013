/**
 * SpreadSheetActivator.java
 */
package com.pluginsacceptor.plugin.spreadsheet;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.pluginsacceptor.api.Activator;
import com.pluginsacceptor.plugin.spreadsheet.model.SSData;

/**
 * Spread sheet activator
 */
public class SSActivator implements Activator {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(SSActivator.class);

    /** */
    private SSHandler handler;

    /** */
    private SSData data;

    /**
     * {@inheritDoc}
     */
    @Override
    public JComponent activate(final String[] metadata) {
        LOG.info("Activate Spread sheet plugin");
        this.data = new SSData(3, 3);
        this.handler = new SSHandler();
        return createUiComponent();
    }

    /**
     * Create UI component
     * @return new UI component
     */
    private JComponent createUiComponent() {
        final JComponent component = new JPanel();
        final JTextField textField = new JTextField("Spread sheet plugin succesfully activated ");
        textField.addFocusListener(new FocusListener() {

            /** */
            private String text;

            @Override
            public void focusLost(final FocusEvent arg0) {
                final String newText = textField.getText();
                if (!newText.equals(this.text)) {
                    try {
                        final double newValue = Double.parseDouble(newText);
                        // TODO custom position
                        data.setData(0, 0, newValue);
                        handler.notifyObservers(data);
                        LOG.debug("The data has changed '" + newValue + "'");
                        textField.setBackground(Color.GREEN);
                    } catch (final Exception e) {
                        LOG.warn("Ivalid value has been set '" + newText + "'", e);
                        textField.setBackground(Color.RED);
                    }
                }
            }

            @Override
            public void focusGained(final FocusEvent arg0) {
                this.text = textField.getText();
            }
        });

        component.add(textField);
        return component;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deactivate() {
        LOG.info("Deactivate Spread sheet plugin");
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setObserver(final Observer observer) {
        LOG.info("Added observer");
        this.handler.addObserver(observer);
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
