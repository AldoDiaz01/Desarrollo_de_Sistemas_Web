/*
 */
package com.empresaurios.bean;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 *
 * @author Luis Angel
 */
@Singleton
@Stateless
@LocalBean
public class SumaBean {
    
    public SumaBean() { }

    public int sumar(int num1, int num2) {
        return num1 + num2;
    }
}
