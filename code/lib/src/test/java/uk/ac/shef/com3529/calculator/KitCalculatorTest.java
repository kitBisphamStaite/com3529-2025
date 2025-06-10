package uk.ac.shef.com3529.calculator;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.InputMismatchException;

public class KitCalculatorTest {

    @Test
    public void shouldAddNumbers() {
        Reader mockReader = mock(Reader.class);
        Writer mockWriter = mock(Writer.class);

        when(mockReader.readDouble()).thenReturn(1.0, 1.0);
        when(mockReader.readWord()).thenReturn("+");

        Calculator calculator = new Calculator(mockReader, mockWriter); 
        calculator.calculate();

        verify(mockWriter).write("1.0 + 1.0 = 2.0");
    }

    @Test
    public void shouldSubNumbers() {
        Reader mockReader = mock(Reader.class);
        Writer mockWriter = mock(Writer.class);

        when(mockReader.readDouble()).thenReturn(1.0, 1.0);
        when(mockReader.readWord()).thenReturn("-");

        Calculator calculator = new Calculator(mockReader, mockWriter); 
        calculator.calculate();

        verify(mockWriter).write("1.0 - 1.0 = 0.0");
    }

    @Test
    public void shouldDevideNumbers() {
        Reader mockReader = mock(Reader.class);
        Writer mockWriter = mock(Writer.class);

        when(mockReader.readDouble()).thenReturn(1.0, 1.0);
        when(mockReader.readWord()).thenReturn("/");

        Calculator calculator = new Calculator(mockReader, mockWriter); 
        calculator.calculate();

        verify(mockWriter).write("1.0 / 1.0 = 1.0");
    }

    @Test
    public void shouldTimesNumbers() {
        Reader mockReader = mock(Reader.class);
        Writer mockWriter = mock(Writer.class);

        when(mockReader.readDouble()).thenReturn(1.0, 1.0);
        when(mockReader.readWord()).thenReturn("*");

        Calculator calculator = new Calculator(mockReader, mockWriter); 
        calculator.calculate();

        verify(mockWriter).write("1.0 * 1.0 = 1.0");
    }

    @Test
    public void shouldThrowExeptionForInvalidNumber() {
        Reader mockReader = mock(Reader.class);
        Writer mockWriter = mock(Writer.class);

        when(mockReader.readDouble()).thenThrow(new InputMismatchException())
                                    .thenReturn(1.0, 1.0);
        when(mockReader.readWord()).thenReturn("*");

        Calculator calculator = new Calculator(mockReader, mockWriter); 
        calculator.calculate();

        verify(mockWriter).write("Please try again (enter a number):");
    }

        @Test
    public void shouldAskToEnterValidOperator() {
        Reader mockReader = mock(Reader.class);
        Writer mockWriter = mock(Writer.class);

        when(mockReader.readDouble()).thenThrow(new InputMismatchException())
                                    .thenReturn(1.0, 1.0);
        when(mockReader.readWord()).thenReturn("a", "*");

        Calculator calculator = new Calculator(mockReader, mockWriter); 
        calculator.calculate();

        verify(mockWriter).write("Please try again (enter an operator):");
    }
}
