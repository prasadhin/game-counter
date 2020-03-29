package co.uk.prasadh.game.gameChanger;

import co.uk.prasadh.game.gameChanger.NumberChanger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test methods to check if rules for replacing numbers
 * is applied properly
 * Below Rules
 * Game 1
 * 1.Replace numbers with multiples of 3 as Fizz
 * 2.Replace numbers with multiples of 5 as Buzz
 * Replace numbers as FIzzBuzz if it has above criterias together
 *
 * Game 2
 * Extension of Game 1 and additional Rule
 * 3.Replace numbers as Fizz if number contains digit 3
 * 4.Replace numbers as Buzz if number contains digit 5
 * 5.Replace numbers as FIzzBuzz if it has above criterias together
 *
 * @author  Prasadh Murugesan
 */
class NumberChangerTest {

@Mock
NumberChanger numberChangerUnderTest;

    @BeforeEach
    void setUp() {
        numberChangerUnderTest = new NumberChanger();
    }

    @AfterEach
    void tearDown() {
        numberChangerUnderTest = null;
    }


    @Test
    void isNumberMultipleOrDivisibleByThree() {
        //check if a number is multiple or divisible by 3
        assertTrue(NumberChanger.isMultipleOrDivisibleByThree(12));
        assertFalse(NumberChanger.isMultipleOrDivisibleByThree(13));
    }

    @Test
    void isMultipleOrDivisibleByFive() {
        //check if a number is multiple or divisible by 5
        assertTrue(NumberChanger.isMultipleOrDivisibleByFive(15));
        assertFalse(NumberChanger.isMultipleOrDivisibleByFive(16));
    }

    @Test
    void hasDigitThree() {
        //check if a number contains digit 3
        assertTrue(NumberChanger.hasDigitThree(13));
        assertFalse(NumberChanger.hasDigitThree(11));
    }

    @Test
    void hasDigitFive() {
        //check if a number contains digit 5
        assertTrue(NumberChanger.hasDigitFive(15));
        assertFalse(NumberChanger.hasDigitFive(11));
    }

    @Test
    void checkRulesAppliedForGameA() {
        //Given a sample of 100 Numbers from 1 to 100
        List<Integer> sampleData = NumberChanger.getSampleData(100);

        /**
         * when game is played with Game Rule A
         *to check if numbers in sample are divisible or mulitples of 3 and 5
         * i.e Rule 1 and 2 specified in implementation class
         * */
        List<String> processedData = numberChangerUnderTest.playTheGameRuleA(sampleData);

        //Then randomly assert that the result is processed perfectly
        assertEquals(processedData.get(2),"Fizz");
        assertEquals(processedData.get(4),"Buzz");
        assertEquals(processedData.get(14),"FizzBuzz");
    }

    @Test
    void checkRulesAppliedForGameB() {
        //Given a sample of 100 Numbers from 1 to 100
        List<Integer> sampleData = NumberChanger.getSampleData(100);

        /**
         * when game is played with Game Rule B
         *to check if numbers in samples are divisible or mulitple of 3 and 5
         * given number contains digits 3 or 5
         * i.e Rule 1,2,3,4 specified in implementation class
         *
         */
        List<String> processedData = numberChangerUnderTest.playTheGameRuleB(sampleData);

        /** Then randomly assert that the result is processed perfectly
        * index 2 with number 3 should have been replaced by Fizz
        * index 12 with number 13 should have been replaced by Fizz since it contains 3
        * index 4 with number 5 should have been replaced by Buzz
        * index 50 with number 51 should have been replaced by FizzBuzz
         * since it is a multiple of 3  and contains digit 5
         */
        assertEquals(processedData.get(2),"Fizz");
        assertEquals(processedData.get(12),"Fizz");
        assertEquals(processedData.get(4),"Buzz");
        assertEquals(processedData.get(50),"FizzBuzz");
        assertEquals(processedData.get(59),"FizzBuzz");
    }
}