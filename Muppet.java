public enum Muppet {

    ELMO("red", "cheerful and friendly", 3.5, 2),
    BIG_BIRD("yellow", "compassionate and thoughtful", 6.5, 3),
    SNUFFLEPAGUS("brown", "calm and compassionate", 5, 8),
    ABBY_CADABBY("pink", "imaginative and playful", 4, 10),
    ZOE("yellow", "silly and upbeat", 3.0, 9),
    BABY_BEAR("brown", "adventurous and imaginative", 5, 5),
    COUNT_VON_COUNT("purple", "outgoing and helpful", 1832652, 10),
    GABRIELLE("brown", "upbeat and curious", 6.75, 11),
    GROVER("blue", "cheerful and clumsy", 4, 10),
    ROSITA("teal", "optimistic and playful", 5, 12),
    RUDY("orange", "curious and outgoing", 3, 6);

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

    public void setCurrentMonth(int month) {
        this.month = month;
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

    public String fixNameSpelling(String name) {
        String[] nameArray = name.split("_");
        String fixedName = "";
        for (String nameSeg : nameArray) {
            fixedName += nameSeg.charAt(0) + nameSeg.substring(1).toLowerCase() + " ";
        }
        return fixedName;
    }

    public void describeDescription() {
        System.out.println(
                "This puppet is " + puppetColor + ", " + age + " years old and born in the month " + birthdayMonth);
    }

    public void whenBirthday() {
        System.out
                .println("This puppet is turning " + (age + 1) + " in "
                        + (birthdayMonth - month + (birthdayMonth - month > 0 ? 0 : 12)) + " months");
    }

    public void mostCompatibleMuppet() {
        int winningScore = 1;
        String matches = "";
        String[] traits = characteristic.split("and");
        boolean warmColor = puppetColor.charAt(puppetColor.length() - 1) != 'l'
                && puppetColor.charAt(puppetColor.length() - 1) != 'e';
        for (Muppet muppet : Muppet.values()) {
            if (!muppet.characteristic.equals(characteristic)) {
                char muppetColor2 = muppet.puppetColor.charAt(muppet.puppetColor.length() - 1);
                boolean warmColor2 = muppetColor2 != 'e' && muppetColor2 != 'l';
                int score = 0;
                for (String chara : traits) {
                    if (muppet.characteristic.contains(chara.trim())) {
                        score += 2;
                    }
                }
                score += (Math.abs(muppet.age - age) <= 5 ? 1 : 0);
                score += (warmColor == warmColor2) ? 1 : 0;
                if (winningScore <= score) {
                    winningScore = score;
                    matches += score + muppet.name() + " ";
                }
            }
        }
        String[] matchesArray = matches.split(" ");
        for (String match : matchesArray) {
            if (match.length() > 2) {
                if (match.charAt(0) - '0' == winningScore) {
                    System.out.println("- " + fixNameSpelling(match.substring(1)));
                }
            }
        }
    }
}