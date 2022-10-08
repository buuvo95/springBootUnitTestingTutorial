package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforEach(){
        demoUtils = new DemoUtils();
        System.out.println("Setup before all!");
    }

    @Test
    //@DisplayName("Equal and Not Equal")
    void testEqualAndNotEqual(){
        DemoUtils demoUtils = new DemoUtils();

        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6");
        assertNotEquals(10, demoUtils.add(2,4), "2+4 must not be 10");

    }

    @Test
    //@DisplayName("Null and Not Null")
    void testNullandNotNull(){
        DemoUtils demoUtils = new DemoUtils();

        String stringOne = null;
        String stringTwo = "Hello";

        assertNull(demoUtils.checkNull(stringOne));
        assertNotNull(demoUtils.checkNull(stringTwo));
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
