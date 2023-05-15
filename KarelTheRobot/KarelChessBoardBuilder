public class KarelChessBoardBuilder extends KarelTheRobot {
    /* Precondition: Karel is at the start position facing East
     * Result: Karel painted the map with a chessboard pattern*/
    public void run() throws Exception {
        /* To avoid the problem of map that is one cell wide we check it at the beginning of program*/
        isRow();
        while (frontIsClear()) {
            paintColumn();
            toTheNextColumn();
        }
        /* To avoid the problem of forgetting the last step
         * after while loop we are building the last column*/
        paintColumn();
    }

    /* Precondition: Karel is at the start position facing East
     * Result: If map is a row Karel turns right*/
    private void isRow() throws Exception {
        if (leftIsBlocked()) {
            turnRight();
        }
    }

    /* Precondition: Karel is at the South border
     * Result: Karel painted column with chessboard pattern and reached the North border*/
    private void paintColumn() throws Exception {
        turnLeft();
        putBeeper();
        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
    }

    /* Precondition: Karel just painted column and standing at the North border facing North
     * Result: Karel moved to the beginning of the next column and stands
     * on the corresponding cell, depending on whether the column is even or odd*/
    private void toTheNextColumn() throws Exception {
        turnAround();
        moveToTheWall();
        turnLeft();
        findPositionForLine();
    }

    /* Precondition: Karel just returned to the beginning of the last painted column
     * Result: If beepers present on the first cell of built column,
     * next column will start painting by skipping first cell*
     * If next column doesn't exist Karel turns left */
    private void findPositionForLine() throws Exception {
        if (frontIsBlocked()) {
            turnLeft();
        } else {
            if (beepersPresent()) {
                move();
                turnLeft();
                move();
                turnRight();
            } else {
                move();
            }
        }
    }


    /* Precondition: Any. Karel can turn right at any time
     * Result: Karel is turned to the right side relatively
     * to the one he was looking at before;*/
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /* Precondition: Any. Karel can turn around in any time
     * Result: Karel is turned to the opposite side relatively
     *to the one he was looking at before;*/
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /*Precondition: Any. Karel just moves until facing the wall
     *Result: Karel stand facing the wall;*/
    private void moveToTheWall() throws Exception {
        while (frontIsClear()) {
            move();
        }

    }

}
