package SVS;
import Eccezioni.*;

/**
 * Rappresenta un votante con caratteristiche nome e budget di voti.
 * Un votante può assegnare voti a canzoni finché ne ha a disposizione.
 *
 * @author Aristei Lorenzo
 */
public class Votante {

    /**
     * Inizializzazione Caratteristiche
     */
    private String nome;
    private int budgetVoti;

    /**
     * Costruttore
     * crea l'oggetto Votante.
     *
     * @param nome Il nome del votante.
     * @param budgetVoti Il numero di voti disponibili.
     */
    public Votante(String nome, int budgetVoti) {
        this.nome = nome;
        this.budgetVoti = budgetVoti;
    }

    /**
     * vota
     * permette di votare per una canzone decrementando il budget dei voti.
     *
     * @param canzone La canzone da votare.
     * @param voto Il voto da assegnare.
     * @throws VotoInvalidoException se il voto non è compreso tra 1 e 10.
     * @throws LimiteVotiSuperatoException se non ci sono più voti disponibili.
     * @throws CanzoneGiaVotataException se la canzone è già stata votata.
     */
    public void vota(Canzone canzone, int voto) throws VotoInvalidoException, LimiteVotiSuperatoException, CanzoneGiaVotataException {
        if (budgetVoti <= 0) {
            throw new LimiteVotiSuperatoException("Non hai più voti disponibili.");
        }
        canzone.assegnaVoto(voto);
        budgetVoti--;
    }

    /**
     * Getter
     * Restituisce il nome del votante.
     *
     * @return Il nome del votante.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Getter
     * Restituisce il budget dei voti residuo.
     *
     * @return Il numero di voti ancora disponibili.
     */
    public int getBudgetVoti() {
        return budgetVoti;
    }

    /**
     * Setter
     * Imposta il budget dei voti residuo.
     *
     * @param budgetVoti Il nuovo budget dei voti.
     */
    public void setBudgetVoti(int budgetVoti) {
        this.budgetVoti = budgetVoti;
    }
}