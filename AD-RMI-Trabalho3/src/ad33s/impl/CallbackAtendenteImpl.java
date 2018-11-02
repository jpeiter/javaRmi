/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad33s.impl;

import ad33s.interfaces.ICallbackAtendente;
import ad33s.views.FrmAtendente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author joao_
 */
public class CallbackAtendenteImpl extends UnicastRemoteObject implements ICallbackAtendente {

    private final FrmAtendente frmAtendente;

    public CallbackAtendenteImpl(FrmAtendente frmAtendente) throws RemoteException {
        super();
        this.frmAtendente = frmAtendente;
    }

    @Override
    public void atualizarSenha(String servico) {
        System.out.println("Senha atualizada");
    }

    @Override
    public void atualizaTamanhoFila(String tipoFila, int tamanho) throws RemoteException {
        frmAtendente.atualizaTamanhoFila(tipoFila, tamanho);
    }

}
