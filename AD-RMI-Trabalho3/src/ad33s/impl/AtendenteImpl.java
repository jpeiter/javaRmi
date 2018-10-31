package ad33s.impl;

import ad33s.interfaces.IAtendente;
import ad33s.interfaces.ICallbackAtendente;
import ad33s.model.Atendente;
import ad33s.model.Guiche;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.util.List;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtendenteImpl extends UnicastRemoteObject implements IAtendente {

    List<Guiche> listaSolicitacoes = new ArrayList<>();
    Registry registry;
    ICallbackAtendente callback;

    public AtendenteImpl(List<Guiche> listaSolicitacoes, Registry registry) throws RemoteException {
        super();
        this.listaSolicitacoes = listaSolicitacoes;
        this.registry = registry;
    }

    @Override
    public void chamaSenha(String servico) throws RemoteException {
        try {
            registry.lookup("Controlador");
            
        } catch (NotBoundException ex) {
            Logger.getLogger(AtendenteImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(AtendenteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<String> login(Atendente atendente, ICallbackAtendente callback) throws RemoteException {

    }

}
