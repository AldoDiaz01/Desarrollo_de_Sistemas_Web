package com.dnieln7.ejb;

import com.dnieln7.ejb.client.SumaBeanClient;
import com.dnieln7.ejb.client.SumaBeanClient2;

public class Cliente {
    public static void main(String[] args) {
        SumaBeanClient sumaBeanClient = new SumaBeanClient();
        SumaBeanClient2 sumaBeanClient2 = new SumaBeanClient2();

        sumaBeanClient.sumaBean.name = "1";
        System.out.println(sumaBeanClient.sumaBean.name);
        System.out.println(sumaBeanClient2.sumaBean.name);
        sumaBeanClient2.sumaBean.name = "2";
        System.out.println(sumaBeanClient.sumaBean.name);
        System.out.println(sumaBeanClient2.sumaBean.name);
    }
}
