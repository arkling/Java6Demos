/*
 *  O R A N G E  O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 *  $Id$
 */
package com.orangeobjects.java6demos.ak.pojo;

import java.lang.annotation.*;

/**
 *
 * @author Armin Kling <armin.kling@orangeobjects.de>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface PojoAnnotation {
    String displayName() default "";
}
