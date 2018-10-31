
/**
 * Exemplo Cliente - RMI
 * @author Prof. Dr. Fábio Favarim
 */

package ad33s.run;

import ad33s.impl.CallbackAtendenteImpl;
import ad33s.interfaces.IAtendente;
import ad33s.interfaces.ICallbackAtendente;
import ad33s.interfaces.IControlador;
import java.rmi.*;
import java.rmi.registry.*;

public class AtendenteRun {

    private IControlador con;

    public AtendenteRun(String ip, int porta) {
        try {
            //Buscar objeto remoto
            Registry registro = LocateRegistry.getRegistry(1053);
            con = (IControlador) registro.lookup("Controlador");
            
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (NotBoundException e) {
            System.out.println("Objeto não encontrado: " + e.getMessage());
        }
    }

    private void iniciar() {
        try {
            
            ICallbackAtendente atendente = new CallbackAtendenteImpl();
            con.registrarAtendente("Atendente1", atendente);
            
            
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        AtendenteRun c = new AtendenteRun("127.0.0.1", 1053);
        c.iniciar();
    }
}
