package Eccezioni;

/**
 * Sottoclasse Di Exception
 * Descrive un'eccezione che viene lanciata quando si supera il limite dei voti disponibili.
 *
 * @author Aristei Lorenzo
 */
public class LimiteVotiSuperatoException extends Exception {

    /**
     * Costruttore per creare una nuova eccezione di tipo  LimiteVotiSuperatoException.
     *
     * @param message Il messaggio di Errore Visualizzato.
     */
    public LimiteVotiSuperatoException(String message) {
        super(message);
    }
}