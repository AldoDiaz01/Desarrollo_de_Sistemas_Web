/*
 */
package soapcliente;

/**
 *
 * @author Luis Angel
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(sumar(10,5));
    }

    private static int sumar(int n1, int n2) {
        soapcliente.WebServiceSuma_Service service = new soapcliente.WebServiceSuma_Service();
        soapcliente.WebServiceSuma port = service.getWebServiceSumaPort();
        return port.sumar(n1, n2);
    }
    
}
