public class KarelColumnBuilder extends KarelTheRobot {

    /* Precondition: Karel stands at the start of the map
     * Result: Karel built columns on every fourth row of the map */
    public void run() throws Exception {
        /* To avoid the problem of forgetting the last step
         * after while loop we are building the last column*/
        while (frontIsClear()) {
            buildColumn();
            toTheNextColumn();
        }
        buildColumn();
    }

    /* Precondition: Karel stands at the South border of the map facing east
     * Result: Karel built column and facing North border */
    private void buildColumn() throws Exception {
        turnLeft();
        while (frontIsClear()) {
            /*To avoid duplication of beepers we put beepers only if they are not present*/
            if (noBeepersPresent()) {
                putBeeper();
            } else {
                move();
            }
        }
        /* To avoid the problem of forgetting the last step
         * after while loop we put the last beeper in the column */
        if (noBeepersPresent()) {
            putBeeper();
        }
    }

    /* Precondition: Any. Karel just moves until facing the wall
     * Result: Karel stand facing the wall;*/
    private void moveUntilTheWall() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

    /* Precondition: Any. Karel can turn around in any time
     * Result: Karel is turned to the opposite side relatively to the one he was looking at before;*/
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /* Precondition: Karel stands on the Northern border facing North
     * Result: Karel stands on the beginning of next column facing East */
    private void toTheNextColumn() throws Exception {
        turnAround();
        moveUntilTheWall();
        turnLeft();
        for(int i=0; i<4; i++){
            move();
        }

    }
}
