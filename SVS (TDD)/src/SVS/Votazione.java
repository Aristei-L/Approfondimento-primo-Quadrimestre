package SVS;
import Eccezioni.*;
import java.util.ArrayList;

public class Votazione {
    private ArrayList<Canzone> canzoni;
    private ArrayList<Votante> votanti;
    private int limiteVotiTotali;
    private int votiTotali;

    public Votazione(int limiteVotiTotali ) {
        canzoni = new ArrayList<>();
        votanti = new ArrayList<>();
        this.limiteVotiTotali = limiteVotiTotali;
        votiTotali = 0;
    }

    public void aggiungiCanzone(Canzone canzone) {
        canzoni.add(canzone);
    }
    public void aggiungiVotante(Votante votante) { votanti.add(votante); }

    public void registraVoto(Votante votante, String titoloCanzone, int voto)
            throws CanzoneNonTrovataException, LimiteVotiSuperatoException, VotoInvalidoException, CanzoneGiàVotataException {
        Canzone canzone = trovaCanzone(titoloCanzone);
        if (canzone == null){
            throw new CanzoneNonTrovataException("Canzone non trovata.");
        }
        if (votiTotali >= limiteVotiTotali) {
            throw new LimiteVotiSuperatoException("Limite di voti totali raggiunto.");
        }
        if (canzone.getVoto() != -1) {
            throw new CanzoneGiàVotataException("La canzone è già stata votata.");
        }
        Votante votanteEsistente = trovaVotante(votante.getNome());
        if (votanteEsistente != null) {
            votanteEsistente.vota(canzone, voto);
        } else {
            votante.vota(canzone, voto);
            votanti.add(votante);
            votiTotali++;
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

    public int getLimiteVotiTotali() {
        return limiteVotiTotali;
    }

    public void setLimiteVotiTotali(int limiteVotiTotali) {
        this.limiteVotiTotali = limiteVotiTotali;
    }

    public int getVotiTotali() {
        return votiTotali;
    }

    public void setVotiTotali(int votiTotali) {
        this.votiTotali = votiTotali;
    }
}