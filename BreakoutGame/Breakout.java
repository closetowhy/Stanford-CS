
/*Creates Breakout game*/
public class Breakout extends WindowProgram {
    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /**
     * Dimensions of the paddle
     */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /**
     * Offset of the paddle up from the bottom
     */
    private static final int PADDLE_Y_OFFSET = 30;

    /**
     * Number of bricks per row
     */
    private static final int NBRICKS_PER_ROW = 6;

    /**
     * Number of rows of bricks
     */
    private static final int NBRICK_ROWS = 10;

    /**
     * Separation between bricks
     */
    private static final int BRICK_SEP = 1;

    /**
     * Height of a brick
     */
    private static final int BRICK_HEIGHT = 10;

    /**
     * Radius of the ball in pixels
     */
    private static final int BALL_RADIUS = 10;
    private static final int BALL_DIAMETER = BALL_RADIUS * 2;

    /**
     * Offset of the top brick row from the top
     */
    private static final int BRICK_Y_OFFSET = 70;

    /**
     * Absolute value of vy which in our case equals vertical speed of the ball
     * */
    private static final double BALL_SPEED = 6.0;

    /**
     * Number of turns
     */
    private static final int NTURNS = 3;

    /**
     * Paddle and ball objects
     * */
    private GRect paddle;
    private GOval ball;

    /**
     * The distance to move the ball in the x and y directions
     */
    private double vx, vy;

    private int numberOfBricks = NBRICK_ROWS * NBRICKS_PER_ROW;

    /* Adds all game components to the screen and launches it
     * */
    public void run() {
        createPaddle();
        createBricks();
        addMouseListeners();
        createBall();
        moveBall(ball);
    }

    /*Create rows of centered colorful bricks which occupy the entire width of the screen
     * regardless of their number*/
    private void createBricks() {
        double totalWidth = getWidth() - 2 * BRICK_SEP;
        double brickWidth = (totalWidth - (NBRICKS_PER_ROW - 1.0) * BRICK_SEP) / NBRICKS_PER_ROW;
        int colorIndex = 0;
        for (int i = 0; i < NBRICK_ROWS; i++) {
            Color color = getColorForBricks(colorIndex++);
            for (int j = 0; j < NBRICKS_PER_ROW; j++) {
                double x = j * (brickWidth + BRICK_SEP) + BRICK_SEP;
                double y = i * (BRICK_HEIGHT + BRICK_SEP) + BRICK_Y_OFFSET;
                GRect brick = new GRect(x, y, brickWidth, BRICK_HEIGHT);
                brick.setFilled(true);
                brick.setColor(color);
                add(brick);
            }
        }
    }

    /* Chooses color for bricks row depending on it's index
     * */
    private Color getColorForBricks(int i) {
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
        int colorIndex = (i / 2) % colors.length;
        return colors[colorIndex];
    }

