package ad33s.interfaces;

import ad33s.model.Atendente;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author jpeit
 */
public interface IAtendente extends Remote {

    public List<String> login(Atendente atendente, ICallbackAtendente callback) throws RemoteException;

    public void chamaSenha(String servico) throws RemoteException;

}
