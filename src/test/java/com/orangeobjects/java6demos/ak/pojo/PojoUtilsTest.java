/*
 *  O R A N G E  O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 *  $Id$
 */
package com.orangeobjects.java6demos.ak.pojo;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.orangeobjects.java6demos.ak.JunitUtils.*;
import java.util.Arrays;
import org.apache.commons.beanutils.PropertyUtils;

/**
 *
 * @author Armin Kling <armin.kling@orangeobjects.de>
 */
public class PojoUtilsTest {

    public PojoUtilsTest() {
    }

    @Test
    public void testExtract() throws Exception {
        PojoUtils.FieldInfo[] fia = PojoUtils.extractFieldInfo(SimplePojo.class);
        assertEquals(2, fia.length);
        println(Arrays.toString(fia));
        assertEquals(Long.class, fia[0].type);
    }

    @Test
    public void testPropertyRead() throws Exception {
        SimplePojo pojo = new SimplePojo();
        pojo.setDbZugangsId(123L);
        Long dbZugangsId = (Long) PropertyUtils.getSimpleProperty(pojo, "dbZugangsId");
        assertEquals(123L, dbZugangsId.longValue());
    }

    @Test
    public void testPropertyWrite() throws Exception {
        SimplePojo pojo = new SimplePojo();
        PropertyUtils.setSimpleProperty(pojo, "dbZugangsId", Long.valueOf(5L));
        assertEquals(5L, pojo.getDbZugangsId().longValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPropertyWriteWrongType() throws Exception {
        SimplePojo pojo = new SimplePojo();
        PropertyUtils.setSimpleProperty(pojo, "dbZugangsId", "wrongType");
    }

    @Test(expected = NoSuchMethodException.class)
    public void testPropertyWriteFail() throws Exception {
        SimplePojo pojo = new SimplePojo();
        PropertyUtils.setSimpleProperty(pojo, "xxx", Long.valueOf(5L));
    }

    @Test
    public void testGetFoo() throws Exception {
        SimplePojo pojo = new SimplePojo();
        String foo = (String) PropertyUtils.getSimpleProperty(pojo, "foo");
        assertEquals("ups", foo);
    }

    @Test
    public void testGetVersion() throws Exception {
        SimplePojo pojo = new SimplePojo();
        int version = (Integer) PropertyUtils.getSimpleProperty(pojo, "version");
        assertEquals(1, version);
    }
}
