package co.uk.prasadh.game.gameChanger;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility to apply rules for replacing numbers in the given samples
 * There may be several rules like
 * Replace numbers with multiples of 3 as Fizz
 * Replace numbers with multiples of 5 as Buzz
 * etc
 *
 * @author  Prasadh Murugesan
 */
public class NumberChanger {

    private final String fizz = "Fizz";
    private final String buzz = "Buzz";

    /**
     * utility method to check if given number
     * y, is divisible by x or
     * y is multiple of x
     */
    static boolean isMultipleOrDivisible(int multipleorDivisibleOf, int numberUnderCheck) {
        if (multipleorDivisibleOf == 0) throw new IllegalStateException("0 cannot be checked for a multiple");
        if (numberUnderCheck % multipleorDivisibleOf == 0) return true;
        else return false;
    }

    /**
     * utility method to check if given number
     * y has a digit x in it
     */
    static Boolean hasDigit(int digitForCheck, int numberUnderCheck) {
        while (numberUnderCheck > 0) {
            if (numberUnderCheck % 10 == digitForCheck)
                return true;

            numberUnderCheck = numberUnderCheck / 10;
        }
        return false;
    }

    /**
     * utility method to generate a sample of numbers
     * example. generate a sample of 100 numbers
     */
    static List<Integer> getSampleData(int totalNumbers){
        List<Integer> sampleData = new ArrayList<Integer>();
        for(int i=1;i<=totalNumbers;i++){
            sampleData.add(i);
        }
        return sampleData;
    }

    /**
     * List of rules to play the game
     * ------------------------------
     * Rule1
     * Check if the number is multiple or divisible by 3
     */
    static boolean isMultipleOrDivisibleByThree(int numberUnderCheck){
        return ((isMultipleOrDivisible(3,numberUnderCheck)) ? true : false  );
    }

    /**
     * Rule 2
     * Check if the number is multiple or divisible by 5
     */
    static boolean isMultipleOrDivisibleByFive(int numberUnderCheck){
        return ((isMultipleOrDivisible(5,numberUnderCheck)) ? true : false  );
    }

    /**
     * Rule 3
     * Check if the number contains digit 3
     */
    static boolean hasDigitThree(int numberUnderCheck){
        return ((hasDigit(3,numberUnderCheck)) ? true : false  );
    }

    /**
     * Rule 4
     * Check if the number contains digit 5
     */
    static boolean hasDigitFive(int numberUnderCheck){
        return ((hasDigit(5,numberUnderCheck)) ? true : false  );
    }

    //play game 1 with Rule A
    public List<String> playTheGameRuleA(List<Integer> sampleData){
        List<String> processedData = new ArrayList<>();
        String ruleAppliedString = "";
        for(Integer numberUnderCheck: sampleData){
            ruleAppliedString = "";
            // Check if number is multiple or Divisible by 3, Refer rule 1 above
            if(isMultipleOrDivisibleByThree(numberUnderCheck)) { ruleAppliedString += fizz; }

            // Check if number is multiple or Divisible by 5, Refer rule 2 above
            if(isMultipleOrDivisibleByFive(numberUnderCheck)) { ruleAppliedString += buzz; }
            if(ruleAppliedString.equals("")) ruleAppliedString = numberUnderCheck+"";
            processedData.add(ruleAppliedString);
        }
        return processedData;
    }

    //play game 1 with Rule B
    public List<String> playTheGameRuleB(List<Integer> sampleData){
        List<String> processedData = new ArrayList<>();
        String ruleAppliedString = "";
        for(Integer numberUnderCheck: sampleData){
            ruleAppliedString = "";
            // Check if number is multiple or Divisible by 3, or has digit 3
            if(isMultipleOrDivisibleByThree(numberUnderCheck) | hasDigitThree(numberUnderCheck)){
                ruleAppliedString += fizz;
            }

            // Check if number is multiple or Divisible by 5, or has digit 5
            if(isMultipleOrDivisibleByFive(numberUnderCheck) | hasDigitFive(numberUnderCheck)){
                ruleAppliedString += buzz;
            }
            if(ruleAppliedString.equals("")) ruleAppliedString = numberUnderCheck+"";
            processedData.add(ruleAppliedString);
        }
        return processedData;
    }


    // Driver code
    public static void main (String[]args)
    {
        NumberChanger numberChangerGame = new NumberChanger();
        //Play Game 1, with 100 samples from 1 to 100
        List<String> processedData = numberChangerGame.playTheGameRuleA(getSampleData(100));
        processedData.forEach(System.out::println);

        //Play Game 2, with 100 samples from 1 to 100
        processedData = numberChangerGame.playTheGameRuleB(getSampleData(100));
        processedData.forEach(System.out::println);

        //please check the Test class for detailed tests.
    }
}

