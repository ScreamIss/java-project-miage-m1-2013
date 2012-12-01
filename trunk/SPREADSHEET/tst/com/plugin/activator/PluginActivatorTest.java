/**
 * PluginActivatorTest.java
 */
package com.plugin.activator;

import org.junit.Test;

import com.plugin.exception.TechnicalException;

/**
 * Test
 */
public class PluginActivatorTest {

    @Test
    public void activate1() throws TechnicalException {
        PluginActivator.activate("tst/tstdata/plugin.jar");

    }

    @Test(expected = TechnicalException.class)
    public void activate2() throws TechnicalException {
        PluginActivator.activate("tst/tstdata/invalid.jar");
    }

    @Test(expected = TechnicalException.class)
    public void activate3() throws TechnicalException {
        PluginActivator.activate("tst/tstdata/invalid_mf.jar");
    }
}
