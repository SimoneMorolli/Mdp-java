import java.util.*;


public class Ex3 {
    /**
     * Metodo pubblico: inizializza la mappa e crea un array booleano copia dell'array generico.
     *
     * @param array  array di elementi generici
     * @param toFind set di elementi da contare
     * @param <T>   tipo generico
     * @return Map con keys gli elementi di toFind e valore il ripetizioni in array
     */
    public static <T> Map<T, Integer> startFunction(T[] array, Set<T> toFind){
        Map<T, Integer> resultMap = new HashMap<>();
        int index = array.length / 2;
        boolean[] isCheck = new boolean[array.length];

        for(T x : toFind)
            resultMap.put(x, 0);


        contaElementiVettore(resultMap, array, toFind, index, isCheck);

        return resultMap;
    }

    /**
     * Metodo privato: Metodo ricorsivo per cercare i valori del set toFind.
     *
     * @param array  array di elementi generici
     * @param toFind set di elementi da contare
     * @param <T>   tipo generico
     * @param index usato per controllare ogni "cella" di array
     * @param isCheck usato per non far andare in overflow (True corrisponde al fatto che quella "casella" è passata sotto al "setaccio" della funzione)
     * @return Map con keys gli elementi di toFind e valore il ripetizioni in array
     */

    private static <T> void contaElementiVettore(Map<T, Integer> resultMap, T[] array, Set<T> toFind, int index, boolean[] isCheck){

        // Caso base, e usato anche per non far andare in overflow (l'or dove controllo se isCheck è True)
        if(index >= array.length || index <= 0 || isCheck[index])
            return;


        isCheck[index] = true;
        // Salvo il contenuto della cella dentro x
        T x = array[index];

        // Verifico x se è un elemento della mappa
        if(toFind.contains(x))
            resultMap.put(x, resultMap.get(x) + 1);

        //Chiamate ricorsive
        contaElementiVettore(resultMap, array, toFind, index - 1, isCheck);
        contaElementiVettore(resultMap, array, toFind, index + 1, isCheck);
    }
}
