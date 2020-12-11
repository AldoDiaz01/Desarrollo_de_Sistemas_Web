/*
 */
package org.uv.empresaurios;

import javax.ejb.Stateless;

/**
 *
 * @author Luis Angel
 */
@Stateless
public class operations implements operationsRemote {

    @Override
    public Integer suma(int num1, int num2) {
        return num1 + num2;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
