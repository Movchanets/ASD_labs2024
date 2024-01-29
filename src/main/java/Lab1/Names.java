package Lab1;

public enum Names {

    ANYA("Anya",Gender.FEMALE),     BOB("Bob",Gender.MALE),
    CHARLIE("",Gender.FEMALE),     DAVID("David",Gender.MALE),
    EMMA("Emma",Gender.FEMALE),    SLAVIK("Slavik",Gender.MALE),
    SOFIA("Sofia",Gender.FEMALE),    MAX("Max",Gender.MALE),
    MARIA("Maria",Gender.FEMALE),   ALEX("Alex",Gender.MALE);
    private final String name;
    private final Gender gender;
    Names(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public Gender getGender()
    {
        return gender;
    }
}
