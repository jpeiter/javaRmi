package ad33s.run;

import ad33s.impl.AtendenteImpl;
import ad33s.interfaces.IAtendente;
import ad33s.interfaces.IGuiche;
import ad33s.model.Atendente;
import ad33s.model.Guiche;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpeit
 */
public class Controlador {

    Registry registry = null;
    List<Guiche> listaSenhas = new ArrayList<>();

    public Controlador(String ip, int porta) {
        try {
            registry = LocateRegistry.createRegistry(1053);

        } catch (Exception e) {
            System.out.println("Erro:" + e);
        }
    }

    public final void iniciar() {
        try {
            IAtendente atendente = new AtendenteImpl(listaSenhas, registry);
            registry.bind("Controlador", atendente);
            System.out.println("Controlador está executando.");
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
        }
    }

    public void registrarPainel() {
        try {
            IPainel painel = new PainelImpl()
            System.out.println("Controlador está executando.");
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        Controlador s = new Controlador("127.0.0.1", 1053);
        s.iniciar();
    }
}
