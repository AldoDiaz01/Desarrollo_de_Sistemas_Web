package com.dnieln7.ejb.client;

import com.dnieln7.ejb.bean.SumaBean;

import javax.ejb.EJB;

public class SumaBeanClient2 {

    @EJB
    public SumaBean sumaBean;

    public SumaBeanClient2() {
        sumaBean = new SumaBean();
    }
}
