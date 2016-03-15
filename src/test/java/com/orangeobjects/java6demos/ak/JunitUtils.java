/*
 *  O R A N G E  O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 *  $Id$
 */
package com.orangeobjects.java6demos.ak;

/**
 *
 * @author Armin Kling <armin.kling@orangeobjects.de>
 */
public class JunitUtils {

    public static void println(Object obj) {
        System.out.println("junit: " + obj);
    }

    public static void printf(String format, Object... args) {
        assert format != null;
        String msg = String.format(format, args);
        println(msg);
    }

    public static String exploreObject(Object obj) {
        if (obj == null) return "obj == null";
        StringBuilder sb = new StringBuilder();
        Class<?> clazz = obj.getClass();
        sb.append("class: ").append(clazz).append('\n');
        Class<?> ancestor = clazz.getSuperclass();
        while (ancestor != null) {
            sb.append("ancestor: ").append(ancestor).append('\n');
            ancestor = ancestor.getSuperclass();
        }
        for (java.lang.reflect.Type iface : clazz.getGenericInterfaces()) {
            sb.append("Interface: ").append(iface).append('\n');
        }
        return sb.toString();
    }
}
