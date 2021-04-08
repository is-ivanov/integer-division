package ua.com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DivisionFacadeTest {
    private static final String RESULT_DIVISION = "ResultDivision";
    private static final String RESULT_DIVISION_ZERO_DIVIDEND = "ResultDivision0";
    private static final String MESSAGE_DIVIDE_BY_ZERO = "Divisor can't be 0";

    private static DivisionFacade divisionFacade;
    @Mock
    DivisionCalculator calculatorMock;
    @Mock
    Formatable divisionFormatterMock;
    @Mock 
    ResultOfCalculations result;

    @BeforeEach
    void setUp() {
//        calculatorMock = mock(DivisionCalculator.class);
//        divisionFormatterMock = mock(DivisionFormatter.class);
        divisionFacade = new DivisionFacade(calculatorMock, divisionFormatterMock);
    }

    @Test
    @DisplayName("test input zero to divisor should output exception")
    void testDivisorIsZero() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> divisionFacade.start(15, 0));
        assertEquals(MESSAGE_DIVIDE_BY_ZERO, exception.getMessage());
    }
    
    @Test
    @DisplayName("test input zero to dividend should call calculator and then formatter")
    void testDividendIsZero() {
        calculatorMock.calculateResult(0, 15);
        verify(calculatorMock).calculateResult(0, 15);
        
        doReturn(result).when(calculatorMock).calculateResult(0, 15);
        
        divisionFormatterMock.formatLine(result);
        verify(divisionFormatterMock).formatLine(result);
        
        when(divisionFormatterMock.formatLine(result)).thenReturn(RESULT_DIVISION_ZERO_DIVIDEND);
        assertEquals(RESULT_DIVISION_ZERO_DIVIDEND, divisionFacade.start(0, 15));
    }
    
    @Test
    @DisplayName("test input two numerals should call calculator and then formatter")
    void testNormalDivision() {
        calculatorMock.calculateResult(345, 15);
        verify(calculatorMock).calculateResult(345, 15);
        
        doReturn(result).when(calculatorMock).calculateResult(345, 15);
        
        divisionFormatterMock.formatLine(result);
        verify(divisionFormatterMock).formatLine(result);
        
        when(divisionFormatterMock.formatLine(result)).thenReturn(RESULT_DIVISION);
        assertEquals(RESULT_DIVISION, divisionFacade.start(345, 15));
    }
    

}
