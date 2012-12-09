/**
 * ActivatorInfo.java
 */
package com.pluginsacceptor.acceptor.activator.model;

/**
 * The class contains information about plugin
 */
public class PluginInfo {

    /** */
    private final String name;

    /** */
    private final String[] requirements;

    /** */
    private final Object activatorInstanse;

    /** */
    private final Class activator;



    /**
     * Constructor
     * @param name the plugin name
     * @param requirements the required plugin name
     * @param activator the class of activator
     * @throws IllegalAccessException if error has occurred
     * @throws InstantiationException if error has occurred
     */
    public PluginInfo(final String name, final String[] requirements, final Class activator)
            throws InstantiationException, IllegalAccessException {
        super();
        this.name = name;
        this.requirements = requirements;
        this.activator = activator;
        this.activatorInstanse = activator.newInstance();
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the requirements
     */
    public String[] getRequirements() {
        return requirements;
    }

    /**
     * @return the activator
     */
    public Class getActivator() {
        return activator;
    }

    /**
     * @return the activatorInstanse
     */
    public Object getActivatorInstanse() {
        return activatorInstanse;
    }

}
