package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumberCalculatorTest {

    private FibonacciNumberCalculator calculator = new FibonacciNumberCalculator();

    @Test
    void should_return_1_given_step_is_1_when_invoke_calculate() {
        assertEquals(1, calculator.calculate(1));
    }
}