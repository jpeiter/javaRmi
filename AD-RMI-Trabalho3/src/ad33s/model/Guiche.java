package ad33s.model;

/**
 *
 * @author jpeit
 */
public class Guiche {

    private static final String[] SERVICOS = {"Convencional", "Preferencial", "VIP"};
    
    private int numeroGuiche;

    private String senha;

    public Guiche() {
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

    public int getNumeroGuiche() {
        return numeroGuiche;
    }

    public void setNumeroGuiche(int numeroGuiche) {
        this.numeroGuiche = numeroGuiche;
    }
    
    

}
