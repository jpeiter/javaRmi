package ad33s.run;

import ad33s.impl.ControladorImpl;
import ad33s.interfaces.IControlador;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

/**
 *
 * @author Prof. Fábio Favarim
 */
public class Servidor {
    Registry registro;
    public Servidor(String ip, int porta) {
        try {
           // Localizar instância do registro de referências remotas já existente
            //registro = LocateRegistry.getRegistry(ip, porta);

           // ou Criar instância do registro de referências remotas
           registro = LocateRegistry.createRegistry(1053);

        } catch (Exception e) {
            System.out.println("Erro:" + e);
        }
    }

    public final void iniciar() {
        try {
            IControlador con = new ControladorImpl();
            registro.bind("Controlador", con);
            System.out.println("Servidor está executando.");        
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
        }
    }

    
    public static void main(String args[]) {
        Servidor s = new Servidor("127.0.0.1", 1053);
        s.iniciar();
    }
}
