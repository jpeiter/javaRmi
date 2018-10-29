package ad33s.model;

/**
 *
 * @author jpeit
 */
public class SolicitacaoServico {

    private static final String[] SERVICOS = {"Convencional", "Preferencial", "VIP"};

    private String senha;

    public SolicitacaoServico() {
    }

    public String[] getSERVICOS() {
        return SERVICOS;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
