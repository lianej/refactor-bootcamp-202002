package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciNumberCalculator {

    public int calculate(int step) {
        if (step < 0) {
            throw new IllegalArgumentException();
        }
        if(step == 0){
            return 0;
        }
        return 1;
    }
}
