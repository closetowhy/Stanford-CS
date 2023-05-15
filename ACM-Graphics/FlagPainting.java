public class FlagPainting extends WindowProgram {
    //Application size
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 500;
    //Flag size
    public static final int FLAG_WIDTH = 200;
    public static final int FLAG_HEIGHT = 150;
    //My flag consists of 3 segments so their height equals flag height/3
    public static final int FLAG_SEGMENT_HEIGHT = FLAG_HEIGHT/3;


    //Creates centered flag of Germany and label in bottom right corner
    public void run() {
        //Calculating coordinates to center the flag
        int flagX = (getWidth() - FLAG_WIDTH) / 2;
        int flagY = (getHeight() - FLAG_HEIGHT) / 2;
        createFlag(flagX, flagY);
        paintTheFlag(flagX, flagY);
        createLabel();
    }

    //Creating white rectangle which is going to be the "canvas" for our flag
    private void createFlag(int flagX, int flagY) {
        GRect flag = new GRect(flagX, flagY, FLAG_WIDTH, FLAG_HEIGHT);
        flag.setColor(Color.white);
        add(flag);
    }

    //Creates 3 rectangles which are 1/3 the width of the flag
    private void paintTheFlag(int flagX, int flagY) {
        //First row of flag have same position as original flag just have another height
        GRect firstRow = new GRect(flagX, flagY, FLAG_WIDTH, FLAG_SEGMENT_HEIGHT);
        firstRow.setFilled(true);
        firstRow.setFillColor(Color.black);
        add(firstRow);

        //Second row Y position equals flag Y plus height of segment to be under first row
        GRect secondRow = new GRect(flagX, flagY + FLAG_SEGMENT_HEIGHT, FLAG_WIDTH, FLAG_SEGMENT_HEIGHT);
        secondRow.setFilled(true);
        secondRow.setFillColor(Color.red);
        secondRow.setColor(Color.red);
        add(secondRow);

        //Third row Y position equals flag Y plus doubled height of segment to be under second row
        GRect thirdRow = new GRect(flagX, flagY + FLAG_SEGMENT_HEIGHT * 2, FLAG_WIDTH, FLAG_SEGMENT_HEIGHT);
        thirdRow.setFilled(true);
        thirdRow.setFillColor(Color.orange);
        thirdRow.setColor(Color.orange);
        add(thirdRow);
    }

    //Creates the label in bottom right corner
    private void createLabel() {
        GLabel label = new GLabel("Flag of Germany");
        label.setFont("Verdana-16");
        // Calculate the coordinates for label to be in bottom right corner
        double x = getWidth() - label.getWidth();
        double y = getHeight() - label.getHeight();
        label.setLocation(x, y);
        add(label);
    }
}
