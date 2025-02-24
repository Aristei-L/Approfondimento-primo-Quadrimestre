package test;
import SVS.*;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class TestVotazione {
    static Votazione votazione;

    @BeforeAll
    @DisplayName("Settings")
    static void setup(){
        votazione = new Votazione(5);
    }
    @Test
    @DisplayName("Test per aggiungere una canzone alla lista")
    void AggiungiCanzoneTest(){
        votazione.aggiungiCanzone(new Canzone("Il Pescatore", "Fabrizio De Andrè"));
        assertTrue(votazione.getCanzoni().getLast().equals(new Canzone("Il Pescatore", "Fabrizio De Andrè")));
    }
    @Test
    @DisplayName("Test per aggiungere un votante alla lista")
    void AggiungiCanzoneTest(){
        votazione.aggiungiVotante(new Votante("Mario Rossi", 5));
        assertTrue(votazione.getVotanti().getLast().equals(new Votante("Mario Rossi", 5)));
    }
    @Test
    @DisplayName("Test per Trovare una Canzone")
    void TrovaCanzoneTest(){
        Canzone canzone = votazione.trovaCanzone("Il Pescatore");
        assertTrue(canzone.equals(new Canzone("Il Pescatore", "Fabrizio De Andrè")));
    }
    @Test
    @DisplayName("Test per Trovare un votante")
    void TrovaCanzoneTest(){
        Votante votante = votazione.trovaVotante("Mario Rossi");
        assertTrue(votante.equals(new Votante("Mario Rossi", 5)));
    }
    @Test
    @DisplayName("Test per Registrare un Voto")
    void RegistraVotoTest(){
        registraVoto(new Votante("Mario Rossi 5",5),"Il Pescatore",9);
        Votante votante = votazione.trovaVotante("Mario Rossi");
        Canzone canzone = votazione.trovaCanzone("Il Pescatore");
        assertTrue(votante.equals(new Votante("Mario Rossi", 4)));
        assertTrue(canzone.equals(new Canzone("Il Pescatore", "Fabrizio De Andrè")));
    }



}
