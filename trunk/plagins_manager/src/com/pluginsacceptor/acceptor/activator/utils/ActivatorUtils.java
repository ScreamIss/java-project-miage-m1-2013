/**
 * ActivatorUtils.java
 */
package com.pluginsacceptor.acceptor.activator.utils;

import java.util.Observer;

import javax.swing.JComponent;

import com.pluginsacceptor.acceptor.activator.model.PluginInfo;
import com.pluginsacceptor.acceptor.exception.TechnicalException;
import com.pluginsacceptor.api.Activator;

/**
 * The class contains utils methods for invoke activators methods
 */
public class ActivatorUtils {

    /**
     * Get observer
     * see {@link Activator}
     * @param pluginInfo the plugin info item
     * @return {@link Observer}
     * @throws TechnicalException if any error has occurred
     */
    public static Observer getObserver(final PluginInfo pluginInfo) throws TechnicalException {
        return (Observer) invokeMethod(pluginInfo, "getObserver");
    }

    /**
     * Set observer
     * see {@link Activator}
     * @param pluginInfo the plugin info item
     * @return {@link Observer}
     * @throws TechnicalException if any error has occurred
     */
    public static void setObserver(final PluginInfo pluginInfo, final Observer observer)
            throws TechnicalException {

        final Class[] paramTypes = new Class[] {Observer.class};
        final Object[] args = new Object[] {observer};
        invokeMethod(pluginInfo, "setObserver", paramTypes, args);
    }

    /**
     * Activate plugin
     * see {@link Activator}
     * @param pluginInfo the plugin info item
     * @return {@link JComponent}
     * @throws TechnicalException if any error has occurred
     */
    public static JComponent activate(final PluginInfo pluginInfo) throws TechnicalException {
        final Class[] paramTypes = new Class[] {String[].class};
        // TODO test
        final Object[] args = new Object[] {
            new String[] {new String("Name " + System.currentTimeMillis()) }
        };
        return (JComponent) invokeMethod(pluginInfo, "activate", paramTypes, args);
    }

    /**
     * Invoke activator method
     * @param pluginInfo the plugin info item
     * @param methodName the activator method name
     * @param paramTypes the array of parameters types
     * @param args the arguments using for the  method call
     * @return method return object
     * @throws TechnicalException if any error has occurred
     */
    private static Object invokeMethod(
        final PluginInfo pluginInfo,
        final String methodName,
        final Class[] paramTypes,
        final Object... args
    ) throws TechnicalException {

        try {
            return pluginInfo.getActivator().getMethod(methodName, paramTypes).invoke(
                pluginInfo.getActivatorInstanse(),
                args
            );
        } catch (final Exception e) {
            throw new TechnicalException(e);
        }
    }

    /**
     * Invoke activator method
     * @param pluginInfo the plugin info item
     * @param methodName the activator method name
     * @param paramTypes the array of parameters types
     * @param args the arguments using for the  method call
     * @return method return object
     * @throws TechnicalException if any error has occurred
     */
    private static Object invokeMethod(
        final PluginInfo pluginInfo,
        final String methodName
    ) throws TechnicalException {

        try {
            return pluginInfo.getActivator()
                .getMethod(methodName).invoke(pluginInfo.getActivatorInstanse());
        } catch (final Exception e) {
            throw new TechnicalException(e);
        }
    }
}
