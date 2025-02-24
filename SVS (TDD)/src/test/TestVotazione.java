package test;
import SVS.*;
import Eccezioni.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.condition.OS.*;

/**
 * Classe di test per la classe Votazione.
 * Verifica il corretto funzionamento delle operazioni di registrazione dei voti e gestione di canzoni e votanti.
 *
 */
public class TestVotazione {
    Votazione votazione;
    static int R = 0;

    /**
     * Impostazioni iniziali per ogni test.
     */
    @BeforeEach
    @DisplayName("Settings")
    void setup(){
        votazione = new Votazione(5);
        votazione.aggiungiVotante(new Votante("Mario Rossi", 5));
        votazione.aggiungiCanzone(new Canzone("Il Pescatore", "Fabrizio De Andrè"));
    }

    /**
     * Test per vedere se funziona il metodo che consente di aggiungere una canzone alla lista.
     */
    @Test
    @DisplayName("Test per aggiungere una canzone alla lista")
    void AggiungiCanzoneTest(){
        votazione.aggiungiCanzone(new Canzone("Bocca di rosa", "Fabrizio De Andrè"));
        assertTrue(votazione.trovaCanzone("Bocca di rosa").equals(votazione.getCanzoni().get(votazione.getCanzoni().size()-1)));
    }

    /**
     * Test per vedere se funziona il metodo che consente di aggiungere un votante alla lista.
     */
    @Test
    @DisplayName("Test per aggiungere un votante alla lista")
    void AggiungiVotanteTest(){
        votazione.aggiungiVotante(new Votante("Marco Verdi", 3));
        assertTrue(votazione.getVotanti().get(votazione.getVotanti().size()-1).equals(votazione.trovaVotante("Marco Verdi")));
    }

    /**
     * Test per vedere se funziona il metodo che consente di cercare una canzone.
     */
    @Test
    @DisplayName("Test per Trovare una Canzone")
    void TrovaCanzoneTest(){
        Canzone canzone = votazione.trovaCanzone("Il Pescatore");
        assertTrue(canzone.equals(votazione.getCanzoni().get(votazione.getCanzoni().size()-1)));
    }

    /**
     * Test per vedere se funziona il metodo che consente di cercare un votante.
     */
    @Test
    @DisplayName("Test per Trovare un votante")
    void TrovaVotanteTest(){
        Votante votante = votazione.trovaVotante("Mario Rossi");
        assertTrue(votante.equals(votazione.getVotanti().get(votazione.getVotanti().size()-1)));
    }

    /**
     * Test deprecato poichè è cambiato il metodo per la registrazione di un voto.
     * @deprecated Usa NuovoRegistraVotoTest() invece.
     */
    @Deprecated
    @DisplayName("Test per Registrare un Voto")
    void RegistraVotoTest() {
        assertDoesNotThrow(() -> votazione.registraVoto(new Votante("Mario Rossi 5", 5), "Il Pescatore", 9));
        Votante votante = votazione.trovaVotante("Mario Rossi");
        Canzone canzone = votazione.trovaCanzone("Il Pescatore");
        assertTrue(votante.equals(votazione.trovaVotante("Mario Rossi")));
        assertTrue(canzone.equals(new Canzone("Il Pescatore", "Fabrizio De Andrè")));
    }

    /**
     * Nuovo Test per vedere se funziona il metodo per la registrazione di un voto.
     *  Viene Eseguito una volta per esito possibile del metodo che testa
     */
    @RepeatedTest(5)
    @DisplayName("Nuovo per Registrare un voto")
    void NuovoRegistraVotoTest(){
        R++;
        if (R == 1){
            Exception e = assertThrows(CanzoneNonTrovataException.class, () -> votazione.registraVoto(new Votante("Mario Rossi 5", 5), "tathwshys",10));
            assertEquals("Canzone non trovata.", e.getMessage());
        } else if (R == 2){
            votazione.setVotiTotali(votazione.getLimiteVotiTotali());
            Exception e = assertThrows(LimiteVotiSuperatoException.class, () -> votazione.registraVoto(new Votante("Mario Rossi 5", 5), "Il Pescatore",10));
            assertEquals("Limite di voti totali raggiunto.", e.getMessage());
        } else if (R == 3){
            votazione.setVotiTotali(0);
            Exception e = assertThrows(VotoInvalidoException.class, () -> votazione.registraVoto(new Votante("Mario Rossi 5", 5), "Il Pescatore",200));
            assertEquals("Il voto deve essere tra 1 e 10.", e.getMessage());
        } else if (R == 4){
            assertDoesNotThrow(() -> votazione.registraVoto(new Votante("Mario Rossi 5", 5), "Il Pescatore",10));
        } else {
            assertDoesNotThrow(() -> votazione.registraVoto(new Votante("Mario Rossi 5", 5), "Il Pescatore",10));
            Exception e = assertThrows(CanzoneGiaVotataException.class, () -> votazione.registraVoto(new Votante("Mario Rossi 5", 5), "Il Pescatore",10));
            assertEquals("La canzone è già stata votata.", e.getMessage());
        }
    }

    /**
     * Test eseguito solo su sistemi Mac.
     */
    @Test
    @EnabledOnOs(MAC)
    @DisplayName("Test su 🍎MAC🍎")
    void onlyOnMacOs() {
        votazione = new Votazione(5);
        votazione.aggiungiVotante(new Votante("John MacOS", 1000));
        votazione.aggiungiCanzone(new Canzone("MacSong.MP3", "Mark SongMaker"));
    }

    /**
     * Test eseguito su Linux o Mac, non su Windows.
     */
    @Test
    @DisabledOnOs(WINDOWS)
    @EnabledOnOs({ LINUX, MAC })
    @DisplayName("Test Non Su ❌Windows❌")
    void onLinuxOrMac() {
        votazione = new Votazione(5);
        votazione.aggiungiVotante(new Votante("John NotWindows", 5));
        votazione.aggiungiCanzone(new Canzone("NotWindowsSong.MP3", "Mark SongMaker"));
    }

    /**
     * Test eseguito solo su sistemi Windows.
     */
    @Test
    @EnabledOnOs(WINDOWS)
    @DisplayName("Test su \uD83E\uDE9FWindows\uD83E\uDE9F")
    void notOnWindows() {
        votazione = new Votazione(5);
        votazione.aggiungiVotante(new Votante("John Windows", 5));
        votazione.aggiungiCanzone(new Canzone("RealWindowsSong.MP3", "Mark SongMaker"));
    }
}