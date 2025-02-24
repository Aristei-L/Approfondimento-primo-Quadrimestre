package test;
import SVS.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;

public class TestVotazione {
    Votazione votazione;

    @BeforeEach
    @DisplayName("Settings")
    void setup(){
        votazione = new Votazione(5);
        votazione.aggiungiVotante(new Votante("Mario Rossi", 5));
        votazione.aggiungiCanzone(new Canzone("Il Pescatore", "Fabrizio De Andrè"));
    }
    @Test
    @DisplayName("Test per aggiungere una canzone alla lista")
    void AggiungiCanzoneTest(){
        votazione.aggiungiCanzone(new Canzone("Bocca di rosa", "Fabrizio De Andrè"));
        assertTrue(votazione.trovaCanzone("Bocca di rosa").equals(votazione.getCanzoni().getLast()));
    }
    @Test
    @DisplayName("Test per aggiungere un votante alla lista")
    void AggiungiVotanteTest(){
        votazione.aggiungiVotante(new Votante("Marco Verdi", 3));
        assertTrue(votazione.getVotanti().getLast().equals(votazione.trovaVotante("Marco Verdi")));
    }
    @Test
    @DisplayName("Test per Trovare una Canzone")
    void TrovaCanzoneTest(){
        Canzone canzone = votazione.trovaCanzone("Il Pescatore");
        assertTrue(canzone.equals(votazione.getCanzoni().getLast()));
    }
    @Test
    @DisplayName("Test per Trovare un votante")
    void TrovaVotanteTest(){
        Votante votante = votazione.trovaVotante("Mario Rossi");
        assertTrue(votante.equals(votazione.getVotanti().getLast()));
    }
    @Test
    @DisplayName("Test per Registrare un Voto")
    void RegistraVotoTest(){
        votazione.registraVoto(new Votante("Mario Rossi 5",5),"Il Pescatore",9);
        Votante votante = votazione.trovaVotante("Mario Rossi");
        Canzone canzone = votazione.trovaCanzone("Il Pescatore");
        assertTrue(votante.equals());
        assertTrue(canzone.equals(new Canzone("Il Pescatore", "Fabrizio De Andrè")));
    }



}
