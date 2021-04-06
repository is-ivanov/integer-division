package ua.com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DivisionFacadeTest {
    private static final String MESSAGE_DIVIDE_BY_ZERO = "Divisor can't be 0";
    private static final String LF = System.lineSeparator();
    private static final String OUTPUT_EXAMPLE_TASK4 = "_78945|4" + LF
                                                     + " 4    |-----" + LF
                                                     + " -    |19736" + LF
                                                     + "_38" + LF
                                                     + " 36" + LF
                                                     + " --" + LF
                                                     + " _29" + LF
                                                     + "  28" + LF
                                                     + "  --" + LF
                                                     + "  _14" + LF
                                                     + "   12" + LF
                                                     + "   --" + LF
                                                     + "   _25" + LF
                                                     + "    24" + LF
                                                     + "    --" + LF
                                                     + "     1";
    private static final String OUTPUT_DIVIDEND_ENDS_ZERO = "_4500|5" + LF
                                                               + " 45  |---" + LF
                                                               + " --  |900" + LF
                                                               + "  0";
    
    private static final String OUTPUT_DIVIDEND_EQUALS_DIVISOR = "_45632|45632" + LF
                                                               + " 45632|-----" + LF
                                                               + " -----|1" + LF
                                                               + "     0";
    
    private static final String OUTPUT_DIVIDEND_EQUALS_ZERO = "_0|45" + LF
                                                            + " 0|-----" + LF
                                                            + " -|0" + LF
                                                            + " 0";

    private static DivisionFacade divisionFacade;

    @BeforeEach
    void setUp() {
        divisionFacade = new DivisionFacade();
    }

    @Test
    @DisplayName("test input data from task4 example should output data from task4")
    void testInputDataFromTask4Example() {
        String actualString = divisionFacade.start(78945, 4);
        assertEquals(OUTPUT_EXAMPLE_TASK4, actualString);
    }

    @Test
    @DisplayName("test input zero to divisor should output exception")
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> divisionFacade.start(15, 0));
        assertEquals(MESSAGE_DIVIDE_BY_ZERO, exception.getMessage());
    }

    @Test
    @DisplayName("test input dividend end in several zeros")
    void testDividendEndsSeveralZeros() {
        String actualString = divisionFacade.start(4500, 5);
        assertEquals(OUTPUT_DIVIDEND_ENDS_ZERO, actualString);
    }
    
    @Test
    @DisplayName("test dividend equals divisor")
    void testDividendEqualsDivisor() {
        int i = 45632;
        String actualString = divisionFacade.start(i, i);
        assertEquals(OUTPUT_DIVIDEND_EQUALS_DIVISOR, actualString);
    }
    
    @Test
    @Disabled
    @DisplayName("test zero to dividend")
    void testZeroToDividend() {
        String actualString = divisionFacade.start(0, 45);
        assertEquals(OUTPUT_DIVIDEND_EQUALS_ZERO, actualString);
    }
    
}
