package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciNumberCalculatorTest {

    private FibonacciNumberCalculator calculator = new FibonacciNumberCalculator();

    @Test
    void should_return_1_given_step_is_1() {
        assertEquals(1, calculator.calculate(1));
    }

    @Test
    void should_return_0_given_step_is_0() {
        assertEquals(0, calculator.calculate(0));
    }

    @Test
    void should_throw_IAE_given_step_is_negative() {
        assertThrows(IllegalArgumentException.class, ()->calculator.calculate(-1));
    }
}