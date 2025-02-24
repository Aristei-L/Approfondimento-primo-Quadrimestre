package SVS;
import Eccezioni.*;
public class Canzone {
    private String titolo;
    private String artista;
    private int voto;

    public Canzone(String titolo, String artista) {
        this.titolo = titolo;
        this.artista = artista;
        this.voto = -1;
    }


    public void assegnaVoto(int voto) throws VotoInvalidoException, CanzoneGiàVotataException {
        if (voto < 1 || voto > 10) {
            throw new VotoInvalidoException("Il voto deve essere tra 1 e 10.");
        }
        if (this.voto != -1) {
            throw new CanzoneGiàVotataException("Questa canzone è già stata votata.");
        }
        this.voto = voto;
    }

    public int getVoto() {
        return voto;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getArtista() {
        return artista;
    }
}
