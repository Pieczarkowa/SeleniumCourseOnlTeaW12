package pl.coderslab.examples;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.coderslab.seleniumcourse.zad3.Calculator2;

public class AssertionExample2 {
        @Test
        public void shouldReturnValidAddResult() {
            // given
            int a = 2;
            int b = 40;
            // when
            int actual = Calculator2.add(a, b);
            // then
            Assertions.assertEquals(44, actual);
        }
    }

