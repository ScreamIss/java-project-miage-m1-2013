/**
 * ClassUtils.java
 */
package com.plugin.activator.utils;

/**
 * The class contains methods for technical operation under classes
 */
public class ClassUtils {


    /**
     * Transform package notation 'package.classname'
     * to file system notation 'package/classname.class'
     * @param clazz the class name with packages structure
     * @return package/classname.class
     */
    public static String packageToFileNotation(final String clazz) {
        return clazz.replace('.', '/').concat(".class");
    }

    /**
     * Transform file system notation 'package/classname.class'
     * to package notation 'package.classname'
     * @param clazz the class name with packages structure
     * @return package.classname
     */
    public static String fileToPackageNotation(final String clazz) {
        return clazz.substring(0, clazz.lastIndexOf(".class")).replace('/', '.');
    }

    /**
     * Constructor
     */
    private ClassUtils() {
        super();
    }
}
