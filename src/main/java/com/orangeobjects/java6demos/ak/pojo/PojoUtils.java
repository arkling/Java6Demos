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
        // FIXME ak: add implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static FieldInfo[] extractFieldInfo(Class<? extends AbstractPojo> clazz) {
        List<FieldInfo> fiList = new ArrayList<FieldInfo>();
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

    private PojoUtils() { }

}
