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
class EMail {

    private String domainPart;
    private String localPart;

    public String getDomainPart() {
        return domainPart;
    }

    public void setDomainPart(String domainPart) {
        this.domainPart = domainPart;
    }

    public String getLocalPart() {
        return localPart;
    }

    public void setLocalPart(String localPart) {
        this.localPart = localPart;
    }
}
