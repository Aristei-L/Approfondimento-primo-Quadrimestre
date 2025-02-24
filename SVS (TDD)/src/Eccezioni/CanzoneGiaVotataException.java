package Eccezioni;

/**
 * Sottoclasse Di Exception
 * Descrive un'eccezione che viene lanciata quando si tenta di votare una canzone che è già stata votata.
 *
 * @author Aristei Lorenzo
 */
public class CanzoneGiaVotataException extends Exception {

    /**
     * Costruttore per creare una nuova eccezione di tipo CanzoneGiàVotataException.
     *
     * @param message Il messaggio di Errore Visualizzato.
     */
    public CanzoneGiaVotataException(String message) {
        super(message);
    }
}