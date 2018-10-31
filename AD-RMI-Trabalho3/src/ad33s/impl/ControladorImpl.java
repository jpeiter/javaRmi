package ad33s.impl;

import ad33s.interfaces.IAtendente;
import ad33s.interfaces.ICallbackAtendente;
import ad33s.interfaces.ICallbackPainel;
import ad33s.interfaces.IControlador;
import ad33s.interfaces.IPainel;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpeit
 */
public class ControladorImpl extends UnicastRemoteObject implements IControlador {

    private Registry registry = null;
    private List<String> listAtendentes;
    private List<List> listaSenhas;
    private List<String> listaSenhasConvencional;
    private List<String> listaSenhasPreferencial;
    private List<String> listaSenhasVIP;
    private IAtendente atendente;
    private IPainel painel;
    private int contadorConvencional = 0, contadorPreferencial = 0, contadorVIP = 0;

    public ControladorImpl(Registry registry) throws RemoteException {
        super();
        this.registry = registry;

        listAtendentes = new ArrayList<>();
        listaSenhas = new ArrayList<>();

        listaSenhasConvencional = new ArrayList<>();
        listaSenhasPreferencial = new ArrayList<>();
        listaSenhasVIP = new ArrayList<>();

        listaSenhas.add(listaSenhasConvencional);
        listaSenhas.add(listaSenhasPreferencial);
        listaSenhas.add(listaSenhasVIP);
    }

    @Override
    public void registrarAtendente(String nome, ICallbackAtendente callback) throws RemoteException {
        try {
            atendente = new AtendenteImpl(listaSenhas, registry);
            registry.bind("Atendente " + nome, atendente);
            System.out.println("Atendente " + nome + " registrado.");
            listAtendentes.add(nome);
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
        }
    }

    @Override
    public String solicitarSenha(String servico) {
        StringBuilder sb = new StringBuilder();
        if (servico.equals("Convencional")) {
            sb.append(servico.charAt(0)).append(contadorConvencional++);
            listaSenhasConvencional.add(sb.toString());
        } else if (servico.equals("Preferencial")) {
            sb.append(servico.charAt(0)).append(contadorPreferencial++);
            listaSenhasPreferencial.add(sb.toString());
        } else if (servico.equals("VIP")) {
            sb.append(servico.charAt(0)).append(contadorVIP++);
            listaSenhasVIP.add(sb.toString());
        } else {
            return "SERVIÇO INCORRETO!";
        }
        System.out.println("Senha " + servico + " " + sb.toString() + " chamada");
        return sb.toString();
    }

    @Override
    public int atenderSenha(String servico) {
        if ((!listaSenhasConvencional.isEmpty())
                || (!listaSenhasPreferencial.isEmpty())
                || (!listaSenhasVIP.isEmpty())) {
            if (servico.equals("Convencional")) {
                System.out.println("Senha " + servico + listaSenhasConvencional.get(0) + " atendida.");
                listaSenhasConvencional.remove(0);
                return listaSenhasConvencional.size();
            } else if (servico.equals("Preferencial")) {
                System.out.println("Senha " + servico + listaSenhasPreferencial.get(0) + " atendida.");
                listaSenhasPreferencial.remove(0);
                return listaSenhasPreferencial.size();
            } else {
                System.out.println("Senha " + servico + listaSenhasVIP.get(0) + " atendida.");
                listaSenhasVIP.remove(0);
                return listaSenhasVIP.size();
            }
        } else {
            return -1;
        }
    }

    @Override
    public void registrarPainel(String nome, ICallbackPainel callback) throws RemoteException {
        try {
            painel = new PainelImpl(listaSenhas, registry);
            registry.bind("Atendente " + nome, atendente);
            System.out.println("Atendente " + nome + " registrado.");
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
        }
    }

}
