package com.acme.edu.iteration02;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.TypeSafeLogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion


    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        TypeSafeLogger.log("str 1");
        TypeSafeLogger.log(1);
        TypeSafeLogger.log(2);
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log(0);
        TypeSafeLogger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("3");
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }


    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        TypeSafeLogger.log("str 1");
        TypeSafeLogger.log(10);
        TypeSafeLogger.log(Integer.MAX_VALUE);
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(String.valueOf(Integer.MAX_VALUE));
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        TypeSafeLogger.log("str 1");
        TypeSafeLogger.log((byte) 10);
        TypeSafeLogger.log((byte) Byte.MAX_VALUE);
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1\n");
        assertSysoutContains("10\n");
        assertSysoutContains(Byte.MAX_VALUE + "\n");
        assertSysoutContains("str 2\n");
        assertSysoutContains("0\n");
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        TypeSafeLogger.log("str 1");
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log(0);
        TypeSafeLogger.log("str 2");
        TypeSafeLogger.log("str 3");
        TypeSafeLogger.log("str 3");
        TypeSafeLogger.log("str 3");
        //endregion

        //region then
        assertSysoutEquals(
                "str 1\n" +
                        "str 2 (x2)\n" +
                        "0\n" +
                        "str 2\n" +
                        "str 3 (x3)\n"
        );
        //endregion
    }
}