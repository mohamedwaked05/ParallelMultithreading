import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {
    
    public static void generateFiles() throws IOException {
        Random rand = new Random();
        
        for (int i = 1; i <= 4; i++) {// To impelement 4 files

            FileWriter writer = new FileWriter("file" + i + ".txt");

            for (int j = 0; j < 1_000_000; j++) {//nested for to implement one million rand numbers in each file

                int num = 1 + rand.nextInt(1_000_000_000);  // Random between 1 and onebillion rand numbers
                writer.write(num + "\n");
            }

            writer.close();// closing method
            System.out.println("file" + i + ".txt generated.");// for file naming
        }
    }
}
