package ad33s.run;

import ad33s.impl.AtendenteImpl;
import ad33s.interfaces.IAtendente;
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
    List<Guiche> listaSolicitacoes = new ArrayList<>();

    public Controlador(String ip, int porta) {
        try {
            registry = LocateRegistry.createRegistry(1053);

        } catch (Exception e) {
            System.out.println("Erro:" + e);
        }
    }

    public boolean iniciarAtendente(String nomeAtendente) {
        try {
            IAtendente atendente = new AtendenteImpl(listaSolicitacoes, registry);
            registry.bind("Atendente " + nomeAtendente, atendente);
            System.out.println("Atendente " + nomeAtendente + "registrado.");

            return true;
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
        }
        return false;
    }

    public boolean iniciarGuiche(int numeroGuiche) {
        try {
            IGuiche guiche = new GuicheImpl(listaSolicitacoes, registry);
            registry.bind("Guiche " + numeroGuiche, guiche);
            System.out.println("Guichê " + numeroGuiche + " registrado.");

            return true;
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
        }
        return false;
    }

    public boolean iniciarPainel(int numeroPainel) {
        try {
            IPainel painel = new PainelImpl(listaSolicitacoes, registry);
            registry.bind("Painel " + numeroPainel, painel);
            System.out.println("Painel " + numeroPainel + " registrado.");

            return true;
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
        }
        return false;
    }

    public static void main(String args[]) {
        Controlador s = new Controlador("127.0.0.1", 1053);
    }
}
