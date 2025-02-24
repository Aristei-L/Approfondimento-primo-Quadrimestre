package SVS;
import Eccezioni.*;

public class Votante {
    private String nome;
    private int budgetVoti;

    public Votante(String nome, int budgetVoti) {
        this.nome = nome;
        this.budgetVoti = budgetVoti;
    }

    public void vota(Canzone canzone, int voto) throws VotoInvalidoException, LimiteVotiSuperatoException, CanzoneGiàVotataException {
        if (budgetVoti <= 0) {
            throw new LimiteVotiSuperatoException("Non hai più voti disponibili.");
        }
        canzone.assegnaVoto(voto);
        budgetVoti--;
    }

    public String getNome() {
        return nome;
    }

    public int getBudgetVoti() {
        return budgetVoti;
    }

    public void setBudgetVoti(int budgetVoti) {
        this.budgetVoti = budgetVoti;
    }
}
