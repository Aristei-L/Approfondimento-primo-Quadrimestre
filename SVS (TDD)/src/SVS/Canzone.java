package SVS;

public class Canzone {
    private String titolo;
    private String artista;
    private int voto;

    public Canzone(String titolo, String artista) {
        this.titolo = titolo;
        this.artista = artista;
        this.voto = -1;
    }

    public void assegnaVoto(int voto) {
        if (voto < 1 || voto > 10) {
            if (this.voto == -1){
                this.voto = voto;
            }
        }
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
