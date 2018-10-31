package ad33s.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jpeit
 */
public interface ICallbackPainel extends Remote {

    public String atualizarPainel(String servico) throws RemoteException;

}
