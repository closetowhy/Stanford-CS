public class HailstoneSequence extends TextProgram {

    //Runs the hailstone sequence of inputted number
    public void run() {
        try{
            int x = readInt("Enter a number");
            hailstoneNumber(x);
        }
        catch (Exception e) {   //Catch wrong input data
            println("Input have to be a positive integer");
        }
    }

    private void hailstoneNumber(int x) {
        int tempX;          //temporary x used to output both x before and after the transformation
        while (x > 1) {
            if (x % 2 == 0) {
                tempX = x / 2;               //If x is even divide it by 2
                println(x + " is even so I take half: " + tempX);
            } else {
                tempX = x * 3 + 1;          //If x is odd multiply it by 3 and add 1
                println(x + " is odd so I make 3n + 1: " + tempX);
            }
            x = tempX;      //In the end of each iteration x is assigned the value of temporary x
        }
    }
}
