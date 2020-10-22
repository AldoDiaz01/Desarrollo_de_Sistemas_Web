/*
 */
package SessionBean;

import javax.ejb.Local;

/**
 *
 * @author Luis Angel
 */
@Local
public interface calcularbeanLocal {

    Integer sumar(int a, int b);
    
}
