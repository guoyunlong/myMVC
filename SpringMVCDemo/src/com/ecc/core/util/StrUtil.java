package com.ecc.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {
	

	/**
	 * 取出null值
	 * 
	 * @param object
	 * @return
	 */
	public static String checkNULL(Object object) {
		if (object == null)
			return "";
		else
			return object.toString();
	}
	
	public static boolean isNull(String str)  {
		if(str == null || str.trim().length() < 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getRegex(String regex) {
		if(StrUtil.isNull(regex)) {
			return "";
		}
		StringBuffer strBuf = new StringBuffer();
		for(int i=0; i<regex.length(); i++) {
			String m = "" + regex.charAt(i);
			if(m.equals(" ")) {
				strBuf.append("\\s");
				continue;
			}
			strBuf.append("[");
			strBuf.append( ( "" + regex.charAt(i) ).toUpperCase() );
			strBuf.append("|");
			strBuf.append( ( "" + regex.charAt(i) ).toLowerCase() );
			strBuf.append("]");
		}
		return strBuf.toString();
	}
	
	public static int lastIndexOfRegex(String regex, String str) {
	    Pattern p = Pattern.compile(regex);
	    Matcher m = p.matcher(str);
	    int lastIndex = -1;
	    int pos = 0;
	    while (m.find(pos)) {
	        pos = m.start() + 1;
	        lastIndex = m.start();
	    }	
	    return lastIndex;
	}
	
	public static int indexOf(String regex, String str) {
	    Pattern p = Pattern.compile(getRegex(regex));
	    Matcher m = p.matcher(str);
	    while (m.find(0)) {
	    	return m.start();
	    }	
	    return -1;
	}
	
	public static int lastIndexOf(String regex, String str) {
	    Pattern p = Pattern.compile(getRegex(regex));
	    Matcher m = p.matcher(str);
	    int lastIndex = -1;
	    int pos = 0;
	    while (m.find(pos)) {
	        pos = m.start() + 1;
	        lastIndex = m.start();
	    }	
	    return lastIndex;
	}
}
