/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad33s.impl;

import ad33s.interfaces.ICallbackAtendente;
import ad33s.interfaces.ICallbackPainel;
import ad33s.interfaces.IControlador;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author joao_
 */
public class ControladorImpl extends UnicastRemoteObject implements IControlador{

    public ControladorImpl() throws RemoteException {
        super();
    }
    
    @Override
    public void registrarAtendente(String nome, ICallbackAtendente callback) throws RemoteException {
        System.out.println("Registrando atendente" + nome);
    }

    @Override
    public void registrarPainel(String nome, ICallbackPainel callback) throws RemoteException {
        System.out.println("Registrando painel" + nome);
    }

    @Override
    public String solicitarSenha(String servico) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atenderSenha(String serviço) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
