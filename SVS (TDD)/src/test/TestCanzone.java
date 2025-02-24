package test;
import SVS.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCanzone {
    static Canzone canzone;

    @BeforeAll
    @DisplayName("Impostazioni")
    static void SetUp(){
        canzone = new Canzone("Il Pescatore", "Fabrizio De Andrè");
    }


    @Test
    @DisplayName("Test per Assegnare un Voto")
    void AssegnaVotoTest(){
        canzone.assegnaVoto(9);
    }

    @Test
    @DisplayName("Test Ottenere Titolo")
    void getTitoloTest(){
       assertEquals("Il Pescatore", canzone.getTitolo());
    }

    @Test
    @DisplayName("Test Ottenere Artista")
    void getArtistaTest(){
        assertEquals("Fabrizio De Andrè", canzone.getArtista());
    }
}
