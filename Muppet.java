import java.util.Hashtable;
import java.util.Scanner;

public enum Muppet {

    ELMO("red", "cheerful and friendly", 3.5, 2),
    BIG_BIRD("yellow", "compassionate and thoughtful", 6.5, 3),
    SNUFFLEPAGUS("brown", "calm and kind", 5.0, 8),
    ABBY_CADABBY("pink", "imaginative and playful", 4.0, 10),
    ZOE("yellow", "silly and upbeat", 3.0, 9),
    BABY_BEAR("brown", "adventurous and artistic", 5.0, 5),
    COUNT_VON_COUNT("purple", "happy and helpful", 1832652.0, 10),
    GABRIELLE("brown", "vibrant and curious", 6.75, 11),
    GROVER("blue", "enthusiatic and clumsy", 4.0, 10),
    ROSITA("teal", "optimistic and playful", 5.0, 12),
    RUDY("orange", "curious and eager", 3.0, 6);

    private int MONTH = 04;
    private String puppetColor;
    private String characteristic;
    private double age;
    private int birthdayMonth;

    Muppet(String puppetColor, String characteristic, double age, int birthdayMonth) {
        this.puppetColor = puppetColor;
        this.characteristic = characteristic;
        this.age = age;
        this.birthdayMonth = birthdayMonth;
    }

    public String getPupptColor() {
        return puppetColor;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public double getAge() {
        return age;
    }

    public void printDescription() {
        System.out.println("This puppet is " + puppetColor + " and is " + age + " years old");
    }

    public void whenBirthday() {
        System.out
                .println("This puppet is turning " + (age + 1) + " in "
                        + ((birthdayMonth - MONTH) + (birthdayMonth - MONTH > 0 ? 0 : 12)) + " months.");
    }

    public static void personalityTest() {
        Hashtable<String, String> traitToMuppet = new Hashtable<>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please choose one of the following characteristics that best describes your personality: ");
        for (Muppet m : Muppet.values()) {
            String[] tempTraits = m.characteristic.split("and");
            for (String t : tempTraits) {
                traitToMuppet.put(t.trim().toLowerCase(), m.name());
                System.out.println("- " + t.trim());
            }
        }
        System.out.print("Your characteristic: ");
        String userInput = keyboard.nextLine().toLowerCase();
        keyboard.close();
        if (traitToMuppet.containsKey(userInput)) {
            System.out.println("You are most similar to " + traitToMuppet.get(userInput));
        } else {
            System.out.println("You don't ressemble any muppet");
        }
    }
}