/**
 * ClassUtils.java
 */
package com.pluginsacceptor.acceptor.activator.utils;


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
     * Checking name in array
     * @param name the desired name
     * @param array the array names
     * @return <code>true</code> if desired name exist in array names
     */
    public static boolean isExist(final String name, final String[] array) {
        boolean result = false;

        for (final String tmp : array) {
            if (tmp.equals(name)) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * Constructor
     */
    private ClassUtils() {
        super();
    }
}
