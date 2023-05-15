
public class CVCParsingOfColumns extends TextProgram {

    /*Parses CVS file end extracts the specific column
    * */
    public void run() {
        ArrayList<String> columnValues = extractColumn("assets/data.csv", 1);
        outputColumn(columnValues);
    }

    /*Outputs each element of arrayList into single line to easily understand how program worked
     *If something went wring and method extractColumn returned null, prints message that file is not found
     * */
    private void outputColumn(ArrayList<String> columnValues) {
        if (columnValues != null) {
            for (String value : columnValues) {
                println(value);
            }
        } else {
            println("File not found or problems with reading file");
        }
    }

    /**
     * Parses a line of CSV data and extracts the fields.
     * Each field may or may not be enclosed in double quotes.
     * Handles double quotes inside quotes by treating them as a single double quote.
     * If a field is not enclosed with double quotes, double quotes may not appear inside the field.
     * Fields containing line breaks, double quotes, and commas are correctly handled.
     *
     * @param line the line of CSV data to parse
     * @return an ArrayList of fields extracted from the line
     */
    private ArrayList<String> fieldsIn(String line) {

        ArrayList<String> fields = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder field = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                if (i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    field.append('"');                  // Handle double quote inside quotes
                    i++;                                // Skip the next quote
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                fields.add(field.toString());           // Found delimiter
                field.setLength(0);                     // Clear the field string
            } else {
                field.append(c);
            }
        }
        fields.add(field.toString());                   //Ensure adding the last field

        return fields;
    }


    /*Opens a CSV file with the name filename, and returns  all the values that are in the columnIndex column
     *in the form of an array
     */
    private ArrayList<String> extractColumn(String filename, int columnIndex) {
        ArrayList<String> columnValues = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();

            while (line != null) {
                ArrayList<String> fields = fieldsIn(line);
                if (columnIndex < fields.size()) {
                    columnValues.add(fields.get(columnIndex));
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            return null;        //If errors occurred, probably file name or path is wrong so return null
        }

        return columnValues;
    }

}

