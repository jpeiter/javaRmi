/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad33s.interfaces;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author joao_
 */
public interface IControlador extends Remote {

    public int[] registrarAtendente(String nome, ICallbackAtendente callback) throws RemoteException;

    public List<String> registrarPainel(ICallbackPainel callback) throws RemoteException;

    public String solicitarSenha(String servico) throws RemoteException, NotBoundException;

    public int atenderSenha(String servico) throws RemoteException;

}
