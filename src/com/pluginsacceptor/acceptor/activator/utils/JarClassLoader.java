/**
 * JarClassLoader.java
 */
package com.pluginsacceptor.acceptor.activator.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureClassLoader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


/**
 * The class implements jar class loader
 */
public class JarClassLoader extends SecureClassLoader {

    /** */
    private final ZipFile file;

    /**
     * Constructor
     * @param filename the file for load
     * @throws IOException if IO error has occurred
     */
    public JarClassLoader(final String filename) throws IOException {
        this.file = new ZipFile(filename);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class findClass(final String name) throws ClassNotFoundException {
       // final String className = name.replace('.', '/') + ".class";
        final ZipEntry entry = this.file.getEntry(name);

        if (entry == null) {
            throw new ClassNotFoundException(name);
        }

        try {
            final ByteArrayOutputStream out = loadClassData(entry);
            final String defineClassName = ClassUtils.fileToPackageNotation(name);
            return defineClass(defineClassName, out.toByteArray(), 0, out.size());
        } catch (final IOException exception) {
            throw new ClassNotFoundException(name, exception);
        }
    }

    /**
     * Load class data
     * @param entry the source entry
     * @return data
     * @throws IOException if some IO error occurred
     */
    private ByteArrayOutputStream loadClassData(final ZipEntry entry) throws IOException {
        final byte[] array = new byte[1024];
        final InputStream in = this.file.getInputStream(entry);
        final ByteArrayOutputStream out = new ByteArrayOutputStream(array.length);
        int length;
        while ((length = in.read(array)) > 0) {
            out.write(array, 0, length);
        }
        return out;
    }
}