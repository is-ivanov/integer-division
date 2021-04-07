package ua.com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
class DivisionFacadeTest {
    private static final String MESSAGE_DIVIDE_BY_ZERO = "Divisor can't be 0";
    private static final String LF = System.lineSeparator();

    private static DivisionFacade divisionFacade;
    @Mock
    DivisionCalculator calculatorMock;
    @Mock
    Formatable divisionFormatterMock;

    @BeforeEach
    void setUp() {
        calculatorMock = mock(DivisionCalculator.class);
        divisionFormatterMock = mock(DivisionFormatter.class);
        divisionFacade = new DivisionFacade(calculatorMock, divisionFormatterMock);
    }

    @Test
    @DisplayName("test input zero to divisor should output exception")
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> divisionFacade.start(15, 0));
        assertEquals(MESSAGE_DIVIDE_BY_ZERO, exception.getMessage());
    }

}
