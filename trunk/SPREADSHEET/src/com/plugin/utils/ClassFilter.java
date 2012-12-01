package com.plugin.utils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author VadymPivak
 *
 */

public class ClassFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		Pattern p = Pattern.compile(".class");
		Matcher m = p.matcher(name);
		return m.lookingAt();
	}
}