/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad33s.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author joao_
 */
public interface IControlador extends Remote {

    public void registrarAtendente(String nome, ICallbackAtendente callback) throws RemoteException;

    public void registrarPainel(String nome, ICallbackPainel callback) throws RemoteException;

    public String solicitarSenha(String servico) throws RemoteException;

    public int atenderSenha(String servico) throws RemoteException;

}
