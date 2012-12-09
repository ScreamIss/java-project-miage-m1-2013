/**
 * SSData.java
 */
package com.pluginsacceptor.plugin.spreadsheet.model;

/**
 * The spread sheet data
 */
public class SSData {

    /** */
    private final double[][] data;

    /**
     * Constructor
     * @param numCol the number of columns
     * @param numRow the number of rows
     */
    public SSData(final int numCol, final int numRow) {
        super();
        this.data = new double[numCol][numRow];

//        for (int col = 0; col < numCol; col++) {
//            for (int row = 0; row < numRow; row++) {
//                this.data[col][row] = 0;
//            }
//        }
    }

    /**
     * @return the data
     */
    public double[][] getData() {
        return data;
    }


    /**
     * Set new value
     * @param colPos the column position
     * @param rowPos the row position
     * @param newVal the new value
     */
    public void setData(final int colPos, final int rowPos, final double newVal) {
        this.data[colPos][rowPos] = newVal;
    }
}
