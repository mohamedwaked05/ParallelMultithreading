import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tmax extends Thread {

    // Stores the name of the file to read numbers from
    private String filename;

    // Stores the maximum value found in the file
    private int max;
    public Tmax(String filename) {
        this.filename = filename;
    }

    public int getTmax() {
        return max;
    }

    //  It reads integers from the specified file and finds the maximum value.

    @Override
    public void run() {

        // Initialize max to the smallest possible integer value
        max = Integer.MIN_VALUE;

        // Use try-with-resources to automatically close the file reader
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {

                // Convert each line to an integer
                int num = Integer.parseInt(line);

                // Update max if a larger number is found
                if (num > max) {
                    max = num;
                }
            }
        } catch (IOException e) {
            
            // If an I/O error occurs (like file not found), display which file caused the error
            System.out.println("Error reading file: " + filename);
            e.printStackTrace();
        }
    }
}
