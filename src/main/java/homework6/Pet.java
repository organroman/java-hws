package homework6;

import java.util.Arrays;

public abstract class Pet {
    protected Species species = Species.UNKNOWN;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, int trickLevel, String[] habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {
    }


    public Species getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        if (trickLevel >= 0 && trickLevel <= 100) {
            this.trickLevel = trickLevel;
        }
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }


    public void eat() {
        System.out.println("Я ї'м!");
    }

    public abstract void respond();


    public static String arrayToString(String[] arr) {
        StringBuilder outcome = new StringBuilder("[");
        for (int idx = 0; idx < arr.length; idx++) {
            String x = arr[idx];
            if (idx > 0) outcome.append(", ");
            outcome.append(x);
        }
        return outcome.append("]").toString();
    }

    @Override
    public String toString() {
        StringBuilder outcome = new StringBuilder();

        outcome
                .append(this.species.name())
                .append("{")
                .append("nickname=")
                .append(this.nickname)
                .append(", age=")
                .append(this.age)
                .append(", trickLevel=")
                .append(this.trickLevel);

        if (this.habits != null) {
            outcome
                    .append(arrayToString(this.habits));

        }
        outcome.append(", legs=")
                .append(this.species.numberOfLegs)
                .append(", canFly=")
                .append(this.species.canFly)
                .append(", hasFur=")
                .append(this.species.hasFur)
                .append("}");

        return outcome.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Arrays.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(habits);
    }

}
