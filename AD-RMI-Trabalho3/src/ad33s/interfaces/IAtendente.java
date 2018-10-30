package ad33s.interfaces;

import ad33s.model.Guiche;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jpeit
 */
public interface IAtendente extends Remote {

    public Guiche chamaSenha(Guiche solicitacaoServico) throws RemoteException;

}
