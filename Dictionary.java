import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;

public class Dictionary {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        BufferedReader inputStream = null;
        String line = "";
        HashSet<String> dictionary = new HashSet<String>();

        System.out.println("Please enter a sentence:");
        String input = keyboard.nextLine();
        String[] inputArray = input.split(" ");

        try {
            inputStream = new BufferedReader(new FileReader("dictionary.txt"));
            while ((line = inputStream.readLine()) != null) {
                dictionary.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file");
        } catch (IOException e) {
            System.out.println("Error creating file");
        } finally {
            System.out.println("Spell check of your sentence:");
            for (int i = 0; i < inputArray.length; i++) {
                System.out.println((i + 1) + ". " + inputArray[i] + " <"
                        + (dictionary.contains(inputArray[i].toLowerCase()) ? "" : "in") + "valid>");
            }
            if (inputStream != null) {
                inputStream.close();
            }
            keyboard.close();
        }
    }
}
