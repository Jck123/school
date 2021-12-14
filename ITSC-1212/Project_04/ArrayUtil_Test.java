import java.util.Arrays;

/**
 * ITSC 1212 ArrayUtil_Test class for Project 4
 */
public class ArrayUtil_Test {
    public static void main(String[] args) {

        // statements for output formatting
        System.out.println("*******************************");
        System.out.println("     Array Utility Project     ");
        System.out.println("*******************************");

        ArrayUtil arrayUtility = new ArrayUtil();

        int[] arr0 = {};
        int[] uniqueArr0 = {};
        arrayUtility.setIntArray(arr0);
        System.out.println("Test 0 - min value: " + validate(0, arrayUtility.minValue()));
        System.out.println("Test 0 - max value: " + validate(0, arrayUtility.maxValue()));
        System.out.println("Test 0 - count unique: " + validate(0, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 0 - unique array: " + validate(uniqueArr0, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 0 - in order: " + validate(0, arrayUtility.isSorted()));
        System.out.println("Test 0 - number swap: N/A");
        System.out.println("-----------------------");

        int[] arr1 = { 3, -3, -1, 0, -1, 4, 0, 3, 4, 0 };
        int[] uniqueArr1 = { 3, -3, -1 , 0, 4 }; 
        int[] swapArr1 = { -3, 3, -1, 0, -1, 4, 0, 3, 4, 0 };
        arrayUtility.setIntArray(arr1);
        System.out.println("Test 1 - min value: " + validate(-3, arrayUtility.minValue()));
        System.out.println("Test 1 - max value: " + validate(4, arrayUtility.maxValue()));
        System.out.println("Test 1 - count unique: " + validate(5, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 1 - unique array: " + validate(uniqueArr1, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 1 - in order: " + validate(0, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 1 - number swap: " + validate(swapArr1, arrayUtility.getIntArray()));
        System.out.println("-----------------------");

        int[] arr2 = { 4, 3, -1, 1, -3, -1, 1, -5, -3, -4 };
        int[] uniqueArr2 = { 4, 3, -1, 1, -3, -5, -4 };
        int[] swapArr2 = { 3, 4, -1, 1, -3, -1, 1, -5, -3, -4 };
        arrayUtility.setIntArray(arr2);
        System.out.println("Test 2 - min value: " + validate(-5, arrayUtility.minValue()));
        System.out.println("Test 2 - max value: " + validate(4, arrayUtility.maxValue()));
        System.out.println("Test 2 - count unique: " + validate(7, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 2 - unique array: " + validate(uniqueArr2, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 2 - in order: " + validate(0, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 2 - number swap: " + validate(swapArr2, arrayUtility.getIntArray()));
        System.out.println("-----------------------");

        int[] arr3 = { 0, 0, 0, -3, 0, -1, -3, 1, 1, 2 };
        int[] uniqueArr3 = { 0, -3, -1, 1, 2 };
        int[] swapArr3 = { 0, 0, 0, -3, 0, -1, -3, 1, 1, 2 };
        arrayUtility.setIntArray(arr3);
        System.out.println("Test 3 - min value: " + validate(-3, arrayUtility.minValue()));
        System.out.println("Test 3 - max value: " + validate(2, arrayUtility.maxValue()));
        System.out.println("Test 3 - count unique: " + validate(5, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 3 - unique array: " + validate(uniqueArr3, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 3 - in order: " + validate(0, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 3 - number swap: " + validate(swapArr3, arrayUtility.getIntArray()));
        System.out.println("-----------------------");

        int[] arr4 = { 8, 7, -1, -2, 9, 0, 3, 2, -2, 3, -2, 9, 2, -3, 3 };
        int[] uniqueArr4 = { 8, 7, -1, -2, 9, 0, 3, 2, -3 };
        int[] swapArr4 = { 7, 8, -1, -2, 9, 0, 3, 2, -2, 3, -2, 9, 2, -3, 3 };
        arrayUtility.setIntArray(arr4);
        System.out.println("Test 4 - min value: " + validate(-3, arrayUtility.minValue()));
        System.out.println("Test 4 - max value: " + validate(9, arrayUtility.maxValue()));
        System.out.println("Test 4 - count unique: " + validate(9, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 4 - unique array: " + validate(uniqueArr4, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 4 - in order: " + validate(0, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 4 - number swap: " + validate(swapArr4, arrayUtility.getIntArray()));
        System.out.println("-----------------------");

        int[] arr5 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] uniqueArr5 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] swapArr5 = { 2, 1, 3, 4, 5, 6, 7, 8, 9, 10 };
        arrayUtility.setIntArray(arr5);
        System.out.println("Test 5 - min value: " + validate(1, arrayUtility.minValue()));
        System.out.println("Test 5 - max value: " + validate(10, arrayUtility.maxValue()));
        System.out.println("Test 5 - count unique: " + validate(10, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 5 - unique array: " + validate(uniqueArr5, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 5 - in order: " + validate(1, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 5 - number swap: " + validate(swapArr5, arrayUtility.getIntArray()));
        System.out.println("-----------------------");

        int[] arr6 = { 2, -3, -1, 0, 1, -2 };
        int[] uniqueArr6 = { 2, -3, -1, 0, 1, -2 };
        int[] swapArr6 = { -3, 2, -1, 0, 1, -2 };
        arrayUtility.setIntArray(arr6);
        System.out.println("Test 6 - min value: " + validate(-3, arrayUtility.minValue()));
        System.out.println("Test 6 - max value: " + validate(2, arrayUtility.maxValue()));
        System.out.println("Test 6 - count unique: " + validate(6, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 6 - unique array: " + validate(uniqueArr6, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 6 - in order: " + validate(0, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 6 - number swap: " + validate(swapArr6, arrayUtility.getIntArray()));
        System.out.println("-----------------------");

        int[] arr7 = { -4, 3, 6, -2, -1, -4 };
        int[] uniqueArr7 = { -4, 3, 6, -2, -1 };
        int[] swapArr7 = { 3, -4, 6, -2, -1, -4 };
        arrayUtility.setIntArray(arr7);
        System.out.println("Test 7 - min value: " + validate(-4, arrayUtility.minValue()));
        System.out.println("Test 7 - max value: " + validate(6, arrayUtility.maxValue()));
        System.out.println("Test 7 - count unique: " + validate(5, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 7 - unique array: " + validate(uniqueArr7, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 7 - in order: " + validate(0, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 7 - number swap: " + validate(swapArr7, arrayUtility.getIntArray()));
        System.out.println("-----------------------");

        int[] arr8 = { 0, -1, 0 };
        int[] uniqueArr8 = { 0, -1 };
        int[] swapArr8 = { -1, 0, 0 };
        arrayUtility.setIntArray(arr8);
        System.out.println("Test 8 - min value: " + validate(-1, arrayUtility.minValue()));
        System.out.println("Test 8 - max value: " + validate(0, arrayUtility.maxValue()));
        System.out.println("Test 8 - count unique: " + validate(2, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 8 - unique array: " + validate(uniqueArr8, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 8 - in order: " + validate(0, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 8 - number swap: " + validate(swapArr8, arrayUtility.getIntArray()));
        System.out.println("-----------------------");

        int[] arr9 = { 1, 2, -1, 40, 1, 40, 0, 0, -3, 2, 2, -2, -5, 0, 1, -4, -5 };
        int[] uniqueArr9 = { 1, 2, -1, 40, 0, -3, -2, -5, -4 };
        int[] swapArr9 = { 2, 1, -1, 40, 1, 40, 0, 0, -3, 2, 2, -2, -5, 0, 1, -4, -5 };
        arrayUtility.setIntArray(arr9);
        System.out.println("Test 9 - min value: " + validate(-5, arrayUtility.minValue()));
        System.out.println("Test 9 - max value: " + validate(40, arrayUtility.maxValue()));
        System.out.println("Test 9 - count unique: " + validate(9, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 9 - unique array: " + validate(uniqueArr9, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 9 - in order: " + validate(0, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 9 - number swap: " + validate(swapArr9, arrayUtility.getIntArray()));
        System.out.println("-----------------------");

        int[] arr10 = { 4, 5, 5, 4, 1, 5, -3, 4, -1, -2, -2, -2, -2, -2, -2, 1, 4, 5, -5 };
        int[] uniqueArr10 = { 4, 5, 1, -3, -1, -2, -5 };
        int[] swapArr10 = { 5, 4, 5, 4, 1, 5, -3, 4, -1, -2, -2, -2, -2, -2, -2, 1, 4, 5, -5 };
        arrayUtility.setIntArray(arr10);
        System.out.println("Test 10 - min value: " + validate(-5, arrayUtility.minValue()));
        System.out.println("Test 10 - max value: " + validate(5, arrayUtility.maxValue()));
        System.out.println("Test 10 - count unique: " + validate(7, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 10 - unique array: " + validate(uniqueArr10, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 10 - in order: " + validate(0, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 10 - number swap: " + validate(swapArr10, arrayUtility.getIntArray()));
        System.out.println("-----------------------");

        int[] arr11 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] uniqueArr11 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };                          //Added 2 of my own examples to check the bonus parts
        int[] swapArr11 = { 9, 10, 8, 7, 6, 5, 4, 3, 2, 1 };
        arrayUtility.setIntArray(arr11);
        System.out.println("Test 11 - min value: " + validate(1, arrayUtility.minValue()));
        System.out.println("Test 11 - max value: " + validate(10, arrayUtility.maxValue()));
        System.out.println("Test 11 - count unique: " + validate(10, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 11 - unique array: " + validate(uniqueArr11, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 11 - in order: " + validate(-1, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 11 - number swap: " + validate(swapArr11, arrayUtility.getIntArray()));
        System.out.println("-----------------------");

        int[] arr12 = { 1, 1, 1 };
        int[] uniqueArr12 = { 1 };
        int[] swapArr12 = { 1, 1, 1 };
        arrayUtility.setIntArray(arr12);
        System.out.println("Test 12 - min value: " + validate(1, arrayUtility.minValue()));
        System.out.println("Test 12 - max value: " + validate(1, arrayUtility.maxValue()));
        System.out.println("Test 12 - count unique: " + validate(1, arrayUtility.countUniqueIntegers()));
        System.out.println("Test 12 - unique array: " + validate(uniqueArr12, arrayUtility.getUniqueIntegers()));
        System.out.println("Test 12 - in order: " + validate(2, arrayUtility.isSorted()));
        arrayUtility.numSwap(0, 1);
        System.out.println("Test 12 - number swap: " + validate(swapArr12, arrayUtility.getIntArray()));
        System.out.println("-----------------------");
    }

    // DO NOT MODIFY validate METHOD
    private static String validate(int expected, int answer) {
        if (answer != expected) {
            return ("The result " + answer + " does not match expected: " + expected + " --->> Failed");
        } else {
            return ("The result " + answer + "  match expected: " + expected + " --->> OK");
        }
    }

    private static String validate(int[] expected, int[] answer) {      //Added my own overload for validate to check arrays
        if (Arrays.equals(expected, answer))
            return "The result matches the expected answer!";
        else
            return "The result does not match the expected answer";
    }
}
