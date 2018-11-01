package ad33s.run;

import ad33s.impl.CallbackAtendenteImpl;
import ad33s.interfaces.ICallbackAtendente;
import ad33s.interfaces.IControlador;
import java.rmi.*;
import java.rmi.registry.*;

public class AtendenteRun {

    private IControlador controlador;

    public AtendenteRun() {
        try {
            Registry registro = LocateRegistry.getRegistry(1053);
            controlador = (IControlador) registro.lookup("Controlador");

        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (NotBoundException e) {
            System.out.println("Objeto não encontrado: " + e.getMessage());
        }
    }

    private void iniciar() {
//        try {
//            ICallbackAtendente callback = new CallbackAtendenteImpl();
//            controlador.registrarAtendente("Atendente1", callback);

//        } catch (RemoteException ex) {
//            System.out.println("RemoteException: " + ex.getMessage());
//        }
    }

    public static void main(String[] args) {
        AtendenteRun c = new AtendenteRun();
        c.iniciar();
    }
}
