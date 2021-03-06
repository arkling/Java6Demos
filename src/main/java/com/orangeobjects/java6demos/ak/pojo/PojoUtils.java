/*
 *  O R A N G E  O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 *  $Id$
 */
package com.orangeobjects.java6demos.ak.pojo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Armin Kling <armin.kling@orangeobjects.de>
 */
public class PojoUtils {

    static class FieldInfo {
        String name;
        Class<?> type;
        String displayName;

        @Override
        public String toString() {
            return "FieldInfo{" + "name=" + name + ", type=" + type + ", displayName=" + displayName + '}';
        }
        
    }

    public static FieldInfo[] extractFieldInfo(AbstractPojo pojo) {
        return extractFieldInfo(pojo.getClass());
    }

    private static void expandFieldInfoList(Class<?> clazz, List<FieldInfo> fiList) {
        assert fiList != null;
        for (Field f : clazz.getDeclaredFields()) {
            FieldInfo fi = new FieldInfo();
            fi.type = f.getType();
            fi.name = f.getName();
            PojoAnnotation anno = f.getAnnotation(PojoAnnotation.class);
            fi.displayName = anno != null ? anno.displayName() : f.getName();
            fiList.add(fi);
        }
    }

    public static FieldInfo[] extractFieldInfo(Class<? extends AbstractPojo> clazz) {
        List<FieldInfo> fiList = new ArrayList<FieldInfo>();
        Class<?> superclazz = clazz.getSuperclass();
        assert superclazz.equals(AbstractPojo.class);
        expandFieldInfoList(superclazz, fiList);
        expandFieldInfoList(clazz, fiList);
        FieldInfo[] fia = new FieldInfo[fiList.size()];
        return fiList.toArray(fia);
    }

    public static FieldInfo[] extractFieldInfoOLD(Class<? extends AbstractPojo> clazz) {
        List<FieldInfo> fiList = new ArrayList<FieldInfo>();
        Class<?> superclass = clazz.getSuperclass();
        assert superclass.equals(AbstractPojo.class);
        for (Field f : clazz.getDeclaredFields()) {
            FieldInfo fi = new FieldInfo();
            fi.type = f.getType();
            fi.name = f.getName();
            PojoAnnotation anno = f.getAnnotation(PojoAnnotation.class);
            fi.displayName = anno != null ? anno.displayName() : f.getName();
            fiList.add(fi);
        }
        FieldInfo[] fia = new FieldInfo[fiList.size()];
        return fiList.toArray(fia);
    }

    /**
     * Copy all Fields from source pojo to destination pojo where
     * field name and field type are the same.
     * @param from non null source pojo
     * @param to non null destination pojo
     */
    public void copyFields(AbstractPojo from, AbstractPojo to) {
        // FIXME ak: add implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private PojoUtils() { }

}
