/*
 */
package com.empresaurios.bean;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Luis Angel
 */
@Singleton
@LocalBean
@Startup
public class SumaBean {

    public int sumar(int n1, int n2) {
        return n1 + n2;
    }
}
