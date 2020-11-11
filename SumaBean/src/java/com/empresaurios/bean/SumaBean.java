/*
 */
package com.empresaurios.bean;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.jws.WebService;

/**
 *
 * @author Luis Angel
 */
@Singleton
@Stateless
@LocalBean
@WebService
public class SumaBean {

    public int sumar(int num1, int num2) {
        return num1 + num2;
    }
}
