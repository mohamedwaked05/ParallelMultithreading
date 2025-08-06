import java.io.IOException;// To Aviod Try Catch

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
            FileGenerator.generateFiles(); // Step 1: Generating files using FileGenerator class

            // Step 2: Create and start threads
            Tmax t1 = new Tmax("file1.txt");
            Tmax t2 = new Tmax("file2.txt");
            Tmax t3 = new Tmax("file3.txt");
            Tmax t4 = new Tmax("file4.txt");

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            // Step 3: Wait for all threads to complete 
            t1.join();
            t2.join();
            t3.join();
            t4.join();

            // Step 4: Display results by getting Tmax from each file.txt using getTmax
                        System.out.println("Tmax of file1.txt:"+ t1.getTmax()+"\n"+
                               "Tmax of file2.txt:"+ t2.getTmax()+"\n"+
                               "Tmax of file3.txt:"+ t3.getTmax()+"\n"+
                               "Tmax of file4.txt:"+ t4.getTmax()+"\n");// Using one sop better than impelementing 4

            // getting the maximum Tmax from all files
            int[] maxValues = {
                t1.getTmax(),
                t2.getTmax(),
                t3.getTmax(),
                t4.getTmax()
            };

            int overallMax = maxValues[0];
            for (int i = 1; i < maxValues.length; i++) {
                overallMax = Math.max(overallMax, maxValues[i]);
            }

            System.out.println("Tmax of all files is: " + overallMax);


    
    }
}

















