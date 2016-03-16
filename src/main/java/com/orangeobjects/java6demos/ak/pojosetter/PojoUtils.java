/*
 *  O R A N G E  O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 *  $Id$
 */
package com.orangeobjects.java6demos.ak.pojosetter;

import java.lang.reflect.Method;
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

    private static void expandFieldInfoList(Class<?> clazz, List<FieldInfo> fiList) {
        assert fiList != null;
        for (Method m : clazz.getDeclaredMethods()) {
            String name = m.getName();
            if (! name.startsWith("set")) continue;
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (parameterTypes.length != 1) continue;
            Class<?> returnType = m.getReturnType();
            if (!returnType.equals(void.class)) continue;
            FieldInfo fi = new FieldInfo();
            // remove "set" and lowercase first char: eg "setAbc" -> "abc"
            fi.name = name.substring(3,4).toLowerCase() + name.substring(4);
            fi.type = parameterTypes[0];
            PojoAnnotation anno = m.getAnnotation(PojoAnnotation.class);
            fi.displayName = anno != null ? anno.displayName() : fi.name;
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