    /*Creates the ball in the middle of window and generates it's starting values for motion
     * */
    private void createBall() {
        ball = new GOval(BALL_DIAMETER, BALL_DIAMETER);
        ball.setFilled(true);
        add(ball, getWidth() / 2.0 - BALL_RADIUS, getHeight() / 2.0 - BALL_RADIUS);
        RandomGenerator rgen = RandomGenerator.getInstance();
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5)) {
            vx = -vx;
        }
        vy = BALL_SPEED;
    }

    /*Moves ball until end of the game
     * Checks if all bricks are destroyed, ad if they are, game is won and ball stops moving
     * When ball reach south borders increases loseCounter. If lose counter is equal NTURNS, game is over and ball stops moving */
    private void moveBall(GOval ball) {
        int loseCounter = 0;
        while (true) {
            ball.move(vx, vy);
            double x = ball.getX();
            double y = ball.getY();
            checkForCollisions(x, y);       //Check collisions of ball with bricks or paddle

            if (numberOfBricks == 0) {
                gameIsWon();
                break; // End the game
            }
            if (y >= getHeight()) {         //If ball reach south border of screen
                loseCounter++;
                int leftLives = NTURNS - loseCounter;
                if (leftLives > 0) {
                    ball.setLocation(getWidth() / 2.0 - BALL_RADIUS, getHeight() / 2.0 - BALL_RADIUS);
                    waitForClick();

                } else {                 //If player lost three times the game is over
                    gameOver();
                    break; // End the game
                }
            }
            pause(90);
        }
    }

    /**
     * Check for collisions with borders and paddle.
     *
     * @param y is Y coordinate of the ball. If it equals 0 that mens ball reached top-border of the screen
     * @param x is X coordinate of the ball. If its equals zero or bigger than width of screen,
     *          that means that ball reached one of the sides of screen;
     *          <p>
     *          Then we assign the value returned by the method getCollidingObject() to the collider.
     *          After that, we check whether this object is a paddle.
     *          If it is, we bounce off it as well as off the walls
     */
    private void checkForCollisions(double x, double y) {
        if (y <= 0) {
            vy = -vy;
        }
        if (x <= 0 || x + BALL_DIAMETER >= getWidth()) {
            vx = -vx;
        }
        GObject collider = getCollidingObject();
        if (collider == paddle) {
            vy = -vy;
        }
    }

    /*Checks the corners of the square in which the circle is inscribed for colliding with objects.
     * If it is, checks if this object is a paddle. If it's not, removes the collided object*/
    private GObject getCollidingObject() {
        double x = ball.getX();
        double y = ball.getY();
        double r = BALL_RADIUS;
        // Check the four corners of the square around the ball
        if (getElementAt(x, y) != null) {
            GObject collider = getElementAt(x, y);
            checkCollidedObject(collider);
            return collider;
        } else if (getElementAt(x + 2 * r, y) != null) {
            GObject collider = getElementAt(x + 2 * r, y);
            checkCollidedObject(collider);
            return collider;
        } else if (getElementAt(x, y + 2 * r) != null) {
            GObject collider = getElementAt(x, y + 2 * r);
            checkCollidedObject(collider);
            return collider;
        } else if (getElementAt(x + 2 * r, y + 2 * r) != null) {
            GObject collider = getElementAt(x + 2 * r, y + 2 * r);
            checkCollidedObject(collider);
            return collider;
        } else {
            return null;
        }
    }

    /*Checks if collided object is a paddle, if it's not, removes this object and
     * decrease the number of bricks counter */
    private void checkCollidedObject(GObject collider) {
        if (collider != paddle) {
            remove(collider);
            vy = -vy;
            numberOfBricks--;
        }
    }

    /*Creates centered rectangle that plays the role of paddle
     * */
    private void createPaddle() {
        paddle = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        add(paddle, getWidth() / 2.0 - PADDLE_WIDTH / 2.0, getHeight() - PADDLE_Y_OFFSET);
    }

    /* Sets location of paddle depending on mouse moving.
     * Also, if-else statements ensure that paddle will not get out of the screen*/
    public void mouseMoved(MouseEvent e) {
        double mouseX = e.getX();
        double x = mouseX - PADDLE_WIDTH / 2.0;
        double y = getHeight() - PADDLE_Y_OFFSET;
        if (x < 0) {                                              // Check if the paddle is within the window
            x = 0;
        } else if (x + PADDLE_WIDTH > getWidth()) {
            x = getWidth() - PADDLE_WIDTH;
        }
        paddle.setLocation(x, y);
    }

    /* Creates centered label to inform user that game is over
       Also deletes the paddle from canvas*/
    private void gameOver() {
        GLabel gameOverLabel = new GLabel("Game Over");
        gameOverLabel.setFont("Arial-Bold-24");
        double x = (getWidth() - gameOverLabel.getWidth()) / 2;
        double y = getHeight() - (getHeight() - BRICK_Y_OFFSET / 2.0);
        gameOverLabel.setColor(Color.red);
        add(gameOverLabel, x, y);
        pause(500);
        remove(paddle);
    }

    /* Creates label to inform user that game is won
    Also deletes the ball and paddle from canvas*/
    private void gameIsWon() {
        GLabel gameIsWon = new GLabel("YOU WIN! :)");
        gameIsWon.setFont("Arial-Bold-24");
        gameIsWon.setColor(Color.red);
        double x = (getWidth() - gameIsWon.getWidth()) / 2;
        double y = getHeight() - (getHeight() - BRICK_Y_OFFSET / 2.0);
        add(gameIsWon, x, y);
        pause(500);
        remove(ball);
        pause(500);
        remove(paddle);
    }

}
