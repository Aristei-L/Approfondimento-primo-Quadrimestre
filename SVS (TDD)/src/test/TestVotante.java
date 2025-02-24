package test;
import SVS.*;
import Eccezioni.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe di test per la classe Votante.
 * Verifica il corretto funzionamento dei metodi relativi al voto e alle proprietà del votante.
 *
 */
public class TestVotante {
    static Votante votante;
    static Canzone canzone;
    static int R = 0;

    /**
     * Impostazioni iniziali per i test.
     */
    @BeforeAll
    @DisplayName("Settings")
    static void SetUp(){
        votante = new Votante("Mario Rossi", 5);
        canzone = new Canzone("Il Pescatore", "Fabrizio De Andrè");
    }

    /**
     * Test deprecato poichè è cambiato il metodo per l'assegnazione del voto.
     * @deprecated NuovoVotaTest() invece.
     */
    @Deprecated
    @DisplayName("Test per Votare")
    void VotaTest(){
        assertDoesNotThrow(() -> votante.vota(canzone,9));
        assertEquals(4, votante.getBudgetVoti());
    }

    /**
     *  Nuovo Test per vedere se funziona il metodo per l'assegnazione del voto.
     * Viene Eseguito una volta per esito possibile del metodo che testa
     *
     */
    @RepeatedTest(4)
    @DisplayName("Nuovo Test per Votare")
    void NuovoVotaTest(){
        R++;
        if (R == 1){
            assertDoesNotThrow(() -> votante.vota(canzone,9));
        } else if (R == 2){
            Exception e = assertThrows(CanzoneGiaVotataException.class, () -> votante.vota(canzone,9));
            assertEquals("Questa canzone è già stata votata.",e.getMessage());
        } else if (R == 3){
            votante.setBudgetVoti(0);
            Exception e = assertThrows(LimiteVotiSuperatoException.class, () -> votante.vota(canzone,9));
            assertEquals("Non hai più voti disponibili.",e.getMessage());
            votante.setBudgetVoti(5);
        } else {
            Exception e = assertThrows(VotoInvalidoException.class, () -> votante.vota(new Canzone("Bocca di rosa", "Fabrizio De Andrè"),300));
            assertEquals("Il voto deve essere tra 1 e 10.",e.getMessage());
        }
    }

    /**
     * Test per vedere se funziona il metodo che consente di ottenere il nome del votante.
     */
    @Test
    @DisplayName("Test Ottenere Nome")
    void getNomeTest(){
        assertEquals("Mario Rossi", votante.getNome());
    }

    /**
     * Test per vedere se funziona il metodo che consente di ottenere il budget dei voti residuo.
     */
    @Test
    @DisplayName("Test Ottenere budgetVoti")
    void getBudgetVotiTest(){
        assertEquals(5, votante.getBudgetVoti());
    }
}
