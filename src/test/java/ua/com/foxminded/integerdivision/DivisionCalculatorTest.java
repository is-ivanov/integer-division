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
    List <DivisionStep> stepsOfCalculate; 
    
    @BeforeEach
    void setUp() throws Exception {
        calculator = new DivisionCalculator();
        stepsOfCalculate = new ArrayList<>();
    }

    @Test
    @DisplayName("test input data from task4 example should output data from task4")
    void testCalculateResultDataFromTask4() {
        actual = calculator.calculateResult(78945, 4);
        
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
    
    @Test
    @DisplayName("test dividend equals divisor")
    void testCalculateResult_DividentEqualsDivisor() {
        actual = calculator.calculateResult(4578, 4578);
        stepsOfCalculate.add(new DivisionStep(4, 0, 4));
        stepsOfCalculate.add(new DivisionStep(45, 0, 45));
        stepsOfCalculate.add(new DivisionStep(457, 0, 457));
        stepsOfCalculate.add(new DivisionStep(4578, 4578, 0));
        
        result = new ResultOfCalculations.ResultOfCalculationsBuilder(4578, 4578)
                .quotient(1)
                .remainder(0)
                .divisionSteps(stepsOfCalculate)
                .build();
        assertEquals(result, actual);
    }
    
    @Test
    @DisplayName("test dividend equals zero")
    void testCalculateResult_DividentEqualsZero() {
        actual = calculator.calculateResult(0, 4578);
        stepsOfCalculate.add(new DivisionStep(0, 0, 0));
        
        result = new ResultOfCalculations.ResultOfCalculationsBuilder(0, 4578)
                .quotient(0)
                .remainder(0)
                .divisionSteps(stepsOfCalculate)
                .build();
        assertEquals(result, actual);
    }

}
