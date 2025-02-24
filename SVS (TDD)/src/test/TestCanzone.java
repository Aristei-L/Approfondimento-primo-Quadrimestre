package test;
import SVS.*;
import Eccezioni.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCanzone {
    static Canzone canzone;
    static int R = 0;

    @BeforeAll
    @DisplayName("Settings")
    static void SetUp(){
        canzone = new Canzone("Il Pescatore", "Fabrizio De Andrè");
    }


    @Deprecated
    @DisplayName("Test per Assegnare un Voto")
    void AssegnaVotoTest(){
        assertDoesNotThrow(() -> canzone.assegnaVoto(9));
    }

    @RepeatedTest(3)
    @DisplayName("Nuovo Test per Assegnare un Voto")
    void NuovoAssegnaVotoTest(){
        R++;
        if (R == 1){
            Exception e = assertThrows(VotoInvalidoException.class,()->canzone.assegnaVoto(2000));
            assertEquals("Il voto deve essere tra 1 e 10.",e.getMessage());
        }else if (R == 2){
            assertDoesNotThrow(() -> canzone.assegnaVoto(9));
        }else{
            Exception e = assertThrows(CanzoneGiàVotataException.class,()->canzone.assegnaVoto(9));
            assertEquals("Questa canzone è già stata votata.",e.getMessage());
        }

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
