package SVS;

import java.util.ArrayList;

public class Votazione {
    private ArrayList<Canzone> canzoni;
    private java.util.ArrayList<Votante> votanti;
    private int limiteVotiTotali;
    private int votiTotali;

    public Votazione (int limiteVotiTotali ) {
        canzoni = new ArrayList<>();
        votanti = new ArrayList<>();
        this.limiteVotiTotali = limiteVotiTotali;
        votiTotali = 0;
    }
    public void aggiungiCanzone(Canzone canzone) {
        canzoni.add(canzone);
    }
    public void aggiungiVotante(Votante votante) { votanti.add(votante); }

    public void registraVoto(Votante votante, String titoloCanzone, int voto) {
        Canzone canzone = trovaCanzone(titoloCanzone);
        if (votiTotali < limiteVotiTotali) {
            if (canzone.getVoto() == -1) {
                Votante votanteEsistente = trovaVotante(votante.getNome());
                if (votanteEsistente != null) {

                    votanteEsistente.vota(canzone, voto);
                } else {
                    votante.vota(canzone, voto);
                    votanti.add(votante);
                    votiTotali++;
                }
            }
        }
    }
    public Canzone trovaCanzone(String titolo) {
        for (Canzone c : canzoni) {
            if (c.getTitolo().equalsIgnoreCase(titolo)) {
                return c;
            }
        }
        return null;
    }
    public Votante trovaVotante(String Nome){
        for (Votante c : votanti) {
            if (c.getNome().equalsIgnoreCase(Nome)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Canzone> getCanzoni() {
        return canzoni;
    }

    // Getter per i votanti
    public ArrayList<Votante> getVotanti() {
        return votanti;
    }
}

