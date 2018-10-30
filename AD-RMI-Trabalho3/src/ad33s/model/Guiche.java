package ad33s.model;

/**
 *
 * @author jpeit
 */
public class Guiche {

    private static final String[] SERVICOS = {"Convencional", "Preferencial", "VIP"};

    private int numeroGuiche;

    public Guiche() {
    }

    public String[] getSERVICOS() {
        return SERVICOS;
    }

    public int getNumeroGuiche() {
        return numeroGuiche;
    }

    public void setNumeroGuiche(int numeroGuiche) {
        this.numeroGuiche = numeroGuiche;
    }

}
