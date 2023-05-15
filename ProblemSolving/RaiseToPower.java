public class RaiseToPower extends TextProgram {
    //Raises to power numbers
    public void run() {
        try{
            double base = readDouble("Enter base:");    //reading input data from user
            int exp = readInt("Enter exponent:");
            double result = raiseToPower(base, exp);
            println("result equals " + result);
        }
        catch (Exception e) {                             //catching wrong input data
            println("Looks like input data is wrong...");
        }
    }

    /*Takes two parameters and calculates the value of the first parameter
    raised to the power of the second parameter; */
    private double raiseToPower(double base, int exponent) {
        double result = 1;
        if (exponent == 0) {                    //If exponent equals 0 the result is always 1
            return result;                      //and there is no need to continue calculations;
        }
        int originalExponent = exponent;        //Saving value of exponent before finding its absolute value
        exponent = abs(exponent);
        for (int i = 0; i < exponent; i++) {    //Multiply the base by itself as many times as the value of exponent equals
            result *= base;
        }
        if (originalExponent < 0) {             //If the original exponent was negative we divide the result by 1
            result = 1 / result;
        }
        return result;
    }

    /*Counts absolute value of number:
    If Number is positive changes nothing
    If number is negative turns it into positive */
    private int abs(int number) {
        if (number < 0) {
            number = -number;
        }
        return number;
    }

}
