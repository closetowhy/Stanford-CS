public class HealthExercises extends TextProgram {

    private static final int DAYS_OF_EXERCISES = 7;
    //A minimum of exercises to complete the task
    private static final int MIN_CARDIO_EXERCISES = 5;
    private static final int MIN_PRESSURE_EXERCISES = 3;

    /*Asks the user for the number of minutes spent on exercise in the last seven days 
    * and reports whether it was enough*/
    public void run() {
        //counters for made exercises
        int exForCardio = 0;
        int exForPressure = 0;
        //Checking the performance of exercises every day for about 7 days
        for (int i = 0; i < DAYS_OF_EXERCISES; i++) {

            int dayNum = i + 1;     //i counts from zero and days from 1; So we add 1 to i each iteration to count number of day
            int minutes = readInt("How many minutes did you do on day " + dayNum + "?"); //taking value of minutes from user input

            if (minutes >= 40) {                     //if user did the exercises 40 minutes or more we increase both counters
                exForCardio++;
                exForPressure++;
            } else if (minutes >= 30) {             //if user did the exercises less than 40 but more than 30 we increase only Cardio counter
                exForCardio++;
            }
            //if he made less than 30 minutes nothing counts
        }

        //Output of the results of the performed exercises
        checkIfCardioIsEnough(exForCardio);
        checkIfPressureIsEnough(exForPressure);
    }

    //Checks if exercises were enough for Cardiovascular health
    private void checkIfCardioIsEnough(int exForCardio) {
        println("Cardiovascular health:");
        if (exForCardio < MIN_CARDIO_EXERCISES) {
            //Counting how many days of exercises are left if there were less than 5 exercises
            int neededExercises = MIN_CARDIO_EXERCISES - exForCardio;
            println("You needed to train hard for at least " + neededExercises + " more day(s) a week!");
        } else {
            println("Great job! You've done enough exercise for cardiovascular health.");
        }
    }

    //Checks if exercises were enough for good blood pressure
    private void checkIfPressureIsEnough(int exForPressure) {
        println("Blood pressure:");
        if (exForPressure < MIN_PRESSURE_EXERCISES) {
            //Counting how many days of exercises are left if there were less than 3 exercises
            int neededExercises = MIN_PRESSURE_EXERCISES - exForPressure;
            println(" You needed to train hard for at least " + neededExercises + " more day(s) a week!");
        } else {
            println("Great job! You've done enough exercise to keep a low blood pressure.");
        }
    }

}
