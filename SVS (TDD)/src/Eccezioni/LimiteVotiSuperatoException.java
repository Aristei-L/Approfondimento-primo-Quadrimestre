package Eccezioni;

public class LimiteVotiSuperatoException extends Exception {
    public LimiteVotiSuperatoException(String message) {
        super(message);
    }
}