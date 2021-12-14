import java.util.Arrays;

public class ArrayUtil {
    private int[] intArray = {};
    private int[] uniqueArray = {};

    public ArrayUtil() {        //Default constructor(what do I even put in here?)

    }

    public ArrayUtil(int[] inputArray) {        //Other constructor
        intArray = inputArray;
        uniqueArray = new int[inputArray.length];
    }

    public void setIntArray(int[] intArray) {       //Changes the target array
        this.intArray = intArray;
    }

    public int[] getIntArray() {                    //Retrieves the current target
        return intArray;
    }

    public int minValue() {                         //Returns lowest value in the array
        if (intArray.length == 0 || intArray == null)
            return 0;                               //If the array is empty, then return 0
        int minVal = Integer.MAX_VALUE;
        for(int i : intArray) {
            if (minVal > i)                         //Simply checks each value if it's lower than the current lowest and if so, take that value
                minVal = i;
        }
        return minVal;
    }

    public int maxValue() {                         //Returns highest value in the array
        if (intArray.length == 0 || intArray == null)
            return 0;                               //Works the exact same way as above, except the greater than symbol and now less than
        int maxVal = Integer.MIN_VALUE;
        for(int i : intArray) {
            if (maxVal < i)
                maxVal = i;
        }
        return maxVal;
    }

    public int countUniqueIntegers() {              //Does 2 jobs to simplify work, might not be effecient but w/e, I'm tired
        if (intArray.length == 0 || intArray == null)   //Both makes the uniqueArray and also counts the unique numbers at the same time
            return 0;                               //If array is empty, return 0
        uniqueArray = new int[intArray.length];
        for(int i = 0; i < uniqueArray.length; i++)
            uniqueArray[i] = Integer.MIN_VALUE;     //Creates an array of the lowest possible value possible with integer, will cause
        int uniqueCount = 0;                        //an issue if someone has an array with the lowest possible integer, leading to a logic error
        boolean unique;

        for (int i : intArray) {                    //Checks each value in the intArray to see if it's found in the current list of unique values
            unique = true;
            for (int j : uniqueArray)               //If so, then marks the number it's currently on as not unique and breaks the loop to save time
                if (i == j) {
                    unique = false;
                    break;
                }
            if (unique) {                           //Once we determine if the uniqueArray does not have the number we're checking,
                uniqueArray[uniqueCount] = i;       //we add it to the uniqueArray and increase uniqueCount by 1
                uniqueCount++;
            }
        }
        uniqueArray = Arrays.copyOfRange(uniqueArray, 0, uniqueCount);  //Here, we shorten the array to remove other unnecessary values that are not unique
        return uniqueCount;
    }

    public int[] getUniqueIntegers() {              //Returns the array of unique integers, to save code, just runs the above method
        countUniqueIntegers();
        return uniqueArray;
    }

    public void numSwap(int firstIndex, int secondIndex) {      //Simply swaps the placement of 2 integers
        int temp = intArray[firstIndex];
        intArray[firstIndex] = intArray[secondIndex];
        intArray[secondIndex] = temp;
    }

    public int isSorted() {                                     //Checks if the array is sorted in numerical order, backwards, forwards, or both!
        if (intArray.length == 0)                               //(If it's both backwards and forwards, then the array only has 1 unique number)
            return 0;
        int[] forwardSort = new int[intArray.length];           //Creates 4 arrays, 2 for each sorting method
        int[] backwardSort = new int[intArray.length];
        int[] tempFor = intArray.clone();
        int[] tempBack = intArray.clone();
        int lowest;
        int highest;
        
        for(int i = 0; i < forwardSort.length; i++) {
            lowest = Integer.MAX_VALUE;
            for(int j = 0; j < tempFor.length; j++)             //Uses selection sort to organize the arrays
                if (lowest > tempFor[j]) {
                    lowest = tempFor[j];
                    tempFor[j] = Integer.MAX_VALUE;
                }
            forwardSort[i] = lowest;
        }

        for(int i = 0; i < backwardSort.length; i++) {
            highest = Integer.MIN_VALUE;
            for(int j = 0; j < tempBack.length; j++)            //Same thing as above, but backwards sorting
                if (highest < tempBack[j]) {
                    highest = tempBack[j];
                    tempBack[j] = Integer.MIN_VALUE;
                }
            backwardSort[i] = highest;
        }

        if (Arrays.equals(intArray, forwardSort) && Arrays.equals(intArray, backwardSort))      //If sorted both backwards and forwards
            return 2;
        else if (Arrays.equals(intArray, forwardSort))                                          //If sorted forwards
            return 1;
        else if (Arrays.equals(intArray, backwardSort))                                         //If sorted backwards
            return -1;
        else                                                                                    //If not sorted at all
            return 0;
    }
}