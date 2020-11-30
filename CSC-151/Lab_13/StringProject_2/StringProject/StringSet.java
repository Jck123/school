import java.util.ArrayList; // Imports ArrayList

public class StringSet extends ArrayList<String> { // Extender header
    
	// Object
    public StringSet() {
    }

    public boolean add(String addedString) {
    	
    	return super.add(addedString);
    }
    
    // Removes item from array
    public void pop() {
        if (size() > 0) {
            super.remove(size() - 1);
            
        }
    }
    
    // Counts how many items are in array
    public int size() {
        return super.size();
    }
   
    // Counts how many characters are in array
    public int numChars() {
        int totalChars = 0;
        for (int i = 0; i < super.size(); i++) {
            String index = super.get(i);
            totalChars += index.length();
        }
        return totalChars;
    }
    
    // Counts how many strings are in array
    public int countStrings(String stringToLookFor){
        int detected = 0;
        for (int i = 0; i < super.size(); i++) {
            String index= super.get(i);
            if ((index.indexOf(stringToLookFor)) == 0){
                detected++;
            }
        }
        return detected;
    }
}