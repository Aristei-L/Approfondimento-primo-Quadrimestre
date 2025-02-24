
package Eccezioni;

/**
 * Sottoclasse Di Exception
 * Descrive un'eccezione che viene lanciata quando la canzone cercata non viene trovata.
 *
 * @author Aristei Lorenzo
 */
public class CanzoneNonTrovataException extends Exception {

    /**
     * Costruttore per creare una nuova eccezione di tipo CanzoneNonTrovataException.
     *
     * @param message Il messaggio di Errore Visualizzato.
     */
    public CanzoneNonTrovataException(String message) {
        super(message);
    }
}