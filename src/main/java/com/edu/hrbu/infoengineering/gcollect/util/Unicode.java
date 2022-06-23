package com.edu.hrbu.infoengineering.gcollect.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Unicode {
    public static String toUnicode(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append("\\u");
            String hex = Integer.toHexString(s.charAt(i));
            StringBuilder strb = new StringBuilder();
            while(strb.length() + hex.length() < 4){strb.append('0');}
            strb.append(hex);
            sb.append(strb);
        }
        return sb.toString();
    }
    public static String toString(String s) {
        Pattern p = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher m = p.matcher(s);
        char ch;
        while (m.find()) {
            ch = (char) Integer.parseInt(m.group(2), 16);
            s = s.replace(m.group(1), ch + "");
        }
        return s;
    }
}