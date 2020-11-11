/*
 */
package com.empresaurios.webservice;

import com.empresaurios.bean.SumaBean;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Luis Angel
 */
@WebService(serviceName = "WebServiceSuma")
@Stateless()
public class WebServiceSuma {

    @EJB
    private SumaBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "sumar")
    public int sumar(@WebParam(name = "n1") int n1, @WebParam(name = "n2") int n2) {
        return ejbRef.sumar(n1, n2);
    }
    
}
