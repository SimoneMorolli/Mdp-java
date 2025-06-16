import java.util.*;
import java.util.stream.*;

/**
 * Classe: ClassificheVideogiochi. Implementa l'interfaccia Iterable per implementare l'iterazione sui videogiochi
 *
 * @attribute instance  serve per la sigletone
 * @attribute games set dei vari giochi in calssifica
 */

public class Ex2_ClassificheVideogiochi implements Iterable<Ex2_Videogioco>{
    private static Ex2_ClassificheVideogiochi instance = null;
    private Set<Ex2_Videogioco> games;

    private Ex2_ClassificheVideogiochi(){
        games = new HashSet<>();
    }

    public static Ex2_ClassificheVideogiochi getInstance(){
        if(instance == null)
            instance = new Ex2_ClassificheVideogiochi();
        return instance;
    }
    /**
     * Metodo: metodo publico per tirare fuori una mappa tramite stream
     *
     * @return una mappa che ha come key la console e come valore un set della classe videogiochi
     */
    public Map<String, Set<Ex2_Videogioco>> getMappaPiattaformeGiochi(){
        return games.stream()
                .collect(Collectors.groupingBy(Ex2_Videogioco::getConsole, Collectors.toSet()));
    }

    /**
     * Metodo: metodo publico per tirare fuori una mappa tramite stream
     *
     * Scorre tutti i giochi, estrae i record di ciascun gioco,
     * filtra tutti i videogiochi in base al Ex2_Giocatore fornito, individua
     * il record con punteggio massimo e ritorna il videogioco associato ad esso.
     * Se il giocatore non ha record, restituisce null.
     *
     * @return il videogioco dove il Giocatore ha il punteggio piu alto
     */

    public Ex2_Videogioco getGiocoRecordGiocatore(Ex2_Giocatore player){
        return games.stream()
                .flatMap(g -> g.getRecords().stream())
                .filter(r -> r.getPlayer().equals(player))
                .max(Comparator.comparingInt(Ex2_Record::getScore))
                .map(Ex2_Record::getGame)
                .orElse(null);
    }

    @Override
    public Iterator<Ex2_Videogioco> iterator() {
        return null;
    }
}
