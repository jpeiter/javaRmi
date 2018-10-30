package ad33s.impl;

import ad33s.interfaces.IAtendente;
import ad33s.model.Guiche;
import java.util.List;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class AtendenteImpl extends UnicastRemoteObject implements IAtendente {

    List<Guiche> listaSolicitacoes = new ArrayList<>();
    Registry registry;

    public AtendenteImpl(List<Guiche> listaSolicitacoes, Registry registry) throws RemoteException {
        super();
        this.listaSolicitacoes = listaSolicitacoes;
        this.registry = registry;
    }

    @Override
    public Guiche chamaSenha(Guiche solicitacaoServico) throws RemoteException {

    }

}
