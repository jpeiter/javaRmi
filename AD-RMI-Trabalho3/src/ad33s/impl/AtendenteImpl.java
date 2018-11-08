package ad33s.impl;

import ad33s.interfaces.IAtendente;
import ad33s.interfaces.ICallbackAtendente;
import java.util.List;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AtendenteImpl extends UnicastRemoteObject implements IAtendente {

    Registry registry;
    ICallbackAtendente callback;
    List<List> listaSenhas;
    List<String> listaSenhasConvencional;
    List<String> listaSenhasPreferencial;
    List<String> listaSenhasVIP;

    public AtendenteImpl(List<List> listaSenhas, Registry registry, ICallbackAtendente callback) throws RemoteException {
        super();
        this.registry = registry;
        this.callback = callback;
        this.listaSenhas = listaSenhas;
        this.listaSenhasConvencional = listaSenhas.get(0);
        this.listaSenhasPreferencial = listaSenhas.get(1);
        this.listaSenhasVIP = listaSenhas.get(2);
    }

    @Override
    public void atualizarTamanhoFila(String tipo, int tamanho) throws RemoteException {
        callback.atualizaTamanhoFila(tipo, tamanho);
    }

}
