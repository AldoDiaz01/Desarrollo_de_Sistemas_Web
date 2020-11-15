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
    private String foo = "Default Foo";

    public String getFoo() {
        return (this.foo);
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    private int bar = 0;

    public int getBar() {
        return (this.bar);
    }

    public void setBar(int bar) {
        this.bar = bar;
    }

}
