package ad33s.model;

import ad33s.interfaces.ICallbackAtendente;

/**
 *
 * @author jpeit
 */
public class Atendente {

    private String nome;
    private ICallbackAtendente callback;

    public Atendente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ICallbackAtendente getCallback() {
        return callback;
    }

    public void setCallback(ICallbackAtendente callback) {
        this.callback = callback;
    }

}
