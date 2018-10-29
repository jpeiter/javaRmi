package ad33s.model;

import ad33s.interfaces.ICallback;

/**
 *
 * @author jpeit
 */
public class Atendente {

    private String nome;
    private ICallback callback;

    public Atendente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ICallback getCallback() {
        return callback;
    }

    public void setCallback(ICallback callback) {
        this.callback = callback;
    }

}
