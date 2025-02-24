package SVS;

import Eccezioni.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principale per l'applicazione di votazione.
 * Fornisce un'interfaccia a menu per aggiungere canzoni, registrare voti e visualizzare
 * le canzoni e i votanti.
 *
 * @author Aristei Lorenzo
 */
public class Main {

    /**
     * Metodo principale che avvia l'applicazione di votazione.
     *
     * @param args Argomenti della riga di comando.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Votazione votazione = new Votazione(15);

        boolean exit = false;

        while (!exit) {
            System.out.println("|=|=|  MENU VOTAZIONE |=|=|");
            System.out.println("| 1:  Aggiungi Canzone    |");
            System.out.println("| 2:  Registra Voto       |");
            System.out.println("| 3:  Visualizza Canzoni  |");
            System.out.println("| 4:  Visualizza Votanti  |");
            System.out.println("| 5:  Esci                |");
            System.out.print("Seleziona un'opzione inserendone il numero: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il titolo della canzone: ");
                    String titolo = scanner.nextLine();
                    System.out.print("Inserisci l'artista della canzone: ");
                    String artista = scanner.nextLine();
                    Canzone nuovaCanzone = new Canzone(titolo, artista);
                    votazione.aggiungiCanzone(nuovaCanzone);
                    System.out.println("Canzone aggiunta con successo!");
                    break;

                case 2:
                    System.out.print("Inserisci il nome del votante: ");
                    String nomeVotante = scanner.nextLine();
                    System.out.print("Inserisci il budget dei voti per il votante: ");
                    int budget = scanner.nextInt();
                    scanner.nextLine();
                    Votante votante = new Votante(nomeVotante, budget);

                    System.out.print("Inserisci il titolo della canzone da votare: ");
                    String titoloDaVotare = scanner.nextLine();
                    System.out.print("Inserisci il voto (1-10): ");
                    int voto = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        votazione.registraVoto(votante, titoloDaVotare, voto);
                        System.out.println("Voto registrato con successo!");
                    } catch (Exception e) {
                        System.out.println("Errore durante la registrazione del voto: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Elenco delle canzoni:");
                    if (votazione.getCanzoni().isEmpty()) {
                        System.out.println("Nessuna canzone registrata.");
                    } else {
                        for (Canzone c : votazione.getCanzoni()) {
                            String votoCanzone = (c.getVoto() == -1) ? "Non votata" : String.valueOf(c.getVoto());
                            System.out.println("Titolo: " + c.getTitolo() + " | Artista: " + c.getArtista() + " | Voto: " + votoCanzone);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Elenco dei votanti:");
                    if (votazione.getVotanti().isEmpty()) {
                        System.out.println("Nessun votante registrato.");
                    } else {
                        for (Votante v : votazione.getVotanti()) {
                            System.out.println("Nome: " + v.getNome() + " | Budget residuo: " + v.getBudgetVoti());
                        }
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Fine votazione.");
                    break;

                default:
                    System.out.println("Opzione non valida. Riprova.");
                    break;
            }
        }
    }
}