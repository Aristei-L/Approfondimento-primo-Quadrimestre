package SVS;
import Eccezioni.*;
import java.util.ArrayList;

/**
 * Classe che gestisce il processo di votazione, incluse le operazioni per aggiungere canzoni e votanti e registrare voti.
 * Mantiene una lista di canzoni e votanti e impone un limite ai voti totali.
 *
 * @author Aristei Lorenzo
 */
public class Votazione {

    /**
     * Inizializzazione Caratteristiche
     */
    private ArrayList<Canzone> canzoni;
    private ArrayList<Votante> votanti;
    private int limiteVotiTotali;
    private int votiTotali;

    /**
     * Costruttore
     * Serve per creare una nuovo oggetto di tipo Votazione.
     *
     * @param limiteVotiTotali Il numero massimo di voti consentiti.
     */
    public Votazione(int limiteVotiTotali ) {
        canzoni = new ArrayList<>();
        votanti = new ArrayList<>();
        this.limiteVotiTotali = limiteVotiTotali;
        votiTotali = 0;
    }

    /**
     * aggiungiCanzone
     * Aggiunge una canzone alla lista di canzoni.
     *
     * @param canzone La canzone da aggiungere.
     */
    public void aggiungiCanzone(Canzone canzone) {
        canzoni.add(canzone);
    }

    /**
     * aggiungiVotante
     * Aggiunge un votante alla lista dei votanti.
     *
     * @param votante Il votante da aggiungere.
     */
    public void aggiungiVotante(Votante votante) {
        votanti.add(votante);
    }

    /**
     * registraVoto
     * Registra un voto per una canzone specificata da un votante specifico.
     * Verifica che la canzone esista, che non sia già stata votata e che non si superi il limite totale di voti.
     *
     * @param votante Il votante che esprime il voto.
     * @param titoloCanzone Il titolo della canzone da votare.
     * @param voto Il valore del voto da assegnare.
     * @throws CanzoneNonTrovataException se la canzone non è presente nella lista.
     * @throws LimiteVotiSuperatoException se il limite totale di voti è stato raggiunto.
     * @throws VotoInvalidoException se il voto non è compreso tra 1 e 10.
     * @throws CanzoneGiaVotataException se la canzone è già stata votata.
     */
    public void registraVoto(Votante votante, String titoloCanzone, int voto)
            throws CanzoneNonTrovataException, LimiteVotiSuperatoException, VotoInvalidoException, CanzoneGiaVotataException {
        Canzone canzone = trovaCanzone(titoloCanzone);
        if (canzone == null){
            throw new CanzoneNonTrovataException("Canzone non trovata.");
        }
        if (votiTotali >= limiteVotiTotali) {
            throw new LimiteVotiSuperatoException("Limite di voti totali raggiunto.");
        }
        if (canzone.getVoto() != -1) {
            throw new CanzoneGiaVotataException("La canzone è già stata votata.");
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

    /**
     * trovaCanzone
     * Cerca e restituisce una canzone in base al titolo.
     *
     * @param titolo Il titolo della canzone da cercare.
     * @return La canzone trovata oppure null se non esiste.
     */
    public Canzone trovaCanzone(String titolo) {
        for (Canzone c : canzoni) {
            if (c.getTitolo().equalsIgnoreCase(titolo)) {
                return c;
            }
        }
        return null;
    }

    /**
     * trovaVotante
     * Cerca e restituisce un votante in base al nome.
     *
     * @param nome Il nome del votante da cercare.
     * @return Il votante trovato oppure null se non esiste.
     */
    public Votante trovaVotante(String nome){
        for (Votante v : votanti) {
            if (v.getNome().equalsIgnoreCase(nome)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Getter
     * Restituisce la lista delle canzoni.
     *
     * @return L'ArrayList di canzoni.
     */
    public ArrayList<Canzone> getCanzoni() {
        return canzoni;
    }

    /**
     * Getter
     * Restituisce la lista dei votanti.
     *
     * @return L'ArrayList dei votanti.
     */
    public ArrayList<Votante> getVotanti() {
        return votanti;
    }

    /**
     * Getter
     * Restituisce il limite totale di voti.
     *
     * @return Il limite totale dei voti.
     */
    public int getLimiteVotiTotali() {
        return limiteVotiTotali;
    }

    /**
     * Setter
     * Imposta il limite totale dei voti.
     *
     * @param limiteVotiTotali Il nuovo limite totale.
     */
    public void setLimiteVotiTotali(int limiteVotiTotali) {
        this.limiteVotiTotali = limiteVotiTotali;
    }

    /**
     * Getter
     * Restituisce il numero totale di voti registrati.
     *
     * @return Il numero di voti totali.
     */
    public int getVotiTotali() {
        return votiTotali;
    }

    /**
     * Setter
     * Imposta il numero totale di voti registrati.
     *
     * @param votiTotali Il nuovo conteggio dei voti.
     */
    public void setVotiTotali(int votiTotali) {
        this.votiTotali = votiTotali;
    }
}