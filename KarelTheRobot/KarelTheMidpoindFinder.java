public class KarelTheMidpoindFinder extends KarelTheRobot {
    /* Precondition: Karel is at start position facing East
     * Result: Karel has put down a beeper at the midpoint and there's any other beepers on the map*/
    public void run() throws Exception {
        /* If map is the column which means the only square also is a center,
        * Karel just puts beeper and program ends*/
        if (frontIsClear()) {
            buildDiagonal();
            findMidpointColumn();
            putMidpointBeeper();
            clearDiagonal();
        } else {
            putBeeper();
        }
    }

    /*Precondition: Karel is at start position facing East
     *Result: Karel has created a diagonal line of beepers and facing East border*/
    private void buildDiagonal() throws Exception {
        while (frontIsClear()) {
            moveDiagonallyEast();
            putBeeper();
        }
    }

    /* Precondition: Karel is in a position that does not border the eastern or southern border
    *  Result: Karel has moved one square diagonally and is facing in the opposite direction */
    private void moveDiagonallyEast() throws Exception {
        move();
        turnLeft();
        move();
        turnRight();
    }

    /*Precondition: Karel is at South-East corner facing East;
     * Result: Karel stands on the central column or on one of the central columns if the map is odd*/
    private void findMidpointColumn() throws Exception {
        moveToSouthernEdge();
        /*Karel moves diagonally west until he finds the beeper, which means he has reached the center column */
        while (noBeepersPresent()) {
            move();
            turnLeft();
            if (noBeepersPresent()) {
                move();
                turnRight();
            }
        }
    }

    /*Precondition:Karel is at the East border of the world facing East, on the diagonal line.
     * Result:Karel has moved to the southern edge of the world and is facing North.
     * */
    private void moveToSouthernEdge() throws Exception {
        turnRight();
        moveToTheWall();
        turnAround();
    }


    /*Precondition: Karel is at the central column
     * Result: Karel reached South border of central column and putted midpoint beeper*/
    private void putMidpointBeeper() throws Exception {
        while (notFacingSouth()) {
            turnLeft();
        }
        moveToTheWall();
        putBeeper();
    }


    /*Precondition: Karel is at start position facing East
     *Result: Karel has cleared a diagonal line from beepers and facing East border*/
    private void clearDiagonal() throws Exception {
        toTheStartPosition();
        while (frontIsClear()) {
            moveDiagonallyEast();
            pickBeeper();
        }
    }

    /*Precondition: Karel is at the midpoint facing South
     * Result: Karel reached the start position(South-West corner) and facing East*/
    private void toTheStartPosition() throws Exception {
        turnRight();
        moveToTheWall();
        turnAround();
    }

    /* Precondition: Any. Karel can turn right at any time
     * Result: Karel is turned to the right side relatively
     * to the one he was looking at before;*/
    private void turnRight() throws Exception {
        turnLeft();
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

    /* Precondition: Any. Karel can turn around in any time
     * Result: Karel is turned to the opposite side relatively
     *to the one he was looking at before;*/
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

}
