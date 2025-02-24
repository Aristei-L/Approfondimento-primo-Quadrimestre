package Eccezioni;
/**
 * Il pacchetto Eccezioni contiene sottoclassi di eccezione utilizzate per gestire errori specifici nel processo di
 * votazione.
 * Le eccezioni incluse sono:
 * <ul>
 *   <li>{@link Eccezioni.CanzoneGiaVotataException} - Lanciata quando si tenta di votare una canzone già votata.</li>
 *   <li>{@link Eccezioni.CanzoneNonTrovataException} - Lanciata quando la canzone richiesta non viene trovata.</li>
 *   <li>{@link Eccezioni.VotoInvalidoException} - Lanciata quando il voto inserito non rientra nel range valido (1-10).</li>
 *   <li>{@link Eccezioni.LimiteVotiSuperatoException} - Lanciata quando il votante ha esaurito il budget di voti.</li>
 * </ul>
 */
