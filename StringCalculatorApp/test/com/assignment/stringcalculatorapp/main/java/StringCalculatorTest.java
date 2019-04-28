package com.assignment.stringcalculatorapp.main.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    StringCalculator stringCalculator;
    @Before
    public void setUp()  {
         stringCalculator=new StringCalculator();
    }

    @After
    public void tearDown() {
        stringCalculator=null;
    }

    @Test
    public void testAddMethod_WhenStringIsEmpty_ThenMethodShouldReturnZero() {
        assertEquals(0,stringCalculator.add(""));
    }

    @Test
    public void testAddMethod_WhenMethodReturnsValue_ThenMethodShouldReturnInteger() {
        assertEquals(4,stringCalculator.add("1,3"));
    }

    @Test
    public void testAddMethod_WhenNewLineCharacterIsAppearedInString_ThenItShouldBeIgnored() {
        assertEquals(4,stringCalculator.add("1,\\n3"));
    }

    @Test
    public void testAddMethod_WhenStringContainsControlCodeToSpecifyDelimiter_ThenMethodShouldProcessItCorrectly() {
        assertEquals(8,stringCalculator.add("//;\\n1;3;4"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethod_WhenMethodCalledOnNegativeNumbers_ThenMethodShouldThrowException() {
        stringCalculator.add("//;\\n-1;3;-4");
    }

    @Test
    public void testAddMethod_WhenStringContainsNumberGreaterThanOneThousand_ThenMethodShouldIgnoreThatNumber() {
        assertEquals(5,stringCalculator.add("//;\\n1;3900;4"));
    }

    @Test
    public void testAddMethod_WhenDelimitersOfArbitraryLengthIsUsed_ThenMethodShouldProcessItCorrectly() {
        assertEquals(6,stringCalculator.add("//***\\n1***2***3"));
    }
    @Test
    public void testAddMethod_WhenMultipleDelimitersOfArbitraryLengthAreUsed_ThenMethodShouldProcessThemCorrectly() {
        assertEquals(6,stringCalculator.add("//$,@\\n1$2@3"));
    }
}