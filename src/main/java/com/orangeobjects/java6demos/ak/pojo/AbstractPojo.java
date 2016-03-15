/*
 *  O R A N G E  O B J E C T S
 *  copyright by Orange Objects
 * 
 *  http://www.OrangeObjects.de
 * 
 *  $Id$
 */
package com.orangeobjects.java6demos.ak.pojo;

/**
 *
 * @author Armin Kling <armin.kling@orangeobjects.de>
 */
public abstract class AbstractPojo {

    private int version = 1;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
}
