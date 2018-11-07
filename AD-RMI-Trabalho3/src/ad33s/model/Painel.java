package ad33s.model;

import ad33s.interfaces.ICallbackPainel;
import java.util.List;

/**
 *
 * @author jpeit
 */
public class Painel {

    private List<String> senhas;
    private String senhaAtual;
    private String atendente;
    private ICallbackPainel callback;

    public Painel() {
    }

    public List<String> getSenhas() {
        return senhas;
    }

    public void setSenhas(List<String> senhas) {
        this.senhas = senhas;
    }

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public ICallbackPainel getCallback() {
        return callback;
    }

    public void setCallback(ICallbackPainel callback) {
        this.callback = callback;
    }

}
