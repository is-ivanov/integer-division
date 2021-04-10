package ua.com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DivisionFormatterTest {
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
                                                            + " 0|--" + LF
                                                            + " -|0" + LF
                                                            + " 0";
    
    private DivisionFormatter divisionFormatter;
    private ResultOfCalculations result;
    private List<DivisionStep> stepsOfCalculate;

    @BeforeEach
    void setUp() throws Exception {
        divisionFormatter = new DivisionFormatter(); 
        stepsOfCalculate = new ArrayList<>();
    }

    @Test
    @DisplayName("test input data from task4 example should output data from task4")
    void testFormatResultDataFromTask4() {
        
        stepsOfCalculate.add(new DivisionStep(7, 4, 3));
        stepsOfCalculate.add(new DivisionStep(38, 36, 2));
        stepsOfCalculate.add(new DivisionStep(29, 28, 1));
        stepsOfCalculate.add(new DivisionStep(14, 12, 2));
        stepsOfCalculate.add(new DivisionStep(25, 24, 1));
        
        result = new ResultOfCalculations.ResultOfCalculationsBuilder(78945, 4)
                .quotient(19736)
                .remainder(1)
                .divisionSteps(stepsOfCalculate)
                .build();
        assertEquals(OUTPUT_EXAMPLE_TASK4, divisionFormatter.formatDivision(result));
    }
    
    @Test
    @DisplayName("test input dividend end in several zeros")
    void testFormatDividendEndsSeveralZeros() {
        
        stepsOfCalculate.add(new DivisionStep(4, 0, 4));
        stepsOfCalculate.add(new DivisionStep(45, 45, 0));
        stepsOfCalculate.add(new DivisionStep(0, 0, 0));
        stepsOfCalculate.add(new DivisionStep(0, 0, 0));
        
        result = new ResultOfCalculations.ResultOfCalculationsBuilder(4500, 5)
                .quotient(900)
                .remainder(0)
                .divisionSteps(stepsOfCalculate)
                .build();
        assertEquals(OUTPUT_DIVIDEND_ENDS_ZERO, divisionFormatter.formatDivision(result));
    }
    
    @Test
    @DisplayName("test dividend equals divisor")
    void testFormatDividendEqualsDivisor() {
        
        stepsOfCalculate.add(new DivisionStep(4, 0, 4));
        stepsOfCalculate.add(new DivisionStep(45, 0, 45));
        stepsOfCalculate.add(new DivisionStep(456, 0, 456));
        stepsOfCalculate.add(new DivisionStep(4563, 0, 4563));
        stepsOfCalculate.add(new DivisionStep(45632, 45632, 0));
        
        result = new ResultOfCalculations.ResultOfCalculationsBuilder(45632, 45632)
                .quotient(1)
                .remainder(0)
                .divisionSteps(stepsOfCalculate)
                .build();
        assertEquals(OUTPUT_DIVIDEND_EQUALS_DIVISOR, divisionFormatter.formatDivision(result));
    }
    
    @Test
    @DisplayName("test dividend equals zero")
    void testFormatDividendEqualsZero() {
        
        stepsOfCalculate.add(new DivisionStep(0, 0, 0));
        
        result = new ResultOfCalculations.ResultOfCalculationsBuilder(0, 45)
                .quotient(0)
                .remainder(0)
                .divisionSteps(stepsOfCalculate)
                .build();
        assertEquals(OUTPUT_DIVIDEND_EQUALS_ZERO, divisionFormatter.formatDivision(result));
    }

}
