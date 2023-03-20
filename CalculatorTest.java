package cz.cvut.fel.ts1;

import cz.cvut.fel.ts1.lab04.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatedTests {
    Calculator calc = new Calculator();

    @ParameterizedTest(name = "{0} plus {1} should be equal to {2}")
    @CsvSource({"1,2,3", "-4,6,2", "1,2,1"})
    public void addsAAndB_returns(int a, int b, int c) {
        int expectedResult = c;
        int result = calc.add(a, b);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "{0} minus {1} should be equal to {2}")
    @CsvSource({"5,2,3", "-4,6,-10", "1,2,1"})
    public void subAAndB_returns(int a, int b, int c) {
        int expectedResult = c;
        int result = calc.subtract(a, b);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "{0} multiply {1} should be equal to {2}")
    @CsvSource({"5,2,10", "-4,6,-24", "1,2,1"})
    public void mulAAndB_returns(int a, int b, int c) {
        int expectedResult = c;
        int result = calc.multiply(a, b);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "{0} divide {1} should be equal to {2}")
    @CsvSource({"10,2,5", "4,2,2", "1,2,2"})
    public void divAAndB_returns(int a, int b, int c) {
        int expectedResult = c;
        int result = calc.divide(a, b);
        Assertions.assertEquals(expectedResult, result);
    }


    @ParameterizedTest(name = "{0} can not be divided by zero")
    @CsvSource({"5", "-4", "0"})
    public void divByZero_throwsIllegalArgumentException(int a) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(a, 0);
        });
    }
}
