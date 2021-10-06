public class MagPie {
    
    private int silentCount = 0;        //Sorry, but I'm cheating to make a cooler program
    /**
     * A default constuctor
     * 
     */
    public MagPie(){        //1 Constructor, does nothing
                            //No fields, there are only variables inside the methods, which do not count
    }                       //3 Methods, getGreeting(), getResponse(), and getRandomResponse()
                            //getGreeting() just returns the String "Hello, let's talk." Nothing else.
    /**
     * Get a default greeting
     * 
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        String response = "";
        if (statement.trim().equalsIgnoreCase("no")) {      //Just modified so if the user simply denies to respond, the chatbot asks "Why so negative?"
            response = "Why so negative?";
        } else if (statement.indexOf("mother") >= 0 || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0 || statement.indexOf("brother") >= 0) {
            response = "Tell me more about your family.";
        } else if (statement.indexOf("Mr. Gaw") >= 0 || statement.indexOf("Gaw") >= 0           //Gaw was wy high school programming teacher, he had a huge influence
                || statement.indexOf("Dr. Whaley") >= 0 || statement.indexOf("Whaley") >= 0 ) { //in my appreciation for programming
            response = "Him? He's a great programming teacher!";
        } else if (statement.indexOf("Potatofactory") >= 0) {
            response = "Potato? He's an excellent fellow and a brilliant man!";     //Close online friend of mine who also taught me a bit of programming and always encouraged me
        } else if (statement.trim().isEmpty()) {                                    //No response
            if (silentCount == 0) {
                response = "Please say something";
                silentCount++;
            } else if (silentCount == 1) {
                response = "Giving me the silent treatment, eh?";
                silentCount++;
            } else if (silentCount == 2) {
                response = "Fine, screw you! I won't say anything either!";
                silentCount++;
            } else {
                response = "...";
            }
        } else {
            response = getRandomResponse();
        }
        if (silentCount > 0 & !statement.trim().isEmpty()) {
            silentCount = 0;
            response = "Finally ready to start talking again, huh? Very well... \n" + response;     //Reinitiating conversation...
        }
        return response;
    }

    //Part D Questions:
    //1. "Why so negative?"
    //2. The output of the first if statement conditional is met
    //3. "Why so negative?"

    /**
     * Pick a default response to use if nothing else fits.
     * 
     * @return a string
     */
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        } else if (whichResponse == 1) {
            response = "Hmmm.";
        } else if (whichResponse == 2) {
            response = "Do you really think so?";
        } else if (whichResponse == 3) {
            response = "You don't say.";
        } else if (whichResponse == 4) {
            response = "Wow, that's crazy!";        //Me when I mishear the person talking to me for the 3rd time in a row
        } else if (whichResponse == 5) {
            response = "Huh? I'm sorry, I wasn't listening";
        }

        return response;
    }
}
