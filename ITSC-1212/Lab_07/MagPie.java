public class MagPie {
    
    private int silentCount = 0;        //Sorry, but I'm cheating to make a cooler program
    /**
     * A default constuctor
     * 
     */
    public MagPie(){        //1 Constructor, does nothing
                            //1 field, cause I wanted to make a cooler program
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
        if (statement.startsWith("no") || statement.startsWith("nah")) {      //Now checks if sentence starts with no
            response = "Why so negative?";
        } else if (statement.indexOf("mother") >= 0 || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0 || statement.indexOf("brother") >= 0) {
            response = "Tell me more about your family.";
        } else if (statement.indexOf("Mr. Gaw") >= 0 || statement.indexOf("Gaw") >= 0           //Gaw was wy high school programming teacher, he had a huge influence
                || statement.indexOf("Dr. Whaley") >= 0 || statement.indexOf("Whaley") >= 0 ) { //in my appreciation for programming
            response = "Him? He's a great programming teacher!";
        } else if (statement.indexOf("Potatofactory") >= 0) {
            response = "Potato? He's an excellent fellow and a brilliant man!";     //Close online friend of mine who also taught me a bit of programming and always encouraged me
        } else if (statement.indexOf("Starbucks") >= 0 && statement.indexOf("near") >= 0) {
            response = "The nearest Starbucks is in the Student Union 0.5 miles away.";     //Starbs
        } else if (statement.indexOf("dog") >= 0 || statement.indexOf("cat") >= 0
                || statement.indexOf("pet") >= 0) {                                         //Pets
            response = "Tell me more about your pets.";
        } else if (statement.indexOf("bat") >= 0 && !(statement.indexOf("baseball") >= 0)) { //Animals
            response = "My buddy John was bitten by one of those once, unfortunately he didn't turn into a vampire.";
        } else if (statement.indexOf("bat") >= 0) {                                         //Sports
            response = "I love baseball!";
        } else if (statement.indexOf("Team") >= 0 && statement.indexOf("Fortress") >= 0 && (statement.indexOf("Two") >= 0 || statement.indexOf("2") >= 0)) {
            response = "I love that game! I am quite ashamed to admit, I have over 3,000 hours in it...";       //Video games(bonus)
        } else if (statement.trim().isEmpty()) {
            if (silentCount == 0) {                                                         //No response
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
