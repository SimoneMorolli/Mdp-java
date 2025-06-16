import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] vettore = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        Set<Integer> daContare = new HashSet<>(Arrays.asList(1, 5, 2, 9));
        Map<Integer, Integer> risultato = Ex3.startFunction(vettore, daContare);
        System.out.println(risultato);
        // Output: {1=2, 2=1, 5=2}
    }
}