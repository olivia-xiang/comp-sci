import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileIO {
    public static void main (String[]  args) {
        int sum = 0;
        double counter = 0.0;
        PrintWriter outputStream = null;

        try {
            outputStream = new PrintWriter("text.txt");
            outputStream.println("2");
            outputStream.println("1");
            outputStream.println("3");
            outputStream.println("4");
            outputStream.println("5");
            outputStream.println("6");
        } catch(IOException exception) {
            System.out.println("Problem creating or writing to the file");
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
        
        BufferedReader inputStream = null;
        String line = null;

        try {
            inputStream = new BufferedReader(new FileReader("text.txt"));
            while ((line = inputStream.readLine()) != null) {
                sum += Integer.parseInt(line);
                counter++;
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Error opening file");
        } catch (IOException exception) {
            System.out.println("Error opening file");
        } finally {
            try { if (inputStream != null) {
                inputStream.close();
                }
            } catch (IOException exception) {
                System.out.println("Error opening file");
            }
        }
        System.out.println(sum / counter);
    }
}