package com.marsrover;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;

public class NasaTest {

    private Nasa nasa;

    @Before
    public void init() {
        nasa = new Nasa();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldPassWithValidParameters() {
        Scanner scanner = mock(Scanner.class);

        doAnswer(new Answer() {
            private int count = 0;

            public Object answer(InvocationOnMock invocation) {
                if (count == 0) {
                    count += 1;
                    return "5 5";
                }
                if (count == 1) {
                    count += 1;
                    return "1 2 N";
                }
                if (count == 2) {
                    count += 1;
                    return "LMLMLMLMM";
                }
                if (count == 3) {
                    count += 1;
                    return "3 3 E";
                }
                if (count == 4) {
                    count += 1;
                    return "MMRMMRMRRM";
                }
                if (count == 5) {
                    return "";
                }
                return "";
            }
        }).when(scanner).nextLine();

        nasa.startProcess(scanner);

        verify(scanner, times(6)).nextLine();
    }

    @Test
    public void shouldThrowInputMismatchExceptionWithMarsNevativeValues() {
        Scanner scanner = mock(Scanner.class);

        when(scanner.nextLine()).thenReturn("-5 -5");

        thrown.expect(InputMismatchException.class);
        thrown.expectMessage(equalTo("Coordinates must be positive!"));

        nasa.startProcess(scanner);
    }

    @Test
    public void shouldThrowInputMismatchExceptionWithRoverNevativeValues() {
        Scanner scanner = mock(Scanner.class);

        doAnswer(new Answer() {
            private int count = 0;

            public Object answer(InvocationOnMock invocation) {
                if (count == 0) {
                    count += 1;
                    return "5 5";
                }
                if (count == 1) {
                    count += 1;
                    return "-1 -2 N";
                }
                return "";
            }
        }).when(scanner).nextLine();


        thrown.expect(InputMismatchException.class);
        thrown.expectMessage(equalTo("Coordinates must be positive!"));

        nasa.startProcess(scanner);
    }

    @Test
    public void shouldThrowInputMismatchExceptionWithRoverMaxValues() {
        Scanner scanner = mock(Scanner.class);

        doAnswer(new Answer() {
            private int count = 0;

            public Object answer(InvocationOnMock invocation) {
                if (count == 0) {
                    count += 1;
                    return "5 5";
                }
                if (count == 1) {
                    count += 1;
                    return "6 0 N";
                }
                return "";
            }
        }).when(scanner).nextLine();


        thrown.expect(InputMismatchException.class);
        thrown.expectMessage(equalTo("Rover coordinates must be in range of Nasa's research field in Mars!"));

        nasa.startProcess(scanner);
    }

}
