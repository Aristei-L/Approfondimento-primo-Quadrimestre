package SVS;

import java.util.ArrayList;

public class Votazione {
    private ArrayList<Canzone> canzoni;
    private java.util.ArrayList<Votante> votanti;
    private int limiteVotiTotali;
    private int votiTotali;

    public Votazione (int limiteVotiTotali ) {
        canzoni = new ArrayList<>();
        votanti = new ArrayList<>();
        this.limiteVotiTotali = limiteVotiTotali;
        votiTotali = 0;
    }
}
