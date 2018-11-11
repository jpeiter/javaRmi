package ad33s.impl;

import ad33s.interfaces.IAtendente;
import ad33s.interfaces.ICallbackAtendente;
import ad33s.interfaces.ICallbackPainel;
import ad33s.interfaces.IControlador;
import ad33s.model.Painel;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jpeit
 */
public class ControladorImpl extends UnicastRemoteObject implements IControlador {

    private Registry registry = null;

    private List<String> listAtendentes;
    private List<Painel> listPaineis;
    private List<List> listaSenhas;
    private List<String> listaSenhasConvencional;
    private List<String> listaSenhasPreferencial;
    private List<String> listaSenhasVIP;
    private List<String> listaSenhasChamadas;
    private List<String> listaSenhasChamadasConv;
    private List<String> listaSenhasChamadasPref;
    private List<String> listaSenhasChamadasVip;
    private List<List> listaEstatisticas;
    private List<ICallbackPainel> paineis;

    private IAtendente atendente;

    private int contadorConvencional = 1, contadorPreferencial = 1, contadorVIP = 1;

    public ControladorImpl(Registry registry) throws RemoteException {
        super();
        this.registry = registry;

        listAtendentes = new ArrayList<>();
        listPaineis = new ArrayList<>();
        listaSenhas = new ArrayList<>();
        listaSenhasConvencional = new ArrayList<>();
        listaSenhasPreferencial = new ArrayList<>();
        listaSenhasVIP = new ArrayList<>();
        listaEstatisticas = new ArrayList<>();
        listaSenhasChamadas = new ArrayList<>();
        listaSenhasChamadasConv = new ArrayList<>();
        listaSenhasChamadasPref = new ArrayList<>();
        listaSenhasChamadasVip = new ArrayList<>();
        paineis = new ArrayList<>();

        listaEstatisticas.add(listAtendentes);
        listaEstatisticas.add(listaSenhasChamadasConv);
        listaEstatisticas.add(listaSenhasChamadasPref);
        listaEstatisticas.add(listaSenhasChamadasVip);

        listaSenhas.add(listaSenhasConvencional);
        listaSenhas.add(listaSenhasPreferencial);
        listaSenhas.add(listaSenhasVIP);
    }

    @Override
    public String solicitarSenha(String servico) throws RemoteException, NotBoundException {
        StringBuilder sb = new StringBuilder();
        if (servico.equals("Convencional")) {
            sb.append(servico.charAt(0)).append(contadorConvencional++);
            listaSenhasConvencional.add(sb.toString());
            for (String nome : listAtendentes) {
                IAtendente atendente = (IAtendente) registry.lookup("Atendente " + nome);
                atendente.atualizarTamanhoFila("Convencional", listaSenhasConvencional.size());
            }
        } else if (servico.equals("Preferencial")) {
            sb.append(servico.charAt(0)).append(contadorPreferencial++);
            listaSenhasPreferencial.add(sb.toString());
            for (String nome : listAtendentes) {
                IAtendente atendente = (IAtendente) registry.lookup("Atendente " + nome);
                atendente.atualizarTamanhoFila("Preferencial", listaSenhasPreferencial.size());
            }
        } else if (servico.equals("VIP")) {
            sb.append(servico.charAt(0)).append(contadorVIP++);
            listaSenhasVIP.add(sb.toString());
            for (String nome : listAtendentes) {
                IAtendente atendente = (IAtendente) registry.lookup("Atendente " + nome);
                atendente.atualizarTamanhoFila("VIP", listaSenhasVIP.size());
            }
        } else {
            return "SERVIÇO INCORRETO!";
        }
        System.out.println("Senha " + servico + " " + sb.toString() + " chamada");
        return sb.toString();
    }

