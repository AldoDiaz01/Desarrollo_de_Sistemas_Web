package com.empresaurios.ejb.operations;

import com.empresaurios.ejb.operations.interfaces.IOperations;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author daniel
 */
@Stateless(name = "Operations")
public class Operations implements IOperations {

    @Resource
    private SessionContext context;

    @Override
    public Integer suma(Integer x, Integer y) {
        return x + y;
    }
}
