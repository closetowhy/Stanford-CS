public class FlagOfJapanAnimation extends WindowProgram {

    private static final int DIAMETER = 220;
    private static final int RADIUS = DIAMETER / 2;
    /*Animation speed. If it is very fast, the animation will stop at the end for a few seconds.
     If it is too slow, it will be cut off without finishing. But it will always last 5 seconds*/
    private static final int ANIMATION_SPEED = 8;

    //Creates animation where inversed Japanese flag transforms into the correct one
    public void run() {
        //set start time
        long startTime = System.currentTimeMillis();
        //Set a red background
        setBackground(Color.red);
        createAndMoveWhiteCircle(startTime);
        animateBackgroundWhite(startTime);
        createAndMoveRedCircle(startTime);
        checkElapsedTime(startTime);
        addLabel();
        //Calculates and outputs the time spent by the animation
        long endTime = System.currentTimeMillis() - startTime;
        println("Time of animation = " + endTime);
    }


    //Animatedly paints canvas in white color by moving white rectangle
    private void animateBackgroundWhite(long startTime) {
        GRect rect = new GRect(0, getHeight(), getWidth(), getHeight() + 10);
        rect.setFilled(true);
        rect.setColor(Color.white);
        add(rect);
        // move the rectangle up to the top-left corner of the screen
        double dy = -ANIMATION_SPEED;
        while (rect.getY() >= 0) { // check if the top edge of the rectangle has reached or passed the top of the screen
            rect.move(0, dy);
            pause(20);
            // check elapsed time
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime >= 4950) { // if more than 4950 ms have elapsed, break the loop
                break;
            }
        }

    }

    //Creates a white circle and moves it up out of the screen
    private void createAndMoveWhiteCircle(long startTime) {
        GOval whiteOval = new GOval(getWidth() / 2 - DIAMETER / 2, getHeight() / 2 - RADIUS, DIAMETER, DIAMETER);
        whiteOval.setFilled(true);
        whiteOval.setColor(Color.white);
        add(whiteOval);

        double dy = -ANIMATION_SPEED;
        while (whiteOval.getY() + whiteOval.getHeight() >= -RADIUS) {
            whiteOval.move(0, dy);
            pause(20);
            // check elapsed time
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime >= 4950) { // if more than 4950 ms have elapsed, break the loop
                break;
            }
        }
    }


    private void createAndMoveRedCircle(long startTime) {
        GOval oval = new GOval(getWidth() / 2 - RADIUS, -getHeight() / 2 - RADIUS, DIAMETER, DIAMETER);
        add(oval);
        oval.setFilled(true);
        oval.setColor(Color.red);
        double dy = ANIMATION_SPEED;
        int centerY = getHeight() / 2;

        while (oval.getY() + DIAMETER / 2 < centerY) {
            oval.move(0, dy);
            pause(20); // pause for 40 milliseconds
            // check elapsed time
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime >= 5000) { // if more than 5000 ms have elapsed, break the loop
                break;
            }
        }

    }

    //Check if animation was played too fast and if that's it, waits until 4950 ms and only after that adds label
    private void checkElapsedTime(long startTime) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime < 4950) { // if less than 4950 ms have elapsed, pause for the remaining time
            pause(4950 - elapsedTime);
        }
    }

    //Adds label of flag created after animation
    private void addLabel() {
        GLabel label = new GLabel("Japan :)", 10, getHeight() - 10);
        label.setFont("Verdana-25");
        add(label);
    }

}
