package ad33s.impl;

import ad33s.interfaces.ICallbackPainel;
import ad33s.views.FrmPainel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author jpeit
 */
public class CallbackPainelImpl extends UnicastRemoteObject implements ICallbackPainel {

    private final FrmPainel frmPainel;

    public CallbackPainelImpl(FrmPainel frmPainel) throws RemoteException {
        super();
        this.frmPainel = frmPainel;
    }

    @Override
    public void atualizarPainel(String senha, String nomeAtendente) throws RemoteException {
        frmPainel.atualizarPainel(senha, nomeAtendente);
    }

}
