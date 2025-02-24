package test;
import SVS.*;
import Eccezioni.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestVotante {
    static Votante votante;
    static Canzone canzone;
    static int R = 0;

    @BeforeAll
    @DisplayName("Settings")
    static void SetUp(){
        votante = new Votante("Mario Rossi", 5);
        canzone = new Canzone("Il Pescatore", "Fabrizio De Andrè");
    }


    @Deprecated
    @DisplayName("Test per Votare")
    void VotaTest(){
        assertDoesNotThrow(()-> votante.vota(canzone,9));
        assertEquals(4,votante.getBudgetVoti());
    }

    @RepeatedTest(4)
    @DisplayName("Nuovo Test per Votare")
    void NuovoVotaTest(){
        R++;
        if (R == 1){
            assertDoesNotThrow(()-> votante.vota(canzone,9));
        }else if (R == 2){
            Exception e = assertThrows(CanzoneGiàVotataException.class, ()-> votante.vota(canzone,9));
            assertEquals("Questa canzone è già stata votata.",e.getMessage());
        }else if (R == 3){
            votante.setBudgetVoti(0);
            Exception e = assertThrows(LimiteVotiSuperatoException.class, ()-> votante.vota(canzone,9));
            assertEquals("Non hai più voti disponibili.",e.getMessage());
            votante.setBudgetVoti(5);
        }else{
            Exception e = assertThrows(VotoInvalidoException.class, ()-> votante.vota(new Canzone("Bocca di rosa", "Fabrizio De Andrè"),300));
            assertEquals("Il voto deve essere tra 1 e 10.",e.getMessage());
        }
    }

    @Test
    @DisplayName("Test Ottenere Nome")
    void getNomeTest(){
        assertEquals("Mario Rossi", votante.getNome());
    }

    @Test
    @DisplayName("Test Ottenere budgetVoti")
    void getBudgetVotiTest(){
        assertEquals(5, votante.getBudgetVoti());
    }
}
