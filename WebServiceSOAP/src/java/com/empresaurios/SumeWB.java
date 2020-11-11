/*
 */
package com.empresaurios;

import javax.jws.WebService;

/**
 *
 * @author Luis Angel
 */
@WebService(serviceName = "SumaBeanService", portName = "SumaBeanPort", endpointInterface = "com.empresaurios.bean.SumaBean", targetNamespace = "http://bean.empresaurios.com/", wsdlLocation = "WEB-INF/wsdl/SumeWB/localhost_8080/SumaBeanService/SumaBean.wsdl")
public class SumeWB {

    public int sumar(int arg0, int arg1) {
        //TODO implement this method
        return arg0 + arg1;
    }
    
}
