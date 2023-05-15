public class RootsOfQuadraticEquation extends TextProgram {
    /* This algorithm takes coefficients a, b, c of quadratic equation and calculates its real roots if they exist */
    public void run(){
        // Read input values for a, b, and c
        double a = readDouble("enter a:");
        double b = readDouble("enter b:");
        double c = readDouble("enter c:");
        // Calculate the discriminant
        double D = calculateD(a,b,c);
        // Calculate roots of quadratic equation
        calculateRoots(D,a,b);
    }

    // Calculate discriminant based on the input values of coefficients a, b, c
    private double calculateD(double a, double b, double c) {
        return Math.pow(b, 2)-4*a*c;
    }

    //Calculate the value of square roots depending on the value of the discriminant
    private void calculateRoots(double D, double a, double b) {
        double x1; double x2;
        if(D>0){
            x1 =(-b - Math.sqrt(D)) / (2 * a);
            x2 =(-b + Math.sqrt(D)) / (2 * a);
            println("There are two roots:" + x1 + " and " + x2);
        }
        else if (D==0){
            //If there is only one root, to avoid creating one more variable we just assign it to x1 variable
            x1 =-b/(2 * a);
            println("There is one root: " + x1);
        }
        //If D is not positive and not equals 0, it's negative and there s no real roots
        else{
            println("There are no real roots");
        }
    }
}
