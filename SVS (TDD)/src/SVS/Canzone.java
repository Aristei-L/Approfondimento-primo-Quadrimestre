package SVS;
import Eccezioni.*;

/**
 * Rappresenta una canzone con le caratteristiche titolo, artista e voto.
 * Il voto può essere assegnato una sola volta e deve essere compreso tra 1 e 10.
 * Un voto non assegnato è indicato dal valore -1.
 * @author Aristei Lorenzo
 */

public class Canzone {

    /**
     * Inizializzazione Caratteristiche
     */
    private String titolo;
    private String artista;
    private int voto;

    /**
     * Costruttore.
     * crea l'oggetto Canzone
     * @param titolo Il titolo della canzone.
     * @param artista L'artista che ha composto la canzone.
     */
    public Canzone(String titolo, String artista) {
        this.titolo = titolo;
        this.artista = artista;
        this.voto = -1;
    }

    /**
     * assegnaVoto
     * Assegna un voto alla canzone.
     * Il voto deve essere compreso tra 1 e 10 e la canzone non deve essere già stata votata.
     *
     * @param voto Il voto da assegnare.
     * @throws VotoInvalidoException se il voto non è compreso tra 1 e 10.
     * @throws CanzoneGiaVotataException se la canzone è già stata votata.
     */
    public void assegnaVoto(int voto) throws VotoInvalidoException, CanzoneGiaVotataException {
        if (voto < 1 || voto > 10) {
            throw new VotoInvalidoException("Il voto deve essere tra 1 e 10.");
        }
        if (this.voto != -1) {
            throw new CanzoneGiaVotataException("Questa canzone è già stata votata.");
        }
        this.voto = voto;
    }

    /**
     * Getter.
     * Restituisce il voto della canzone.
     *
     * @return Il voto assegnato, oppure -1 se non votata.
     */
    public int getVoto() {
        return voto;
    }

    /**
     * Getter.
     * Restituisce il titolo della canzone.
     *
     * @return Il titolo della canzone.
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Getter.
     * Restituisce l'artista della canzone.
     *
     * @return L'artista della canzone.
     */
    public String getArtista() {
        return artista;
    }
}