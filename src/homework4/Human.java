package homework4;

import java.util.Arrays;

import static homework4.Pet.arrayToString;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private String[][] schedule;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        if (iq >= 0 && iq <= 100) this.iq = iq;
    }


    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void greetPet() {
        System.out.printf("Привіт, %s", this.family.pet.getNickname());
    }

    public void describePet() {
        StringBuilder outcome = new StringBuilder("У мене є");
        String trickLevelStr;

        if (family.pet.getTrickLevel() >= 50) {
            trickLevelStr = "дуже хитрий";
        } else trickLevelStr = "майже не хитрий";

        outcome.append(family.pet.getSpecies()).append(" їй ").append(family.pet.getAge()).append("він").append(trickLevelStr);

        System.out.println(outcome);
    }

    static String arr2dToStr(String[][] xss) {
        StringBuilder outcome = new StringBuilder("[");

        for (int idx = 0; idx < xss.length; idx++) {
            String[] xs = xss[idx];
            String x1 = arrayToString(xs);
            outcome
                    .append("\n")
                    .append("  ")
                    .append(x1);
        }

        return outcome.append("\n]\n").toString();
    }

    @Override
    public String toString() {
        StringBuilder outcome = new StringBuilder();
        outcome
                .append("Human{name=")
                .append(this.name)
                .append(", surname=")
                .append(this.surname)
                .append(", year=")
                .append(this.year)
                .append(", iq=")
                .append(this.iq);

        if (schedule != null) {
            outcome.append(", schedule=")
                    .append(arr2dToStr(this.schedule));
        }


        outcome.append("}");


        return outcome.toString();
    }
}
