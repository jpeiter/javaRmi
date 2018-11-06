package ad33s.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jpeit
 */
public interface ICallbackAtendente extends Remote {

    public void atualizaTamanhoFila(String tipo, int tamanho) throws RemoteException;

}
