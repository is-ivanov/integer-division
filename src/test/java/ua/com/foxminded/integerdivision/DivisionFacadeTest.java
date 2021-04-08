package ua.com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
    Formatable formatterMock;
    @Mock
    ResultOfCalculations result;

    @BeforeEach
    void setUp() {
        divisionFacade = new DivisionFacade(calculatorMock,
                formatterMock);
    }

    @Test
    @DisplayName("test case: divisor equals zero -> Facade should throw IllegalArgumentException with right message")
    void testDivisorEqualsZero_ThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> divisionFacade.start(15, 0));
        assertEquals(MESSAGE_DIVIDE_BY_ZERO, exception.getMessage());
    }
        
    @Nested
    @DisplayName("test case: dividend equals zero")
    class DividendEqualsZero {

        @Test
        @DisplayName("Facade should call calculator with right arguments")
        void testDividendEqualsZero_CallCalculator() {
            divisionFacade.start(0, 15);
            verify(calculatorMock).calculateResult(0, 15);
        }
        
        @Test
        @DisplayName("Facade should call formatter after calculator with right object")
        void testDividendEqualsZero_CallFormatterAfterCalculator() {
            doReturn(result).when(calculatorMock).calculateResult(0, 15);
            divisionFacade.start(0, 15);
            verify(formatterMock).formatLine(result);
        }
        
        @Test
        @DisplayName("Facade should output right string from formatter")
        void testDividendEqualsZero_RightOutput () {
            doReturn(result).when(calculatorMock).calculateResult(0, 15);
            when(formatterMock.formatLine(result)).thenReturn(RESULT_DIVISION_ZERO_DIVIDEND);
            
            assertEquals(RESULT_DIVISION_ZERO_DIVIDEND, divisionFacade.start(0, 15));
        }
        
    }

    @Nested
    @DisplayName("test case: normal division")
    class NormalDivision {

        @Test
        @DisplayName("Facade should call calculator with right arguments")
        void testNormalDivision_CallCalculator() {
            divisionFacade.start(17895, 15);
            verify(calculatorMock).calculateResult(17895, 15);
        }
        
        @Test
        @DisplayName("Facade should call formatter after calculator with right object")
        void testNormalDivision_CallFormatterAfterCalculator() {
            doReturn(result).when(calculatorMock).calculateResult(78965, 745);
            divisionFacade.start(78965, 745);
            verify(formatterMock).formatLine(result);
        }
        
        @Test
        @DisplayName("Facade should output right string from formatter")
        void testNormalDivision_RightOutput () {
            doReturn(result).when(calculatorMock).calculateResult(457, 15);
            when(formatterMock.formatLine(result)).thenReturn(RESULT_DIVISION);
            
            assertEquals(RESULT_DIVISION, divisionFacade.start(457, 15));
        }
        
    }


}
