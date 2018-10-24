package ad23s.interfaces;

import ad23s.model.SolicitacaoServico;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author jpeit
 */
public interface IAtendente extends Remote {

    public SolicitacaoServico chamaSenha(SolicitacaoServico solicitacaoServico) throws RemoteException;

}
