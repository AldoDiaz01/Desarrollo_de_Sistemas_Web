/*
 */
package SessionBean;

import javax.ejb.Stateless;

/**
 *
 * @author Luis Angel
 */
@Stateless
public class calcularbean implements calcularbeanLocal {

    @Override
    public Integer sumar(int a, int b) {
        return (a + b);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
