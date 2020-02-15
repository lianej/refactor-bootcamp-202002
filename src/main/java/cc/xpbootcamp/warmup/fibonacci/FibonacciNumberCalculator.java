package cc.xpbootcamp.warmup.fibonacci;

import java.util.Arrays;

public class FibonacciNumberCalculator {

    private long[] resultCache;

    int maxStep = 50;

    public FibonacciNumberCalculator() {
        this.resultCache = new long[maxStep + 1];
        Arrays.fill(resultCache, 1, this.resultCache.length, -1);
        initCalculateResultCache();
    }

    private void initCalculateResultCache() {
        this.resultCache[0] = 0;
        this.resultCache[1] = 1;
        for (int i = 0; i <= maxStep; i++) {
            getResultFromCache(i);
        }
    }

    public long calculate(int step) {
        if (step < 0) {
            throw new IllegalArgumentException();
        }
        if (step > maxStep) {
            throw new IllegalArgumentException();
        }
        return getResultFromCache(step);
    }

    private long getResultFromCache(int step) {
        if (resultCache[step] >= 0) {
            return resultCache[step];
        }
        long result = getResultFromCache(step - 2) + getResultFromCache(step - 1);
        resultCache[step] = result;
        return result;
    }
}
