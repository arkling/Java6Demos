/*
 *  O R A N G E  O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 *  $Id$
 */
package com.orangeobjects.java6demos.ak.pojosetter;

import static com.orangeobjects.java6demos.ak.JunitUtils.println;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

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
        assertEquals(3, fia.length);
        println(Arrays.toString(fia));
        assertEquals(Long.class, fia[1].type);
    }


}
