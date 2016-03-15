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
public class SimplePojo extends AbstractPojo {

    private Long dbZugangsId;

    @PojoAnnotation(displayName = "Email Alias")
    private EMail emailAdresseAlias;

    public Long getDbZugangsId() {
        return dbZugangsId;
    }

    public void setDbZugangsId(Long dbZugangsId) {
        this.dbZugangsId = dbZugangsId;
    }

    public EMail getEmailAdresseAlias() {
        return emailAdresseAlias;
    }

    public void setEmailAdresseAlias(EMail emailAdresseAlias) {
        this.emailAdresseAlias = emailAdresseAlias;
    }

    public String getFoo() { return "ups"; }
}
