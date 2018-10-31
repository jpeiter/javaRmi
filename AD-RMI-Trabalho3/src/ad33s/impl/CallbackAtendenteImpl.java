/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad33s.impl;

import ad33s.interfaces.ICallbackAtendente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author joao_
 */
public class CallbackAtendenteImpl extends UnicastRemoteObject implements ICallbackAtendente {

    public CallbackAtendenteImpl() throws RemoteException {
        super();
    }

    

    @Override
    public void atualizarSenha(String servico) {
        System.out.println("Senha atualizada");
    }

}
