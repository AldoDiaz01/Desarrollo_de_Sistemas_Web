package com.empresaurios.ejb.operations.interfaces;

import javax.ejb.Remote;

/**
 *
 * @author daniel
 */
@Remote
public interface IOperations {

    public Integer suma(Integer x, Integer y);
}
