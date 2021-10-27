public class ITSC1212Lab9 {
    public static void main(String[] args) {
        //Part A
        char symbol1 = '#';
        char symbol2 = '%';
        //Part C
        int a = 4;      //Rows
        int b = 4;      //Columns
        int c = 4;      //Width of individual squares

        for (int i = 0; i < a; i++) {               //Rows
            for (int j = 0; j < b; j++) {           //Columns
                for (int k = 0; k < c; k++) {       //Square width
                    if ((i + j) % 2 == 0)           //Checks if sum of coordinates is even or odd
                        System.out.print(symbol2);  //(Starts coordinates at 0)
                    else
                        System.out.print(symbol1);
                }
                System.out.print(" ");              //Seperates squares
            }
            System.out.println();                   //New row
        }
    }
}
