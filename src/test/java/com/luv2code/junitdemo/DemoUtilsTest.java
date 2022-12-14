package com.luv2code.junitdemo;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforEach(){
        demoUtils = new DemoUtils();
        System.out.println("Setup before all!");
    }

    @Test
    @DisplayName("Equal and Not Equal")
    void testEqualAndNotEqual(){
        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6");
        assertNotEquals(10, demoUtils.add(2,4), "2+4 must not be 10");

    }

    @Test
    @DisplayName("Null and Not Null")
    void testNullandNotNull(){
        String stringOne = null;
        String stringTwo = "Hello";

        assertNull(demoUtils.checkNull(stringOne));
        assertNotNull(demoUtils.checkNull(stringTwo));
    }

    @Test
    @DisplayName("Same and Not Same")
    void testSameandNotSame(){
        String str = "luv2code";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate());
        assertNotSame(demoUtils.getAcademy(), str);
    }

    @Test
    @DisplayName("True and False")
    void testTrueandFalse() {
        int gradeOne = 5;
        int gradeTwo = 10;

        assertTrue(demoUtils.isGreater(gradeTwo, gradeOne));
        assertFalse(demoUtils.isGreater(gradeOne, gradeTwo));
    }

    @Test
    @DisplayName("Array Equals")
    void testArrayEquals() {
         String[] stringArray = {"A", "B", "C"};

         assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet());
    }

    @Test
    @DisplayName("Iterable Equals")
    void testIterableEquals() {
        List<String> stringList = List.of("luv", "2", "code");

        assertIterableEquals(stringList, demoUtils.getAcademyInList());
    }

    @Test
    @DisplayName("Line Match")
    void testLinesMatch () {
        List<String> stringList = List.of("luv", "2", "code");

        assertLinesMatch(stringList, demoUtils.getAcademyInList());
    }

    @Test
    @DisplayName("Throw Exception and Does not Throw")
    void testThrowAndDoesNotThrow() {
        assertThrows(Exception.class, () -> { demoUtils.throwException(-1); });
        assertDoesNotThrow(() -> { demoUtils.throwException(1); });

    }

    @Test
    @DisplayName("Time Out")
    void testTimeOut() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> { demoUtils.checkTimeout();});
    }
    /*
    @AfterEach
    void tearDownAfterEach(){
        System.out.println("Setup before all!");
    }

    @BeforeAll
    static void setupBeforeAll(){
        System.out.println("Setup before all!");
    }

    @AfterAll
    static void tearDownAfterAll(){
        System.out.println("tear down after all!");
    }
     */

}
