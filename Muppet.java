public enum Muppet {
    
    ELMO("red", "cheerful voice and a contagious giggle", 3.5, "0203"),
    BIG_BIRD("yellow", "compassionate", 6.5, "0320"),
    SNUFFLEPAGUS("brown", "slow talking and thoughtful", 5.0, "0819"),
    ABBY_CADABBY("pink", "imaginative and playful", 4.0, "1021"),
    ZOE("yellow", "silly and upbeat", 3.0, "0930"),
    BABY_BEAR("brown", "adventurous and artistic", 5.0, "0512"),
    COUNT_VON_COUNT("purple", "happy and helpful", 1832652, "1009"),
    GABRIELLE("brown", "vibrant and  curious", 6.75, "1118"),
    GROVER("blue", "enthusiatic and clumsy", 4.0, "1014"),
    ROSITA("teal", "optimistic and playful", 5.0, "1207"),
    RUDY("orange", "curisous and eager", 3.0, "0601");


    private String puppetColor;
    private String characteristic;
    private double age;
    private String birthday;

    Muppet(String puppetColor, String characteristic, double age, String birthday) {
        this.puppetColor = puppetColor;
        this.characteristic = characteristic;
        this.age = age;
        this.birthday = birthday;
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
        System.out.println("This puppet is" + puppetColor + " and is " + age + " years old");
    }



}