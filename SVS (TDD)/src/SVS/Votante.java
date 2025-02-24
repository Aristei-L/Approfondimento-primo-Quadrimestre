package SVS;

public class Votante {
    private String nome;
    private int budgetVoti;

    public Votante(String nome, int budgetVoti) {
        this.nome = nome;
        this.budgetVoti = budgetVoti;
    }

    public void vota(Canzone canzone, int voto) {
        if (budgetVoti > 0) {
            canzone.assegnaVoto(voto);
            budgetVoti--;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getBudgetVoti() {
        return budgetVoti;
    }
}
