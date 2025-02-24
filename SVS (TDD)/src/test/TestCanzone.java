package test;
import SVS.*;
import Eccezioni.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe di test per la classe Canzone.
 * Utilizza JUnit per verificare il corretto funzionamento dei metodi della classe Canzone.
 */
public class TestCanzone {
    static Canzone canzone;
    static int R = 0;

    /**
     * Impostazioni iniziali per i test.
     */
    @BeforeAll
    @DisplayName("Settings")
    static void SetUp(){
        canzone = new Canzone("Il Pescatore", "Fabrizio De Andrè");
    }

    /**
     * Test deprecato poichè è cambiato il metodo per l'assegnazione del voto.
     * @deprecated Usa NuovoAssegnaVotoTest() invece.
     */
    @Deprecated
    @DisplayName("Test per Assegnare un Voto")
    void AssegnaVotoTest(){
        assertDoesNotThrow(() -> canzone.assegnaVoto(9));
    }

    /**
     * Nuovo Test per vedere se funziona il metodo l'assegnazione del voto.
     * Viene Eseguito una volta per esito possibile del metodo che testa
     */
    @RepeatedTest(3)
    @DisplayName("Nuovo Test per Assegnare un Voto")
    void NuovoAssegnaVotoTest(){
        R++;
        if (R == 1){
            Exception e = assertThrows(VotoInvalidoException.class,()->canzone.assegnaVoto(2000));
            assertEquals("Il voto deve essere tra 1 e 10.",e.getMessage());
        } else if (R == 2){
            assertDoesNotThrow(() -> canzone.assegnaVoto(9));
        } else {
            Exception e = assertThrows(CanzoneGiaVotataException.class,()->canzone.assegnaVoto(9));
            assertEquals("Questa canzone è già stata votata.",e.getMessage());
        }
    }

    /**
     * Test per vedere se funziona il metodo che consente di ottenere il titolo della canzone.
     */
    @Test
    @DisplayName("Test Ottenere Titolo")
    void getTitoloTest(){
        assertEquals("Il Pescatore", canzone.getTitolo());
    }

    /**
     * Test per vedere se funziona il metodo che consente di ottenere l'artista della canzone.
     */
    @Test
    @DisplayName("Test Ottenere Artista")
    void getArtistaTest(){
        assertEquals("Fabrizio De Andrè", canzone.getArtista());
    }
}
