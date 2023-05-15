public class SaintPetersburgGame extends TextProgram {
    //Plays the s.peterburg game
    public void run() {
        int startSum = 1;                       //The starting bet with which players start(basically under our conditions it's always 1)
        int result = playGame(startSum);        //Playing the first game
        println("Your total is: " + result);    //Output the result of the first game

        int numOfGames = 1;                     //number of games counter
        while (result < 20) {                   //Playing the games until sum of winning will be 20 or more
            result += playGame(startSum);
            println("Your total is: " + result);
            numOfGames++;
        }
        println("It took " + numOfGames + " games to earn $20");
    }

    private int playGame(int sum) {
        while (true) {
            int randomNumber = (int) (Math.random() * 2);  // 0 - head; 1 - tail;
            if (randomNumber == 0) {        //If 'head' - double the sum
                sum = sum * 2;
            } else {                        //If 'tail' - end the game
                break;
            }
        }
        println("This game, you earned " + sum);
        return sum;
    }
}
