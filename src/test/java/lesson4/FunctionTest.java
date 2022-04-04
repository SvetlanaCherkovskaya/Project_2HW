package lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static lesson4.Function.getAreaOfTriangle;

public class FunctionTest {

    private static final Logger logger = LoggerFactory.getLogger("FunctionTest");

    @ParameterizedTest
    @CsvSource({"2.905,3,2,4", "61.275,10.3,12,16.8"})
    void getAreaTest(double expectedResult, double a, double b, double c) throws NotTriangleExeption {
        Assertions.assertEquals(expectedResult, getAreaOfTriangle(a, b, c), 0.005);
        logger.info("getAreaTest is finished");
    }

    @Test
    void getIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> getAreaOfTriangle(3, 5.2, 0));
        logger.info("getIllegalArgumentException is finished");
    }

    @Test
    void getNotTriangleExeptionTest() {
        Assertions.assertThrows(NotTriangleExeption.class, () -> getAreaOfTriangle(3, 5.2, 100));
        logger.info("getNotTriangleExeptionTest");
    }
}
