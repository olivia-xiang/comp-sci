import java.util.Hashtable;
import java.util.Scanner;

public enum Muppet {

    ELMO("red", "cheerful and friendly", 3.5, 2),
    BIG_BIRD("yellow", "compassionate and thoughtful", 6.5, 3),
    SNUFFLEPAGUS("brown", "calm and kind", 5, 8),
    ABBY_CADABBY("pink", "imaginative and playful", 4, 10),
    ZOE("yellow", "silly and upbeat", 3.0, 9),
    BABY_BEAR("brown", "adventurous and artistic", 5, 5),
    COUNT_VON_COUNT("purple", "outgoing and helpful", 1832652, 10),
    GABRIELLE("brown", "vibrant and curious", 6.75, 11),
    GROVER("blue", "enthusiatic and clumsy", 4, 10),
    ROSITA("teal", "optimistic and playful", 5, 12),
    RUDY("orange", "curious and eager", 3, 6);

    private int month = 04;
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
        System.out.println("This puppet is " + puppetColor + " and " + age + " years old");
    }

    public void whenBirthday() {
        System.out
                .println("This puppet is turning " + (age + 1) + " in "
                        + (birthdayMonth - month + (birthdayMonth - month > 0 ? 0 : 12)) + " months");
    }

    // fix grammer
    public void colorMatch() {
        boolean checkMatch = false;
        System.out.print("There are ");
        for (Muppet m : Muppet.values()) {
            if (m.puppetColor == puppetColor && m.birthdayMonth != birthdayMonth) {
                System.out.print(m.name() + " ");
                checkMatch = true;
            }
        }
        System.out.print((checkMatch ? "who match " : "no puppets who match ") + "the color of " + puppetColor);
    }

    // nmaybe make more personalized to each character?
    public void personalityTest() {
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
            System.out.print("You are most similar to ");
            String[] name = traitToMuppet.get(userInput).split("_");
            for (String n : name) {
                System.out.print(n.charAt(0) + n.toLowerCase().substring(1) + " ");
            }
            System.out.println();
        } else {
            System.out.println("You don't ressemble any muppet");
        }
    }

    public void personaTest() {
        Scanner keyboard = new Scanner(System.in);
        String[] chara = characteristic.split("and");
        int score = 100;
        System.out.println("This is a personality test to see how well you match with this muppet: ");
        System.out.println("Please answer each question with y or n");
        for (int i = 0; i < chara.length; i++) {
            answerPrompt: while (true) {
                System.out.println((i + 1) + ". Do you consider youself " + chara[i] + "?");
                char input = keyboard.nextLine().toLowerCase().charAt(0);
                if (input == 'n') {
                    score -= 50;
                    break;
                } else if (input != 'y') {
                    System.out.println("Please enter a valid answer: y or n");
                    continue answerPrompt;
                }
                break;
            }
        }
        System.out.println("Compatibility: " + score + "%");
        keyboard.close();
    }
}