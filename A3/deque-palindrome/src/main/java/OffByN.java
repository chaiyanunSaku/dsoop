public class OffByN implements CharacterComparator {
    private int n;

    // Constructor to set the difference N
    public OffByN(int N) {
        this.n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == n;
    }
}
