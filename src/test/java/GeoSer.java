import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import java.util.Locale;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

public class GeoSer {

    private static long startTime;
    private static long testStartTime;

    @BeforeAll
    public static void initSetup() {
        System.out.println("Старт");
        startTime = System.nanoTime();
    }

    @AfterAll
    public static void completeSetup() {
        System.out.println("Проверка строки завершена: " + (System.nanoTime() - startTime));
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Начинаем новое");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalTest() {
        System.out.println("Тест завершон: " + (System.nanoTime() - testStartTime));
    }
    @ParameterizedTest
    @CsvSource({"'127.0.0.1','172.0.32.11','96.44.183.149','172.12.25.33','96.55.78.35'"})
    public void byIpTest(String local, String moskov, String newYork, String ipMoskov, String ipNewYork) {
        String loc = GeoServiceImpl.LOCALHOST;
        Assertions.assertEquals(loc, local);

        String mosk = GeoServiceImpl.MOSCOW_IP;
        Assertions.assertEquals(mosk, moskov);

        String newY = GeoServiceImpl.NEW_YORK_IP;
        Assertions.assertEquals(newY, newYork);

        boolean ipstr = ipMoskov.startsWith("172.");
        Assertions.assertTrue(ipstr, ipMoskov);

        boolean ipstri = ipNewYork.startsWith("96.");
        Assertions.assertTrue(ipstri, ipNewYork);
    }
    @Test
    public void location() {
        GeoServiceImpl geo = new GeoServiceImpl();
        var expected = RuntimeException.class;
        Assertions.assertThrows(expected,() -> geo.byCoordinates(0.1,0.2));
    }
}
