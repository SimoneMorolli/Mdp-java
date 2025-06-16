# Tipi generici
### Cosa sono i tipi generici?
i tipi generici sono dei particolari tipi che manifestano la volonta del programmatore di voler **riutilizzare** il codice al massimo delle sue **potenzialità**, essi servono a non dover più fare conversioni esplicite e ridurre i rischio di errore a runtime.
possiamo dichiarare con tipo generico **classi**, **interfacce** e **metodi**, andiamo a vedere subito un esempio e in seguito a commentarlo.

```java
public class Scatola<T> {
    private T contenuto;

    public void setContenuto(T contenuto) {
        this.contenuto = contenuto;
    }

    public T getContenuto() {
        return contenuto;
    }

    public static void main(String[] args) {
        Scatola<String> scatolaDiTesto = new Scatola<>();
        scatolaDiTesto.setContenuto("Ciao, mondo!");
        System.out.println(scatolaDiTesto.getContenuto());

        Scatola<Integer> scatolaDiNumeri = new Scatola<>();
        scatolaDiNumeri.setContenuto(42);
        System.out.println(scatolaDiNumeri.getContenuto());
    }
}
```
Possiamo da subito notare come la nostra classe **Scatola** abbiamo una peculiare notazione, usata dai tipi *List* e *Map*, questo simbolo che sta ad annotare che (in questo caso) la classe è generica serve a dire al compilatore, che il tipo di questa classe generica verra dichiarato solo quando essa verra istanziata con la **keyworld** *new*. Come possiamo vedere infatti nel main, esattamente a questa riga
```java
Scatola<String> scatolaDiTesto = new Scatola<>();
```
il tipo viene specificato tra "<>" che contraddistinguino il tipo generico, bisogna badare bene al fatto che solo questa specifica **instanza** avrà il tipo specificato, sennò verrebbe meno il **concetto** che abbiamo ripetuto poco fa, ovvero il **riutilizzo** del codice per qualsiasi tipo, qui invece possiamo notare un esempio con il solo metodo generico
```java
public class Utility {
    public static <T> void stampaArray(T[] array) {
        for (T elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] parole = {"Java", "Generics", "Sono", "Potenti"};
        Integer[] numeri = {1, 2, 3, 4, 5};

        stampaArray(parole);
        stampaArray(numeri);
    }
}
```
Notiamo bene come in questo caso il metododo genercio sia *static* perche ciò? dato che il tipo è generico, per come funziona la **JVM** dobbiamo fissare subito in memoria questo metodo sennò la **JVM** non riuscira proprio a compilare e dara il seguente **errore**.
```java
java: non-static method <T>startFunction(T[],java.util.Set<T>) cannot be referenced from a static context
```
Detto cio possiamo scrivere un metodoto con tipo generico cosi:
```java
	public static <T> void *MethodName*(T x, T y)
```
Come detto in introduzione, anche le interfacce possono essere rese generiche, riporto un esempio:
```java
interface Comparabile<T> {
    boolean confronta(T altro);
}

class Persona implements Comparabile<Persona> {
    private String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean confronta(Persona altro) {
        return this.nome.equals(altro.nome);
    }

    public static void main(String[] args) {
        Persona p1 = new Persona("Mario");
        Persona p2 = new Persona("Luigi");

        System.out.println(p1.confronta(p2)); // false
    }
}
```
Come possiamo vedere le interfacce funzionano in maniera alle interfacce classice salvo che va specificato il tipo dopo che si è scritto il nome dell'interfaccia, quindi in generale possiamo scrivere:
```java
class *ClassName* implements *InterfaceName*<T> 
```

