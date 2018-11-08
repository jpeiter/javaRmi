package ad33s.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jpeit
 */
public interface ICallbackPainel extends Remote {

    public void atualizarPainel(String senha, String nomeAtendente) throws RemoteException;

}
