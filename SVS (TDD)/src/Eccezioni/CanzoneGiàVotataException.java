package Eccezioni;

public class CanzoneGiàVotataException extends Exception {
    public CanzoneGiàVotataException(String message) {
        super(message);
    }
}