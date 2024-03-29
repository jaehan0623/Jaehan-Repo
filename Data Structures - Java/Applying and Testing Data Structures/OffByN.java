public class OffByN implements CharacterComparator {
    private int diff;
    public OffByN(int N) {
        diff = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int distance = x - y;
        return (distance == diff || distance == -diff);
    }
}
