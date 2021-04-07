package ua.com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DivisionCalculatorTest {
    DivisionCalculator calculator;
    ResultOfCalculations actual;
    ResultOfCalculations result;
    
    @BeforeEach
    void setUp() throws Exception {
        calculator = new DivisionCalculator();
    }

    @Test
    @DisplayName("test input data from task4 example should output data from task4")
    void testCalculateResult() {
        actual = calculator.calculateResult(78945, 4);
        
        List <DivisionStep> stepsOfCalculate = new ArrayList<>();
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
        assertEquals(result, actual);
    }

}
