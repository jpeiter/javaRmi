package ad33s.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jpeit
 */
public interface IAtendente extends Remote {

    public void atualizarTamanhoFila(String tipo, int tamanho) throws RemoteException;

}
