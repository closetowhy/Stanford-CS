public class KarelNewspaperCollector extends KarelTheRobot {

    /* Precondition: Karel stands in a house without newspaper
     * Result: Karel collected Newspaper and returned to start position;*/
    public void run() throws Exception {
        goToNewspaper();
        /*To avoid creating new method like "pickNewspaper" with the same functionality we use standard pickBeeper method*/
        pickBeeper();
        returnToStart();
    }

    /* Precondition: Karel stands in North-East corner of the house facing east;
     * Result: Karel outside the house on square with newspaper;*/
    private void goToNewspaper() throws Exception {
        moveToTheWall();
        turnRight();
        move();
        turnLeft();
        move();
        move();
    }

    /* Precondition: Karel stands outside the house on square where was newspaper, facing east;
     * Result: Karel is on starting position:North-East corner of the house facing east ;*/
    private void returnToStart() throws Exception {
        turnAround();
        move();
        move();
        turnRight();
        move();
        turnLeft();
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
