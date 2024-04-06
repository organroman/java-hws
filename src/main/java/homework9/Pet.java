package homework9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public abstract class Pet {
    protected Species species = Species.UNKNOWN;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits = new HashSet<>();

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
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

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.println("Я ї'м!");
    }

    public abstract void respond();

    public void addHabits(String habit) {
        this.habits.add(habit);
    }


    public static String setToString(Set<String> arr) {
        StringBuilder outcome = new StringBuilder("[");
        Iterator<String> iterator = arr.iterator();
        while (iterator.hasNext()) {
            outcome.append(iterator.next());
            if (iterator.hasNext()) {
                outcome.append(", ");
            }
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
                    .append(", habits=")
                    .append(setToString(this.habits));

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
        return Objects.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habits);
    }

}
