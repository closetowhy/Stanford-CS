public class PyramidBuilding extends WindowProgram {
    //Constants
    private static final int BRICK_HEIGHT = 20;
    private static final int BRICK_WIDTH = 40;
    private static final int BRICKS_IN_BASE = 9;

    //Draws the pyramid
    public void run() {
        int startX = (getWidth() - BRICKS_IN_BASE * BRICK_WIDTH) / 2;  //Calculating X start position for pyramid to be centered
        int currentY = getHeight() - BRICK_HEIGHT;                     //Calculating current Y for first iteration of loop
        //Drawing a pyramid by row
        for (int bricksInRow = BRICKS_IN_BASE; bricksInRow > 0; bricksInRow--) {
            buildRow(bricksInRow, currentY, startX);
            currentY -= BRICK_HEIGHT;                                   //With each next row, Y changes to the height of the brick
        }
    }

    //Draws a row of pyramid
    private void buildRow(int bricksInRow, int currentY, int startX) {
        int currentX = startX + ((BRICKS_IN_BASE - bricksInRow) * (BRICK_WIDTH / 2)); //Calculating current Y for first iteration of loop
        for (int i = 0; i < bricksInRow; i++) {
            addBrick(currentX, currentY);
            currentX += BRICK_WIDTH;                 //With each next iteration, X changes to the height of the brick
        }
    }

    //Adds the brick to the canvas
    private void addBrick(int x, int y) {
        GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        brick.setFilled(true);
        brick.setFillColor(Color.ORANGE);
        brick.setColor(Color.black);
        add(brick);
    }

}
