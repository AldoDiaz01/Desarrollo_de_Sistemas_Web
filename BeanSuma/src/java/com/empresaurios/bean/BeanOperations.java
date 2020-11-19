/*
 */
package com.empresaurios.bean;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;

/**
 *
 * @author Luis Angel
 */
@Startup
@Singleton
@Stateless(name = "BeanOperations")
public class BeanOperations implements BeanOperationsLocal {

    @Resource
    private SessionContext context;

    @Override
    public Integer sumar(int num1, int num2) {
        return num1 + num2;
    }

}
