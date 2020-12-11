/*
 */
package com.empresaurios.bean;

import javax.ejb.Local;

/**
 *
 * @author Luis Angel
 */
@Local
public interface BeanOperationsLocal {
    
    Integer sumar(int num1, int num2);
    
}
