/*
 */
package org.uv.empresaurios;

import javax.ejb.Remote;

/**
 *
 * @author Luis Angel
 */
@Remote
public interface operationsRemote {

    Integer suma(int num1, int num2);
    
}
