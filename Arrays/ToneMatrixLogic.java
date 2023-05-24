public class ToneMatrixLogic {
    /**
     * Given the contents of the tone matrix, returns a string of notes that should be played
     * to represent that matrix.
     *
     * @param toneMatrix The contents of the tone matrix.
     * @param column     The column number that is currently being played.
     * @param samples    The sound samples associated with each row.
     * @return A sound sample corresponding to all notes currently being played.
     */
    public static double[] matrixToMusic(boolean[][] toneMatrix, int column, double[][] samples) {
        double[] result = new double[ToneMatrixConstants.sampleSize()];

        double[] sampleRow;                                 //variable to assign to a particular row of the sample array

        for (int row = 0; row < toneMatrix.length; row++) {
            if (toneMatrix[row][column]) {
                sampleRow = samples[row];
                for (int i = 0; i < sampleRow.length; i++) {
                    result[i] += sampleRow[i];
                }
            }
        }
        normalizeValues(result);
        return result;
    }

    /* Finds the max value of sound-wave frequency in sound and if it's bigger than 1 normalizes all sound values
     * */
    private static void normalizeValues(double[] result) {
        double maxAmplitude = 0.0;
        for (double values : result) {
            if (Math.abs(values) > maxAmplitude) {
                maxAmplitude = Math.abs(values);
            }
        }
        if (maxAmplitude > 1.0) {
            for (int i = 0; i < result.length; i++) {
                result[i] /= maxAmplitude;
            }
        }
    }
}
