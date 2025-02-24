package test;
import SVS.*;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestVotante {
    static Votante votante;
    static Canzone canzone;

    @BeforeAll
    @DisplayName("Impostazioni")
    static void SetUp(){
        votante = new Votante("Mario Rossi", 5);
        canzone = new Canzone("Il Pescatore", "Fabrizio De Andrè");
    }


    @Test
    @DisplayName("Test per Votare")
    void VotaTest(){
        votante.vota(canzone,9);
        assertEquals(4,votante.getBudgetVoti());
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
