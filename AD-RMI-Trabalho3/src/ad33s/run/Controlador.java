package ad33s.run;

import ad33s.impl.AtendenteImpl;
import ad33s.impl.CallbackAtendenteImpl;
import ad33s.interfaces.IAtendente;
import ad33s.interfaces.ICallbackAtendente;
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
public class Controlador implements IControlador {

    Registry registry = null;
    List<Guiche> listaSenhas = new ArrayList<>();
    IAtendente atendente;

    public Controlador(String ip, int porta) {
        try {
            registry = LocateRegistry.createRegistry(1053);
            atendente = (IAtendente) registry.lookup("Atendente");
            
            ICallbackAtendente callback = new CallbackAtendenteImpl();
            
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

    public static void main(String args[]) {
        Controlador s = new Controlador("127.0.0.1", 1053);
        s.iniciar();
    }

    @Override
    public void registrarAtendente(String nome, ICallbackAtendente callback) throws RemoteException {
        try {
            IAtendente atendente = new AtendenteImpl(listaSenhas, registry);
            registry.bind("Atendente " + nome, atendente);
            System.out.println("Atendente " + nome + " registrado.");
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
        }
    }

//    @Override
//    public void registrarPainel(String nome, ICallbackPainel callback) throws RemoteException {
//        try {
//            IPainel painel = new PainelImpl(listaSenhas, registry);
//            registry.bind("Painel " + nome, painel);
//            System.out.println("Atendente " + nome + " registrado.");
//        } catch (RemoteException ex) {
//            System.out.println("RemoteException: " + ex.getMessage());
//        } catch (AlreadyBoundException ex) {
//            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
//        }
//    }

    @Override
    public String solicitarSenha(String servico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atenderSenha(String serviço) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
