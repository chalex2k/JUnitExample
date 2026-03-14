import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorTest {

//    @BeforeEach
//    void setUp() {
//        Calculator this.calc = new Calculator(); // Можно положить в поле класса, тогда в каждом тесте не придётся создавать объект
//    }

    @Test
    void testGcd() {
        Calculator calc = new Calculator();

        int result = calc.gcd(2, 3);

        assertEquals(1, result, String.format("ожидалось 1, получено %d", result));
    }

    @Test
    @DisplayName("Должен сортировать обычный массив")
    void testBubbleSort_NormalArray() {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};

        Calculator.bubbleSort(array);

        assertArrayEquals(expected, array);
    }

    @Test
    @DisplayName("Должен обрабатывать уже отсортированный массив")
    void testBubbleSort_AlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        Calculator.bubbleSort(array);

        assertArrayEquals(expected, array);
    }


    @ParameterizedTest
    @MethodSource("gcdTestData")
    void testGcd_WithMethodSource(int a, int b, int expected) {
        Calculator calc = new Calculator();

        assertEquals(expected, calc.gcd(a, b));
    }

    static Stream<Arguments> gcdTestData() {
        return Stream.of(
                Arguments.of(54, 24, 6),
                Arguments.of(48, 18, 6),
                Arguments.of(17, 19, 1),
                Arguments.of(0, 5, 5),
                Arguments.of(100, 10, 10),
                Arguments.of(81, 27, 27),
                Arguments.of(13, 7, 1),
                Arguments.of(-48, 18, 6),
                Arguments.of(48, -18, 6),
                Arguments.of(-48, -18, 6),
                Arguments.of(1071, 462, 21),
                Arguments.of(252, 105, 21)
        );
    }
}