    @Override
    public int atenderSenha(String servico, String nomeAtendente) throws RemoteException, AccessException {
//        if ((!listaSenhasConvencional.isEmpty()) || (!listaSenhasPreferencial.isEmpty()) || (!listaSenhasVIP.isEmpty())) {
        if (servico.equals("Convencional") && (!listaSenhasConvencional.isEmpty())) {
            System.out.println("Senha " + servico + listaSenhasConvencional.get(0) + " atendida.");

            listaSenhasChamadas.add(
                    listaSenhasConvencional.get(0)
            );
            listaSenhasChamadasConv.add(
                    nomeAtendente + ";" + listaSenhasConvencional.get(0)
            );

            for (ICallbackPainel painel : paineis) {
                painel.atualizarPainel(listaSenhasConvencional.get(0), nomeAtendente);
            }

            listaSenhasConvencional.remove(0);

            for (String nome : listAtendentes) {
                IAtendente atendente;
                try {
                    atendente = (IAtendente) registry.lookup("Atendente " + nome);
                    atendente.atualizarTamanhoFila("Convencional", listaSenhasConvencional.size());
                } catch (NotBoundException ex) {
                    Logger.getLogger(ControladorImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return listaSenhasConvencional.size();

        } else if (servico.equals("Preferencial") && (!listaSenhasPreferencial.isEmpty())) {
            System.out.println("Senha " + servico + listaSenhasPreferencial.get(0) + " atendida.");

            listaSenhasChamadas.add(
                    listaSenhasPreferencial.get(0)
            );
            listaSenhasChamadasPref.add(
                    nomeAtendente + ";" + listaSenhasPreferencial.get(0)
            );

            for (ICallbackPainel painel : paineis) {
                painel.atualizarPainel(listaSenhasPreferencial.get(0), nomeAtendente);
            }

            listaSenhasPreferencial.remove(0);

            for (String nome : listAtendentes) {
                IAtendente atendente;
                try {
                    atendente = (IAtendente) registry.lookup("Atendente " + nome);
                    atendente.atualizarTamanhoFila("Preferencial", listaSenhasPreferencial.size());
                } catch (NotBoundException ex) {
                    Logger.getLogger(ControladorImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return listaSenhasPreferencial.size();

        } else if (servico.equals("VIP") && (!listaSenhasVIP.isEmpty())) {
            System.out.println("Senha " + servico + listaSenhasVIP.get(0) + " atendida.");

            listaSenhasChamadas.add(
                    listaSenhasVIP.get(0)
            );
            listaSenhasChamadasVip.add(
                    nomeAtendente + ";" + listaSenhasVIP.get(0)
            );

            for (ICallbackPainel painel : paineis) {
                painel.atualizarPainel(listaSenhasVIP.get(0), nomeAtendente);
            }

            listaSenhasVIP.remove(0);

            for (String nome : listAtendentes) {
                IAtendente atendente;
                try {
                    atendente = (IAtendente) registry.lookup("Atendente " + nome);
                    atendente.atualizarTamanhoFila("VIP", listaSenhasVIP.size());
                } catch (NotBoundException ex) {
                    Logger.getLogger(ControladorImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return listaSenhasVIP.size();
        }
        return -1;

    }

    @Override
    public int[] registrarAtendente(String nome, ICallbackAtendente callback) throws RemoteException {
        try {
            atendente = new AtendenteImpl(listaSenhas, registry, callback);
            registry.bind("Atendente " + nome, atendente);
            System.out.println("Atendente " + nome + " registrado.");
            listAtendentes.add(nome);

            return new int[]{
                listaSenhasConvencional.size(),
                listaSenhasPreferencial.size(),
                listaSenhasVIP.size()
            };
        } catch (RemoteException ex) {
            System.out.println("RemoteException: " + ex.getMessage());
        } catch (AlreadyBoundException ex) {
            System.out.println("Já existe um objeto com esse nome registrado!!! " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<String> registrarPainel(ICallbackPainel callback) throws RemoteException {
        paineis.add(callback);
        System.out.println("Painel registrado.");
        return listaSenhasChamadas;
    }

    @Override
    public List<List> solicitarEstatisticas() throws RemoteException {
        return listaEstatisticas;
    }

}
