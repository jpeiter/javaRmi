package ad33s.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jpeit
 */
public interface IPainel extends Remote {

    public void atualizarPainel() throws RemoteException;

}
