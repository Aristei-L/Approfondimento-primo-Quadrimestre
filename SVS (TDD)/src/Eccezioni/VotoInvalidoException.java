package Eccezioni;

/**
 * Sottoclasse Di Exception
 * Descrive un'eccezione che viene lanciata quando viene inserito un voto non valido (non compreso tra 1 e 10).
 *
 * @author Aristei Lorenzo
 */
public class VotoInvalidoException extends Exception {

    /**
     * Costruttore per creare una nuova eccezione di tipo VotoInvalidoException.
     *
     * @param message Il messaggio di Errore Visualizzato.
     */
    public VotoInvalidoException(String message) {
        super(message);
    }
}