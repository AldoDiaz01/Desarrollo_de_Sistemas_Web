
package com.empresaurios.bean;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SumaBean", targetNamespace = "http://bean.empresaurios.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SumaBean {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sumar", targetNamespace = "http://bean.empresaurios.com/", className = "com.empresaurios.bean.Sumar")
    @ResponseWrapper(localName = "sumarResponse", targetNamespace = "http://bean.empresaurios.com/", className = "com.empresaurios.bean.SumarResponse")
    @Action(input = "http://bean.empresaurios.com/SumaBean/sumarRequest", output = "http://bean.empresaurios.com/SumaBean/sumarResponse")
    public int sumar(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}
