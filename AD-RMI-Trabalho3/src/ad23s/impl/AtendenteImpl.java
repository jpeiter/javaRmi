package ad23s.impl;

import ad23s.interfaces.IAtendente;
import ad23s.model.SolicitacaoServico;
import java.util.List;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class AtendenteImpl extends UnicastRemoteObject implements IAtendente {

    List<SolicitacaoServico> listaSolicitacoes = new ArrayList<>();
    Registry registry;

    public AtendenteImpl(List<SolicitacaoServico> listaSolicitacoes, Registry registry) throws RemoteException {
        super();
        this.listaSolicitacoes = listaSolicitacoes;
        this.registry = registry;
    }

    @Override
    public SolicitacaoServico chamaSenha(SolicitacaoServico solicitacaoServico) throws RemoteException {

    }

}
