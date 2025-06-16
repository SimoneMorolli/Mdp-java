public class Ex2_Record implements Comparable<Ex2_Record>{
    private Ex2_Giocatore player;
    private Ex2_Videogioco game;
    private int score;

    public Ex2_Giocatore getPlayer() {
        return player;
    }

    public int getScore() {
        return score;
    }

    public Ex2_Videogioco getGame() {
        return game;
    }

    @Override
    public int compareTo(Ex2_Record other) {
        return Integer.compare(this.score, other.score);
    }
}
