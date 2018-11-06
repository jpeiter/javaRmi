package ad33s.impl;

import ad33s.interfaces.ICallbackPainel;
import ad33s.interfaces.IPainel;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author jpeit
 */
public class PainelImpl extends UnicastRemoteObject implements IPainel {

    List<List> listaSenhas;
    List<String> listaSenhasConvencional;
    List<String> listaSenhasPreferencial;
    List<String> listaSenhasVIP;
    ICallbackPainel callback;

    public PainelImpl(List<List> listaSenhas, Registry registry, ICallbackPainel callback) throws RemoteException {
        super();
        this.listaSenhas = listaSenhas;
        this.listaSenhasConvencional = this.listaSenhas.get(0);
        this.listaSenhasPreferencial = this.listaSenhas.get(1);
        this.listaSenhasVIP = this.listaSenhas.get(2);
        this.callback = callback;
    }

    @Override
    public void atualizarPainel() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
