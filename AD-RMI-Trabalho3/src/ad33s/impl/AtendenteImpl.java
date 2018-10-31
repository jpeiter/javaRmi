package ad33s.impl;

import ad33s.interfaces.IAtendente;
import ad33s.interfaces.ICallbackAtendente;
import java.util.List;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AtendenteImpl extends UnicastRemoteObject implements IAtendente {

    List<List> listaSenhas;
    List<String> listaSenhasConvencional;
    List<String> listaSenhasPreferencial;
    List<String> listaSenhasVIP;
    Registry registry;
    ICallbackAtendente callback;

    public AtendenteImpl(List<List> listaSenhas, Registry registry) throws RemoteException {
        super();
        this.listaSenhas = listaSenhas;
        this.listaSenhasConvencional = listaSenhas.get(0);
        this.listaSenhasPreferencial = listaSenhas.get(1);
        this.listaSenhasVIP = listaSenhas.get(2);
        this.registry = registry;
    }

    @Override
    public void atualizarSenhas(String senha) throws RemoteException {
        System.out.println("Atualizando senha atendente");
    }

}
