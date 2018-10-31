package ad33s.run;

import ad33s.impl.ControladorImpl;
import ad33s.interfaces.IControlador;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

/**
 *
 * @author jpeit
 */
public class Servidor {

    private Registry registro;

    public Servidor(int porta) {
        try {
            registro = LocateRegistry.createRegistry(porta);

        } catch (Exception e) {
            System.out.println("Erro:" + e);
        }
    }

    public final void iniciar() {
        try {
            IControlador controlador = new ControladorImpl(registro);
            registro.bind("Controlador", controlador);
            System.out.println("Servidor está executando.");
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        Servidor s = new Servidor(1053);
        s.iniciar();
    }
}
