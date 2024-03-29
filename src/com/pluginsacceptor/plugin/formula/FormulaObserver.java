/**
 * FormulaObserver.java
 */
package com.pluginsacceptor.plugin.formula;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import org.apache.log4j.Logger;

/**
 * The class contains method for update data from formula plugin
 */
public class FormulaObserver implements Observer {

    /** Logger */
    private static final Logger LOG = Logger.getLogger(FormulaObserver.class);

    /** */
    private final JTextField textField;

    // TODO need update UI component

    /**
     * Constructor
     */
    public FormulaObserver(final JTextField textField) {
        this.textField = textField;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Observable arg0, final Object externalData) {

        if (externalData instanceof double[][]) {

            final double[][] data = (double[][]) externalData;

            // TODO test
            this.textField.setText(String.valueOf(data[0][0]));

            for (int col = 0; col < data.length; col++) {
                for (int row = 0; row < data[col].length; row++) {
                    LOG.debug(" " + data[col][row]);
                }
                LOG.debug("\n ");
            }
        }
    }
}
