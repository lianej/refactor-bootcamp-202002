package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciNumberCalculatorTest {

    private FibonacciNumberCalculator calculator = new FibonacciNumberCalculator();

    @Test
    void should_return_1_given_step_is_1() {
        assertEquals(1L, calculator.calculate(1));
    }

    @Test
    void should_return_0_given_step_is_0() {
        assertEquals(0L, calculator.calculate(0));
    }

    @Test
    void should_return_1_given_step_is_2() {
        assertEquals(1L, calculator.calculate(2));
    }

    @Test
    void should_return_55_given_step_is_10() {
        assertEquals(55L, calculator.calculate(10));
    }

    @Test
    void should_return_55_given_step_is_50() {
        assertEquals(12586269025L, calculator.calculate(50));
    }

    @Test
    void should_throw_IAE_given_step_is_negative() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(-1));
    }
}