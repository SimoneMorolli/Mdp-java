import java.util.*;

public class Ex2_Videogioco implements Comparable<Ex2_Videogioco> {
    private int id;
    private String name;
    private int year;
    private Ex2_Console ex2Console;
    private Set<Ex2_Record> records;

    public Ex2_Videogioco(int id, String name, int year, Ex2_Console ex2Console){
        this.id = id;
        this.name = name;
        this.year = year;
        this.ex2Console = ex2Console;
        records = new HashSet<>();
    }

    public String getConsole() {
        return ex2Console.getConsoleName();
    }

    public Set<Ex2_Record> getRecords(){
        return records;
    }

    @Override
    public int compareTo(Ex2_Videogioco other) {
        return Integer.compare(this.year, other.year);
    }
}

