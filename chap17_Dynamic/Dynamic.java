package chap17_Dynamic;

public class Dynamic {
    public int dynamicFunc(int n) {
        int[] cache = new int[n + 1];

        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            cache[n] = cache[n - 1] + cache[n - 2];
        }
        return cache[n];
    }

}
