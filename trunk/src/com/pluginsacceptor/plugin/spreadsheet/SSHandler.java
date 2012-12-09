/**
 * SpreadSheetObservable.java
 */
package com.pluginsacceptor.plugin.spreadsheet;

import java.util.Observable;

import com.pluginsacceptor.plugin.spreadsheet.model.SSData;

/**
 * The class creates updates spreatesheet data for listeners (observers)
 */
public class SSHandler extends Observable {

    /**
     * Notify observers about spreatesheet data changes
     * @param data the new data
     */
    public void notifyObservers(final SSData data) {
        setChanged();
        notifyObservers(data.getData());
    }
}
